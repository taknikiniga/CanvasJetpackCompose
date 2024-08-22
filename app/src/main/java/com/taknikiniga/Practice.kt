import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StampedPathEffectStyle
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.taknikiniga.canvaspractice.lession.MorseCodeEffect
import kotlin.math.sign

@Composable
fun PathEffect(modifier: Modifier = Modifier) {

    val dashDot = 50f
    val density = LocalDensity.current

    with(density) {
        val dashOnInterval = dashDot.toDp().toPx()
        val dashOffInterval = dashDot.toDp().toPx()

        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashOnInterval, dashOffInterval))

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {


            drawLine(
                color = Color.White,
                pathEffect = pathEffect,
                start = Offset(0f, size.height / 2),
                end = Offset(size.width, size.height / 2), strokeWidth = 20f, cap = StrokeCap.Round
            )

        }

    }


}


@Composable
fun MorseCode(modifier: Modifier = Modifier) {

    val dash = 5f

    val desnity = LocalDensity.current

    with(desnity) {

        val dashOnInterval = (dash * 4).dp.toPx()
        val dashOffInterval = (dash * 4).dp.toPx()
        val dotOnInterval = (dash / 2).dp.toPx()
        val dotOffInterval = (dash * 4).dp.toPx()


        val pathEffect = PathEffect.dashPathEffect(
            floatArrayOf(
                dashOnInterval,
                dashOffInterval,
                dotOnInterval,
                dotOffInterval
            )
        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {


            drawLine(
                color = Color.White,
                pathEffect = pathEffect,
                start = Offset(0f, size.height / 2),
                end = Offset(size.width, size.height / 2), strokeWidth = 20f, cap = StrokeCap.Round
            )

        }


    }

}


@Composable
fun CirclePath(modifier: Modifier = Modifier) {

    val space = 50f

    val density = LocalDensity.current
    with(density) {

        val path = Path().apply {
//            addOval(Rect(center = Offset.Zero, 10f.toDp().toPx()))

        }

        val pathEffect =
            PathEffect.stampedPathEffect(path, space, 20f, StampedPathEffectStyle.Translate)

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {


            drawLine(
                color = Color.White,
                pathEffect = pathEffect,
                start = Offset(0f, size.height / 2),
                end = Offset(size.width, size.height / 2)
            )

        }

    }

}

@Preview
@Composable
private fun PreviewPathEffect() {

    CirclePath()
}
