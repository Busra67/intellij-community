// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.rendering

import kotlin.math.roundToInt
import org.jetbrains.icons.rendering.Dimensions
import org.jetbrains.icons.rendering.IconRenderer
import org.jetbrains.icons.rendering.ScalingContext
import org.jetbrains.icons.scale.IconScale

fun IconRenderer.resolve(density: Float, scale: IconScale?): ResolvedScalingContext {
    val original = calculateUsedDimensions(DefaultScalingContext(density, 1f))
    val factor = scale?.toFactor(density, original.width, original.height) ?: 1f
    return ResolvedScalingContext(
        Dimensions((original.width * factor).roundToInt(), (original.height * factor).roundToInt()),
        DefaultScalingContext(density, factor),
    )
}

class ResolvedScalingContext(val finalDimensions: Dimensions, val context: ScalingContext)
