package com.taknikiniga.canvaspractice.lession

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun PracticeProgressBar(modifier: Modifier = Modifier) {


    var progressValue by remember {
        mutableFloatStateOf(0.9f)
    }


    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(16.dp)
    ) {

        val width = size.width
        val height = size.height

        /*
        *
        * Drawing Rectangle Progress Bar
        *
        * */

//        val path = Path().apply {
//

//            moveTo(width / 2, 0f)
//            lineTo(0f, height / 2)
//            lineTo(width / 2, height / 2)
//            close()
//
//
//        }
//
//
//
//        clipPath(path = path) {
//
//            drawPath(path, color = Color.Red)
//            drawRect(color = Color.White, size = Size(progressValue * size.width, size.height))
//
//        }


        /*
        *
        * Drawing Circle Progress Bar
        *
        * */


//        drawCircle(color = Color.White, radius = width / 2, style = Stroke(width = 30f))
//        drawArc(
//            color = Color.Blue,
//            sweepAngle = progressValue * size.width/2,
//            startAngle = 0f,
//            useCenter = false, style = Stroke(width =20f, cap = StrokeCap.Round)
//        )


        drawArc(color = Color.White, sweepAngle = 300f, startAngle = 120f,
            useCenter = false, style = Stroke(width = 30f, cap = StrokeCap.Round))

        drawArc(color = Color.Red, sweepAngle = progressValue * 300f, startAngle = 120f,
            useCenter = false, style = Stroke(width = 30f, cap = StrokeCap.Round))
    }


}

@Preview
@Composable
private fun PreviewProgressBar() {
    PracticeProgressBar()
}