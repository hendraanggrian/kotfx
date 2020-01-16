@file:JvmMultifileClass
@file:JvmName("BindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import java.util.concurrent.Callable
import javafx.beans.Observable
import javafx.beans.binding.Bindings
import javafx.beans.binding.LongBinding
import javafx.beans.value.ObservableBooleanValue
import javafx.beans.value.ObservableDoubleValue
import javafx.beans.value.ObservableFloatValue
import javafx.beans.value.ObservableIntegerValue
import javafx.beans.value.ObservableLongValue
import javafx.beans.value.ObservableValue

/** Create a [LongBinding] with multiple [Observable] dependencies. */
fun longBindingOf(vararg dependencies: Observable, valueProvider: () -> Long): LongBinding =
    Bindings.createLongBinding(Callable(valueProvider), *dependencies)

/** Create a [LongBinding] with single [ObservableValue] dependency. */
inline fun <V> ObservableValue<V>.toLongBinding(noinline valueProvider: (V?) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value) }

/** Create a [LongBinding] with single [ObservableBooleanValue] dependency. */
inline fun ObservableBooleanValue.toLongBinding(noinline valueProvider: (Boolean) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value) }

/** Create a [LongBinding] with single [ObservableDoubleValue] dependency. */
inline fun ObservableDoubleValue.toLongBinding(noinline valueProvider: (Double) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Double) }

/** Create a [LongBinding] with single [ObservableFloatValue] dependency. */
inline fun ObservableFloatValue.toLongBinding(noinline valueProvider: (Float) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Float) }

/** Create a [LongBinding] with single [ObservableIntegerValue] dependency. */
inline fun ObservableIntegerValue.toLongBinding(noinline valueProvider: (Int) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Int) }

/** Create a [LongBinding] with single [ObservableLongValue] dependency. */
inline fun ObservableLongValue.toLongBinding(noinline valueProvider: (Long) -> Long): LongBinding =
    longBindingOf(this) { valueProvider(value as Long) }
