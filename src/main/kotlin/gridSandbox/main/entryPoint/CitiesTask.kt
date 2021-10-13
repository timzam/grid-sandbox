package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span
import gridSandbox.data.box.spanReference
import gridSandbox.data.box.spanStringText
import gridSandbox.data.input.BoxTask

internal val citiesTask: BoxTask
    get() = BoxTask("cities.html", "Cities", citiesRootBox)

private val citiesRootBox: Box
    get() =
        flexContainer(
            displaySchemaElements(
                concept("Country"),
                concept("City"),
            ),
            displayAllInstances(
                country("Italy", "Rome"),
                country("Germany", "Berlin"),
                city("Rome", "Italy"),
                city("Milan", "Italy"),
                city("Berlin", "Germany"),
                city("Munich", "Germany"),
            ),
        )

private fun country(countryName: String, capitalName: String): Box =
    flexContainer(
        span("country"),
        spanStringText(countryName),
        span("with capital:"),
        spanReference(capitalName),
    )

private fun city(cityName: String, countryName: String): Box =
    flexContainer(
        span("city"),
        spanStringText(cityName),
        span(" ("),
        spanReference(countryName),
        span(")"),
    )
