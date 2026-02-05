// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.modifiers

import org.jetbrains.annotations.ApiStatus
import org.jetbrains.icons.design.Color
import org.jetbrains.icons.design.IconAlign
import org.jetbrains.icons.design.IconUnit
import org.jetbrains.icons.filters.ColorFilter
import org.jetbrains.icons.patchers.SvgPatcher
import org.jetbrains.icons.scale.IconScale

@ApiStatus.Internal
interface ModifiersFactory {
    fun combine(a: IconModifier, b: IconModifier): IconModifier

    fun align(align: IconAlign): IconModifier

    fun alpha(alpha: Float): IconModifier

    fun colorFilter(colorFilter: ColorFilter): IconModifier

    fun cutoutMargin(size: IconUnit): IconModifier

    fun margin(left: IconUnit, top: IconUnit, right: IconUnit, bottom: IconUnit): IconModifier

    fun scale(scale: IconScale): IconModifier

    fun stroke(color: Color): IconModifier

    fun patchSvg(svgPatcher: SvgPatcher): IconModifier
}
