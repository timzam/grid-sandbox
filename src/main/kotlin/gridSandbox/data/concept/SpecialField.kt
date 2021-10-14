package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.spanKeyword

class SpecialField constructor(
    private val fieldName: String,
) : ConceptField {

    override fun getBox(): Box =
        flexContainer(
            spanKeyword(fieldName),
        )

}
