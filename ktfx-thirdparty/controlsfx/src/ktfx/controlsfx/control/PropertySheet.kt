@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker
import org.controlsfx.control.PropertySheet

/** Creates a [PropertySheet]. */
fun propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: ((@LayoutMarker PropertySheet).() -> Unit)? = null
): PropertySheet = PropertySheet(items).also { init?.invoke(it) }

/** Creates a [PropertySheet] and add it to this manager. */
inline fun NodeInvokable.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    noinline init: ((@LayoutMarker PropertySheet).() -> Unit)? = null
): PropertySheet = ktfx.controlsfx.propertySheet(items, init)()