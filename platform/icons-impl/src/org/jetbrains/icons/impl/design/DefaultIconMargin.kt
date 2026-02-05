// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.design

import kotlinx.serialization.Serializable
import org.jetbrains.icons.design.IconMargin
import org.jetbrains.icons.design.IconUnit

@Serializable
class DefaultIconMargin(
    override val top: IconUnit,
    override val left: IconUnit,
    override val bottom: IconUnit,
    override val right: IconUnit,
) : IconMargin {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as org.jetbrains.icons.design.IconMargin

        if (top != other.top) return false
        if (left != other.left) return false
        if (bottom != other.bottom) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = top.hashCode()
        result = 31 * result + left.hashCode()
        result = 31 * result + bottom.hashCode()
        result = 31 * result + right.hashCode()
        return result
    }

    override fun toString(): String {
        return "IconMargin(top=$top, left=$left, bottom=$bottom, right=$right)"
    }
}
