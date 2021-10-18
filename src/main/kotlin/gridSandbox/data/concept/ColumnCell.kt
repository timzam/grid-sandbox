package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.Span
import gridSandbox.data.box.verticalFlexContainer

class ColumnCell internal constructor(
    private val cells: List<EditorCell>,
) : EditorCell {

    override fun getSpan(): Span =
        throw UnsupportedOperationException()

    override fun getBox(): Box {
        val header = textCell("column")
        val columnBoxes = cells.map { cell -> cell.getBox() }
        return verticalFlexContainer(
            header.getSpan(),
            *columnBoxes.toTypedArray(),
        )
    }

}

fun columnCell(vararg cells: EditorCell): EditorCell =
    ColumnCell(cells.toList())
