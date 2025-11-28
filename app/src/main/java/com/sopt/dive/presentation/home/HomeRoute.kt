package com.sopt.dive.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.dive.presentation.home.component.ProfileCard
import com.sopt.dive.presentation.home.model.userProfileList

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        uiState = uiState,
        paddingValues = paddingValues,
        modifier = modifier
    )
}

@Composable
fun HomeScreen(
    uiState: HomeState,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(items = uiState.users, key = { it.id }) { user ->
            ProfileCard(
                avatar = user.avatar,
                name = "${user.firstname} ${user.lastname}",
                title = user.email,
            )
        }
    }
}

