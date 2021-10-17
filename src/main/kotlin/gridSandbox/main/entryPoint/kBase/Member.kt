package gridSandbox.main.entryPoint.kBase

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span
import gridSandbox.data.box.spanContainer
import gridSandbox.data.box.spanReference
import gridSandbox.data.box.spanStringText
import gridSandbox.data.concept.ConceptField
import gridSandbox.main.entryPoint.EVENT_MEMBER_COLON_CELL_ID
import gridSandbox.main.entryPoint.EVENT_MEMBER_DEF_NAME_FIELD_ID
import gridSandbox.main.entryPoint.EVENT_MEMBER_NOTION_DEF_FIELD_ID
import gridSandbox.main.entryPoint.getNotionDefId

class Member constructor(
    override val conceptName: String,
    override val fieldName: String,
    private val notionDefName: String,
    private val memberCellId: String,
) : ConceptField {

    override fun getBox(): Box =
        flexContainer(
            spanContainer(
                spanStringText(fieldName, fieldId, memberCellId, EVENT_MEMBER_DEF_NAME_FIELD_ID),
                span(":", EVENT_MEMBER_COLON_CELL_ID)
            ),
            spanReference(notionDefName, getNotionDefId(notionDefName), EVENT_MEMBER_NOTION_DEF_FIELD_ID),
        )

}
