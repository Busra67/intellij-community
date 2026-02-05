// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.patchers

import org.jetbrains.icons.IconManager
import org.jetbrains.icons.design.SvgPatcherDesigner

interface SvgPatcher {
    fun combineWith(other: SvgPatcher?): SvgPatcher?
}

fun svgPatcher(designer: SvgPatcherDesigner.() -> Unit): SvgPatcher {
    return IconManager.getInstance().svgPatcher(designer)
}
