package com.sopt.dive.presentation.main

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.sopt.dive.R
import com.sopt.dive.core.navigation.MainTabRoute
import com.sopt.dive.presentation.home.navigation.Home
import com.sopt.dive.presentation.my.navigation.MyPage
import com.sopt.dive.presentation.search.navigation.Search

enum class MainNavTab(
    @DrawableRes val icon: Int,
    val contentDescription: String,
    val route: MainTabRoute
) {
    HOME(
        icon = R.drawable.ic_home,
        contentDescription = "home",
        route = Home
    ),

    SEARCH(
        icon = R.drawable.ic_search,
        contentDescription = "search",
        route = Search
    ),

    MYPAGE(
        icon = R.drawable.ic_mypage,
        contentDescription = "mypage",
        route = MyPage
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainNavTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (MainTabRoute) -> Boolean): Boolean {
            return entries.any { predicate(it.route) }
        }
    }
}
