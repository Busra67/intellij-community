// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.modifiers

import kotlinx.serialization.Serializable
import org.jetbrains.icons.filters.ColorFilter
import org.jetbrains.icons.impl.rendering.layers.LayerLayout

@Serializable
class ColorFilterModifier(val colorFilter: ColorFilter) : ApplyableIconModifier {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ColorFilterModifier

        return colorFilter == other.colorFilter
    }

    override fun hashCode(): Int {
        return colorFilter.hashCode()
    }

    override fun toString(): String {
        return "ColorFilterModifier(colorFilter=$colorFilter)"
    }

    override fun applyTo(layout: LayerLayout): LayerLayout {
        return layout.copy(colorFilter = colorFilter)
    }
}
