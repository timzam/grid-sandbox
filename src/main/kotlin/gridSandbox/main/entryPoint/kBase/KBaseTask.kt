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
import gridSandbox.data.concept.EditorCell
import gridSandbox.data.concept.RefField
import gridSandbox.data.concept.SpecialField
import gridSandbox.data.concept.columnCell
import gridSandbox.data.concept.fieldCell
import gridSandbox.data.concept.getConceptId
import gridSandbox.data.concept.gridCell
import gridSandbox.data.concept.ifPresentCell
import gridSandbox.data.concept.rowCell
import gridSandbox.data.concept.stringTextCell
import gridSandbox.data.input.BoxTask
import gridSandbox.main.entryPoint.kBase.Member

val kBaseTask: BoxTask
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

private const val PERSONIFIES_WHO_MEMBER_ID: String = "MemberPersonifiesWho"
private const val PERSONIFIES_WHAT_MEMBER_ID: String = "MemberPersonifiesWhat"

private const val PERSONIFIES_PERSONIFIES_CELL_ID: String = "CellPersonifiesPersonifies"

private const val PUSH_INTO_WHO_MEMBER_ID: String = "MemberPushIntoWho"
private const val PUSH_INTO_WHAT_MEMBER_ID: String = "MemberPushIntoWhat"
private const val PUSH_INTO_INTO_WHAT_MEMBER_ID: String = "MemberPushIntoIntoWhat"

private const val PUSH_INTO_PUSHED_CELL_ID: String = "CellPushIntoPushed"
private const val PUSH_INTO_INTO_CELL_ID: String = "CellPushIntoInto"

private const val HATED_WHO_MEMBER_ID: String = "MemberHatedWho"
private const val HATED_WHOM_MEMBER_ID: String = "MemberHatedWhom"

private const val HATED_HATED_CELL_ID: String = "CellHatedHated"

private const val PLANNED_WHO_MEMBER_ID: String = "MemberPlannedWho"
private const val PLANNED_WHAT_MEMBER_ID: String = "MemberPlannedWhat"

private const val PLANNED_PLANNED_CELL_ID: String = "CellPlannedPlanned"

private const val VISITED_WHO_MEMBER_ID: String = "MemberVisitedWho"
private const val VISITED_WHAT_MEMBER_ID: String = "MemberVisitedWhat"

private const val VISITED_VISITED_CELL_ID: String = "CellVisitedVisited"

private const val EVENT_DEF_NAME_FIELD_ID: String = "FieldEventDefName"
private const val EVENT_DEF_EDITOR_FIELD_ID: String = "FieldEventDefEditor"
private const val EVENT_DEF_MEMBERS_FIELD_ID: String = "FieldEventDefMembers"

internal const val EVENT_DEF_PREDICATE_CELL_ID: String = "CellEventDefPredicate"

internal const val EVENT_MEMBER_DEF_NAME_FIELD_ID: String = "FieldEventMemberDefName"
internal const val EVENT_MEMBER_NOTION_DEF_FIELD_ID: String = "FieldEventMemberNotionDef"

internal const val EVENT_MEMBER_COLON_CELL_ID: String = "CellEventMemberColon"

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
                        stringTextCell(">>>$BLANK", NOTION_DEF_PREFIX_CELL_ID),
                        fieldCell("name", "NotionDef", NOTION_DEF_NAME_FIELD_ID),
                        ifPresentCell(
                            stringTextCell(":$BLANK", EXTENDS_COLON_CELL_ID),
                            fieldCell("extends", "NotionDef", EXTENDS_FIELD_ID),
                        ),
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
                        stringTextCell("${BLANK}is$BLANK", IS_CELL_ID),
                        fieldCell("notionDef", "NotionInstance", NOTION_DEF_FIELD_ID),
                    ),
                ),
                metaConcept(
                    "EventDef",
                    fields = listOf(
                        SpecialField("name", "EventDef", EVENT_DEF_NAME_FIELD_ID),
                        SpecialField("editor", "EventDef", EVENT_DEF_EDITOR_FIELD_ID),
                        RefField("members", "EventDef", "EventMemberDef", EVENT_DEF_MEMBERS_FIELD_ID, "components"),
                    ),
                    editorCells = listOf(
                        columnCell(
                            rowCell(
                                stringTextCell("Predicate:$BLANK", EVENT_DEF_PREDICATE_CELL_ID),
                                fieldCell("name", "EventDef", EVENT_DEF_NAME_FIELD_ID),
                            ),
                            gridCell(
                                fieldCell("members", "EventDef", EVENT_DEF_MEMBERS_FIELD_ID),
                                fieldCell("editor", "EventDef", EVENT_DEF_EDITOR_FIELD_ID),
                            ),
                        ),
                    ),
                    conceptBoxes = listOf(
                        concept(
                            "EventMemberDef",
                            fields = listOf(
                                SpecialField("name", "EventMemberDef", EVENT_MEMBER_DEF_NAME_FIELD_ID),
                                RefField("notionDef", "EventMemberDef", "NotionDef", EVENT_MEMBER_NOTION_DEF_FIELD_ID),
                            ),
                            editorCells = listOf(
                                fieldCell("name", "EventMemberDef", EVENT_MEMBER_DEF_NAME_FIELD_ID),
                                stringTextCell(":$BLANK", EVENT_MEMBER_COLON_CELL_ID),
                                fieldCell("notionDef", "EventMemberDef", EVENT_MEMBER_NOTION_DEF_FIELD_ID),
                            ),
                        ),
                    ),
                ),
                predicate(
                    "GaveBirth",
                    members = listOf(
                        Member("GaveBirth", "who", "Person", GAVE_BIRTH_WHO_MEMBER_ID),
                        Member("GaveBirth", "toWhom", "Person", GAVE_BIRTH_TO_WHOM_MEMBER_ID),
                        Member("GaveBirth", "father", "Person", GAVE_BIRTH_FATHER_MEMBER_ID),
                    ),
                    editorCells = listOf(
                        fieldCell("who", "GaveBirth", GAVE_BIRTH_WHO_MEMBER_ID),
                        stringTextCell("${BLANK}gave birth to$BLANK", GAVE_BIRTH_GAVE_BIRTH_CELL_ID),
                        fieldCell("toWhom", "GaveBirth", GAVE_BIRTH_TO_WHOM_MEMBER_ID),
                        stringTextCell("${BLANK}(father is$BLANK", GAVE_BIRTH_FATHER_CELL_ID),
                        fieldCell("father", "GaveBirth", GAVE_BIRTH_FATHER_MEMBER_ID),
                        stringTextCell(")", GAVE_BIRTH_CLOSE_PAREN_CELL_ID),
                    ),
                ),
                predicate(
                    "Personifies",
                    members = listOf(
                        Member("Personifies", "who", "Person", PERSONIFIES_WHO_MEMBER_ID),
                        Member("Personifies", "what", "Something", PERSONIFIES_WHAT_MEMBER_ID),
                    ),
                    editorCells = listOf(
                        fieldCell("who", "Personifies", PERSONIFIES_WHO_MEMBER_ID),
                        stringTextCell("${BLANK}personfies$BLANK", PERSONIFIES_PERSONIFIES_CELL_ID),
                        fieldCell("what", "Personifies", PERSONIFIES_WHAT_MEMBER_ID),
                    ),
                ),
                predicate(
                    "PushInto",
                    members = listOf(
                        Member("PushInto", "who", "Person", PUSH_INTO_WHO_MEMBER_ID),
                        Member("PushInto", "what", "SpaceObject", PUSH_INTO_WHAT_MEMBER_ID),
                        Member("PushInto", "intoWhat", "SpaceObject", PUSH_INTO_INTO_WHAT_MEMBER_ID),
                    ),
                    editorCells = listOf(
                        fieldCell("who", "PushInto", PUSH_INTO_WHO_MEMBER_ID),
                        stringTextCell("${BLANK}pushed$BLANK", PUSH_INTO_PUSHED_CELL_ID),
                        fieldCell("what", "PushInto", PUSH_INTO_WHAT_MEMBER_ID),
                        stringTextCell("${BLANK}into$BLANK", PUSH_INTO_INTO_CELL_ID),
                        fieldCell("intoWhat", "PushInto", PUSH_INTO_INTO_WHAT_MEMBER_ID),
                    ),
                ),
                predicate(
                    "Hated",
                    members = listOf(
                        Member("Hated", "who", "Person", HATED_WHO_MEMBER_ID),
                        Member("Hated", "whom", "Person", HATED_WHOM_MEMBER_ID),
                    ),
                    editorCells = listOf(
                        fieldCell("who", "Hated", HATED_WHO_MEMBER_ID),
                        stringTextCell("${BLANK}hated$BLANK", HATED_HATED_CELL_ID),
                        fieldCell("whom", "Hated", HATED_WHOM_MEMBER_ID),
                    ),
                ),
                predicate(
                    "Planned",
                    members = listOf(
                        Member("Planned", "who", "Person", PLANNED_WHO_MEMBER_ID),
                        Member("Planned", "what", "Action", PLANNED_WHAT_MEMBER_ID),
                    ),
                    editorCells = listOf(
                        fieldCell("who", "Planned", PLANNED_WHO_MEMBER_ID),
                        stringTextCell("${BLANK}planned$BLANK", PLANNED_PLANNED_CELL_ID),
                        fieldCell("what", "Planned", PLANNED_WHAT_MEMBER_ID),
                    ),
                ),
                predicate(
                    "Visited",
                    members = listOf(
                        Member("Visited", "who", "Person", VISITED_WHO_MEMBER_ID),
                        Member("Visited", "what", "Place", VISITED_WHAT_MEMBER_ID),
                    ),
                    editorCells = listOf(
                        fieldCell("who", "Visited", VISITED_WHO_MEMBER_ID),
                        stringTextCell("${BLANK}visited$BLANK", VISITED_VISITED_CELL_ID),
                        fieldCell("what", "Visited", VISITED_WHAT_MEMBER_ID),
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
                personifies("Erebus", "Darkness"),
                personifies("Nyx", "Night"),
                personifies("Aether", "Light"),
                personifies("Hemera", "Day"),
                personifies("Thalassa", "Sea"),
                personifies("Gaia", "Earth"),
                personifies("Tartarus", "Depth"),
                personifies("Tartarus", "Caves"),
                personifies("Pontus", "Sea"),
                personifies("Pontus", "Sky"),
                pushedInto("Uranus", "Brontes", "Gaia"),
                pushedInto("Uranus", "Steropes", "Gaia"),
                pushedInto("Uranus", "Arges", "Gaia"),
                pushedInto("Uranus", "Cottus", "Gaia"),
                pushedInto("Uranus", "Gyges", "Gaia"),
                pushedInto("Uranus", "Aegaeon", "Gaia"),
                hated("Gaia", "Uranus"),
                planned("Gaia", "Revenge"),
                visited("Gaia", "Othrys"),
            ),
        )

private fun predicate(conceptName: String, members: List<Member>, editorCells: List<EditorCell>): Box =
    verticalFlexContainer(
        simpleFlexContainer(
            span("Predicate:", EVENT_DEF_PREDICATE_CELL_ID),
            spanStringText(conceptName, getConceptId(conceptName), originReferenceId = EVENT_DEF_NAME_FIELD_ID),
        ),
        gridContainer(
            simpleFlexContainerWithVShift(
                spanArgumentName("members", EVENT_DEF_MEMBERS_FIELD_ID),
            ),
            elementsBox(members),
            simpleFlexContainerWithVShift(
                spanArgumentName("editor", EVENT_DEF_EDITOR_FIELD_ID),
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

internal fun getNotionDefId(notionDefName: String): String =
    "idNotionDef$notionDefName"

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

private fun personifies(who: String, what: String): Box =
    flexContainer(
        notionInstanceRef(who, PERSONIFIES_WHO_MEMBER_ID),
        span("personifies", PERSONIFIES_PERSONIFIES_CELL_ID),
        notionInstanceRef(what, PERSONIFIES_WHAT_MEMBER_ID),
    )

private fun pushedInto(who: String, what: String, intoWhat: String): Box =
    flexContainer(
        notionInstanceRef(who, PUSH_INTO_WHO_MEMBER_ID),
        span("pushed", PUSH_INTO_PUSHED_CELL_ID),
        notionInstanceRef(what, PUSH_INTO_WHAT_MEMBER_ID),
        span("into", PUSH_INTO_INTO_CELL_ID),
        notionInstanceRef(intoWhat, PUSH_INTO_INTO_WHAT_MEMBER_ID),
    )

private fun hated(who: String, whom: String): Box =
    flexContainer(
        notionInstanceRef(who, HATED_WHO_MEMBER_ID),
        span("hated", HATED_HATED_CELL_ID),
        notionInstanceRef(whom, HATED_WHOM_MEMBER_ID),
    )

private fun planned(who: String, what: String): Box =
    flexContainer(
        notionInstanceRef(who, PLANNED_WHO_MEMBER_ID),
        span("planned", PLANNED_PLANNED_CELL_ID),
        notionInstanceRef(what, PLANNED_WHAT_MEMBER_ID),
    )

private fun visited(who: String, what: String): Box =
    flexContainer(
        notionInstanceRef(who, VISITED_WHO_MEMBER_ID),
        span("visited", VISITED_VISITED_CELL_ID),
        notionInstanceRef(what, VISITED_WHAT_MEMBER_ID),
    )
