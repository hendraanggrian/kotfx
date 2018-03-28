@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.value

import javafx.beans.value.ObservableIntegerValue
import kotlin.reflect.KProperty

inline operator fun ObservableIntegerValue.getValue(thisRef: Any?, property: KProperty<*>): Int = get()