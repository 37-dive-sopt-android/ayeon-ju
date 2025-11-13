package com.sopt.dive.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.sopt.dive.presentation.home.navigation.homeGraph
import com.sopt.dive.presentation.my.navigation.myPageGraph
import com.sopt.dive.presentation.search.navigation.searchGraph
import com.sopt.dive.presentation.signin.navigation.signInGraph
import com.sopt.dive.presentation.signup.navigation.signUpGraph

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {

    val clearStackNavOptions = navOptions {
        popUpTo(0) { inclusive = true }
        launchSingleTop = true
        restoreState = false
    }

    val keepStackNavOptions = navOptions {
        launchSingleTop = true
        restoreState = true
    }

    NavHost(
        modifier = modifier,
        navController = navigator.navController,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        startDestination = navigator.startDestination
    ) {
        signInGraph(
            paddingValues = paddingValues,
            navigateToHome = { navigator.navigateToHome(clearStackNavOptions) },
            navigateToSignUp = { navigator.navigateToSignUp(clearStackNavOptions) }
        )

        signUpGraph(
            paddingValues = paddingValues,
            navigateToSignIn = { navigator.navigateToSignIn(clearStackNavOptions) }
        )

        homeGraph(
            paddingValues = paddingValues
        )

        searchGraph(
            paddingValues = paddingValues
        )

        myPageGraph(
            paddingValues = paddingValues
        )

    }
}