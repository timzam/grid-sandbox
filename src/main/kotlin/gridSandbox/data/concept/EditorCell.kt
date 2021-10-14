package gridSandbox.data.concept

import gridSandbox.data.box.Box
import gridSandbox.data.box.Span
import gridSandbox.data.box.flexContainer

interface EditorCell : InterfaceElement {

    fun getSpan(): Span

    override fun getBox(): Box =
        flexContainer(
            getSpan(),
        )

}
