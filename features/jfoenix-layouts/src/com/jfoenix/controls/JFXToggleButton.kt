@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXToggleButton] with initialization block. */
inline fun jfxToggleButton(
    configuration: (@LayoutsDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXToggleButton().apply(configuration)
}

/** Add a [JFXToggleButton] to this manager. */
fun NodeManager.jfxToggleButton(): JFXToggleButton = addChild(JFXToggleButton())

/** Add a [JFXToggleButton] with initialization block to this manager. */
inline fun NodeManager.jfxToggleButton(
    configuration: (@LayoutsDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXToggleButton(), configuration)
}