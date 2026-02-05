// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.jewel.ui.icon

import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import org.jetbrains.annotations.ApiStatus
import org.jetbrains.icons.design.Circle
import org.jetbrains.icons.design.DisplayPoint
import org.jetbrains.icons.design.IconAlign
import org.jetbrains.icons.design.Shape
import org.jetbrains.icons.design.IconDesigner
import org.jetbrains.icons.design.IconUnit
import org.jetbrains.icons.design.Rectangle
import org.jetbrains.icons.design.badge
import org.jetbrains.icons.design.circle
import org.jetbrains.icons.design.dp
import org.jetbrains.icons.design.px
import org.jetbrains.icons.design.rectangle
import org.jetbrains.icons.filters.ColorFilter
import org.jetbrains.icons.impl.design.DefaultSRGB
import org.jetbrains.icons.impl.filters.TintColorFilter
import org.jetbrains.icons.modifiers.IconModifier
import org.jetbrains.icons.modifiers.stroke
import org.jetbrains.icons.modifiers.tintColor
import org.jetbrains.icons.scale.FillAreaScale
import org.jetbrains.icons.scale.FitAreaScale
import org.jetbrains.icons.scale.fillArea
import org.jetbrains.icons.scale.fitArea
import org.jetbrains.jewel.foundation.ExperimentalJewelApi

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun IconModifier.tintColor(composeColor: Color, blendMode: BlendMode = BlendMode.SrcIn): IconModifier {
    return tintColor(composeColor.toIconsColor(), blendMode.toIconsBlendMode())
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun circle(radius: Dp): Circle {
    return circle(radius.toIconsDp())
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun rectangle(width: Dp, heigth: Dp): Rectangle {
    return rectangle(width.toIconsDp(), heigth.toIconsDp())
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun fitArea(width: Dp, heigth: Dp): FitAreaScale {
    return fitArea(width.toIconsDp(), heigth.toIconsDp())
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun fillArea(width: Dp, heigth: Dp): FillAreaScale {
    return fillArea(width.toIconsDp(), heigth.toIconsDp())
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun Dp.toIconsDp(): DisplayPoint {
    return this.value.dp
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun IconModifier.stroke(composeColor: Color): IconModifier {
    return stroke(composeColor.toIconsColor())
}


@ExperimentalJewelApi
@ApiStatus.Experimental
public fun IconDesigner.badge(
    color: Color,
    shape: Shape = circle(2.8.dp),
    align: IconAlign = IconAlign.TopRight,
    cutout: IconUnit = 1.2.dp,
    modifier: IconModifier = IconModifier,
) {
    badge(color.toIconsColor(), shape, align, cutout, modifier)
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun ColorFilter.toCompose(): androidx.compose.ui.graphics.ColorFilter {
    return when (this) {
        is TintColorFilter -> androidx.compose.ui.graphics.ColorFilter.tint(color.toCompose(), blendMode.toCompose())
        else -> error("Unsupported color filter $this")
    }
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun org.jetbrains.icons.design.Color.toCompose(): Color {
    return when (this) {
        is DefaultSRGB -> Color(red, green, blue, alpha)
        else -> error("Unsupported color $this")
    }
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun org.jetbrains.icons.design.BlendMode.toCompose(): BlendMode {
    return when (this) {
        org.jetbrains.icons.design.BlendMode.SrcIn -> BlendMode.SrcIn
        org.jetbrains.icons.design.BlendMode.Color -> BlendMode.Color
        org.jetbrains.icons.design.BlendMode.Hue -> BlendMode.Hue
        org.jetbrains.icons.design.BlendMode.Luminosity -> BlendMode.Luminosity
        org.jetbrains.icons.design.BlendMode.Saturation -> BlendMode.Saturation
        org.jetbrains.icons.design.BlendMode.Multiply -> BlendMode.Multiply
    }
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun BlendMode.toIconsBlendMode(): org.jetbrains.icons.design.BlendMode {
    return when (this) {
        BlendMode.SrcIn -> org.jetbrains.icons.design.BlendMode.SrcIn
        BlendMode.Color -> org.jetbrains.icons.design.BlendMode.Color
        BlendMode.Hue -> org.jetbrains.icons.design.BlendMode.Hue
        BlendMode.Luminosity -> org.jetbrains.icons.design.BlendMode.Luminosity
        BlendMode.Saturation -> org.jetbrains.icons.design.BlendMode.Saturation
        BlendMode.Multiply -> org.jetbrains.icons.design.BlendMode.Multiply
        else -> error("Unsupported Compose blend mode $this")
    }
}

@ExperimentalJewelApi
@ApiStatus.Experimental
public fun Color.toIconsColor(): org.jetbrains.icons.design.Color {
    return DefaultSRGB(red, green, blue, alpha)
}
