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
import gridSandbox.data.concept.EditorCell
import gridSandbox.data.concept.InterfaceElement
import gridSandbox.data.concept.getConceptId

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

internal fun concept(conceptName: String, fields: List<ConceptField>, editorCells: List<EditorCell>): Box =
    verticalFlexContainer(
        simpleFlexContainer(
            spanKeyword("concept"),
            spanStringText(conceptName, getConceptId(conceptName)),
        ),
        gridContainer(
            simpleFlexContainerWithVShift(
                spanArgumentName("fields"),
            ),
            elementsBox(fields),
            simpleFlexContainerWithVShift(
                spanArgumentName("editor"),
            ),
            elementsBox(editorCells),
        ),
    )

internal fun metaConcept(conceptName: String, fields: List<ConceptField>, editorCells: List<EditorCell>): Box =
    verticalFlexContainer(
        simpleFlexContainer(
            spanKeyword("meta concept"),
            spanStringText(conceptName, getConceptId(conceptName)),
        ),
        gridContainer(
            simpleFlexContainerWithVShift(
                spanArgumentName("fields"),
            ),
            elementsBox(fields),
            simpleFlexContainerWithVShift(
                spanArgumentName("editor"),
            ),
            elementsBox(editorCells),
            simpleFlexContainerWithVShift(
                spanArgumentName("inner concepts"),
            ),
        ),
    )

internal fun elementsBox(elements: List<InterfaceElement>): Box {
    val boxes = elements.map { field -> field.getBox() }
    return simpleFlexContainer(*boxes.toTypedArray())
}
