@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.menus

import javafx.scene.control.SeparatorMenuItem
import kotfx.internal.ControlDsl
import kotfx.internal.PopupManager

@JvmOverloads
inline fun separatorMenuItemOf(
        noinline init: ((@ControlDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.separatorMenuItem(
        noinline init: ((@ControlDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }.add()