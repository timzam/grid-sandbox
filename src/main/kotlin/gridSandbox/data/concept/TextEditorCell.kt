package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.spanStringText

class TextEditorCell internal constructor(
    private val text: String,
) : EditorCell {

    override fun getBox(): Box =
        flexContainer(
            spanStringText(text),
        )

}

fun textCell(text: String): EditorCell =
    TextEditorCell(text)
