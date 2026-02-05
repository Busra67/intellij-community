// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.design

import kotlinx.serialization.Serializable
import org.jetbrains.icons.design.IconUnit
import org.jetbrains.icons.design.Pixel

@Serializable
class DefaultPixel(override val value: Int) : Pixel {
    override fun plus(other: Pixel): Pixel {
        return DefaultPixel(value + other.value)
    }

    override fun times(other: Int): IconUnit {
        return DefaultPixel(value * other)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DefaultPixel

        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return "PixelIconUnit(value=$value)"
    }
}
