package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainerBox
import gridSandbox.data.input.BoxTask

internal val kBaseTask: BoxTask
    get() = BoxTask("kbase.html", "kBase", kBaseRootBox)

private val kBaseRootBox: Box
    get() = flexContainerBox()
