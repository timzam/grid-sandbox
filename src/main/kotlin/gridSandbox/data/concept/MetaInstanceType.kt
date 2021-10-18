package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span
import gridSandbox.data.box.spanReference

class MetaInstanceType constructor(
    private val refConceptName: String,
) : InterfaceElement {

    override fun getBox(): Box =
        flexContainer(
            spanReference(refConceptName, getConceptId(refConceptName)),
            span("ref")
        )

}
