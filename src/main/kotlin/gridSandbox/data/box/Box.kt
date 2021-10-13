package gridSandbox.data.box

import kotlinx.html.FlowContent

interface Box {

    fun getBlock(currentLevel: Int): FlowContent.() -> Unit

}
