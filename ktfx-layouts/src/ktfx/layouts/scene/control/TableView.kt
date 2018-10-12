@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.TableView

/** Creates a [TableView]. */
fun <S> tableView(
    items: ObservableList<S> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl TableView<S>).() -> Unit)? = null
): TableView<S> = TableView<S>(items).also { init?.invoke(it) }

/** Creates a [TableView] and add it to this [LayoutManager]. */
inline fun <S> LayoutManager<Node>.tableView(
    items: ObservableList<S> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl TableView<S>).() -> Unit)? = null
): TableView<S> = ktfx.layouts.tableView(items, init)()