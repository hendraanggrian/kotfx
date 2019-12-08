package ktfx.layouts.scene.control

import javafx.scene.control.ChoiceBox
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.choiceBox
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty

class ChoiceBoxTest : LayoutTest<NodeManager, ChoiceBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = choiceBox<String> { }
    override fun NodeManager.child2() = choiceBox<String>()
    override fun NodeManager.child3() = choiceBox<String> { }

    override fun ChoiceBox<String>.testDefaultValues() {
        assertEmpty(items)
    }
}