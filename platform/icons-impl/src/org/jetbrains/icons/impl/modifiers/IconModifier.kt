// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.modifiers

import kotlin.math.roundToInt
import org.jetbrains.annotations.ApiStatus
import org.jetbrains.icons.design.IconUnit
import org.jetbrains.icons.impl.design.DefaultDisplayPoint
import org.jetbrains.icons.impl.design.DefaultPixel
import org.jetbrains.icons.impl.rendering.layers.LayerLayout
import org.jetbrains.icons.modifiers.IconModifier
import org.jetbrains.icons.rendering.ScalingContext

@ApiStatus.Internal
fun IconModifier.applyTo(layout: LayerLayout): LayerLayout {
    return if (this is ApplyableIconModifier) {
        applyTo(layout)
    } else {
        layout
    }
}

fun IconUnit.asFractionalPixels(scaling: ScalingContext, additionalScale: Float = 1f): Float {
    return when (this) {
        is DefaultPixel -> scaling.contextScale * value * additionalScale
        is DefaultDisplayPoint -> scaling.displayDensity * scaling.contextScale * value * additionalScale
        else -> error("Unsupported IconUnit: $this")
    }.toFloat()
}

fun IconUnit.asPixels(scaling: ScalingContext, additionalScale: Float = 1f): Int {
    return asFractionalPixels(scaling, additionalScale).roundToInt()
}
