@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.SVGPath

/** Creates a [SVGPath]. */
fun svgPath(
    init: ((@LayoutMarker SVGPath).() -> Unit)? = null
): SVGPath = SVGPath().also { init?.invoke(it) }

/** Creates a [SVGPath] and add it to this manager. */
inline fun NodeInvokable.svgPath(
    noinline init: ((@LayoutMarker SVGPath).() -> Unit)? = null
): SVGPath = ktfx.layouts.svgPath(init)()