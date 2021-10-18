package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.simpleFlexContainerWithHShift
import gridSandbox.data.box.span
import gridSandbox.data.box.spanContainer
import gridSandbox.data.box.spanReference
import gridSandbox.data.box.spanStringText
import gridSandbox.data.box.verticalFlexContainer

class RefField constructor(
    override val fieldName: String,
    override val conceptName: String,
    private val refConceptName: String,
    private val fieldCellId: String,
    private val refFieldKind: String = "ref",
    private val metaInstanceType: MetaInstanceType? = null,
) : ConceptField {

    override fun getBox(): Box {
        val boxes = listOf(
            spanContainer(
                spanStringText(fieldName, fieldId, fieldCellId),
                span(":")
            ),
            spanReference(refConceptName, getConceptId(refConceptName)),
            span(refFieldKind),
        )
        return if (metaInstanceType == null) {
            flexContainer(*boxes.toTypedArray())
        } else {
            verticalFlexContainer(
                simpleFlexContainerWithHShift(*boxes.toTypedArray()),
                metaInstanceType.getBox(),
            )
        }
    }

}
