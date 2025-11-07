package com.sopt.dive.presentation.search.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ImageCard(
    @DrawableRes frontImage: Int,
    @DrawableRes backImage: Int,
    modifier: Modifier = Modifier
) {
    var isReversed by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (isReversed) 180f else 0f,
        label = "rotation"
    )

    val image = if (rotation <= 90f) frontImage else backImage
    val visibleRotation = if (rotation <= 90f) rotation else rotation - 180f

    Box(
        modifier = modifier
            .size(300.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .graphicsLayer {
                rotationY = rotation
            }
            .clickable { isReversed = !isReversed },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = image,
            contentDescription = "image card",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .graphicsLayer {
                    rotationY = visibleRotation
            }
        )
    }
}