package gridSandbox.main.entryPoint

import gridSandbox.data.input.BoxTask
import gridSandbox.data.input.Page
import gridSandbox.data.input.PageTask

internal val citiesPageTask: PageTask
    get() = PageTask(
        "cities.html", Page("Cities", "cities!"),
    )

internal val citiesTask: BoxTask
    get() = BoxTask("cities.html", "Cities")
