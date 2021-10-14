package gridSandbox.data.concept

import gridSandbox.data.box.Span
import gridSandbox.data.box.spanStringText

class TextEditorCell internal constructor(
    private val text: String,
) : EditorCell {

    override fun getSpan(): Span =
        spanStringText(text)

}

fun textCell(text: String): EditorCell =
    TextEditorCell(text)
