// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.modifiers

import org.jetbrains.icons.IconManager
import org.jetbrains.icons.design.SvgPatcherDesigner
import org.jetbrains.icons.patchers.SvgPatcher
import org.jetbrains.icons.patchers.svgPatcher

fun IconModifier.patchSvg(svgPatcher: SvgPatcher): IconModifier {
    return this then IconManager.modifiers().patchSvg(svgPatcher)
}

fun IconModifier.patchSvg(svgPatcherBuilder: SvgPatcherDesigner.() -> Unit): IconModifier {
    return this.patchSvg(svgPatcher(svgPatcherBuilder))
}
