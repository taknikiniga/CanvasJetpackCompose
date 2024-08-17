package com.taknikiniga.canvaspractice.lession

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.clipPath
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




























