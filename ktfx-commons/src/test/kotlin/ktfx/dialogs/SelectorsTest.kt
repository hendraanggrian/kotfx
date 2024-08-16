package ktfx.dialogs

import com.hanggrian.ktfx.test.DialogShowingTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class SelectorsTest : DialogShowingTest() {
    @Test
    fun selector() {
        interact {
            assertEquals(
                "Jump off bridge",
                selector<String>(
                    listOf("Jump off bridge", "Live a happy life"),
                    "Live a happy life",
                ) {
                    headerTitle = "Selector"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Selector", headerText)
                    assertEquals("Selector", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                    assertEquals("Live a happy life", defaultChoice)
                    selectedItem = "Jump off bridge"
                }.get(),
            )
            assertEquals(
                "Jump off bridge",
                selector(
                    "Jump off bridge",
                    "Live a happy life",
                    prefill = "Live a happy life",
                ) {
                    headerTitle = "Selector"
                    graphicIcon = sampleGraphic

                    closeOnShow(this)
                    assertEquals("Selector", headerText)
                    assertEquals("Selector", title)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals(sampleGraphic.image, icon)
                    assertEquals("Live a happy life", defaultChoice)
                    selectedItem = "Jump off bridge"
                }.get(),
            )
        }
    }
}
