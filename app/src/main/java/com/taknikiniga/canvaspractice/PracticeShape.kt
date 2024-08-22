package com.taknikiniga.canvaspractice

import android.graphics.Canvas
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import kotlin.math.max


/*
*
* Drawing Arch
*
* */


@Preview
@Composable
private fun PracticeCanvas() {


    Canvas(
        modifier = Modifier
            .size(200.dp)
            .border(color = Color.Red, width = 5.dp)
            .padding(16.dp)
    ) {


//        drawRect(
//            color = Color.Yellow,
//            size = size / 2f,
//            topLeft = Offset(size.width /4, size.height / 4),
//            style = Stroke(width = 5f)
//        )

        val height = size.height
        val width = size.width



        drawPath(Path().apply {


            moveTo(size.width / 2, 0f)
            lineTo(0f, size.height / 2)
            lineTo(size.width, size.height / 2)


            moveTo(size.width, size.height / 2)
            lineTo(0f, size.height / 2)
            lineTo(size.width / 2, size.height)
//
//
//
//
            moveTo(0f, 0f)
            lineTo(0f, size.height / 2)
            lineTo(width / 2, size.height / 2)

            moveTo(width, 0f)
            lineTo(width / 2, height / 2)
            lineTo(width, height / 2)


            // First Move
//            moveTo(size.width/2,0f)
//            lineTo(size.width,size.height/2)
//            lineTo(0f,size.height/2)

            // Second Move
//            moveTo(0f,size.height/2)
//            lineTo(size.width,size.height/2)
//            lineTo(size.width/2,size.height)


            // Third Move

//            moveTo(0f,size.height/2)
//            lineTo(size.width/2,size.height/2)
//            lineTo(0f,size.height/2)


            close()
        }, color = Color.Blue)
        drawCircle(color = Color.White, center = Offset(width / 3, height / 2.5f), radius = 30f)
        drawCircle(color = Color.White, center = Offset(width / 1.5f, height / 2.5f), radius = 30f)

        drawArc(
            color = Color.White,
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(width / 3, height / 2.5f),
            size = size / 3f
        )
    }

}

