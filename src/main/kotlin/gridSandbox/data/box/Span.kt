package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.span

class Span internal constructor(
    private val text: String,
    private val spanClass: String = "",
) : Box {

    override fun getBlock(currentLevel: Int): FlowContent.() -> Unit = {
        span(spanClass) {
            +text
        }
    }

}

fun span(text: String): Box =
    Span(text)

fun spanKeyword(text: String): Box =
    Span(text, "keyword")
