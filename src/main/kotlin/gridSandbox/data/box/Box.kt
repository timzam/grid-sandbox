package gridSandbox.data.box

import kotlinx.html.FlowContent

interface Box {

    fun getBlock(): FlowContent.() -> Unit

}
