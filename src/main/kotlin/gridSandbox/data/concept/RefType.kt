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
    private val datalogExpression: DatalogExpression? = null,
) : InterfaceElement {

    override fun getBox(): Box {
        val boxes = listOf(
            spanReference(refConceptName, getConceptId(refConceptName)),
            span(refFieldKind),
        )
        return if (datalogExpression == null) {
            flexContainer(*boxes.toTypedArray())
        } else {
            verticalFlexContainer(
                simpleFlexContainerWithHShift(*boxes.toTypedArray()),
                datalogExpression.getBox(),
            )
        }
    }

}
