package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.spanReference

class FieldEditorCell internal constructor(
    private val fieldName: String,
    private val conceptName: String,
) : EditorCell {

    override fun getBox(): Box =
        flexContainer(
            spanReference(fieldName, fieldId),
        )

    private val fieldId: String
        get() = getFieldId(fieldName, conceptName)

}

fun fieldCell(fieldName: String, conceptName: String): EditorCell =
    FieldEditorCell(fieldName, conceptName)
