// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.intellij.rendering

import com.intellij.util.ui.StartupUiUtil
import kotlinx.coroutines.CoroutineScope
import org.jetbrains.icons.impl.intellij.rendering.images.IntelliJImageResourceProvider
import org.jetbrains.icons.rendering.ImageModifiers
import org.jetbrains.icons.rendering.MutableIconUpdateFlow
import org.jetbrains.icons.rendering.RenderingContext
import org.jetbrains.icons.impl.rendering.CoroutineBasedMutableIconUpdateFlow
import org.jetbrains.icons.impl.rendering.DefaultIconRendererManager
import org.jetbrains.icons.layers.IconLayer
import org.jetbrains.icons.impl.rendering.DefaultImageModifiers
import org.jetbrains.icons.impl.rendering.layers.IconLayerRenderer
import org.jetbrains.icons.impl.layers.SwingIconLayer
import org.jetbrains.icons.impl.patchers.DefaultSvgPatcher
import org.jetbrains.icons.impl.rendering.DefaultRenderingContext

@Suppress("UNCHECKED_CAST")
class IntelliJIconRendererManager: DefaultIconRendererManager() {
  private val imageProvider = IntelliJImageResourceProvider()

  override fun createRenderer(layer: IconLayer, renderingContext: RenderingContext): IconLayerRenderer {
    if (layer is SwingIconLayer) {
      return SwingIconLayerRenderer(layer, renderingContext as DefaultRenderingContext)
    } else {
      return super.createRenderer(layer, renderingContext)
    }
  }

  override fun createUpdateFlow(scope: CoroutineScope?, updateCallback: (Int) -> Unit): MutableIconUpdateFlow {
    if (scope != null) {
      return CoroutineBasedMutableIconUpdateFlow(scope, updateCallback)
    } else {
      return IntelliJMutableIconUpdateFlowImpl(updateCallback)
    }
  }

  override fun createRenderingContext(
    updateFlow: MutableIconUpdateFlow,
    defaultImageModifiers: ImageModifiers?,
  ): RenderingContext {
    val knownModifiers = defaultImageModifiers as? DefaultImageModifiers
    return DefaultRenderingContext(
      updateFlow,
      DefaultImageModifiers(
        knownModifiers?.colorFilter,
        knownModifiers?.svgPatcher,
        StartupUiUtil.isDarkTheme,
        knownModifiers?.stroke
      ),
      imageProvider
    )
  }
}