package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.Span
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

private const val GAVE_BIRTH_WHO_MEMBER_ID: String = "MemberGaveBirthWho"
private const val GAVE_BIRTH_TO_WHOM_MEMBER_ID: String = "MemberGaveBirthToWhom"
private const val GAVE_BIRTH_FATHER_MEMBER_ID: String = "MemberGaveBirthFather"

private const val GAVE_BIRTH_GAVE_BIRTH_CELL_ID: String = "CellGaveBirthGaveBirth"
private const val GAVE_BIRTH_FATHER_CELL_ID: String = "CellGaveBirthFather"
private const val GAVE_BIRTH_CLOSE_PAREN_CELL_ID: String = "CellGaveBirthCloseParen"

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
                metaConcept(
                    "EventDef",
                    fields = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "Gave Birth",
                    members = listOf(
                    ),
                    editorCells = listOf(
                        fieldCell("who", "Gave Birth", GAVE_BIRTH_WHO_MEMBER_ID),
                        textCell("${BLANK}gave birth to$BLANK", GAVE_BIRTH_GAVE_BIRTH_CELL_ID),
                        fieldCell("toWhom", "Gave Birth", GAVE_BIRTH_TO_WHOM_MEMBER_ID),
                        textCell("${BLANK}(father is$BLANK", GAVE_BIRTH_FATHER_CELL_ID),
                        fieldCell("father", "Gave Birth", GAVE_BIRTH_FATHER_MEMBER_ID),
                        textCell(")", GAVE_BIRTH_CLOSE_PAREN_CELL_ID),
                    ),
                ),
                predicate(
                    "Personifies",
                    members = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "PushInto",
                    members = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "Hated",
                    members = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "Planned",
                    members = listOf(
                    ),
                    editorCells = listOf(
                    ),
                ),
                predicate(
                    "Visited",
                    members = listOf(
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
                gaveBirth("Chaos", "Erebus", "Chaos"),
                gaveBirth("Chaos", "Nyx", "Chaos"),
                gaveBirth("Nyx", "Aether", "Erebus"),
                gaveBirth("Nyx", "Hemera", "Erebus"),
                gaveBirth("Hemera", "Thalassa", "Aether"),
                gaveBirth("Chaos", "Gaia", "Chaos"),
                gaveBirth("Chaos", "Tartarus", "Chaos"),
                gaveBirth("Chaos", "Pontus", "Chaos"),
                gaveBirth("Gaia", "Oceanus", "Uranus"),
                gaveBirth("Gaia", "Coeus", "Uranus"),
                gaveBirth("Gaia", "Crius", "Uranus"),
                gaveBirth("Gaia", "Hyperion", "Uranus"),
                gaveBirth("Gaia", "Iapetus", "Uranus"),
                gaveBirth("Gaia", "Cronus", "Uranus"),
                gaveBirth("Gaia", "Theia", "Uranus"),
                gaveBirth("Gaia", "Themis", "Uranus"),
                gaveBirth("Gaia", "Mnemosyne", "Uranus"),
                gaveBirth("Gaia", "Phoebe", "Uranus"),
                gaveBirth("Gaia", "Tethys", "Uranus"),
                gaveBirth("Gaia", "Rhea", "Uranus"),
                gaveBirth("Gaia", "Brontes", "Uranus"),
                gaveBirth("Gaia", "Steropes", "Uranus"),
                gaveBirth("Gaia", "Arges", "Uranus"),
                gaveBirth("Gaia", "Cottus", "Uranus"),
                gaveBirth("Gaia", "Gyges", "Uranus"),
                gaveBirth("Gaia", "Aegaeon", "Uranus"),
            ),
        )

private fun predicate(conceptName: String, members: List<ConceptField>, editorCells: List<EditorCell>): Box =
    verticalFlexContainer(
        simpleFlexContainer(
            span("Predicate:"),
            spanStringText(conceptName, getConceptId(conceptName)),
        ),
        gridContainer(
            simpleFlexContainerWithVShift(
                spanArgumentName("members"),
            ),
            elementsBox(members),
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

private fun notionInstanceRef(notionInstanceName: String, memberId: String): Span =
    spanReference(notionInstanceName, getNotionInstanceId(notionInstanceName), memberId)

private fun gaveBirth(who: String, toWhom: String, father: String): Box =
    flexContainer(
        notionInstanceRef(who, GAVE_BIRTH_WHO_MEMBER_ID),
        span("gave birth to", GAVE_BIRTH_GAVE_BIRTH_CELL_ID),
        notionInstanceRef(toWhom, GAVE_BIRTH_TO_WHOM_MEMBER_ID),
        span("(father is", GAVE_BIRTH_FATHER_CELL_ID),
        spanContainer(
            notionInstanceRef(father, GAVE_BIRTH_FATHER_MEMBER_ID),
            span(")", GAVE_BIRTH_CLOSE_PAREN_CELL_ID),
        ),
    )
