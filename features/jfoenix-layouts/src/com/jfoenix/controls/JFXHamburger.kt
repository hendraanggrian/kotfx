@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXHamburger
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXHamburger] with initialization block. */
inline fun jfxHamburger(
    configuration: (@LayoutsDslMarker JFXHamburger).() -> Unit
): JFXHamburger {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXHamburger().apply(configuration)
}

/** Add a [JFXHamburger] to this manager. */
fun NodeManager.jfxHamburger(): JFXHamburger = addChild(JFXHamburger())

/** Add a [JFXHamburger] with initialization block to this manager. */
inline fun NodeManager.jfxHamburger(
    configuration: (@LayoutsDslMarker JFXHamburger).() -> Unit
): JFXHamburger {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXHamburger(), configuration)
}