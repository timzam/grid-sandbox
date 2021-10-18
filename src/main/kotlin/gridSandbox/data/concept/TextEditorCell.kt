package gridSandbox.data.concept

import gridSandbox.data.box.Span
import gridSandbox.data.box.span

class TextEditorCell internal constructor(
    private val text: String,
    private val originReferenceId: String?,
) : EditorCell {

    override fun getSpan(): Span =
        span(text, originReferenceId)

}

fun textCell(text: String, originReferenceId: String? = null): EditorCell =
    TextEditorCell(text, originReferenceId)
