// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.rendering.layers

import org.jetbrains.icons.design.dp
import org.jetbrains.icons.impl.modifiers.applyTo
import org.jetbrains.icons.modifiers.IconModifier
import org.jetbrains.icons.rendering.LayerPaintingContext

interface IconLayerRenderer {
    /**
     * Renders the icon layer using the provided painting API. The renderer is required to set
     * paintingContext.usedDimensions to the actual dimensions of the rendered content. Parent layers will use this
     * information to calculate the layout of the next layer.
     */
    fun render(paintingContext: LayerPaintingContext)

    val layout: LayerLayout

    fun applyLayout(modifier: IconModifier, width: CompoundSize, height: CompoundSize): LayerLayout {
        val layout =
            LayerLayout(
                0.dp.compoundSize(),
                0.dp.compoundSize(),
                0.dp.compoundSize(),
                0.dp.compoundSize(),
                width,
                height,
            )
        return modifier.applyTo(layout)
    }
}
