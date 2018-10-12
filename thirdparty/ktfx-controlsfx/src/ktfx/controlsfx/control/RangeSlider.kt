@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.RangeSlider

/** Creates a [RangeSlider]. */
fun rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    init: ((@LayoutDsl RangeSlider).() -> Unit)? = null
): RangeSlider = RangeSlider(min, max, lowValue, highValue).also { init?.invoke(it) }

/** Creates a [RangeSlider] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.rangeSlider(
    min: Double = 0.0,
    max: Double = 1.0,
    lowValue: Double = 0.25,
    highValue: Double = 0.75,
    noinline init: ((@LayoutDsl RangeSlider).() -> Unit)? = null
): RangeSlider = ktfx.controlsfx.rangeSlider(min, max, lowValue, highValue, init)()