package kotfx.controls

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import kotfx.internal.MenuManager

class _MenuBar(vararg menus: Menu) : MenuBar(*menus), MenuManager