@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.ObservableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.PropertySheet

/** Create a [PropertySheet] with initialization block. */
inline fun propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: (@LayoutsDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return PropertySheet(items).apply(init)
}

/** Add a [PropertySheet] to this manager. */
fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null
): PropertySheet = addChild(PropertySheet(items))

/** Add a [PropertySheet] with initialization block to this manager. */
inline fun NodeManager.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: (@LayoutsDslMarker PropertySheet).() -> Unit
): PropertySheet {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(PropertySheet(items), init)
}
