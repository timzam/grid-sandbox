package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.FlexContainerBox
import gridSandbox.data.box.KeywordSpan
import gridSandbox.data.input.BoxTask

internal val citiesTask: BoxTask
    get() = BoxTask("cities.html", "Cities", citiesRootBox)

private val citiesRootBox: Box
    get() =
        FlexContainerBox(
            KeywordSpan("concept"),
        )
