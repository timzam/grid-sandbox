package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.div

class FlexContainerBox private constructor(
    private val boxes: List<Box>,
) : Box {

    constructor(vararg boxes: Box) : this(boxes.toList())

    override fun getBlock(): FlowContent.() -> Unit = {
        div("flex-container with-vpadding with-hpadding") {
            for (box in boxes) {
                val block = box.getBlock()
                block(this)
            }
        }
    }

}
