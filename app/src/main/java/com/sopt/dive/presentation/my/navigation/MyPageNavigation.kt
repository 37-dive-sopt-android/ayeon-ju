package com.sopt.dive.presentation.my.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.dive.core.navigation.MainTabRoute
import com.sopt.dive.presentation.my.MyPageRoute
import kotlinx.serialization.Serializable


fun NavController.navigateToMyPage(navOptions: NavOptions? = null) {
    navigate(MyPage, navOptions)
}

fun NavGraphBuilder.myPageGraph(
    paddingValues: PaddingValues
) {
    composable<MyPage>{
        MyPageRoute(
            paddingValues = paddingValues
        )

    }
}
@Serializable
data object MyPage : MainTabRoute