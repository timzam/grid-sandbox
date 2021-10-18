package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.simpleFlexContainerWithHShift
import gridSandbox.data.box.span
import gridSandbox.data.box.spanReference
import gridSandbox.data.box.verticalFlexContainer

class RefType constructor(
    private val refConceptName: String,
    private val refFieldKind: String = "ref",
    private val clauses: List<DataPattern> = emptyList(),
) : InterfaceElement {

    override fun getBox(): Box {
        val boxes = listOf(
            spanReference(refConceptName, getConceptId(refConceptName)),
            span(refFieldKind),
        )
        val clauseBoxes = clauses.map { clause -> clause.getBox() }.toTypedArray()
        return if (clauses.isEmpty()) {
            flexContainer(*boxes.toTypedArray())
        } else {
            verticalFlexContainer(
                simpleFlexContainerWithHShift(*boxes.toTypedArray()),
                *clauseBoxes,
            )
        }
    }

}
