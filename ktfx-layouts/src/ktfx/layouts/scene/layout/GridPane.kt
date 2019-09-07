@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.ConstraintsBase
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import javafx.scene.layout.RowConstraints

open class _GridPane : GridPane(), NodeManager, MarginConstraints, HAlignConstraints, VAlignConstraints,
    HGrowConstraints, VGrowConstraints {

    override fun <T : Node> addNode(node: T): T = node.also { children += it }

    override fun Node.reset(): Unit = clearConstraints(this)

    infix fun <T : Node> T.row(row: Int?): T = also { it.row = row }

    infix fun <T : Node> T.col(col: Int?): T = also { it.col = col }

    infix fun <T : Node> T.rowSpans(rowSpans: Int?): T = also { it.rowSpans = rowSpans }

    infix fun <T : Node> T.colSpans(colSpans: Int?): T = also { it.colSpans = colSpans }

    var Node.row: Int?
        get() = getRowIndex(this)
        set(value) = setRowIndex(this, value)

    var Node.col: Int?
        get() = getColumnIndex(this)
        set(value) = setColumnIndex(this, value)

    var Node.rowSpans: Int? // alias for reserved variable `rowSpan`
        get() = getRowSpan(this)
        set(value) = setRowSpan(this, value)

    var Node.colSpans: Int?
        get() = getColumnSpan(this)
        set(value) = setColumnSpan(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)

    override var Node.valign: VPos?
        get() = getValignment(this)
        set(value) = setValignment(this, value)

    override var Node.halign: HPos?
        get() = getHalignment(this)
        set(value) = setHalignment(this, value)

    infix fun <T : Node> T.hfill(value: Boolean): T = apply { hfill = value }

    infix fun <T : Node> T.vfill(value: Boolean): T = apply { vfill = value }

    var Node.hfill: Boolean?
        get() = isFillWidth(this)
        set(value) = setFillWidth(this, value)

    var Node.vfill: Boolean?
        get() = isFillHeight(this)
        set(value) = setFillHeight(this, value)

    override var Node.hpriority: Priority?
        get() = getHgrow(this)
        set(value) = setHgrow(this, value)

    override var Node.vpriority: Priority?
        get() = getVgrow(this)
        set(value) = setVgrow(this, value)
}

/** Create a [GridPane] with initialization block. */
inline fun gridPane(
    init: (@LayoutDslMarker _GridPane).() -> Unit
): GridPane = _GridPane().apply(init)

/** Add a [GridPane] to this manager. */
fun NodeManager.gridPane(): GridPane =
    addNode(ktfx.layouts.gridPane { })

/** Add a [GridPane] with initialization block to this manager. */
inline fun NodeManager.gridPane(
    init: (@LayoutDslMarker _GridPane).() -> Unit
): GridPane = addNode(ktfx.layouts.gridPane(init))

/** Interface to build [GridPane] row and column constraints with Kotlin DSL. */
sealed class ConstraintsBuilder<out T : ConstraintsBase> {

    abstract fun constraints(): T

    inline fun constraints(init: T.() -> Unit): T =
        constraints().apply(init)

    abstract fun constraints(size: Double): T

    inline fun constraints(size: Double, init: T.() -> Unit): T =
        constraints(size).apply(init)

    abstract fun constraints(minSize: Double, prefSize: Double, maxSize: Double): T

    inline fun constraints(minSize: Double, prefSize: Double, maxSize: Double, init: T.() -> Unit): T =
        constraints(minSize, prefSize, maxSize).apply(init)
}

private abstract class _ConstraintsBuilder<T : ConstraintsBase> : ConstraintsBuilder<T>() {

    companion object {
        fun ofRow(): _ConstraintsBuilder<RowConstraints> = object : _ConstraintsBuilder<RowConstraints>() {
            override fun newInstance(): RowConstraints = RowConstraints()
            override fun newInstance(width: Double): RowConstraints = RowConstraints(width)
            override fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): RowConstraints =
                RowConstraints(width, prefWidth, maxWidth)
        }

        fun ofColumn(): _ConstraintsBuilder<ColumnConstraints> = object : _ConstraintsBuilder<ColumnConstraints>() {
            override fun newInstance(): ColumnConstraints = ColumnConstraints()
            override fun newInstance(width: Double): ColumnConstraints = ColumnConstraints(width)
            override fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): ColumnConstraints =
                ColumnConstraints(width, prefWidth, maxWidth)
        }
    }

    val collection: MutableCollection<T> = mutableListOf()

    abstract fun newInstance(): T

    abstract fun newInstance(width: Double): T

    abstract fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): T

    override fun constraints(): T =
        newInstance().also { collection += it }

    override fun constraints(size: Double): T =
        newInstance(size).also { collection += it }

    override fun constraints(minSize: Double, prefSize: Double, maxSize: Double): T =
        newInstance(minSize, prefSize, maxSize).also { collection += it }
}

/** Invokes a row constraints DSL builder. */
fun GridPane.rowConstraints(init: ConstraintsBuilder<RowConstraints>.() -> Unit) {
    rowConstraints += _ConstraintsBuilder.ofRow().apply(init).collection
}

/** Invokes a column constraints DSL builder. */
fun GridPane.columnConstraints(init: ConstraintsBuilder<ColumnConstraints>.() -> Unit) {
    columnConstraints += _ConstraintsBuilder.ofColumn().apply(init).collection
}
