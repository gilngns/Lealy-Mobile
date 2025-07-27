
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.LayoutDirection

fun curvedBottomShape(): Shape = GenericShape { size: Size, _: LayoutDirection ->
    val width = size.width
    val height = size.height
    val curveDepth = 25f

    moveTo(0f, 0f)
    lineTo(0f, height - curveDepth)

    cubicTo(
        width * 0.25f, height + curveDepth,
        width * 0.75f, height + curveDepth,
        width, height - curveDepth
    )

    lineTo(width, 0f)
    close()
}
