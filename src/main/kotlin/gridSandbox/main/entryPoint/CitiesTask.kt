package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainerBox
import gridSandbox.data.box.simpleFlexContainerBox
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
                simpleFlexContainerBox(
                    spanKeyword("display"), span("schema elements"),
                ),
                simpleFlexContainerBox(
                    verticalFlexContainerBox(
                        simpleFlexContainerBox(
                            spanKeyword("concept"),
                        ),
                    ),
                    verticalFlexContainerBox(
                        simpleFlexContainerBox(
                            spanKeyword("concept"),
                        ),
                    ),
                ),
            ),
            verticalFlexContainerBox(
                simpleFlexContainerBox(
                    spanKeyword("display"), span("all instances"),
                ),
                simpleFlexContainerBox(
                ),
            ),
        )
