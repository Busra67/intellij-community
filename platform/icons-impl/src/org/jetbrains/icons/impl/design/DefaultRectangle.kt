// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.design

import kotlinx.serialization.Serializable
import org.jetbrains.icons.design.IconUnit
import org.jetbrains.icons.design.Rectangle

@Serializable
class DefaultRectangle(override val width: IconUnit, override val height: IconUnit) : Rectangle {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DefaultRectangle

        if (width != other.width) return false
        if (height != other.height) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width.hashCode()
        result = 31 * result + height.hashCode()
        return result
    }

    override fun toString(): String = "DefaultRectangle(width=$width, height=$height)"
}
