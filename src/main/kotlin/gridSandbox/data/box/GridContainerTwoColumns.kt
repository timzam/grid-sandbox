package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.div

class GridContainerTwoColumns internal constructor(
    private val boxes: List<Box>,
) : Box {

    override fun getBlock(currentLevel: Int): FlowContent.() -> Unit = {
        div("grid-container-two-columns") {
            for (box in boxes) {
                val block = box.getBlock(currentLevel)
                block(this)
            }
        }
    }

}

fun gridTwoColumns(vararg boxes: Box): Box =
    GridContainerTwoColumns(boxes.toList())
