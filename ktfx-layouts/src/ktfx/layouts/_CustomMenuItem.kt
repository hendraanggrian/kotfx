@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem
import ktfx.internal.KtfxInternals.newChild
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CustomMenuItem] to this manager.
 */
fun MenuItemManager.customMenuItem(content: Node? = null, hideOnClick: Boolean = true):
    CustomMenuItem = customMenuItem(content = content, hideOnClick = hideOnClick) { }

/**
 * Create a [CustomMenuItem] with configuration block.
 */
inline fun customMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    configuration: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CustomMenuItem(content, hideOnClick), configuration = configuration)
}

/**
 * Add a [CustomMenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.customMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    configuration: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CustomMenuItem(content, hideOnClick), configuration = configuration))
}

/**
 * Create a styled [CustomMenuItem].
 */
fun styledCustomMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    vararg styleClass: String,
    id: String? = null
): CustomMenuItem = styledCustomMenuItem(
    content = content, hideOnClick = hideOnClick,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [CustomMenuItem] to this manager.
 */
fun MenuItemManager.styledCustomMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    vararg styleClass: String,
    id: String? = null
): CustomMenuItem = styledCustomMenuItem(
    content = content, hideOnClick = hideOnClick,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Create a styled [CustomMenuItem] with configuration block.
 */
inline fun styledCustomMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        CustomMenuItem(content, hideOnClick), styleClass = *styleClass, id = id,
        configuration = configuration
    )
}

/**
 * Add a styled [CustomMenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.styledCustomMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            CustomMenuItem(content, hideOnClick), styleClass = *styleClass,
            id =
                id,
            configuration = configuration
        )
    )
}