@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Ellipse

/** Creates a [Ellipse]. */
fun ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    init: ((@LayoutMarker Ellipse).() -> Unit)? = null
): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).also { init?.invoke(it) }

/** Creates a [Ellipse] and add it to this manager. */
inline fun NodeInvokable.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    noinline init: ((@LayoutMarker Ellipse).() -> Unit)? = null
): Ellipse = ktfx.layouts.ellipse(centerX, centerY, radiusX, radiusY, init)()