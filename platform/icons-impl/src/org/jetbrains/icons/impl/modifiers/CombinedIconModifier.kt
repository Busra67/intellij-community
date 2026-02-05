// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.modifiers

import kotlinx.serialization.Serializable
import org.jetbrains.icons.impl.rendering.layers.LayerLayout

@Serializable
class CombinedIconModifier(val root: ApplyableIconModifier, val other: ApplyableIconModifier) : ApplyableIconModifier {
    override fun applyTo(layout: LayerLayout): LayerLayout {
        return other.applyTo(root.applyTo(layout))
    }

    override fun toString(): String {
        return "CombinedIconModifier(root=$root, other=$other)"
    }

    override fun equals(other1: Any?): Boolean {
        if (this === other1) return true
        if (javaClass != other1?.javaClass) return false

        other1 as CombinedIconModifier

        if (root != other1.root) return false
        if (other != other1.other) return false

        return true
    }

    override fun hashCode(): Int {
        var result = root.hashCode()
        result = 31 * result + other.hashCode()
        return result
    }
}
