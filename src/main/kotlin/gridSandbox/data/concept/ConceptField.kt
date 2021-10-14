package gridSandbox.data.concept

interface ConceptField : InterfaceElement {

    val fieldName: String

    val conceptName: String

    val fieldId: String
        get() = getFieldId(fieldName, conceptName)

}

internal fun getFieldId(fieldName: String, conceptName: String): String =
    "idField$conceptName$fieldName"
