// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.modifiers

import org.jetbrains.icons.IconManager
import org.jetbrains.icons.design.BlendMode
import org.jetbrains.icons.design.Color
import org.jetbrains.icons.filters.ColorFilter
import org.jetbrains.icons.filters.tintColorFilter

fun IconModifier.colorFilter(colorFilter: ColorFilter): IconModifier {
    return this then IconManager.modifiers().colorFilter(colorFilter)
}

fun IconModifier.tintColor(color: Color, blendMode: BlendMode): IconModifier {
    return colorFilter(tintColorFilter(color, blendMode))
}
