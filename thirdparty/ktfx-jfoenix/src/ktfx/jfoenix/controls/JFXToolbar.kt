@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToolbar
import javafx.scene.Node
import ktfx.LayoutDsl
import ktfx.NodeManager

open class _JFXToolbar : JFXToolbar() {

    val collection: MutableCollection<Node> = mutableListOf()

    fun leftItems(init: (@LayoutDsl NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        leftItems.addAll(collection)
    }

    fun rightItems(init: (@LayoutDsl NodeManager).() -> Unit) {
        collection.clear()
        object : NodeManager {
            override fun <R : Node> R.invoke(): R = also { collection += it }
        }.apply(init)
        rightItems.addAll(collection)
    }
}

/** Creates a [JFXToolbar]. */
fun jfxToolbar(
    init: ((@LayoutDsl _JFXToolbar).() -> Unit)? = null
): JFXToolbar = _JFXToolbar().also { init?.invoke(it) }

/** Creates a [JFXToolbar] and add it to this manager. */
inline fun NodeManager.jfxToolbar(
    noinline init: ((@LayoutDsl _JFXToolbar).() -> Unit)? = null
): JFXToolbar = ktfx.jfoenix.jfxToolbar(init)()