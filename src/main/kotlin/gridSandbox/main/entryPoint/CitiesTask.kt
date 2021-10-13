package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainerBox
import gridSandbox.data.box.flexContainerBoxSameLevel
import gridSandbox.data.box.span
import gridSandbox.data.box.spanKeyword
import gridSandbox.data.box.verticalFlexContainerBox
import gridSandbox.data.input.BoxTask

internal val citiesTask: BoxTask
    get() = BoxTask("cities.html", "Cities", citiesRootBox)

private val citiesRootBox: Box
    get() =
        flexContainerBox(
            verticalFlexContainerBox(
                flexContainerBoxSameLevel(
                    spanKeyword("display"), span("schema elements"),
                ),
            ),
        )
