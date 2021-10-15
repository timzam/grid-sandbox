package gridSandbox.main.entryPoint.kBase

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span
import gridSandbox.data.box.spanContainer
import gridSandbox.data.box.spanReference
import gridSandbox.data.box.spanStringText
import gridSandbox.data.concept.ConceptField
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
                spanStringText(fieldName, fieldId, memberCellId),
                span(":")
            ),
            spanReference(notionDefName, getNotionDefId(notionDefName)),
        )

}
