package gridSandbox.data.concept

import gridSandbox.data.box.Span
import gridSandbox.data.box.spanReference

class FieldEditorCell internal constructor(
    private val fieldName: String,
    private val conceptName: String,
    private val fieldCellId: String,
) : EditorCell {

    override fun getSpan(): Span =
        spanReference(fieldName, fieldId, originId = fieldCellId)

    private val fieldId: String
        get() = getFieldId(fieldName, conceptName)

}

fun fieldCell(fieldName: String, conceptName: String, fieldCellId: String): EditorCell =
    FieldEditorCell(fieldName, conceptName, fieldCellId)
