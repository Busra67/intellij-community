// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.modifiers

import kotlinx.serialization.Serializable
import org.jetbrains.icons.impl.patchers.DefaultSvgPatcher
import org.jetbrains.icons.impl.rendering.layers.LayerLayout

@Serializable
class SvgPatcherModifier(val svgPatcher: DefaultSvgPatcher) : ApplyableIconModifier {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SvgPatcherModifier

        return svgPatcher == other.svgPatcher
    }

    override fun hashCode(): Int {
        return svgPatcher.hashCode()
    }

    override fun toString(): String {
        return "SvgPatcherModifier(svgPatcher=$svgPatcher)"
    }

    override fun applyTo(layout: LayerLayout): LayerLayout {
        // This modifier doesn't affect layout
        return layout
    }
}
