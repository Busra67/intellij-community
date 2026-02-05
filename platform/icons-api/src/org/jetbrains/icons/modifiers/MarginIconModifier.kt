// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.modifiers

import org.jetbrains.icons.IconManager
import org.jetbrains.icons.design.IconUnit

fun IconModifier.margin(left: IconUnit, top: IconUnit, right: IconUnit, bottom: IconUnit): IconModifier {
    return this then IconManager.modifiers().margin(left, top, right, bottom)
}

fun IconModifier.margin(all: IconUnit): IconModifier {
    return margin(all, all, all, all)
}

fun IconModifier.margin(vertical: IconUnit, horizontal: IconUnit): IconModifier {
    return margin(horizontal, vertical, horizontal, vertical)
}
