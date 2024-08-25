package com.taknikiniga.canvaspractice

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PracticeDayView(modifier: Modifier = Modifier) {

    val textMeasure = rememberTextMeasurer()

    val timeList: MutableList<String> = mutableListOf(
        "1:00 AM", "2:00 AM", "3:00 AM", "4:00 AM", "5:00 AM",
        "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM",
        "11:00 AM", "12:00 PM", "1:00 PM", "2:00 PM", "3:00 PM",
        "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM",
        "9:00 PM", "10:00 PM", "11:00 PM"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(2000.dp)
                .padding(start = 16.dp)
        ) {
            val totalLine = 23

            val height = size.height
            val width = size.width

            val boxWidth = width / totalLine
            val boxHeight = height / totalLine


            for (i in 0.until(timeList.size)) {
                val y = height * i / totalLine

                val textLayoutResult = textMeasure.measure(
                    text = AnnotatedString(timeList[i]),
                    style = TextStyle(color = Color.White, textAlign = TextAlign.Center)
                )

                val textHeight = textLayoutResult.size.height.toFloat()
                val textWidth = textLayoutResult.size.width.toFloat()

                drawLine(
                    color = Color.White,
                    start = Offset(boxWidth / 5 + textWidth, y),
                    end = Offset(width, y)
                )

                drawText(
                    textLayoutResult = textLayoutResult,
                    topLeft = Offset(0f, boxHeight * i - textHeight / 2),

                    )

                drawLine(
                    color = Color.White,
                    start = Offset(x = width / 5, height + boxHeight),
                    end = Offset(x = width / 5, 0f)
                )

                /*
                *
                * Content  Here
                *
                * */

                val title =
                    textMeasure.measure(AnnotatedString("my name is abhinash singh "))

                drawText(title, topLeft =
                Offset(width / 4, y + textHeight), color = Color.White)
            }
        }


    }

}


@Preview
@Composable
private fun PreviewPractice() {
    PracticeDayView()
}