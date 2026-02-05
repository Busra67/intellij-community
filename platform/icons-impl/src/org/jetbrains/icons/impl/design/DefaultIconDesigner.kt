// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.design

import org.jetbrains.icons.Icon
import org.jetbrains.icons.ImageResourceLocation
import org.jetbrains.icons.design.Color
import org.jetbrains.icons.design.IconAnimationDesigner
import org.jetbrains.icons.design.IconDesigner
import org.jetbrains.icons.design.Shape
import org.jetbrains.icons.impl.DefaultLayeredIcon
import org.jetbrains.icons.impl.layers.AnimatedIconLayer
import org.jetbrains.icons.impl.layers.ImageIconLayer
import org.jetbrains.icons.impl.layers.LayoutIconLayer
import org.jetbrains.icons.impl.layers.NestedIconLayer
import org.jetbrains.icons.impl.layers.ShapeIconLayer
import org.jetbrains.icons.impl.layers.SpacerIconLayer
import org.jetbrains.icons.layers.IconLayer
import org.jetbrains.icons.modifiers.IconModifier

abstract class DefaultIconDesigner : IconDesigner {
    protected val layers = mutableListOf<IconLayer>()

    override fun image(resourceLoader: ImageResourceLocation, modifier: IconModifier) {
        layers.add(ImageIconLayer(resourceLoader, modifier))
    }

    override fun icon(icon: Icon, modifier: IconModifier) {
        layers.add(NestedIconLayer(icon, modifier))
    }

    override fun box(modifier: IconModifier, builder: IconDesigner.() -> Unit) {
        layout(LayoutIconLayer.LayoutDirection.Box, modifier, builder)
    }

    override fun row(modifier: IconModifier, builder: IconDesigner.() -> Unit) {
        layout(LayoutIconLayer.LayoutDirection.Row, modifier, builder)
    }

    override fun column(modifier: IconModifier, builder: IconDesigner.() -> Unit) {
        layout(LayoutIconLayer.LayoutDirection.Column, modifier, builder)
    }

    override fun spacer(modifier: IconModifier) {
        layers.add(SpacerIconLayer(modifier))
    }

    private fun layout(
        direction: LayoutIconLayer.LayoutDirection,
        modifier: IconModifier,
        builder: IconDesigner.() -> Unit,
    ) {
        val nestedIconDesigner = createNestedDesigner()
        nestedIconDesigner.builder()
        layers.add(LayoutIconLayer(nestedIconDesigner.buildLayers(), direction, modifier))
    }

    override fun animation(modifier: IconModifier, builder: IconAnimationDesigner.() -> Unit) {
        val designer = DefaultIconAnimationDesigner(this)
        designer.builder()
        layers.add(AnimatedIconLayer(designer.build(), modifier))
    }

    override fun shape(color: Color, shape: Shape, modifier: IconModifier) {
        layers.add(ShapeIconLayer(color, shape, modifier))
    }

    abstract fun createNestedDesigner(): DefaultIconDesigner

    fun build(): DefaultLayeredIcon {
        return DefaultLayeredIcon(buildLayers())
    }

    fun buildLayers(): List<IconLayer> = layers.toList()
}
