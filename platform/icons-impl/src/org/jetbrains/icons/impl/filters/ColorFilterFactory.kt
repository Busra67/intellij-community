// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.filters

import org.jetbrains.icons.design.BlendMode
import org.jetbrains.icons.design.Color
import org.jetbrains.icons.filters.ColorFilter
import org.jetbrains.icons.filters.ColorFilterFactory

object DefaultColorFilterFactory : ColorFilterFactory {
    override fun tintColor(color: Color, blendMode: BlendMode): ColorFilter {
        return TintColorFilter(color, blendMode)
    }
}
