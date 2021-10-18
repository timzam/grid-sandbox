package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span

class DataPattern constructor(
    private val entity: PatternElement,
    private val attribute: PatternElement,
    private val value: PatternElement,
) : InterfaceElement {

    override fun getBox(): Box =
        flexContainer(
            span("["),
            entity.getBox(),
            attribute.getBox(),
            value.getBox(),
            span("]"),
        )

}
