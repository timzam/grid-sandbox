package gridSandbox.data.box

import kotlinx.html.FlowContent
import kotlinx.html.span

class SpanContainer internal constructor(
    private val spans: List<Span>,
) : Box {

    override fun getBlock(currentLevel: Int): FlowContent.() -> Unit = {
        span {
            for (span in spans) {
                val block = span.getBlock(currentLevel)
                block(this)
            }
        }
    }

}

fun spanContainer(vararg spans: Span): Box =
    SpanContainer(spans.toList())
