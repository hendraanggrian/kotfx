@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSpinner
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/**
 * Add a [JFXSpinner] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxSpinner(progress: Double = INDETERMINATE_PROGRESS): JFXSpinner =
    jfxSpinner(progress = progress) { }

/**
 * Create a [JFXSpinner] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxSpinner(progress: Double = INDETERMINATE_PROGRESS, configuration: (@LayoutDslMarker
    JFXSpinner).() -> Unit): JFXSpinner {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXSpinner(progress), configuration = configuration)
}

/**
 * Add a [JFXSpinner] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxSpinner(progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker JFXSpinner).() -> Unit): JFXSpinner {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXSpinner(progress), configuration = configuration))
}

/**
 * Create a styled [JFXSpinner].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledJFXSpinner(
  progress: Double = INDETERMINATE_PROGRESS,
  vararg styleClass: String,
  id: String? = null
): JFXSpinner = styledJFXSpinner(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXSpinner] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXSpinner(
  progress: Double = INDETERMINATE_PROGRESS,
  vararg styleClass: String,
  id: String? = null
): JFXSpinner = styledJFXSpinner(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXSpinner] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXSpinner(
  progress: Double = INDETERMINATE_PROGRESS,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXSpinner).() -> Unit
): JFXSpinner {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(JFXSpinner(progress), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [JFXSpinner] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXSpinner(
  progress: Double = INDETERMINATE_PROGRESS,
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker JFXSpinner).() -> Unit
): JFXSpinner {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(JFXSpinner(progress), styleClass = *styleClass, id = id, configuration =
      configuration))
}