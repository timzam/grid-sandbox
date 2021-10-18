package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.simpleFlexContainer
import gridSandbox.data.box.span
import gridSandbox.data.box.spanArgumentName
import gridSandbox.data.box.spanContainer
import gridSandbox.data.box.spanStringText
import gridSandbox.data.box.verticalFlexContainer

class RefField constructor(
    override val fieldName: String,
    override val conceptName: String,
    private val fieldCellId: String,
    private val type: RefType,
    private val metaInstanceType: RefType? = null,
) : ConceptField {

    override fun getBox(): Box {
        val boxes = listOf(
            spanContainer(
                spanStringText(fieldName, fieldId, fieldCellId),
                span(":")
            ),
            type.getBox(),
        )
        return if (metaInstanceType == null) {
            flexContainer(*boxes.toTypedArray())
        } else {
            verticalFlexContainer(
                simpleFlexContainer(*boxes.toTypedArray()),
                simpleFlexContainer(
                    spanArgumentName("meta instance type"),
                    metaInstanceType.getBox(),
                )
            )
        }
    }

}
