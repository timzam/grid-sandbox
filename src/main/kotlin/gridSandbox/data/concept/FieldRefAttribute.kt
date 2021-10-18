package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.spanReference

class FieldRefAttribute constructor(
    private val fieldName: String,
    private val conceptName: String,
) : PatternElement {

    override fun getBox(): Box =
        flexContainer(
            spanReference(fieldName, fieldId),
        )

    private val fieldId: String
        get() = getFieldId(fieldName, conceptName)

}
