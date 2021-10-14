package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.SPAN
import kotlinx.html.span

class Span internal constructor(
    private val text: String,
    private val spanClass: String? = null,
    private val sourceId: String = "",
    private val referenceId: String = "",
) : Box {

    override fun getBlock(currentLevel: Int): FlowContent.() -> Unit = {
        span(spanClass) {
            setAttribute("sourceId", sourceId)
            setAttribute("referenceId", referenceId)
            +text
        }
    }

    private fun SPAN.setAttribute(attrName: String, attrValue: String) {
        if (attrValue.isNotEmpty()) {
            attributes[attrName] = attrValue
        }
    }

}

fun span(text: String): Span =
    Span(text)

fun spanKeyword(text: String): Span =
    Span(text, "keyword")

fun spanArgumentName(text: String): Span =
    Span(text, "argument-name")

fun spanStringText(text: String, sourceId: String): Span =
    Span(text, "string-text", sourceId = sourceId)

fun spanReference(text: String, referenceId: String): Span =
    Span(text, "reference", referenceId = referenceId)
