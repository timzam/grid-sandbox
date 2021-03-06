package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.spanKeyword

class SpecialField constructor(
    override val fieldName: String,
    override val conceptName: String,
    private val fieldCellId: String,
) : ConceptField {

    override fun getBox(): Box =
        flexContainer(
            spanKeyword(fieldName, fieldId, fieldCellId),
        )

}
