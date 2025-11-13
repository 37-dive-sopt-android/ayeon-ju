package com.sopt.dive.presentation.search.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage

@Composable
fun ImageTextCard(
    @DrawableRes frontImage: Int,
    modifier: Modifier = Modifier
) {
    var isReversed by remember { mutableStateOf(false) }

    val transition = updateTransition(
        targetState = isReversed,
        label = "card transition"
    )

    val spring = spring<Float>(
        stiffness = 177.8f,
        dampingRatio = 0.75f
    )

    val rotation by transition.animateFloat(
        transitionSpec = { spring },
        label = "rotate"
    ) { isReversed ->
        if (isReversed) 180f else 0f
    }


    val textAlpha by transition.animateFloat(
        transitionSpec = { spring },
        label = "textAlpha"
    ) { isReversed ->
        if (isReversed) 0f else 1f
    }

    val frontCardCorner = RoundedCornerShape(
        topStart = 20.dp,
        topEnd = 80.dp,
        bottomStart = 80.dp,
        bottomEnd = 20.dp
    )

    val backCardShape = RoundedCornerShape(
        topStart = 80.dp,
        topEnd = 20.dp,
        bottomStart = 20.dp,
        bottomEnd = 80.dp
    )

    Box(
        modifier = modifier
            .size(300.dp)
            .clickable { isReversed = !isReversed },
        contentAlignment = Alignment.Center
    ) {
        BackCard(
            modifier = Modifier
                .zIndex(if (isReversed) 1f else 0f)
                .clip(backCardShape),
        )

        Box(
            modifier = Modifier
                .zIndex(if (isReversed) 0f else 1f)
                .clip(frontCardCorner)
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 12f * density
                }
        ) {
            AsyncImage(
                model = frontImage,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun BackCard(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {
        Text(
            text = "졸려".repeat(50),
            color = Color.Red,
            modifier = Modifier
                .align(alignment = Alignment.Center)
        )
    }
}

