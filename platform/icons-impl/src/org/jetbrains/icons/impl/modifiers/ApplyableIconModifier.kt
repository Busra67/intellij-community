// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.modifiers

import org.jetbrains.icons.impl.rendering.layers.LayerLayout
import org.jetbrains.icons.modifiers.IconModifier

interface ApplyableIconModifier : IconModifier {
    fun applyTo(layout: LayerLayout): LayerLayout
}
