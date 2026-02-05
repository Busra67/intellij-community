// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.filters

import org.jetbrains.icons.IconManager
import org.jetbrains.icons.design.BlendMode
import org.jetbrains.icons.design.Color

fun tintColorFilter(color: Color, blendMode: BlendMode = BlendMode.SrcIn): ColorFilter {
    return IconManager.colorFilters().tintColor(color, blendMode)
}
