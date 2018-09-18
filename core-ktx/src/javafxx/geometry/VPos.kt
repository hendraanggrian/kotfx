@file:Suppress("NOTHING_TO_INLINE")

package javafxx.geometry

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafxx.internal.Internals

/** Construct a new position given the added horizontal position. */
inline operator fun VPos.plus(hpos: HPos): Pos = Internals.posOf(this, hpos)