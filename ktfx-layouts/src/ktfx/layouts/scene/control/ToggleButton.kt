@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton

/** Creates a [ToggleButton]. */
fun toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutMarker ToggleButton).() -> Unit)? = null
): ToggleButton = ToggleButton(text, graphic).also { init?.invoke(it) }

/** Creates a [ToggleButton] and add it to this manager. */
inline fun NodeInvokable.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutMarker ToggleButton).() -> Unit)? = null
): ToggleButton = ktfx.layouts.toggleButton(text, graphic, init)()

/** Creates a [ToggleButton] and add it to this manager. */
inline fun ToggleButtonInvokable.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutMarker ToggleButton).() -> Unit)? = null
): ToggleButton = ktfx.layouts.toggleButton(text, graphic, init)()