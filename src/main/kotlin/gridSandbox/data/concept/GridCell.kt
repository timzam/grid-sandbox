package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.Span
import gridSandbox.data.box.flexContainer

class GridCell internal constructor(
    private val cells: List<EditorCell>,
) : EditorCell {

    override fun getSpan(): Span =
        throw UnsupportedOperationException()

    override fun getBox(): Box {
        val header = textCell("grid")
        val boxes = cells.map { cell -> cell.getBox() }
        return flexContainer(
            header.getSpan(),
            *boxes.toTypedArray(),
        )
    }

}

fun gridCell(vararg cells: EditorCell): EditorCell =
    GridCell(cells.toList())
