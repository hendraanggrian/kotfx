@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.RadioButton
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun radioButtonOf(
        text: String? = null,
        noinline init: ((@ControlDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.radioButton(
        text: String? = null,
        noinline init: ((@ControlDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.radioButton(
        text: String? = null,
        noinline init: ((@ControlDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()