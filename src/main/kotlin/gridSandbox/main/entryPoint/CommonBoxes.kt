package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.simpleFlexContainer
import gridSandbox.data.box.simpleHorizontalFlexContainer
import gridSandbox.data.box.span
import gridSandbox.data.box.spanKeyword
import gridSandbox.data.box.spanStringText
import gridSandbox.data.box.verticalFlexContainer

internal fun displaySchemaElements(vararg boxes: Box): Box =
    verticalFlexContainer(
        simpleHorizontalFlexContainer(
            spanKeyword("display"), span("schema elements"),
        ),
        simpleFlexContainer(*boxes),
    )

internal fun displayAllInstances(vararg boxes: Box): Box =
    verticalFlexContainer(
        simpleHorizontalFlexContainer(
            spanKeyword("display"), span("all instances"),
        ),
        simpleFlexContainer(*boxes),
    )

internal fun concept(conceptName: String): Box =
    verticalFlexContainer(
        simpleFlexContainer(
            spanKeyword("concept"),
            spanStringText(conceptName, getConceptId(conceptName)),
        ),
    )

private fun getConceptId(conceptName: String): String =
    "idConcept$conceptName"
