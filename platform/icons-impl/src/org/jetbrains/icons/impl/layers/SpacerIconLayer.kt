// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.layers

import kotlinx.serialization.Serializable
import org.jetbrains.icons.layers.IconLayer
import org.jetbrains.icons.modifiers.IconModifier

@Serializable
class SpacerIconLayer(override val modifier: IconModifier) : IconLayer {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SpacerIconLayer

        return modifier == other.modifier
    }

    override fun hashCode(): Int {
        return modifier.hashCode()
    }

    override fun toString(): String {
        return "SpacerIconLayer(modifier=$modifier)"
    }
}
