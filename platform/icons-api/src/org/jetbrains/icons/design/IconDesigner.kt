// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.design

import org.jetbrains.icons.Icon
import org.jetbrains.icons.ImageResourceLocation
import org.jetbrains.icons.modifiers.IconModifier
import org.jetbrains.icons.modifiers.align
import org.jetbrains.icons.modifiers.cutoutMargin

/**
 * Individual methods act as layers and the order dictates in which order they are rendered.
 *
 * @param IconModifier Modifications that should be performed on the Layer, like sizing, margin, color filters etc.
 *   (order-dependant)
 */
interface IconDesigner {
    fun image(resourceLoader: ImageResourceLocation, modifier: IconModifier = IconModifier)

    fun image(path: String, classLoader: ClassLoader? = null, modifier: IconModifier = IconModifier)

    fun icon(icon: Icon, modifier: IconModifier = IconModifier)

    fun box(modifier: IconModifier = IconModifier, builder: IconDesigner.() -> Unit)

    fun row(modifier: IconModifier = IconModifier, builder: IconDesigner.() -> Unit)

    fun column(modifier: IconModifier = IconModifier, builder: IconDesigner.() -> Unit)

    fun spacer(modifier: IconModifier = IconModifier)

    fun animation(modifier: IconModifier = IconModifier, builder: IconAnimationDesigner.() -> Unit)

    fun shape(color: Color, shape: Shape, modifier: IconModifier = IconModifier)
}

fun IconDesigner.badge(
    color: Color,
    shape: Shape = circle((2.8).dp),
    align: IconAlign = IconAlign.TopRight,
    cutout: IconUnit = 1.2.dp,
    modifier: IconModifier = IconModifier,
) {
    shape(color, shape, modifier.align(align).cutoutMargin(cutout))
}

interface IconAnimationDesigner {
    fun frame(duration: Long, builder: IconDesigner.() -> Unit)
}
