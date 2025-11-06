package com.sopt.dive.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sopt.dive.presentation.home.navigation.navigateToHome
import com.sopt.dive.presentation.my.navigation.navigateToMyPage
import com.sopt.dive.presentation.search.navigation.navigateToSearch
import com.sopt.dive.presentation.signin.navigation.SignIn
import com.sopt.dive.presentation.signin.navigation.navigateToSignIn
import com.sopt.dive.presentation.signup.navigation.navigateToSignUp

class MainNavigator(
    val navController: NavHostController,

    ) {
    val startDestination = SignIn

    private val currentDestination: NavDestination?
        @Composable get() =
            navController.currentBackStackEntryAsState().value?.destination

    val currentTab: MainNavTab?
        @Composable get() = MainNavTab.find {
            currentDestination?.hasRoute(it::class) == true
        }

    fun navigate(tab: MainNavTab) {
        val navOptions =
            navOptions {
                navController.currentDestination?.route?.let {
                    popUpTo(it) {
                        inclusive = true
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true
            }

        val myPageOptions =
            navOptions {
                navController.currentDestination?.route?.let {
                    popUpTo(it) {
                        inclusive = true
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = false
                }
            }

        when (tab) {
            MainNavTab.HOME -> navController.navigateToHome(navOptions = navOptions)
            MainNavTab.SEARCH -> navController.navigateToSearch(navOptions = navOptions)
            MainNavTab.MYPAGE -> navController.navigateToMyPage(navOptions = myPageOptions)
        }
    }

    @Composable
    fun showBottomBar() =
        MainNavTab.contains {
            currentDestination?.hasRoute(it::class) == true
        }

    fun navigateToHome(navOptions: NavOptions) {
        navController.navigateToHome(navOptions)
    }

    fun navigateToSearch(navOptions: NavOptions) {
        navController.navigateToSearch(navOptions)
    }

    fun navigateToMyPage(navOptions: NavOptions) {
        navController.navigateToMyPage(navOptions)
    }

    fun navigateToSignIn(navOptions: NavOptions) {
        navController.navigateToSignIn(navOptions)
    }

    fun navigateToSignUp(navOptions: NavOptions) {
        navController.navigateToSignUp(navOptions)
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController()
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
