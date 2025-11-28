package com.sopt.dive.core.designsystem

import androidx.compose.runtime.staticCompositionLocalOf

val LocalAppSnackbarHostState =
    staticCompositionLocalOf<(String) -> Unit> {
        error("No SnackBar provided")
    }