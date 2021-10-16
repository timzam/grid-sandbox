package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.Span
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.spanKeyword

class IfPresentEditorCell internal constructor(
    private val cells: List<EditorCell>,
) : EditorCell {

    override fun getSpan(): Span =
        throw UnsupportedOperationException()

    override fun getBox(): Box {
        val boxes = cells.map { cell -> cell.getBox() }
        return flexContainer(
            *boxes.toTypedArray(),
            spanKeyword("if present"),
        )
    }

}

fun ifPresentCell(vararg cells: EditorCell): EditorCell =
    IfPresentEditorCell(cells.toList())
