import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.geometry.Size

fun curvedBottomShape(): Shape = GenericShape { size: Size, _: LayoutDirection ->
    val width = size.width
    val height = size.height
    val curveDepth = 50f // kedalaman lengkung, sesuaikan jika ingin lebih datar/curam

    moveTo(0f, 0f)
    lineTo(0f, height - curveDepth)

    // V-style landai dan lebar
    cubicTo(
        width * 0.25f, height,
        width * 0.75f, height,
        width, height - curveDepth
    )

    lineTo(width, 0f)
    close()
}
