// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.modifiers

import kotlinx.serialization.Serializable
import org.jetbrains.icons.impl.rendering.layers.LayerLayout
import org.jetbrains.icons.scale.IconScale

@Serializable
class ScaleModifier(val scale: IconScale) : ApplyableIconModifier {

    override fun applyTo(layout: LayerLayout): LayerLayout {
        return layout.copy(scale = scale)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ScaleModifier

        return scale == other.scale
    }

    override fun hashCode(): Int {
        return scale.hashCode()
    }

    override fun toString(): String {
        return "ScaleModifier(scale=$scale)"
    }
}
