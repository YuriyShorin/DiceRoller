package course.google.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import course.google.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceWithButtonAndImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var headerText by remember { mutableStateOf("Roll!") }
    var pick = 0
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = headerText,
            fontFamily = FontFamily(Font(R.font.helveticaneuecyr_black)),
            fontSize = 70.sp,
            color = colorResource(R.color.purple),
            lineHeight = 75.sp
        )
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            colors = ButtonDefaults.buttonColors(colorResource(R.color.purple), Color.Yellow),
            onClick = {
                if (pick == 0) {
                    headerText = "Your bet!"
                    return@Button
                }
                result = (1..6).random()
                headerText = if (result == pick) {
                    "You won!"
                } else {
                    "You lost :("
                }
            }) {
            Text(
                stringResource(R.string.roll),
                fontSize = 35.sp
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                colors = ButtonDefaults.buttonColors(
                    colorResource(R.color.purple),
                    Color.Yellow
                ), onClick = { pick = 1 }) {
                BetButtonText(text = "1")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                colors = ButtonDefaults.buttonColors(
                    colorResource(R.color.purple),
                    Color.Yellow
                ), onClick = { pick = 2 }) {
                BetButtonText(text = "2")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                colors = ButtonDefaults.buttonColors(
                    colorResource(R.color.purple),
                    Color.Yellow
                ), onClick = { pick = 3 }) {
                BetButtonText(text = "3")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                colors = ButtonDefaults.buttonColors(
                    colorResource(R.color.purple),
                    Color.Yellow
                ), onClick = { pick = 4 }) {
                BetButtonText(text = "4")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                colors = ButtonDefaults.buttonColors(
                    colorResource(R.color.purple),
                    Color.Yellow
                ),
                onClick = { pick = 5 }) {
                BetButtonText(text = "5")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                colors = ButtonDefaults.buttonColors(
                    colorResource(R.color.purple),
                    Color.Yellow
                ), onClick = { pick = 6 }) {
                BetButtonText(text = "6")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun BetButtonText(text : String) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.helveticaneuecyr_black)),
        fontSize = 20.sp
    )
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}