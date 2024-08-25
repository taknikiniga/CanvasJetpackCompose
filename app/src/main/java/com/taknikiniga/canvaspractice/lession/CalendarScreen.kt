package com.taknikiniga.canvaspractice.lession

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
fun DrawDatesGrid(modifier: Modifier = Modifier) {

    val textMeasure = rememberTextMeasurer()

    val currentMonth = LocalDate.now().month
    val totalDays = currentMonth.length(LocalDate.now().isLeapYear)
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {

/*
*  Canvas Weight And Height
* */
        val width = size.width
        val height = size.height


        /*
        *
        * Total Row And Columns
        *
        *
        * */

        val totalColumn = 7
        val totalRow = (totalDays + totalColumn) / 7


        /*
        *  Row and Columns Height and weight
        *
        * */

        val boxHeight = height / totalRow
        val boxWeight = width / totalColumn


        /*
        *  Loop For Row And Column
        *
        * */


        for (days in 1..totalDays) {

            val row = (days - 1) / totalColumn
            val column = (days - 1) % totalColumn

            val x = column * boxWeight
            val y = row * boxHeight

            drawRect(
                color = Color.Gray, topLeft = Offset(x, y),
                size = Size(boxWeight, boxHeight)
            )

            drawText(
                textMeasure,
                text = "$days",
                topLeft = Offset(
                    x + boxWeight / 3 + 15,
                    y + boxHeight / 2.5f
                )
            )

        }


    }


}






@Preview
@Composable
private fun PreviewCalendarScreen() {

    DrawDatesGrid()

}