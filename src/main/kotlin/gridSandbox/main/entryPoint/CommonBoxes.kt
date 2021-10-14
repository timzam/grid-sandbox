package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.gridContainer
import gridSandbox.data.box.simpleFlexContainer
import gridSandbox.data.box.simpleFlexContainerWithHShift
import gridSandbox.data.box.simpleFlexContainerWithVShift
import gridSandbox.data.box.span
import gridSandbox.data.box.spanArgumentName
import gridSandbox.data.box.spanKeyword
import gridSandbox.data.box.spanStringText
import gridSandbox.data.box.verticalFlexContainer
import gridSandbox.data.concept.ConceptField

internal fun displaySchemaElements(vararg boxes: Box): Box =
    verticalFlexContainer(
        simpleFlexContainerWithHShift(
            spanKeyword("display"), span("schema elements"),
        ),
        simpleFlexContainer(*boxes),
    )

internal fun displayAllInstances(vararg boxes: Box): Box =
    verticalFlexContainer(
        simpleFlexContainerWithHShift(
            spanKeyword("display"), span("all instances"),
        ),
        simpleFlexContainer(*boxes),
    )

internal fun concept(conceptName: String, fields: List<ConceptField>): Box =
    verticalFlexContainer(
        simpleFlexContainer(
            spanKeyword("concept"),
            spanStringText(conceptName, getConceptId(conceptName)),
        ),
        gridContainer(
            simpleFlexContainerWithVShift(
                spanArgumentName("fields"),
            ),
            fieldsBox(fields),
            simpleFlexContainerWithVShift(
                spanArgumentName("editor"),
            ),
            simpleFlexContainer(

            ),
        ),
    )

private fun getConceptId(conceptName: String): String =
    "idConcept$conceptName"

private fun fieldsBox(fields: List<ConceptField>): Box {
    val boxes = fields.map { field -> field.getBox() }
    return simpleFlexContainer(*boxes.toTypedArray())
}
