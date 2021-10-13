package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.div

class FlexContainerBox internal constructor(
    private val boxes: List<Box>,
    private val directionClass: String = "",
    private val isSameLevel: Boolean = false,
    private val withPadding: Boolean = true,
) : Box {

    override fun getBlock(currentLevel: Int): FlowContent.() -> Unit = {
        val levelClass: String
        val nextLevel: Int
        if (isSameLevel) {
            levelClass = ""
            nextLevel = currentLevel
        } else {
            levelClass = "level-$currentLevel"
            nextLevel = currentLevel + 1
        }
        val paddingClasses: String =
            if (withPadding) {
                "with-vpadding with-hpadding"
            } else {
                ""
            }
        val classes =
            listOf("flex-container", paddingClasses, levelClass, directionClass)
                .filter { s -> s.isNotEmpty() }
                .joinToString(" ")
        div(classes) {
            for (box in boxes) {
                val block = box.getBlock(nextLevel)
                block(this)
            }
        }
    }

}

fun flexContainerBox(vararg boxes: Box): Box =
    FlexContainerBox(boxes.toList())

fun simpleFlexContainerBox(vararg boxes: Box): Box =
    FlexContainerBox(boxes.toList(), isSameLevel = true, withPadding = false)

fun verticalFlexContainerBox(vararg boxes: Box): Box =
    FlexContainerBox(boxes.toList(), "flex-column")
