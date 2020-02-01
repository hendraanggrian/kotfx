@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDecorator
import javafx.scene.Node
import javafx.stage.Stage
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXDecorator] with initialization block. */
inline fun jfxDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    configuration: (@LayoutsDslMarker JFXDecorator).() -> Unit
): JFXDecorator {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXDecorator(stage, node, fullScreen, max, min).apply(configuration)
}

/** Add a [JFXDecorator] to this manager. */
fun NodeManager.jfxDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true
): JFXDecorator = addChild(JFXDecorator(stage, node, fullScreen, max, min))

/** Add a [JFXDecorator] with initialization block to this manager. */
inline fun NodeManager.jfxDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    configuration: (@LayoutsDslMarker JFXDecorator).() -> Unit
): JFXDecorator {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXDecorator(stage, node, fullScreen, max, min), configuration)
}