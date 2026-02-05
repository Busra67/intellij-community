// Copyright 2000-2026 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.icons.impl.intellij.modifiers

import org.jetbrains.icons.design.dp
import org.jetbrains.icons.icon
import org.jetbrains.icons.impl.intellij.testIcons
import org.jetbrains.icons.modifiers.IconModifier
import org.jetbrains.icons.modifiers.margin
import org.junit.jupiter.api.Test

class MarginModifierTest {
  @Test
  fun `should properly apply margin modifier`() {
    testIcons {
      val imgA = testImage(20, 20)

      val result = pretendToRender(
        icon {
          row {
            image(imgA, modifier = IconModifier.margin(1.dp, 2.dp, 3.dp, 4.dp))
          }
        }
      )

      result.assertSize(24, 26)
      result.assertImage(1, 2, 20, 20, imgA)
    }
  }
}
