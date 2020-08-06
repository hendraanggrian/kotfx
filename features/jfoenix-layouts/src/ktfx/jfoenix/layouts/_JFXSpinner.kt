@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSpinner
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXSpinner] to this manager.
 */
fun NodeManager.jfxSpinner(progress: Double = INDETERMINATE_PROGRESS): JFXSpinner =
    jfxSpinner(progress = progress) { }

/**
 * Create a [JFXSpinner] with configuration block.
 */
inline fun jfxSpinner(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (
        @LayoutDslMarker    
        JFXSpinner
    ).() -> Unit
): JFXSpinner {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXSpinner(progress), configuration = configuration)
}

/**
 * Add a [JFXSpinner] with configuration block to this manager.
 */
inline fun NodeManager.jfxSpinner(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker JFXSpinner).() -> Unit
): JFXSpinner {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXSpinner(progress), configuration = configuration))
}

/**
 * Create a styled [JFXSpinner].
 */
fun styledJFXSpinner(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null
): JFXSpinner = styledJFXSpinner(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXSpinner] to this manager.
 */
fun NodeManager.styledJFXSpinner(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null
): JFXSpinner = styledJFXSpinner(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXSpinner] with configuration block.
 */
inline fun styledJFXSpinner(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXSpinner).() -> Unit
): JFXSpinner {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        JFXSpinner(progress), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXSpinner] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXSpinner(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXSpinner).() -> Unit
): JFXSpinner {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            JFXSpinner(progress), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}