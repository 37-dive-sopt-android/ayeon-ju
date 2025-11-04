package com.sopt.dive.presentation.my

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.dive.R
import com.sopt.dive.ui.theme.DiveTheme

@Composable
fun MyPageRoute(
    userId: String,
    userPassword: String,
    nickname: String,
    userAlcohol: String,
    modifier: Modifier = Modifier
) {
    MyPageScreen(
        userId = userId,
        userPassword = userPassword,
        nickname = nickname,
        userAlcohol = userAlcohol,
        modifier = modifier
    )
}
@Composable
fun MyPageScreen(
    userId: String,
    userPassword: String,
    nickname: String,
    userAlcohol: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 24.dp, vertical = 32.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.img_profile),
                contentDescription = "profile image",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(32.dp)
            )

            Text(
                text = nickname,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
            )
        }

        Text(
            text = "안녕하세요 ${nickname}입니다.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(30.dp))

        UserInfo(
            title = "ID",
            value = userId
        )

        UserInfo(
            title = "PW",
            value = userPassword
        )

        UserInfo(
            title = "NICKNAME",
            value = nickname
        )

        UserInfo(
            title = "주량",
            value = userAlcohol
        )
    }
}

@Composable
fun UserInfo(
    title: String,
    value: String
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DiveTheme {
        MyPageScreen(
            userId = "",
            userPassword = "",
            nickname = "",
            userAlcohol = ""
        )
    }
}