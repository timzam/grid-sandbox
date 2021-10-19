package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span

class DatalogInfixExpression constructor(
    private val operation: String,
    private val operand1: DatalogExpression,
    private val operand2: DatalogExpression,
) : DatalogExpression {

    override fun getBox(): Box =
        flexContainer(
            operand1.getBox(),
            span(operation),
            operand2.getBox(),
        )

}
