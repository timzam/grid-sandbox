package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span
import gridSandbox.data.box.spanContainer
import gridSandbox.data.box.spanStringText

class RefField constructor(
    override val fieldName: String,
    override val conceptName: String,
    private val fieldCellId: String,
    private val refType: RefType,
) : ConceptField {

    override fun getBox(): Box =
        flexContainer(
            spanContainer(
                spanStringText(fieldName, fieldId, fieldCellId),
                span(":")
            ),
            refType.getBox(),
        )

}
