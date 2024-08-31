package com.taknikiniga.canvaspractice.lession

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class BarGraph(var y: Float = 0f, var name: String)

@Composable
fun Bar(modifier: Modifier = Modifier) {

    val barList = listOf(BarGraph(0.1f, "A"),
        BarGraph(0.6f, "B"),
        BarGraph(0.7f, "B"),
        BarGraph(0.9f, "B"),
        BarGraph(0.4f, "B"),

    )
    val rememberMeasurer = rememberTextMeasurer()

    val colorList = listOf(

        Color.Red,
        Color.Green,
        Color.Yellow,

        Color.Magenta,
        Color.Cyan,
    )


    Canvas(
        modifier = Modifier
            .fillMaxWidth().padding(20.dp)
            .height(400.dp)
    ) {



        for (count in 0..10) {
            val y = size.height - size.height * count / 10

            val text = rememberMeasurer.measure(AnnotatedString("${count * 10}"))

            drawText(text, topLeft = Offset(0f, y ))


            drawLine(
                color = Color.Black,
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = 1f
            )
        }


        for (i in barList.indices) {

            val text = rememberMeasurer.measure(AnnotatedString("item $i"),
                style = TextStyle(fontSize = 10.sp, textAlign = TextAlign.Center))

            drawText(text, topLeft = Offset(size.width / 9 * i + size.width /9,  size.height))



            drawRoundRect(
                color = colorList.random(),
                size = Size(size.width / 10,  -size.height  * barList[i].y ),
                topLeft = Offset(size.width / 9 * i + size.width /10 ,  size.height ), cornerRadius = CornerRadius(16f)
            )
        }

    }


}

@Preview(showSystemUi = true,)
@Composable
private fun PreviewBar() {
    Bar()
}