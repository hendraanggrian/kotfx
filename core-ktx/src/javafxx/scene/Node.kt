@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")

package javafxx.scene

import javafx.scene.Node
import javafx.scene.SnapshotParameters
import javafx.scene.image.WritableImage

/** Alias of [Node.lookup] with non-null return. */
inline operator fun Node.get(selector: String): Node = lookup(selector)

/** Alias of [Node.lookup] with non-null return and specified type. */
@Suppress("UNCHECKED_CAST")
inline fun <T : Node> Node.find(selector: String): T = this[selector] as T

/** Take a screenshot of this [Node] returning image it wrote. */
inline fun Node.snapshot(
    params: SnapshotParameters? = null,
    image: WritableImage? = null
): WritableImage = snapshot(params, image)