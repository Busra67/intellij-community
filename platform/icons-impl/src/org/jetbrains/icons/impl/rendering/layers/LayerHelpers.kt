// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.rendering.layers

import kotlin.math.ceil
import org.jetbrains.icons.impl.layers.findModifier
import org.jetbrains.icons.impl.modifiers.ColorFilterModifier
import org.jetbrains.icons.impl.modifiers.StrokeModifier
import org.jetbrains.icons.impl.modifiers.SvgPatcherModifier
import org.jetbrains.icons.impl.rendering.DefaultImageModifiers
import org.jetbrains.icons.impl.rendering.DefaultRenderingContext
import org.jetbrains.icons.layers.IconLayer
import org.jetbrains.icons.rendering.ScalingContext

fun IconLayer.generateImageModifiers(renderingContext: DefaultRenderingContext? = null): DefaultImageModifiers {
    val defaults = renderingContext?.defaultImageModifiers
    return DefaultImageModifiers(
        colorFilter = findModifier<ColorFilterModifier>()?.colorFilter ?: defaults?.colorFilter,
        svgPatcher = findModifier<SvgPatcherModifier>()?.svgPatcher ?: defaults?.svgPatcher,
        isDark = defaults?.isDark ?: false,
        stroke = findModifier<StrokeModifier>()?.color ?: defaults?.stroke,
    )
}

fun ScalingContext.applyTo(px: Int): Int {
    return applyTo(px.toDouble())
}

fun ScalingContext.applyTo(px: Double): Int {
    return ceil(px * displayDensity * contextScale).toInt()
}

fun ScalingContext.applyTo(px: Int?): Int? {
    if (px == null) return null
    return applyTo(px)
}
