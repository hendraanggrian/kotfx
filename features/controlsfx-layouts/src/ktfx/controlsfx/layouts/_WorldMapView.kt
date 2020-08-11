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
import org.controlsfx.control.WorldMapView

/**
 * Add a [WorldMapView] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.worldMapView(): WorldMapView = worldMapView() { }

/**
 * Create a [WorldMapView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun worldMapView(configuration: (@LayoutDslMarker WorldMapView).() -> Unit): WorldMapView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(WorldMapView(), configuration = configuration)
}

/**
 * Add a [WorldMapView] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.worldMapView(configuration: (@LayoutDslMarker WorldMapView).() -> Unit):
    WorldMapView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(WorldMapView(), configuration = configuration))
}

/**
 * Create a styled [WorldMapView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledWorldMapView(vararg styleClass: String, id: String? = null): WorldMapView =
    styledWorldMapView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [WorldMapView] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledWorldMapView(vararg styleClass: String, id: String? = null): WorldMapView =
    styledWorldMapView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [WorldMapView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledWorldMapView(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker WorldMapView).() -> Unit
): WorldMapView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return newChild(WorldMapView(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [WorldMapView] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledWorldMapView(
  vararg styleClass: String,
  id: String? = null,
  configuration: (@LayoutDslMarker WorldMapView).() -> Unit
): WorldMapView {
  contract { callsInPlace(configuration, EXACTLY_ONCE) }
  return addChild(newChild(WorldMapView(), styleClass = *styleClass, id = id, configuration =
      configuration))
}