package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span
import gridSandbox.data.box.spanContainer
import gridSandbox.data.box.spanReference
import gridSandbox.data.box.spanStringText

class RefField constructor(
    override val fieldName: String,
    override val conceptName: String,
    private val refConceptName: String,
) : ConceptField {

    override fun getBox(): Box =
        flexContainer(
            spanContainer(
                spanStringText(fieldName, fieldId),
                span(":")
            ),
            spanReference(refConceptName, getConceptId(refConceptName)),
            span("ref")
        )

}
