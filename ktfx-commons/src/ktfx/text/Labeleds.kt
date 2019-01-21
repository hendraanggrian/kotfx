@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.scene.control.Labeled
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import java.io.InputStream

fun Labeled.updateFont(size: Number) {
    font = Font.font(size.toDouble())
}

fun Labeled.updateFont(
    family: String = "System",
    weight: FontWeight? = null,
    posture: FontPosture? = null,
    size: Number = -1
) {
    font = Font.font(family, weight, posture, size.toDouble())
}

fun Labeled.loadFont(url: String, size: Number = -1) {
    font = Font.loadFont(url, size.toDouble())
}

fun Labeled.loadFont(stream: InputStream, size: Number = -1) {
    font = Font.loadFont(stream, size.toDouble())
}