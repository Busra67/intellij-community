// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.rendering

import org.jetbrains.icons.ImageResourceLocation
import org.jetbrains.icons.impl.rendering.layers.generateImageModifiers
import org.jetbrains.icons.layers.IconLayer
import org.jetbrains.icons.rendering.ImageModifiers
import org.jetbrains.icons.rendering.ImageResource
import org.jetbrains.icons.rendering.ImageResourceProvider
import org.jetbrains.icons.rendering.MutableIconUpdateFlow
import org.jetbrains.icons.rendering.RenderingContext

class DefaultRenderingContext(
    override val updateFlow: MutableIconUpdateFlow,
    override val defaultImageModifiers: DefaultImageModifiers?,
    val imageResourceProvider: ImageResourceProvider,
) : RenderingContext {
    fun adjustTo(iconLayer: IconLayer): DefaultRenderingContext =
        DefaultRenderingContext(updateFlow, iconLayer.generateImageModifiers(this), imageResourceProvider)

    override fun imageResource(loader: ImageResourceLocation, imageModifiers: ImageModifiers?): ImageResource {
        return imageResourceProvider.loadImage(loader, imageModifiers)
    }
}
