// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.design

import kotlinx.serialization.Serializable
import org.jetbrains.icons.design.DisplayPoint
import org.jetbrains.icons.design.IconUnit

@Serializable
class DefaultDisplayPoint(override val value: Double) : DisplayPoint {
    override fun plus(other: DisplayPoint): DisplayPoint {
        return DefaultDisplayPoint(value + other.value)
    }

    override fun times(other: Int): IconUnit {
        return DefaultDisplayPoint(value * other)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DefaultDisplayPoint

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "DisplayPointIconUnit(value=$value)"
    }
}
