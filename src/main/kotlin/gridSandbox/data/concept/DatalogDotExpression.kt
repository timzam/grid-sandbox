package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span

class DatalogDotExpression constructor(
    private val entityExpression: DatalogExpression,
    private val attribute: FieldRefAttribute,
) : DatalogExpression {

    override fun getBox(): Box =
        flexContainer(
            entityExpression.getBox(),
            span("."),
            attribute.getBox(),
        )

}
