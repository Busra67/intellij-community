// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.layers

import javax.swing.Icon
import kotlinx.serialization.Serializable
import org.jetbrains.icons.layers.IconLayer
import org.jetbrains.icons.modifiers.IconModifier

@Serializable class SwingIconLayer(val legacyIcon: Icon, override val modifier: IconModifier) : IconLayer
