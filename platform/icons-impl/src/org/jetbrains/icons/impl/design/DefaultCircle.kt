// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.design

import kotlinx.serialization.Serializable
import org.jetbrains.icons.design.Circle
import org.jetbrains.icons.design.IconUnit

@Serializable
class DefaultCircle(override val radius: IconUnit) : Circle {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DefaultCircle

        return radius == other.radius
    }

    override fun hashCode(): Int {
        return radius.hashCode()
    }

    override fun toString(): String {
        return "CircleIconUnit(radius=$radius)"
    }
}
