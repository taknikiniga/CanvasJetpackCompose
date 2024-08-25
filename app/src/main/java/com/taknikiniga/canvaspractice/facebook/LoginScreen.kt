package com.taknikiniga.canvaspractice.facebook

import android.media.tv.TvContract.Channels.Logo
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.taknikiniga.canvaspractice.R


@Preview(showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}

@Composable
fun LoginScreen() {


    val colorList = listOf(
        Color(0xFF2739B0),
        Color(0xFF01133F),
    )

    val brush = Brush.linearGradient(colors = colorList)


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = brush)
    )


    Box(modifier = Modifier
        .fillMaxSize()
        .drawWithContent {

            val width = size.width
            val height = size.height

            /*
        * Circle Path
        * */

            val circlePath = Path().apply {

                moveTo(0f, height / 2)
                addOval(Rect(center = Offset(0f, height), radius = width / 2))
            }

            val liquidPath = Path().apply {
                moveTo(width / 1.5f, 0f)
                cubicTo(0f, height / 3f, width, height / 2, width, height / 1.5f)
                lineTo(width, 0f)
                close()
            }

            drawPath(circlePath, color = Color(0xFFDE62F3), blendMode = BlendMode.Saturation)
            drawPath(liquidPath, color = Color(0xFFDE62F3), blendMode = BlendMode.Saturation)

        })


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), color = Color.Transparent
    ) {


        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Logo()
            MidContent()
            BottomSection()
        }


    }

}

@Composable
fun Logo(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Facebook",
            style = MaterialTheme.typography.displayMedium,
            color = Color.White, fontWeight = FontWeight.Bold
        )

        Image(
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = Color.White), modifier = Modifier.size(80.dp)
        )
    }
}

@Composable
fun MidContent(modifier: Modifier = Modifier) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier.padding(20.dp)
    ) {


        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label = {
            Text(text = "Username", color = Color.Gray)
        }, leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.outline_person_2_24),
                contentDescription = "", tint = Color.Gray
            )
        }, modifier = Modifier.fillMaxWidth(), shape = MaterialTheme.shapes.extraLarge)


        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label = {
            Text(text = "Password", color = Color.Gray)
        }, leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.outline_lock_24),
                contentDescription = "", tint = Color.Gray
            )
        }, modifier = Modifier.fillMaxWidth(), shape = MaterialTheme.shapes.extraLarge)


        Spacer(modifier = Modifier.padding(10.dp))


        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Login Now")
        }


        Spacer(modifier = Modifier.padding(8.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(modifier = Modifier.weight(1f))
            Text(
                text = "OR",
                color = Color.White,
                modifier = Modifier
                    .weight(.5f)
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
            Divider(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.padding(8.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Login As Guest")
        }

        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "Forgot Password", color = Color.White)


    }
}


@Composable
fun BottomSection(modifier: Modifier = Modifier) {

    Column(modifier = Modifier.padding(20.dp)) {


        OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth().height(56.dp)) {
            Text(text = "Create new Account", color = Color.White)
        }

    }
}
