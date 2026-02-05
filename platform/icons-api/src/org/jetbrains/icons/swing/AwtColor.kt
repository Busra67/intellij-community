// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.swing

import org.jetbrains.icons.IconManager
import org.jetbrains.icons.design.Color

fun Color.toAwtColor(): java.awt.Color {
    return IconManager.getInstance().unitsFactory().toAwtColor(this)
}
