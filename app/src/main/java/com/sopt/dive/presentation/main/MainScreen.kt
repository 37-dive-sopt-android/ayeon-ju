package com.sopt.dive.presentation.main

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.sopt.dive.core.designsystem.LocalAppSnackbarHostState
import com.sopt.dive.presentation.main.component.MainBottomBar
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator()
) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    val currentTab = navigator.currentTab
    val showBottomBar = navigator.showBottomBar()

    val onShowSnackBar: (String) -> Unit = { message ->
        scope.launch {
            snackBarHostState.currentSnackbarData?.dismiss()
            val job = launch {
                snackBarHostState.showSnackbar(message)
            }
            delay(3000L)
            job.cancel()
        }
    }

    CompositionLocalProvider(
        LocalAppSnackbarHostState provides onShowSnackBar
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
            bottomBar = {
                MainBottomBar(
                    visible = showBottomBar,
                    tabs = MainNavTab.entries.toImmutableList(),
                    currentTab = currentTab,
                    onTabSelected = { selectedTab ->
                        navigator.navigate(tab = selectedTab)
                    }
                )
            }
        ) { innerPadding ->
            MainNavHost(
                navigator = navigator,
                paddingValues = innerPadding
            )
        }
    }
}