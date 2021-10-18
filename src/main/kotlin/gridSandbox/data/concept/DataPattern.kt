package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span

class DataPattern constructor(
) : InterfaceElement {

    override fun getBox(): Box =
        flexContainer(
            span("["),
            span("]"),
        )

}
