@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

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
import org.controlsfx.control.SegmentedBar

/**
 * Add a [SegmentedBar] to this manager.
 *
 * @return the control added.
 */
fun <T : SegmentedBar.Segment> NodeManager.segmentedBar(): SegmentedBar<T> = segmentedBar() { }

/**
 * Create a [SegmentedBar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun <T : SegmentedBar.Segment> segmentedBar(configuration: (@LayoutDslMarker
    SegmentedBar<T>).() -> Unit): SegmentedBar<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(SegmentedBar<T>(), configuration = configuration)
}

/**
 * Add a [SegmentedBar] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun <T : SegmentedBar.Segment> NodeManager.segmentedBar(configuration: (@LayoutDslMarker
    SegmentedBar<T>).() -> Unit): SegmentedBar<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(SegmentedBar<T>(), configuration = configuration))
}

/**
 * Create a styled [SegmentedBar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun <T : SegmentedBar.Segment> styledSegmentedBar(vararg styleClass: String, id: String? = null):
    SegmentedBar<T> = styledSegmentedBar(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SegmentedBar] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun <T : SegmentedBar.Segment> NodeManager.styledSegmentedBar(vararg styleClass: String, id: String?
    = null): SegmentedBar<T> = styledSegmentedBar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SegmentedBar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun <T : SegmentedBar.Segment> styledSegmentedBar(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker SegmentedBar<T>).() -> Unit
): SegmentedBar<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(SegmentedBar<T>(), styleClass = *styleClass, id = id, configuration =
      configuration)
}

/**
 * Add a styled [SegmentedBar] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun <T : SegmentedBar.Segment> NodeManager.styledSegmentedBar(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker SegmentedBar<T>).() -> Unit
): SegmentedBar<T> {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(SegmentedBar<T>(), styleClass = *styleClass, id = id, configuration =
      configuration))
}