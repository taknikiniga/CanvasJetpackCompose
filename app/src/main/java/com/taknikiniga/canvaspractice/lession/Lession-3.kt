package com.taknikiniga.canvaspractice.lession

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import com.taknikiniga.canvaspractice.R


@Composable
fun LessionThree(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(color = Color.Red, width = 5.dp)
            .padding(16.dp)
    ) {

        val drawable = context.getDrawable(R.drawable.ic_launcher_background)
        val bitmap = drawable?.toBitmap(size.width.toInt(), size.height.toInt())

//        val bitmap:Bitmap = BitmapFactory.decodeResource(context.applicationContext.resources,R.drawable.ic_launcher_background)

        val image = bitmap?.asImageBitmap()

        val canvasMinDimension = size.minDimension / 2

        val path = Path().apply {
            addOval(Rect(center = center, radius = canvasMinDimension))
        }

        clipPath(path) {
            if (image != null) {
                drawImage(image, dstSize = IntSize(size.width.toInt(), size.height.toInt()))
            }
        }
    }

}

@Composable
fun ClipImageIntoText(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val drawable = context.getDrawable(R.drawable.ic_launcher_background)
    val bitmap = drawable?.toBitmap()
    val image = bitmap?.asImageBitmap()


//    val textMeasurer = rememberTextMeasurer()
//
//    val textStyle = LocalTextStyle.current
//
//    val textLayoutResult = remember(textStyle, textMeasurer) {
//        textMeasurer.measure(
//            "Hello World",
//            style = textStyle.copy(textAlign = TextAlign.Center, color = Color.Red)
//        )
//    }
//    Canvas(
//        modifier = Modifier
//            .size(200.dp)
//            .border(color = Color.Red, width = 5.dp)
//            .padding(16.dp)
//    ) {
//        val path = Path()
//
//        // Get text size and draw it in the center
//        val textOffsetX = (size.width - textLayoutResult.size.width) / 2
//        val textOffsetY = (size.height + textLayoutResult.size.height) / 2
//
//        // Add the text layout to the path
//        path.addRect(Rect(Offset(textOffsetX, textOffsetY - textLayoutResult.size.height), size))
//
//
//        clipPath(path) {
//            image?.let {
//
//                drawImage(it, dstSize = IntSize(size.width.toInt(), size.height.toInt()))
//            }
//        }
//
//    }


}


@Composable
fun ColorAnimator(modifier: Modifier = Modifier) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp), shape = RoundedCornerShape(16.dp)
    ) {
        val colorBg = Color(0xFF2C3141)
        val colors =
            listOf(
                Color(0xFFFF595A),
                Color(0xFFFFC766),
                Color(0xFF35A07F),
                Color(0xFF35A07F),
                Color(0xFFFFC766),
                Color(0xFFFF595A)
            )

        val brush = Brush.sweepGradient(colors)

        val infiniteTransition = rememberInfiniteTransition(label = "")
        val angle by
        infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec =
            infiniteRepeatable(
                animation = tween(1500, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = ""
        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(2.dp)
                .background(colorBg)
        ) {


            rotate(degrees = angle) {
                drawCircle(
                    brush = brush,
                    radius = size.width,
                    blendMode = BlendMode.SrcIn,
                )
            }

            drawRoundRect(
                color = colorBg,
                topLeft = Offset(1.dp.toPx(), 1.dp.toPx()),
                size = Size(
                    width = size.width - 2.dp.toPx(),
                    height = size.height - 2.dp.toPx()
                ),
                cornerRadius = CornerRadius(
                    x = 20.dp.toPx(),
                    y = 20.dp.toPx()
                )
            )
        }

    }
}


@Composable
private fun ColorAnimatePreview() {
//    ColorAnimator()
}


@Composable
fun AnimateableColor(modifier: Modifier = Modifier) {


    val color = Color(0xFF9C27B0)
    val bgColor = Color(0xFF2C3141)


    val colorList = listOf(
        Color(0xFFFF595A),
        Color(0xFFFFC766),
        Color(0xFF35A07F),
        Color(0xFF003323),
        Color(0xFFFFC766),
        Color(0xFF360000)
    )

    val brush = Brush.sweepGradient(colors = colorList)

    val inifiniteAnimate = rememberInfiniteTransition(label = "InfiniteTransition")


//    val colors by inifiniteAnimate.animateColor(
//        initialValue = color,
//        targetValue = colorList,
//        animationSpec = infiniteRepeatable(
//            animation = tween(
//                durationMillis = 2000,
//                easing = LinearEasing
//            ), repeatMode = RepeatMode.Reverse
//        )
//    )

    val angle by inifiniteAnimate.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )



    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(bgColor)
    ) {

        rotate(degrees = angle) {
            drawCircle(brush = brush, radius = size.width, blendMode = BlendMode.SrcIn)
        }


        drawRoundRect(
            color = bgColor,
            style = Stroke(5f),
            topLeft = Offset(10f, 10f), cornerRadius = CornerRadius(16f),
            size = Size(size.width /2,size.height)
        )

//        drawRect(brush = brush, size = Size(size.width, size.height / 2))


    }

}

@Preview()
@Composable
private fun PreviewAnimateableColor() {
    AnimateableColor()
}































