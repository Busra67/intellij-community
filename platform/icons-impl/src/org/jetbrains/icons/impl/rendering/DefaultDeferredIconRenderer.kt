// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.rendering

import org.jetbrains.annotations.ApiStatus
import org.jetbrains.icons.DeferredIcon
import org.jetbrains.icons.Icon
import org.jetbrains.icons.impl.DefaultDeferredIcon
import org.jetbrains.icons.impl.DefaultIconManager
import org.jetbrains.icons.impl.DeferredIconEventHandler
import org.jetbrains.icons.rendering.Dimensions
import org.jetbrains.icons.rendering.IconRenderer
import org.jetbrains.icons.rendering.LayerPaintingContext
import org.jetbrains.icons.rendering.RenderingContext
import org.jetbrains.icons.rendering.ScalingContext
import org.jetbrains.icons.rendering.createRenderer

internal class DefaultDeferredIconRenderer(
    override val icon: DefaultDeferredIcon,
    val renderingContext: RenderingContext,
) : IconRenderer, DeferredIconEventHandler {
    private var isDone = false
    private var renderer = icon.placeholder?.createRenderer(renderingContext)

    override fun whenDone(deferredIcon: DeferredIcon, resolvedIcon: Icon) {
        renderer = resolvedIcon.createRenderer(renderingContext)
        isDone = true
        renderingContext.updateFlow.triggerUpdate()
    }

    @ApiStatus.Internal
    override fun render(paintingContext: LayerPaintingContext) {
        if (!isDone) {
            DefaultIconManager.getDefaultManagerInstance().scheduleEvaluation(icon)
        }
        renderer?.render(paintingContext)
    }

    @ApiStatus.Internal
    override fun calculateUsedDimensions(scaling: ScalingContext): Dimensions {
        return renderer?.calculateUsedDimensions(scaling) ?: Dimensions(0, 0)
    }
}
