@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane

/**
 * Invoking layout DSL will only set content to center.
 * To set other sides, explicitly use `top`, `left`, `bottom`, or `right`.
 */
open class _BorderPane : BorderPane(), AlignableConstraints, MarginableConstraints, NodeInvokable {

    override fun <R : Node> R.invoke(): R = also { center = it }

    override fun Node.reset(): Unit = clearConstraints(this)

    override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [BorderPane]. */
fun borderPane(
    init: ((@LayoutMarker _BorderPane).() -> Unit)? = null
): BorderPane = _BorderPane().also { init?.invoke(it) }

/** Creates a [BorderPane] and add it to this manager. */
inline fun NodeInvokable.borderPane(
    noinline init: ((@LayoutMarker _BorderPane).() -> Unit)? = null
): BorderPane = ktfx.layouts.borderPane(init)()