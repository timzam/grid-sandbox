package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.div

class ContainerBox : Box {

    override fun getBlock(): FlowContent.() -> Unit = {
        div("container with-vpadding with-hpadding") {
            +"inside div!"
        }
    }

}
