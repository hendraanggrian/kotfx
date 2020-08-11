@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.text.Text
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Text] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.text(text: String? = null): Text = text(text = text) { }

/**
 * Create a [Text] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun text(text: String? = null, configuration: (@LayoutDslMarker Text).() -> Unit): Text {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Text(text), configuration = configuration)
}

/**
 * Add a [Text] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.text(text: String? = null, configuration: (@LayoutDslMarker Text).() ->
    Unit): Text {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Text(text), configuration = configuration))
}

/**
 * Create a styled [Text].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledText(
  text: String? = null,
  vararg styleClass: String,
  id: String? = null
): Text = styledText(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Text] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledText(
  text: String? = null,
  vararg styleClass: String,
  id: String? = null
): Text = styledText(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Text] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledText(
  text: String? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Text).() -> Unit
): Text {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(Text(text), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Text] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledText(
  text: String? = null,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker Text).() -> Unit
): Text {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(Text(text), styleClass = *styleClass, id = id, configuration =
      configuration))
}