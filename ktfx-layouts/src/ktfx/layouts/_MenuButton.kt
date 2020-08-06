@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [MenuButton] to this manager.
 */
fun NodeManager.menuButton(text: String? = null, graphic: Node? = null): MenuButton =
    menuButton(text = text, graphic = graphic) { }

/**
 * Create a [MenuButton] with configuration block.
 */
inline fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxMenuButton(text, graphic), configuration = configuration)
}

/**
 * Add a [MenuButton] with configuration block to this manager.
 */
inline fun NodeManager.menuButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxMenuButton(text, graphic), configuration = configuration))
}

/**
 * Create a styled [MenuButton].
 */
fun styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): MenuButton = styledMenuButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MenuButton] to this manager.
 */
fun NodeManager.styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): MenuButton = styledMenuButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MenuButton] with configuration block.
 */
inline fun styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxMenuButton(text, graphic), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [MenuButton] with configuration block to this manager.
 */
inline fun NodeManager.styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxMenuButton(text, graphic), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}