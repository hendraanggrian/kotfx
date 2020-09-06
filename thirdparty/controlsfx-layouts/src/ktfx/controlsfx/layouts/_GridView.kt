@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.GridView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [GridView] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.gridView(items: ObservableList<T> = observableArrayList()): GridView<T> =
    gridView(items = items) { }

/**
 * Create a [GridView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun <T> gridView(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = GridView<T>(items)
    child.configuration()
    return child
}

/**
 * Add a [GridView] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun <T> NodeManager.gridView(
    items: ObservableList<T> = observableArrayList(),
    configuration: (@KtfxLayoutDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = GridView<T>(items)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [GridView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun <T> styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): GridView<T> = styledGridView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [GridView] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun <T> NodeManager.styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): GridView<T> = styledGridView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [GridView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun <T> styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = GridView<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [GridView] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledGridView(
    items: ObservableList<T> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker GridView<T>).() -> Unit
): GridView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = GridView<T>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}