package com.taknikiniga.canvaspractice.lession

import android.graphics.DiscretePathEffect
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StampedPathEffectStyle
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asAndroidPathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Lession5(modifier: Modifier = Modifier) {


    val density = LocalDensity.current
    val LINE_WIDTH = 20.0f

    with(density) {
        val lineOnInterval = (LINE_WIDTH * 4).toDp().toPx()
        val lineOffInterval = (LINE_WIDTH * 2).toDp().toPx()


        val pathEffect = PathEffect.dashPathEffect(
            floatArrayOf(
                lineOnInterval,
                lineOffInterval,

                ), phase = 0f
        )
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {

            drawLine(
                color = Color.White,
                start = Offset(0f, size.height / 2),
                end = Offset(size.width, size.height / 2),
                pathEffect = pathEffect,
                strokeWidth = 20f,
                cap = StrokeCap.Round
            )

        }

    }


}

@Composable
fun MorseCodeEffect(modifier: Modifier = Modifier) {


    val LINE_WIDTH = 20.0f
    val density = LocalDensity.current

    with(density) {

        val dashOnInterval = (LINE_WIDTH * 4).toDp().toPx()
        val dashOffInterval = (LINE_WIDTH * 2).toDp().toPx()
        val dotOnInterval = (LINE_WIDTH / 4).toDp().toPx()
        val dotOffInterval = (LINE_WIDTH * 2).toDp().toPx()

        val morsePathEffect = PathEffect.dashPathEffect(
            floatArrayOf(
                dashOnInterval,
                dashOffInterval,
                dotOnInterval,
                dotOffInterval
            ), phase = 0f
        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {

            drawLine(
                color = Color.White,
                start = Offset(0f, size.height / 2),
                end = Offset(size.width, size.height / 2),
                pathEffect = morsePathEffect,
                strokeWidth = 20f,
                cap = StrokeCap.Round
            )
        }


    }


}


@Composable
fun DotDash(modifier: Modifier = Modifier) {


    val dotRadus = 10
    val dotSpace = dotRadus * 10.0f

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp)
    ) {

        val circle = Path().apply {
            addOval(Rect(center = Offset.Zero, radius = dotRadus.toDp().toPx()))
        }


        val pathEffect =
            PathEffect.stampedPathEffect(circle, dotSpace, 10f, StampedPathEffectStyle.Translate)



        drawLine(
            color = Color.White,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            pathEffect = pathEffect,
            cap = StrokeCap.Round,
            strokeWidth = 10f
        )

    }

}


@Composable
fun HeartComp(modifier: Modifier = Modifier) {


    val destiny = LocalDensity.current
    val shapeWidth  = 50f
    
    val zigzag= remember {
        with(destiny){
            Path().apply {

                val width = shapeWidth.toDp().toPx()
                val height = shapeWidth.toDp().toPx()
//                moveTo(width/2,0f)
                cubicTo(width,0f,width,height/2,width/2,height)

//                lineTo(width,0f)

            }
        }
    }

    Canvas(
        modifier = Modifier
            .size(200.dp)
    ) {

        val pathEffect =
            PathEffect.stampedPathEffect(zigzag, shapeWidth.toDp().toPx(), 10f, StampedPathEffectStyle.Translate)

        drawLine(
            color = Color.White,
            start = Offset(size.width / 2, 0f),
            end = Offset(size.width / 2, size.height / 2), cap = StrokeCap.Round, strokeWidth = shapeWidth.toDp().toPx(),
            pathEffect = pathEffect,
        )


    }


}

@Preview
@Composable
private fun PreviewLession5() {
//   Lession5()
//    MorseCodeEffect()
    DotDash()
//    HeartComp()

}