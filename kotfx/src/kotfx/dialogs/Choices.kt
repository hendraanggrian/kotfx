@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.scene.Node
import javafx.scene.control.ChoiceDialog
import javafx.scene.image.ImageView

@JvmOverloads
inline fun <T> choiceDialog(
    items: Collection<T>? = null,
    prefill: T? = null,
    noinline init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = choiceDialog(null, null, items, prefill, init)

@JvmOverloads
fun <T> choiceDialog(
    title: String?,
    graphic: Node?,
    items: Collection<T>? = null,
    prefill: T? = null,
    init: (ChoiceDialog<T>.() -> Unit)? = null
): ChoiceDialog<T> = ChoiceDialog<T>(prefill, items).apply {
    if (title != null) headerTitle = title
    if (graphic != null) when (graphic) {
        is ImageView -> graphicIcon = graphic
        else -> setGraphic(graphic)
    }
    init?.invoke(this)
}