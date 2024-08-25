package com.taknikiniga.canvaspractice.lession

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Lession6(modifier: Modifier = Modifier) {


    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)) {
//        drawCircle(color = Color.White, radius = 200f, style = Stroke(width = 10f))
//        drawCircle(color = Color.White, radius = 180f, style = Stroke(width = 8f))
//        drawCircle(color = Color.White, radius = 160f, style = Stroke(width = 6f))


        val colorList = listOf(
            Color(0xFFC06667),
            Color(0xFF3F51B5),
        )

        val brush = Brush.linearGradient(colors = colorList)

        val path = Path().apply {

            val width = size.width
            val height = size.height

            moveTo(0f, height/2)
            quadraticBezierTo(width/2,-height/7f,width/2,height/3f)
            quadraticBezierTo(width/2,height,width,height/4f)
            lineTo(width,0f)
            lineTo(0f,0f)
            close()
        }

        val pathLine = Path().apply {

            val width = size.width
            val height = size.height

            moveTo(0f, height/2)
            quadraticBezierTo(width/2,-height/7f,width/2,height/3f)
            quadraticBezierTo(width/2,height,width,height/4f)
//            lineTo(width,0f)
//            lineTo(0f,0f)
//            close()
        }


        drawPath(path, brush = brush)
        drawPath(pathLine, color = Color.White, style = Stroke(width = 10f))
    }

}


@Preview
@Composable
private fun PreviewLession6() {
    Lession6()
}