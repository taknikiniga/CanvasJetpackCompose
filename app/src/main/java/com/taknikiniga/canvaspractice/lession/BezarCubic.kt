package com.taknikiniga.canvaspractice.lession

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BezierCubic(modifier: Modifier = Modifier) {


    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {


        val path = androidx.compose.ui.graphics.Path().apply {
            val width = size.width
            val height = size.height

            moveTo(0f, 0f)
            quadraticBezierTo(100f, height, 300f, 300f)
            quadraticBezierTo(width.times(0.4f), 10f, 500f, 300f)
            quadraticBezierTo(600f, 600f, width, 0f)
            close()


        }

        drawPath(path, color = Color.Red,)
    }


}





@Preview
@Composable
private fun PreviewBezierCubic() {
    BezierCubic()
}