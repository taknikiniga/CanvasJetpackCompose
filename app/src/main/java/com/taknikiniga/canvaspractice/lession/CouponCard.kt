package com.taknikiniga.canvaspractice.lession

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CouponCard(modifier: Modifier = Modifier) {
    Surface(color = Color(0xFFF9F9F9)) {

    CouponCanvas()
    }
}

@Composable
fun CouponCanvas(
    offer: String = "30%",
    validTill: String = "",
    strokeColor: Color = Color(0xFFF9F9F9),
    offBackColor: Color = Color(0xFFFFFFFF),
    lineColor: Color = Color(0xFFF9F9F9),
    couponBack: Color = Color(0xFF673AB7)
) {


    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .height(120.dp)
        .drawWithCache {

            onDrawWithContent {

                val height = size.height
                val width = size.width

                val radius = 20f

                val path = Path().apply {
                    // Start at top left corner
                    moveTo(0f, 0f)


                    // Draw top side

                    // Draw right side with arcs
                    for (i in 0..8) {
                        addArc(
                            Rect(
                                center = Offset(width + 2, height * i / 5),
                                radius = radius
                            ),
                            startAngleDegrees = 90f,
                            sweepAngleDegrees = 180f
                        )
                    }

                    // Draw bottom side

                    // Draw left side with arcs
                    for (i in 6 downTo 0) {
                        addArc(
                            Rect(center = Offset(-5f, height * i / 6), radius = radius),
                            startAngleDegrees = -90f,
                            sweepAngleDegrees = 180f
                        )
                    }



                    close()
                }

                /*
            *
            * Line
            *
            * */

                val lineOffInterval = size.height / 10
                val lineOnInterval = 10f

                val pathEffect =
                    PathEffect.dashPathEffect(floatArrayOf(lineOnInterval, lineOffInterval))



                drawRect(color = offBackColor, topLeft = Offset(0f, 0f))


                drawRect(color = couponBack, topLeft = Offset(size.width / 2.3f, 0f))



                drawPath(path = path, color = strokeColor)


                drawLine(
                    pathEffect = pathEffect,
                    start = Offset(size.width / 2, 0f),
                    end = Offset(size.width / 2, height),
                    color = lineColor, strokeWidth = 10f, cap = StrokeCap.Round
                )


                drawContent()
            }

        }) {


        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .rotate(-90f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Text(
                    text = "Shopping Coupon",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 5.sp,
                        letterSpacing = TextUnit(3f, type = TextUnitType.Sp)
                    ), textAlign = TextAlign.Center
                )

                Text(
                    text = offer,
                    modifier = Modifier,
                    style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Text(
                    text = "TAKNIKINIGA.IN",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 5.sp,
                        letterSpacing = TextUnit(3f, type = TextUnitType.Sp)
                    ), textAlign = TextAlign.Center, color = Color.White
                )

                Text(
                    text = "Coupon",
                    modifier = Modifier,
                    style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center, color = Color.White
                )

                Text(
                    text = "VALID TILL DECEMBER 2023",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 5.sp,
                        letterSpacing = TextUnit(1f, type = TextUnitType.Sp)
                    ), textAlign = TextAlign.Center, color = Color.White
                )
            }

        }


    }


}


@Preview
@Composable
private fun PreviewCouponCard() {
    CouponCard()
}