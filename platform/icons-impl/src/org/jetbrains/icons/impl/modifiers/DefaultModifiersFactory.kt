// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.modifiers

import org.jetbrains.icons.design.Color
import org.jetbrains.icons.design.IconAlign
import org.jetbrains.icons.design.IconUnit
import org.jetbrains.icons.filters.ColorFilter
import org.jetbrains.icons.impl.patchers.DefaultSvgPatcher
import org.jetbrains.icons.modifiers.IconModifier
import org.jetbrains.icons.modifiers.ModifiersFactory
import org.jetbrains.icons.patchers.SvgPatcher
import org.jetbrains.icons.scale.IconScale

object DefaultModifiersFactory : ModifiersFactory {
    override fun combine(a: IconModifier, b: IconModifier): IconModifier {
        val aCasted = a as? ApplyableIconModifier ?: RootIconModifier
        val bCasted = b as? ApplyableIconModifier ?: RootIconModifier
        return CombinedIconModifier(aCasted, bCasted)
    }

    override fun align(align: IconAlign): IconModifier {
        return AlignIconModifier(align)
    }

    override fun alpha(alpha: Float): IconModifier {
        return AlphaIconModifier(alpha)
    }

    override fun colorFilter(colorFilter: ColorFilter): IconModifier {
        return ColorFilterModifier(colorFilter)
    }

    override fun cutoutMargin(size: IconUnit): IconModifier {
        return CutoutMarginModifier(size)
    }

    override fun margin(left: IconUnit, top: IconUnit, right: IconUnit, bottom: IconUnit): IconModifier {
        return MarginIconModifier(left, top, right, bottom)
    }

    override fun stroke(color: Color): IconModifier {
        return StrokeModifier(color)
    }

    override fun scale(scale: IconScale): IconModifier {
        return ScaleModifier(scale)
    }

    override fun patchSvg(svgPatcher: SvgPatcher): IconModifier {
        return SvgPatcherModifier(svgPatcher as? DefaultSvgPatcher ?: error("Unsupported svgPatcher: $svgPatcher"))
    }
}
