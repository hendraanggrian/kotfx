@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.chart.Axis
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.XYChart.Series
import ktfx.collections.mutableObservableListOf

/** Create a [BubbleChart] with initialization block. */
inline fun <X, Y> bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker BubbleChart<X, Y>).() -> Unit
): BubbleChart<X, Y> = BubbleChart(x, y, data).apply(init)

/** Add a [BubbleChart] to this manager. */
fun <X, Y> NodeManager.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf()
): BubbleChart<X, Y> = addNode(BubbleChart(x, y, data))

/** Add a [BubbleChart] with initialization block to this manager. */
inline fun <X, Y> NodeManager.bubbleChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: (@LayoutDslMarker BubbleChart<X, Y>).() -> Unit
): BubbleChart<X, Y> = addNode(BubbleChart(x, y, data), init)
