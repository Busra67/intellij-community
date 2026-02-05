// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.rendering

import org.jetbrains.annotations.ApiStatus
import org.jetbrains.icons.Icon

interface IconRenderer {
    val icon: Icon

    @ApiStatus.Internal fun render(paintingContext: LayerPaintingContext)

    @ApiStatus.Internal fun calculateUsedDimensions(scaling: ScalingContext): Dimensions
}
