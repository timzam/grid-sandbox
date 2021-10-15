package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.gridContainer
import gridSandbox.data.box.simpleFlexContainer
import gridSandbox.data.box.simpleFlexContainerWithVShift
import gridSandbox.data.box.span
import gridSandbox.data.box.spanArgumentName
import gridSandbox.data.box.spanContainer
import gridSandbox.data.box.spanReference
import gridSandbox.data.box.spanStringText
import gridSandbox.data.box.verticalFlexContainer
import gridSandbox.data.concept.ConceptField
import gridSandbox.data.concept.EditorCell
import gridSandbox.data.concept.RefField
import gridSandbox.data.concept.SpecialField
import gridSandbox.data.concept.fieldCell
import gridSandbox.data.concept.getConceptId
import gridSandbox.data.concept.textCell
import gridSandbox.data.input.BoxTask

internal val kBaseTask: BoxTask
    get() = BoxTask("kbase.html", "kBase", kBaseRootBox)

private const val NOTION_DEF_NAME_FIELD_ID: String = "FieldNotionDefName"
private const val EXTENDS_FIELD_ID: String = "FieldNotionDefExtends"

private const val NOTION_INSTANCE_NAME_FIELD_ID: String = "FieldNotionInstanceName"
private const val NOTION_DEF_FIELD_ID: String = "FieldNotionInstanceNotionDef"

private const val NOTION_DEF_PREFIX_CELL_ID: String = "CellNotionDefPrefix"
private const val EXTENDS_COLON_CELL_ID: String = "CellNotionDefExtendsColon"

private const val IS_CELL_ID: String = "CellNotionInstanceIs"

private const val BLANK: Char = '\u23B5'

private val kBaseRootBox: Box
    get() =
        flexContainer(
            displaySchemaElements(
                concept(
                    "NotionDef",
                    fields = listOf(
                        SpecialField("name", "NotionDef", NOTION_DEF_NAME_FIELD_ID),
                        RefField("extends", "NotionDef", "NotionDef", EXTENDS_FIELD_ID),
                    ),
                    editorCells = listOf(
                        textCell(">>>$BLANK", NOTION_DEF_PREFIX_CELL_ID),
                        fieldCell("name", "NotionDef", NOTION_DEF_NAME_FIELD_ID),
                        /*
                        ifPresentCell(
                            "extends",
                        ),
                        */
                        textCell(":$BLANK", EXTENDS_COLON_CELL_ID),
                        fieldCell("extends", "NotionDef", EXTENDS_FIELD_ID),
                    ),
                ),
                concept(
                    "NotionInstance",
                    fields = listOf(
                        SpecialField("name", "NotionInstance", NOTION_INSTANCE_NAME_FIELD_ID),
                        RefField("notionDef", "NotionInstance", "NotionDef", NOTION_DEF_FIELD_ID),
                    ),
                    editorCells = listOf(
                        fieldCell("name", "NotionInstance", NOTION_INSTANCE_NAME_FIELD_ID),
                        textCell("${BLANK}is$BLANK", IS_CELL_ID),
                        fieldCell("notionDef", "NotionInstance", NOTION_DEF_FIELD_ID),
                    ),
                ),
                concept(
                    "EventDef",
                    fields = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "Gave Birth",
                    fields = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "Personifies",
                    fields = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "PushInto",
                    fields = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "Hated",
                    fields = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "Planned",
                    fields = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "Visited",
                    fields = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
            ),
            displayAllInstances(
                notionDef("SpaceObject"),
                notionDef("Person", "SpaceObject"),
                notionDef("God", "Person"),
                notionDef("Male", "Person"),
                notionDef("Female", "Person"),
                notionDef("Something"),
                notionDef("Action"),
                notionDef("Place"),
                notionDef("Mountain", "Place"),
                notionDef("Greek God", "God"),
                notionDef("Primordial Deity", "Greek God"),
                notionDef("Pre-olympic God", "Greek God"),
                notionDef("Titan", "Pre-olympic God"),
                notionDef("Cyclops", "Pre-olympic God"),
                notionDef("Hecatonchire", "Person"),
                notionInstance("Night", "Something"),
                notionInstance("Darkness", "Something"),
                notionInstance("Light", "Something"),
                notionInstance("Day", "Something"),
                notionInstance("Earth", "Something"),
                notionInstance("Caves", "Something"),
                notionInstance("Depth", "Something"),
                notionInstance("Sea", "Something"),
                notionInstance("Sky", "Something"),
                notionInstance("Revenge", "Action"),
                notionInstance("Chaos", "Primordial Deity"),
                notionInstance("Erebus", "Primordial Deity", "Male"),
                notionInstance("Nyx", "Primordial Deity", "Female"),
                notionInstance("Aether", "Primordial Deity", "Male"),
                notionInstance("Gaia", "Primordial Deity", "Female"),
                notionInstance("Tartarus", "Primordial Deity", "Male"),
                notionInstance("Pontus", "Primordial Deity", "Male"),
                notionInstance("Uranus", "Primordial Deity", "Male"),
                notionInstance("Hemera", "Primordial Deity", "Female"),
                notionInstance("Thalassa", "Primordial Deity", "Female"),
                notionInstance("Oceanus", "Titan", "Male"),
                notionInstance("Coeus", "Titan", "Male"),
                notionInstance("Crius", "Titan", "Male"),
                notionInstance("Hyperion", "Titan", "Male"),
                notionInstance("Iapetus", "Titan", "Male"),
                notionInstance("Cronus", "Titan", "Male"),
                notionInstance("Theia", "Titan", "Female"),
                notionInstance("Themis", "Titan", "Female"),
                notionInstance("Mnemosyne", "Titan", "Female"),
                notionInstance("Phoebe", "Titan", "Female"),
                notionInstance("Tethys", "Titan", "Female"),
                notionInstance("Rhea", "Titan", "Female"),
                notionInstance("Brontes", "Cyclops", "Male"),
                notionInstance("Steropes", "Cyclops", "Male"),
                notionInstance("Arges", "Cyclops", "Male"),
                notionInstance("Cottus", "Hecatonchire"),
                notionInstance("Gyges", "Hecatonchire"),
                notionInstance("Aegaeon", "Hecatonchire"),
                notionInstance("Othrys", "Mountain"),
            ),
        )

private fun predicate(conceptName: String, fields: List<ConceptField>, editorCells: List<EditorCell>): Box =
    verticalFlexContainer(
        simpleFlexContainer(
            span("Predicate:"),
            spanStringText(conceptName, getConceptId(conceptName)),
        ),
        gridContainer(
            simpleFlexContainerWithVShift(
                spanArgumentName("members"),
            ),
            elementsBox(fields),
            simpleFlexContainerWithVShift(
                spanArgumentName("editor"),
            ),
            elementsBox(editorCells),
        ),
    )

private fun notionDef(notionDefName: String, extends: String? = null): Box {
    val boxes =
        @OptIn(ExperimentalStdlibApi::class)
        buildList {
            add(
                spanStringText(
                    notionDefName, getNotionDefId(notionDefName), originReferenceId = NOTION_DEF_NAME_FIELD_ID,
                ),
            )
            if (extends != null) {
                add(
                    span(": ", EXTENDS_COLON_CELL_ID),
                )
                add(
                    spanReference(extends, getNotionDefId(extends), EXTENDS_FIELD_ID),
                )
            }
        }
    return flexContainer(
        span(">>>", NOTION_DEF_PREFIX_CELL_ID),
        spanContainer(*boxes.toTypedArray()),
    )
}

private fun getNotionDefId(notionDefName: String): String =
    "idNotionDef$notionDefName"

/*
private fun ifPresentCell(fieldId: String, vararg cells: EditorCell): EditorCell {
    return flexContainer(

    )
}
*/

private fun notionInstance(notionInstanceName: String, vararg notionDefNames: String): Box {
    val notionDefName = notionDefNames.first()
    return flexContainer(
        spanStringText(
            notionInstanceName,
            getNotionInstanceId(notionInstanceName),
            originReferenceId = NOTION_INSTANCE_NAME_FIELD_ID,
        ),
        span("is", IS_CELL_ID),
        spanReference(notionDefName, getNotionDefId(notionDefName), NOTION_DEF_FIELD_ID),
    )
}

private fun getNotionInstanceId(notionInstanceName: String): String =
    "idNotionInstance$notionInstanceName"
