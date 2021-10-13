package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.span

class Span internal constructor(
    private val text: String,
    private val spanClass: String = "",
    private val sourceId: String = "",
) : Box {

    override fun getBlock(currentLevel: Int): FlowContent.() -> Unit = {
        span(spanClass) {
            if (sourceId.isNotEmpty()) {
                attributes["sourceId"] = sourceId
            }
            +text
        }
    }

}

fun span(text: String): Box =
    Span(text)

fun spanKeyword(text: String): Box =
    Span(text, "keyword")

fun spanStringText(text: String, sourceId: String): Box =
    Span(text, "string-text", sourceId = sourceId)

fun spanReference(text: String): Box =
    Span(text, "reference")
