package com.taknikiniga.canvaspractice.lession

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ClipPath(modifier: Modifier = Modifier) {

    val sliderValue by remember {
        mutableFloatStateOf(0.2f)
    }

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {


        val height = size.height
        val width = size.width


        val path = Path().apply {

            moveTo(size.width, 0f)
            lineTo(width, height / 2)
            lineTo(0f, height / 2)
            close()
        }

        clipPath(path = path) {

            drawPath(path = path, color = Color.Gray)
            drawRect(color = Color.Yellow, size = Size(width / 4, height))
            drawRect(color = Color.Red, size = Size(sliderValue * width, height))
        }


    }
}


@Composable
fun CircularProgressBar(modifier: Modifier = Modifier) {

    val progressValue by remember {
        mutableFloatStateOf(0.1f)
    }

    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawCircle(color = Color.Red, radius = size.width / 2, style = Stroke(width = 15f))

        drawArc(
            color = Color.Green,
            startAngle = 0f,
            sweepAngle = 360f * progressValue,
            useCenter = false,
            style = Stroke(width = 10f, cap = StrokeCap.Round),
        )

    }


}


@Composable
fun GaugeCircle(modifier: Modifier = Modifier) {

    val progressValue by remember {
        mutableFloatStateOf(0.2f)
    }

    Canvas(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
    ) {


        drawArc(
            color = Color.Gray,
            sweepAngle = 300f,
            startAngle = 120f,
            useCenter = false,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )

        val progress = progressValue * 300


        drawArc(
            color = Color.Red,
            sweepAngle = progress,
            startAngle = 120f,
            useCenter = false,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )

    }

}


@Preview
@Composable
private fun ClipPathPreview() {

    Column {


        GaugeCircle()
        CircularProgressBar()
        ClipPath()
    }
}