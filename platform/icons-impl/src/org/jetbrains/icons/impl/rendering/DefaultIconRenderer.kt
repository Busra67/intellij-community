// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.rendering

import org.jetbrains.icons.Icon
import org.jetbrains.icons.impl.DefaultLayeredIcon
import org.jetbrains.icons.impl.rendering.layers.CompoundDimensions
import org.jetbrains.icons.impl.rendering.layers.IconLayerManager
import org.jetbrains.icons.impl.rendering.layers.IconLayerRenderer
import org.jetbrains.icons.impl.rendering.layers.maxCompoundSize
import org.jetbrains.icons.rendering.Dimensions
import org.jetbrains.icons.rendering.IconRenderer
import org.jetbrains.icons.rendering.LayerPaintingContext
import org.jetbrains.icons.rendering.RenderingContext
import org.jetbrains.icons.rendering.ScalingContext

class DefaultIconRenderer(val iconInstance: DefaultLayeredIcon, private val context: RenderingContext) : IconRenderer {
    override val icon: Icon = iconInstance
    private var isLoaded = false
    private val layerRenderers = createRenderers()

    private fun createRenderers(): List<IconLayerRenderer> {
        val manager = IconLayerManager.getInstance()
        val renderers = iconInstance.layers.map { manager.createRenderer(it, context) }
        isLoaded = true
        return renderers
    }

    override fun render(paintingContext: LayerPaintingContext) {
        val usedDimensions = calculateUsedDimensions(paintingContext.scaling)
        for (layer in layerRenderers) {
            val nested =
                paintingContext.createNestedLayer(slotWidth = usedDimensions.width, slotHeight = usedDimensions.height)
            layer.render(nested)
        }
    }

    internal fun consumedSpace(): CompoundDimensions {
        return layerRenderers.maxCompoundSize { it.layout.consumedSpace() }
    }

    override fun calculateUsedDimensions(scaling: ScalingContext): Dimensions {
        var width = 0
        var height = 0
        for (layer in layerRenderers) {
            val dimensions = layer.layout.consumedSpace(scaling)
            if (dimensions.width > width) {
                width = dimensions.width
            }
            if (dimensions.height > height) {
                height = dimensions.height
            }
        }
        return Dimensions(width, height)
    }
}
