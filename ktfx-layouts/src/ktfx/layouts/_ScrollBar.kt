@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ScrollBar
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [ScrollBar] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.scrollBar(): ScrollBar = scrollBar() { }

/**
 * Create a [ScrollBar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun scrollBar(configuration: (@LayoutDslMarker ScrollBar).() -> Unit): ScrollBar {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(ScrollBar(), configuration = configuration)
}

/**
 * Add a [ScrollBar] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.scrollBar(configuration: (@LayoutDslMarker ScrollBar).() -> Unit):
    ScrollBar {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(ScrollBar(), configuration = configuration))
}

/**
 * Create a styled [ScrollBar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledScrollBar(vararg styleClass: String, id: String? = null): ScrollBar =
    styledScrollBar(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ScrollBar] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledScrollBar(vararg styleClass: String, id: String? = null): ScrollBar =
    styledScrollBar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ScrollBar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
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
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledScrollBar(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker ScrollBar).() -> Unit
): ScrollBar {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(ScrollBar(), styleClass = *styleClass, id = id, configuration =
      configuration))
}