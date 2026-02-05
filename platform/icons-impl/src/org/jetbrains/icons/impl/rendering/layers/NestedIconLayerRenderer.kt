// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.rendering.layers

import org.jetbrains.icons.impl.layers.NestedIconLayer
import org.jetbrains.icons.impl.rendering.DefaultIconRenderer
import org.jetbrains.icons.impl.rendering.DefaultRenderingContext
import org.jetbrains.icons.rendering.LayerPaintingContext
import org.jetbrains.icons.rendering.createRenderer

class NestedIconLayerRenderer(private val layer: NestedIconLayer, renderingContext: DefaultRenderingContext) :
    IconLayerRenderer {
    private val renderer = layer.icon.createRenderer(renderingContext.adjustTo(layer))

    override val layout: LayerLayout = applyLayout()

    private fun applyLayout(): LayerLayout {
        if (renderer !is DefaultIconRenderer) error("Unsupported renderer: $renderer")
        val consumed = renderer.consumedSpace()
        return applyLayout(layer.modifier, consumed.width, consumed.height)
    }

    override fun render(paintingContext: LayerPaintingContext) {
        val placement = layout.placement(paintingContext)
        val nestedLayerContext =
            paintingContext.createNestedLayer(placement.bounds.x, placement.bounds.y, scale = placement.scale)
        renderer.render(nestedLayerContext)
    }
}
