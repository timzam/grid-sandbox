package gridSandbox.main.entryPoint

import gridSandbox.data.input.Page
import gridSandbox.data.input.PageTask
import gridSandbox.data.input.SiteTask

val siteTask: SiteTask =
    SiteTask(
        PageTask(
            "cities.html", Page("Cities", "hello!"),
        ),
    )
