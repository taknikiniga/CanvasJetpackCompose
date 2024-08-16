package com.taknikiniga.canvaspractice.lession

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.DrawTransform
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
private fun DrawAShader() {
    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(5.dp, color = Color.Red)
    ) {

        val shader = Brush.linearGradient(
            start = Offset.Zero,
            colors = listOf(Color.Blue, Color.Green, Color.Magenta),
            end = Offset(size.width, size.height)
        )

        drawRect(shader)

    }
}

@Preview
@Composable
private fun DrawTransform() {
    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(5.dp, color = Color.White)
            .padding(16.dp)
    ) {
        rotate(degrees = 27f) {
            drawRect(color = Color.Red, size = size)
        }
    }
}

@Preview
@Composable
private fun DrawAClip() {
    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(color = Color.DarkGray, width = 5.dp)
            .padding(16.dp)
    ) {
        clipPath(Path().apply {
            addOval(Rect(Offset.Zero, size))
        }) {
            drawRect(color = Color.Yellow)
        }
    }
}

@Preview
@Composable
private fun DrawArc() {
    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(5.dp, color = Color.Cyan)
            .padding(16.dp)
    ) {
        drawArc(
            color = Color.Red,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = true,
            topLeft = Offset.Zero,
            size = size
        )
    }
}

@Preview
@Composable
private fun DrawPath() {

    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(5.dp, color = Color.Red)
    ) {
        val path = Path().apply {
            moveTo(size.width / 2, 0f)
            lineTo(size.width, size.height / 2)
            lineTo(0f, size.height / 2)
            close()
        }

        drawPath(path, color = Color.Blue, style = Stroke(width = 5f))
    }

}

@Preview(showBackground = true)
@Composable
fun ShapePractice(modifier: Modifier = Modifier) {
    CircleShape()

}

@Composable
fun CircleShape(modifier: Modifier = Modifier) {
    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(5.dp, color = Color.Red)
    ) {
        drawCircle(color = Color.Blue, radius = 200f)
    }
}


@Preview(showBackground = true)
@Composable
fun DrawRect(modifier: Modifier = Modifier) {
    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(5.dp, color = Color.Red)
    ) {
        drawRect(color = Color.Red, size = size)
    }
}


@Preview
@Composable
private fun DrawLine() {

    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(5.dp, color = Color.White)
    ) {
        drawLine(
            color = Color.Blue,
            start = Offset.Zero,
            end = Offset(size.width, size.height),
            cap = StrokeCap.Round,
            strokeWidth = 5f
        )
    }

}


@Preview
@Composable
private fun DrawText() {
    val textMeasurer = rememberTextMeasurer()
    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(5.dp, color = Color.Blue)
            .padding(16.dp)
    ) {
        drawText(textMeasurer, text = "Hello World", size = size)
    }
}

