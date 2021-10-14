package gridSandbox.data.concept

import gridSandbox.data.box.Span
import gridSandbox.data.box.spanContainer

class SpanCell internal constructor(
    private val cells: List<EditorCell>,
) : EditorCell {

    override fun getSpan(): Span {
        val spans = cells.map { cell -> cell.getSpan() }
        return spanContainer(*spans.toTypedArray())
    }

}

fun spanCell(vararg cells: EditorCell): EditorCell =
    SpanCell(cells.toList())
