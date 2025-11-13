package com.sopt.dive.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.dive.R
import com.sopt.dive.presentation.search.component.ImageCard
import com.sopt.dive.presentation.search.component.ImageTextCard

@Composable
fun SearchRoute(
    paddingValues: PaddingValues
) {
    SearchScreen(
        paddingValues = paddingValues
    )
}

@Composable
fun SearchScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageCard(
            frontImage = R.drawable.img_front,
            backImage = R.drawable.img_back
        )

        Spacer(modifier = Modifier.height(10.dp))

        ImageTextCard(
            frontImage = R.drawable.img_front
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen(
        paddingValues = PaddingValues()
    )
}