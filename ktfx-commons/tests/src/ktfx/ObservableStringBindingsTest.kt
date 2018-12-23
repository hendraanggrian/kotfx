package ktfx

import javafx.scene.control.Label
import ktfx.bindings.eq
import ktfx.bindings.eqIg
import ktfx.bindings.greater
import ktfx.bindings.greaterEq
import ktfx.bindings.less
import ktfx.bindings.lessEq
import ktfx.bindings.neq
import ktfx.bindings.neqIg

class ObservableStringBindingsTest {

    private val label = Label()

    fun eq() {
        label.textProperty().isEqualTo(label.styleProperty())
        label.textProperty() eq label.styleProperty()
    }

    fun neq() {
        label.textProperty().isNotEqualTo(label.styleProperty())
        label.textProperty() neq label.styleProperty()
    }

    fun eqIg() {
        label.textProperty().isEqualToIgnoreCase(label.styleProperty())
        label.textProperty() eqIg label.styleProperty()
    }

    fun neqIg() {
        label.textProperty().isNotEqualToIgnoreCase(label.styleProperty())
        label.textProperty() neqIg label.styleProperty()
    }

    fun greater() {
        label.textProperty().greaterThan(label.styleProperty())
        label.textProperty() greater label.styleProperty()
    }

    fun less() {
        label.textProperty().lessThan(label.styleProperty())
        label.textProperty() less label.styleProperty()
    }

    fun greaterEq() {
        label.textProperty().greaterThanOrEqualTo(label.styleProperty())
        label.textProperty() greaterEq label.styleProperty()
    }

    fun lessEq() {
        label.textProperty().lessThanOrEqualTo(label.styleProperty())
        label.textProperty() lessEq label.styleProperty()
    }
}