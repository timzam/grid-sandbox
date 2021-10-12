package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.span

class KeywordSpan constructor(
    private val text: String,
) : Box {

    override fun getBlock(): FlowContent.() -> Unit = {
        span("keyword") {
            +text
        }
    }

}
