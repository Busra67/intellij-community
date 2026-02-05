// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl

import java.awt.Color
import org.jetbrains.icons.design.Circle
import org.jetbrains.icons.design.DisplayPoint
import org.jetbrains.icons.design.IconAlign
import org.jetbrains.icons.design.IconHorizontalAlign
import org.jetbrains.icons.design.IconMargin
import org.jetbrains.icons.design.IconUnit
import org.jetbrains.icons.design.IconVerticalAlign
import org.jetbrains.icons.design.Pixel
import org.jetbrains.icons.design.Rectangle
import org.jetbrains.icons.design.SRGBColor
import org.jetbrains.icons.design.UnitsFactory
import org.jetbrains.icons.impl.design.DefaultCircle
import org.jetbrains.icons.impl.design.DefaultDisplayPoint
import org.jetbrains.icons.impl.design.DefaultFactorScale
import org.jetbrains.icons.impl.design.DefaultFillAreaScale
import org.jetbrains.icons.impl.design.DefaultFitAreaScale
import org.jetbrains.icons.impl.design.DefaultIconAlign
import org.jetbrains.icons.impl.design.DefaultIconMargin
import org.jetbrains.icons.impl.design.DefaultPixel
import org.jetbrains.icons.impl.design.DefaultRectangle
import org.jetbrains.icons.impl.design.DefaultSRGB
import org.jetbrains.icons.scale.FactorScale
import org.jetbrains.icons.scale.FillAreaScale
import org.jetbrains.icons.scale.FitAreaScale

object DefaultUnitsFactory : UnitsFactory {
    override fun align(verticalAlign: IconVerticalAlign, horizontalAlign: IconHorizontalAlign): IconAlign {
        return DefaultIconAlign(verticalAlign, horizontalAlign)
    }

    override fun margin(top: IconUnit, left: IconUnit, bottom: IconUnit, right: IconUnit): IconMargin {
        return DefaultIconMargin(top, left, bottom, right)
    }

    override fun circle(radius: IconUnit): Circle {
        return DefaultCircle(radius)
    }

    override fun rectangle(width: IconUnit, height: IconUnit): Rectangle {
        return DefaultRectangle(width, height)
    }

    override fun sRGB(red: Float, green: Float, blue: Float, alpha: Float): SRGBColor {
        return DefaultSRGB(red, green, blue, alpha)
    }

    override fun sRGBHex(hex: String): SRGBColor {
        return DefaultSRGB.fromHex(hex)
    }

    override fun dp(value: Double): DisplayPoint {
        return DefaultDisplayPoint(value)
    }

    override fun px(value: Int): Pixel {
        return DefaultPixel(value)
    }

    override fun factorScale(factor: Double): FactorScale {
        return DefaultFactorScale(factor)
    }

    override fun fitAreaScale(width: IconUnit, height: IconUnit, relative: Boolean): FitAreaScale {
        return DefaultFitAreaScale(width, height, relative)
    }

    override fun fillAreaScale(width: IconUnit, height: IconUnit, relative: Boolean): FillAreaScale {
        return DefaultFillAreaScale(width, height, relative)
    }

    override fun toAwtColor(color: org.jetbrains.icons.design.Color): Color {
        @Suppress("UseJBColor")
        return when (color) {
            is DefaultSRGB -> Color(color.red, color.green, color.blue, color.alpha)
            else -> error("Unsupported color: $this")
        }
    }
}
