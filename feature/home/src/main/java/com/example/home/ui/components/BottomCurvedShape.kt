import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.geometry.Size

fun curvedBottomShape(curveHeight: Float): Shape = GenericShape { size: Size, _: LayoutDirection ->
    val width = size.width
    val height = size.height

    moveTo(0f, 0f)
    lineTo(0f, height - curveHeight)

    cubicTo(
        width * 0.25f, height + curveHeight,
        width * 0.75f, height + curveHeight,
        width, height - curveHeight
    )

    lineTo(width, 0f)
    close()
}
