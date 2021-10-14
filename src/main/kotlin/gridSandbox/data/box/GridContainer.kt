package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.div

class GridContainer internal constructor(
    private val boxes: List<Box>,
) : Box {

    override fun getBlock(currentLevel: Int): FlowContent.() -> Unit = {
        div("grid-container") {
            for (box in boxes) {
                val block = box.getBlock(currentLevel)
                block(this)
            }
        }
    }

}

fun gridContainer(vararg boxes: Box): Box =
    GridContainer(boxes.toList())
