package gridSandbox.main.entryPoint

import gridSandbox.data.input.BoxTask
import gridSandbox.data.input.Page
import gridSandbox.data.input.PageTask

internal val kBasePageTask: PageTask
    get() = PageTask(
        "kbase.html", Page("kBase", "kbase!"),
    )

internal val kBaseTask: BoxTask
    get() = BoxTask("kbase.html", "kBase")
