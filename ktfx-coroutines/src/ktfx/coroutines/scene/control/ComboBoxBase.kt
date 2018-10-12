@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBoxBase
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** The ComboBox action, which is invoked whenever the [ComboBoxBase.valueProperty] property is changed. */
fun ComboBoxBase<*>.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [ComboBoxBase] popup/display has been hidden. */
fun ComboBoxBase<*>.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnHidden { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [ComboBoxBase] popup/display is shown. */
fun ComboBoxBase<*>.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnHiding { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [ComboBoxBase] popup/display being shown. */
fun ComboBoxBase<*>.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [ComboBoxBase] popup/display is shown. */
fun ComboBoxBase<*>.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnShown { event -> GlobalScope.launch(context) { action(event) } }