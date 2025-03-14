package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }

    @Composable
    fun CaptainGame() {
        val treasuresFound = remember {
            mutableStateOf(0)
        }
        val direction = remember {
            mutableStateOf("North")
        }
        val stormOrTreasure = remember {
            mutableStateOf("")
        }

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "찾은 보물의 수 : ${treasuresFound.value}")
            Text(text = "현재 진행 방향 : ${direction.value}")
            Text(text = stormOrTreasure.value)
            Button(onClick = {
                direction.value = "East"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                    stormOrTreasure.value = "보물 발견!"
                } else {
                    stormOrTreasure.value = "폭풍 조우!"
                }
            }) {
                Text(text = "동쪽으로 항해")
            }
            Button(onClick = {
                direction.value = "West"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                    stormOrTreasure.value = "보물 발견!"
                } else {
                    stormOrTreasure.value = "폭풍 조우!"
                }
            }) {
                Text(text = "서쪽으로 항해")
            }
            Button(onClick = {
                direction.value = "South"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                    stormOrTreasure.value = "보물 발견!"
                } else {
                    stormOrTreasure.value = "폭풍 조우!"
                }
            }) {
                Text(text = "남쪽으로 항해")
            }
            Button(onClick = {
                direction.value = "North"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                    stormOrTreasure.value = "보물 발견!"
                } else {
                    stormOrTreasure.value = "폭풍 조우!"
                }
            }) {
                Text(text = "북쪽으로 항해")
            }
        }
    }

}
