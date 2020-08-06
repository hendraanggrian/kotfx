@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ScrollBar
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ScrollBar] to this manager.
 */
fun NodeManager.scrollBar(): ScrollBar = scrollBar() { }

/**
 * Create a [ScrollBar] with configuration block.
 */
inline fun scrollBar(configuration: (@LayoutDslMarker ScrollBar).() -> Unit): ScrollBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ScrollBar(), configuration = configuration)
}

/**
 * Add a [ScrollBar] with configuration block to this manager.
 */
inline fun NodeManager.scrollBar(configuration: (@LayoutDslMarker ScrollBar).() -> Unit):
    ScrollBar {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(ScrollBar(), configuration = configuration))
    }

/**
 * Create a styled [ScrollBar].
 */
fun styledScrollBar(vararg styleClass: String, id: String? = null): ScrollBar =
    styledScrollBar(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ScrollBar] to this manager.
 */
fun NodeManager.styledScrollBar(vararg styleClass: String, id: String? = null): ScrollBar =
    styledScrollBar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ScrollBar] with configuration block.
 */
inline fun styledScrollBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ScrollBar).() -> Unit
): ScrollBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ScrollBar(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [ScrollBar] with configuration block to this manager.
 */
inline fun NodeManager.styledScrollBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ScrollBar).() -> Unit
): ScrollBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            ScrollBar(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}