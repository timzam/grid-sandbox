package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.simpleFlexContainerBox
import gridSandbox.data.box.simpleHorizontalFlexContainerBox
import gridSandbox.data.box.span
import gridSandbox.data.box.spanKeyword
import gridSandbox.data.box.spanStringText
import gridSandbox.data.box.verticalFlexContainerBox

internal fun displaySchemaElements(vararg boxes: Box): Box =
    verticalFlexContainerBox(
        simpleHorizontalFlexContainerBox(
            spanKeyword("display"), span("schema elements"),
        ),
        simpleFlexContainerBox(*boxes),
    )

internal fun displayAllInstances(vararg boxes: Box): Box =
    verticalFlexContainerBox(
        simpleHorizontalFlexContainerBox(
            spanKeyword("display"), span("all instances"),
        ),
        simpleFlexContainerBox(*boxes),
    )

internal fun concept(conceptName: String): Box =
    verticalFlexContainerBox(
        simpleFlexContainerBox(
            spanKeyword("concept"),
            spanStringText(conceptName, getConceptId(conceptName)),
        ),
    )

private fun getConceptId(conceptName: String): String =
    "idConcept$conceptName"
