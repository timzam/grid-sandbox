package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span

class BuiltInQueryVariable constructor(
    private val variableName: String,
) : PatternElement {

    override fun getBox(): Box =
        flexContainer(
            span("?$variableName"),
        )

}
