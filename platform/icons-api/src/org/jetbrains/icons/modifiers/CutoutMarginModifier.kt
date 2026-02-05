// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.modifiers

import org.jetbrains.icons.IconManager
import org.jetbrains.icons.design.IconUnit

fun IconModifier.cutoutMargin(size: IconUnit): IconModifier {
    return this then IconManager.modifiers().cutoutMargin(size)
}
