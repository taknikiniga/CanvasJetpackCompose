package com.taknikiniga.canvaspractice.lession

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun LessionTwo(modifier: Modifier = Modifier) {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        /*
        *
        * Draw Rounded Rect With Stroke
        * */

//        drawRoundRect(
//            color = Color.White,
//            size = Size(size.width, size.height / 3),
//            cornerRadius = CornerRadius(50f), style = Stroke(width = 5f)
//        )


        /*
        *
        * Draw Arc
        *
        * */


//        drawArc(
//            color = Color.Red,
//            startAngle = 0f,
//            sweepAngle = 180f,
//            useCenter = true,
//            style = Stroke(width = 10f)
//        )


        /*
        *
        *  Drawing Path
        *
        * */


//        drawPath(Path().apply {
//
//            moveTo(0f, size.height / 2)
//            lineTo(size.width/2, 0f)
//            lineTo(size.width,size.height/2)
//
//        }, color = Color.Red)


        /*
        *
        * Drawing Circle
        *
        * */

//        drawCircle(
//            color = Color.White,
//            radius = 50f,
//            center = Offset(size.width / 3, size.height / 2)
//        )
//
//        drawCircle(
//            color = Color.White,
//            radius = 50f,
//            center = Offset(size.width / 1.5f, size.height / 2)
//        )


        /*
        *
        * Drawing Arc
        *
        * */

//
//        drawArc(
//            color = Color.White,
//            startAngle = 0f,
//            sweepAngle = 180f,
//            useCenter = true,
//            size = size / 3f,
//            topLeft = Offset(size.width/3,size.height/2.5f)
//        )

        /*
        *
        * Drawing Oval
        *
        * */

//        drawOval(
//            color = Color.Red,
//            size = size / 2f,
//            topLeft = Offset(size.width / 4, size.height / 4), style = Stroke(width = 5f)
//        )

        
    }

}