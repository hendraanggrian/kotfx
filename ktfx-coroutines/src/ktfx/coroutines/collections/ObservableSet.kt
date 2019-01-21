@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.collections.ObservableSet
import javafx.collections.SetChangeListener
import javafx.collections.SetChangeListener.Change
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Add a listener to this observable map. */
fun <E> ObservableSet<E>.listener(
    context: CoroutineContext = Dispatchers.JavaFx,
    listener: suspend (Change<out E>) -> Unit
): SetChangeListener<E> = SetChangeListener<E> { change ->
    GlobalScope.launch(context) { listener(change) }
}.also { addListener(it) }