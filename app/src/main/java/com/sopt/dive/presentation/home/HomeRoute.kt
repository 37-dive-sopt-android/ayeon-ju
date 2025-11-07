package com.sopt.dive.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.dive.presentation.home.component.ProfileCard
import com.sopt.dive.presentation.home.model.userProfileList
import com.sopt.dive.ui.theme.DiveTheme


@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    HomeScreen(
        paddingValues = paddingValues,
        modifier = modifier
    )
}

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(items = userProfileList, key = { it.nickname }) { profile ->
            ProfileCard(
                name = profile.nickname,
                title = profile.title
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DiveTheme {

    }
}