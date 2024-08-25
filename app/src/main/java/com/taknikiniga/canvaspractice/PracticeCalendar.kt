package com.taknikiniga.canvaspractice

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate

@Composable
fun CalendarDate(modifier: Modifier = Modifier) {


    val currentMonth = LocalDate.now().month
    val totalDays = currentMonth.length(LocalDate.now().isLeapYear)

    val textMeasure = rememberTextMeasurer()

    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)) {

        val width = size.width
        val height = size.height

        val daysInMonth = 7
        val totalRow = (totalDays + daysInMonth) /7


        val boxHeight = height / totalRow
        val boxWidth = width / daysInMonth


        for (days in 1..totalDays){

            val row = (days -1) / daysInMonth
            val column = (days -1) % daysInMonth


            val x = column * boxWidth
            val y = row * boxHeight


            drawRect(color = Color.Gray, topLeft = Offset(x,y), size = Size(boxWidth,boxHeight))


            drawText(textMeasure, text = "$days", topLeft = Offset( x + boxWidth /3 +10,y+boxHeight /2.5f))


        }


    }


}

@Preview
@Composable
private fun PreviewCalendarDate() {
    CalendarDate()
}