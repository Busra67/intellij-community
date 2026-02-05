// This file is used by Jewel gradle script, check community/platform/jewel

plugins {
  jewel
}

sourceSets {
  main {
    kotlin {
      setSrcDirs(listOf("src"))
    }
  }

  test {
    kotlin {
      setSrcDirs(listOf("test"))
    }
  }
}

dependencies {
  api("org.jetbrains:annotations:26.0.2")
  api(libs.kotlinx.coroutines.core)
}
