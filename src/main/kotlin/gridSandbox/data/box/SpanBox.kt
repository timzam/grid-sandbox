package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.SPAN
import kotlinx.html.span

class SpanBox internal constructor(
    private val text: String,
    private val spanClass: String? = null,
    private val sourceId: String? = null,
    private val referenceId: String? = null,
) : Span {

    override fun getBlock(currentLevel: Int): FlowContent.() -> Unit = {
        span(spanClass) {
            setAttribute("sourceId", sourceId)
            setAttribute("referenceId", referenceId)
            +text
        }
    }

    private fun SPAN.setAttribute(attrName: String, attrValue: String?) {
        if (attrValue != null) {
            attributes[attrName] = attrValue
        }
    }

}

fun span(text: String): Span =
    SpanBox(text)

fun spanKeyword(text: String, sourceId: String? = null): Span =
    SpanBox(text, "keyword", sourceId = sourceId)

fun spanArgumentName(text: String): Span =
    SpanBox(text, "argument-name")

fun spanStringText(text: String, sourceId: String? = null): Span =
    SpanBox(text, "string-text", sourceId = sourceId)

fun spanReference(text: String, referenceId: String): Span =
    SpanBox(text, "reference", referenceId = referenceId)
