// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.rendering

import org.jetbrains.icons.Icon
import org.jetbrains.icons.impl.DefaultDeferredIcon
import org.jetbrains.icons.impl.DefaultLayeredIcon
import org.jetbrains.icons.impl.layers.AnimatedIconLayer
import org.jetbrains.icons.impl.layers.ImageIconLayer
import org.jetbrains.icons.impl.layers.LayoutIconLayer
import org.jetbrains.icons.impl.layers.NestedIconLayer
import org.jetbrains.icons.impl.layers.ShapeIconLayer
import org.jetbrains.icons.impl.layers.SpacerIconLayer
import org.jetbrains.icons.impl.rendering.layers.AnimatedIconLayerRenderer
import org.jetbrains.icons.impl.rendering.layers.IconLayerManager
import org.jetbrains.icons.impl.rendering.layers.IconLayerRenderer
import org.jetbrains.icons.impl.rendering.layers.ImageIconLayerRenderer
import org.jetbrains.icons.impl.rendering.layers.LayoutIconLayerRenderer
import org.jetbrains.icons.impl.rendering.layers.NestedIconLayerRenderer
import org.jetbrains.icons.impl.rendering.layers.ShapeIconLayerRenderer
import org.jetbrains.icons.impl.rendering.layers.SpacerIconLayerRenderer
import org.jetbrains.icons.layers.IconLayer
import org.jetbrains.icons.rendering.IconRenderer
import org.jetbrains.icons.rendering.IconRendererManager
import org.jetbrains.icons.rendering.RenderingContext

abstract class DefaultIconRendererManager : IconRendererManager, IconLayerManager {
    init {
        IconLayerManager.setInstance(this)
    }

    override fun createRenderer(icon: Icon, context: RenderingContext): IconRenderer {
        return createRendererOrNull(icon, context) ?: error("Unsupported icon type: $icon")
    }

    protected fun createRendererOrNull(icon: Icon, context: RenderingContext): IconRenderer? {
        return when (icon) {
            is DefaultLayeredIcon -> DefaultIconRenderer(icon, context)
            is DefaultDeferredIcon -> createDeferredIconRenderer(icon, context)
            else -> null
        }
    }

    private fun createDeferredIconRenderer(icon: DefaultDeferredIcon, context: RenderingContext): IconRenderer {
        val renderer = DefaultDeferredIconRenderer(icon, context)
        icon.addDoneListener(renderer)
        return renderer
    }

    override fun createRenderer(layer: IconLayer, renderingContext: RenderingContext): IconLayerRenderer {
        if (renderingContext !is DefaultRenderingContext) error("Unsupported rendering context: $renderingContext")
        return when (layer) {
            is ImageIconLayer -> {
                ImageIconLayerRenderer(layer, renderingContext)
            }
            is NestedIconLayer -> {
                NestedIconLayerRenderer(layer, renderingContext)
            }
            is LayoutIconLayer -> {
                LayoutIconLayerRenderer(layer, renderingContext)
            }
            is AnimatedIconLayer -> {
                AnimatedIconLayerRenderer(layer, renderingContext)
            }
            is ShapeIconLayer -> {
                ShapeIconLayerRenderer(layer, renderingContext)
            }
            is SpacerIconLayer -> {
                SpacerIconLayerRenderer(layer, renderingContext)
            }
            else -> error("Unsupported icon layer type: $layer")
        }
    }
}
