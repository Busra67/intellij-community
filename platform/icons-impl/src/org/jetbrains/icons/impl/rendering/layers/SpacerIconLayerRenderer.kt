// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.rendering.layers

import org.jetbrains.icons.design.dp
import org.jetbrains.icons.impl.layers.SpacerIconLayer
import org.jetbrains.icons.rendering.LayerPaintingContext
import org.jetbrains.icons.rendering.RenderingContext

class SpacerIconLayerRenderer(private val layer: SpacerIconLayer, renderingContext: RenderingContext) :
    IconLayerRenderer {
    override val layout: LayerLayout = applyLayout(layer.modifier, 1.dp.compoundSize(), 1.dp.compoundSize())

    override fun render(paintingContext: LayerPaintingContext) {
        // Render nothing
    }
}
