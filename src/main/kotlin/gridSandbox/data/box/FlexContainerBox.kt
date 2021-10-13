package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.div

class FlexContainerBox internal constructor(
    private val boxes: List<Box>,
    private val directionClass: String = "",
    private val isSameLevel: Boolean = false,
) : Box {

    override fun getBlock(currentLevel: Int): FlowContent.() -> Unit = {
        div("flex-container with-vpadding with-hpadding level-$currentLevel $directionClass") {
            val nextLevel = if (isSameLevel) currentLevel else currentLevel + 1
            for (box in boxes) {
                val block = box.getBlock(nextLevel)
                block(this)
            }
        }
    }

}

fun flexContainerBox(vararg boxes: Box): Box =
    FlexContainerBox(boxes.toList())

fun flexContainerBoxSameLevel(vararg boxes: Box): Box =
    FlexContainerBox(boxes.toList(), isSameLevel = true)

fun verticalFlexContainerBox(vararg boxes: Box): Box =
    FlexContainerBox(boxes.toList(), "flex-column")
