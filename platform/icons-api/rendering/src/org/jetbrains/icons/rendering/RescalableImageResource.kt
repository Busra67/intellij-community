// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.rendering

import org.jetbrains.annotations.ApiStatus
import org.jetbrains.icons.scale.IconScale

@ApiStatus.Internal
interface RescalableImageResource : ImageResource {
    fun scale(density: Float, scale: IconScale): BitmapImageResource

    fun calculateExpectedDimensions(density: Float, scale: IconScale): Bounds
}
