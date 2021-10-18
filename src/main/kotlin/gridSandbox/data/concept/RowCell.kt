package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.Span
import gridSandbox.data.box.flexContainer

class RowCell internal constructor(
    private val cells: List<EditorCell>,
) : EditorCell {

    override fun getSpan(): Span =
        throw UnsupportedOperationException()

    override fun getBox(): Box {
        val header = textCell("row")
        val boxes = cells.map { cell -> cell.getBox() }
        return flexContainer(
            header.getSpan(),
            *boxes.toTypedArray(),
        )
    }

}

fun rowCell(vararg cells: EditorCell): EditorCell =
    RowCell(cells.toList())
