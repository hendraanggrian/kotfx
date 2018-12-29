@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import ktfx.collections.observableListOf

/** Creates a [ComboBox]. */
fun <T> comboBox(
    items: ObservableList<T> = observableListOf(),
    init: ((@LayoutMarker ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ComboBox(items).also { init?.invoke(it) }

/** Creates a [ComboBox] and add it to this manager. */
inline fun <T> NodeInvokable.comboBox(
    items: ObservableList<T> = observableListOf(),
    noinline init: ((@LayoutMarker ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ktfx.layouts.comboBox(items, init)()