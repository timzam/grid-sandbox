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
        val rowCells = listOf(
            textCell("row"),
            *cells.toTypedArray(),
        )
        val boxes = rowCells.map { cell -> cell.getBox() }
        return flexContainer(
            *boxes.toTypedArray(),
        )
    }

}

fun rowCell(vararg cells: EditorCell): EditorCell =
    RowCell(cells.toList())
