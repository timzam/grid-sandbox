package gridSandbox.data.concept

import gridSandbox.data.box.Span
import gridSandbox.data.box.spanStringText

class StringTextEditorCell internal constructor(
    private val text: String,
    private val sourceInstanceId: String?,
) : EditorCell {

    override fun getSpan(): Span =
        spanStringText(text, originId = sourceInstanceId)

}

fun stringTextCell(text: String, sourceInstanceId: String? = null): EditorCell =
    StringTextEditorCell(text, sourceInstanceId)
