@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXPopup
import javafx.scene.Node
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeInvokable
import ktfx.internal.KtfxInternals

open class _JFXPopup : JFXPopup(), NodeInvokable {

    override fun <T : Node> T.invoke(): T = also { popupContent = KtfxInternals.asPane(it) }
}

/** Creates a [JFXPopup]. */
fun jfxPopup(
    init: ((@LayoutMarker _JFXPopup).() -> Unit)? = null
): JFXPopup = _JFXPopup().also { init?.invoke(it) }