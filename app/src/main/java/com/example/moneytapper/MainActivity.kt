package com.example.moneytapper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneytapper.ui.theme.MoneyTapperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyTapperTheme {
                    MoneyTapper()
            }
        }
    }
}

@Composable
fun MoneyTapper() {
    val amountOfMoney = remember {
        mutableStateOf(0)
    }
    Surface(modifier = Modifier.fillMaxSize(),
    color = Color.LightGray) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${amountOfMoney.value}$",
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(50.dp))
            CreateCircle(amount = amountOfMoney.value) { newValue ->
                amountOfMoney.value = newValue
            }
        }
    }
}

@Composable
private fun CreateCircle(amount: Int, onAmountChange:(Int) -> Unit) {

    Card(
        modifier = Modifier
            .size(100.dp)
            .clickable {
                onAmountChange(amount + 10)
            },
        backgroundColor = Color.Black,
        shape = CircleShape,
        elevation = 4.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Tap",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoneyTapperTheme {
        MoneyTapper()
    }
}