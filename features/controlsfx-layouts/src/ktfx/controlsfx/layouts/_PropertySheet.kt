@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.ObservableList
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PropertySheet
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [PropertySheet] to this manager.
 */
fun NodeManager.propertySheet(items: ObservableList<PropertySheet.Item>? = null): PropertySheet =
    propertySheet(items = items) { }

/**
 * Create a [PropertySheet] with configuration block.
 */
inline fun propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    configuration: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(PropertySheet(items), configuration = configuration)
}

/**
 * Add a [PropertySheet] with configuration block to this manager.
 */
inline fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    configuration: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(PropertySheet(items), configuration = configuration))
}

/**
 * Create a styled [PropertySheet].
 */
fun styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null
): PropertySheet = styledPropertySheet(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [PropertySheet] to this manager.
 */
fun NodeManager.styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null
): PropertySheet = styledPropertySheet(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [PropertySheet] with configuration block.
 */
inline fun styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        PropertySheet(items), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [PropertySheet] with configuration block to this manager.
 */
inline fun NodeManager.styledPropertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            PropertySheet(items), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}