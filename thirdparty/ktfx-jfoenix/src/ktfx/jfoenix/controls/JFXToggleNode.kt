@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXToggleNode
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXToggleNode]. */
fun jfxToggleNode(
    graphic: Node? = null,
    init: ((@LayoutDsl JFXToggleNode).() -> Unit)? = null
): JFXToggleNode = JFXToggleNode(graphic).also { init?.invoke(it) }

/** Creates a [JFXToggleNode] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxToggleNode(
    graphic: Node? = null,
    noinline init: ((@LayoutDsl JFXToggleNode).() -> Unit)? = null
): JFXToggleNode = ktfx.jfoenix.jfxToggleNode(graphic, init)()