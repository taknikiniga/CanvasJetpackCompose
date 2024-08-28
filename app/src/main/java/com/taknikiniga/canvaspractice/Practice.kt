package com.taknikiniga.canvaspractice

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.draggable2D
import androidx.compose.foundation.gestures.rememberDraggable2DState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.intermediateLayout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PracticeDayView(modifier: Modifier = Modifier) {

    val measureText = rememberTextMeasurer()
    var x by remember {
        mutableStateOf(0f)
    }

    var y by remember {
        mutableStateOf(0f)
    }

    var contentHover by remember {
        mutableStateOf(false)
    }

    var textPosition by remember { mutableStateOf(Offset.Zero) }
    var boxPosition by remember { mutableStateOf(Offset.Zero) }
    var boxSize by remember { mutableStateOf(IntSize.Zero) }

    var isCollapsed by remember {
        mutableStateOf(false)
    }


    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray), contentAlignment = Alignment.Center
    )  {



            Box(
                modifier = Modifier

                    .size(200.dp)
                    .onGloballyPositioned { it ->
                        boxPosition = it.positionInRoot()
                        boxSize = it.size
                    }

                    .background(color = if (isCollapsed) Color.Red else Color.Gray),
                contentAlignment = Alignment.Center
            ) {

                Text(text = if (isCollapsed) "Content Found" else "Drag Content Here")
            }

            Text(text = "this is testing", modifier = Modifier
                .offset {
                    textPosition.toIntOffset()
                }
                .onGloballyPositioned {
                    it.parentCoordinates?.positionInWindow()
                }
                .pointerInput(Unit) {

                    detectDragGestures { change, dragAmount ->

                        change.consume()

                        textPosition += dragAmount

                        isCollapsed = checkCollision(textPosition, boxPosition, boxSize)

                        Log.e("PracticeDayView: ", "$isCollapsed", )

                    }
                })




    }


}

// Utility function to check for collision
fun checkCollision(
    textPosition: Offset,
    boxPosition: Offset,
    boxSize: IntSize
): Boolean {
    val textLeft = textPosition.x
    val textRight = textPosition.x +100 // assuming text width is 100
    val textTop = textPosition.y
    val textBottom = textPosition.y +50 // assuming text height is 50

    val boxLeft = boxPosition.x
    val boxRight = boxPosition.x + boxSize.width
    val boxTop = boxPosition.y
    val boxBottom = boxPosition.y + boxSize.height

    return textRight > boxLeft && textLeft < boxRight &&
            textBottom > boxTop && textTop < boxBottom
}

// Extension function to convert Offset to IntOffset
fun Offset.toIntOffset() = IntOffset(x.toInt(), y.toInt())


@Preview
@Composable
private fun PreviewPractice() {
    PracticeDayView()
}