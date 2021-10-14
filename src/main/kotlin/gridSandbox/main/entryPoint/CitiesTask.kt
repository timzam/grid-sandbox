package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span
import gridSandbox.data.box.spanContainer
import gridSandbox.data.box.spanReference
import gridSandbox.data.box.spanStringText
import gridSandbox.data.concept.SpecialField
import gridSandbox.data.concept.fieldCell
import gridSandbox.data.concept.textCell
import gridSandbox.data.input.BoxTask

internal val citiesTask: BoxTask
    get() = BoxTask("cities.html", "Cities", citiesRootBox)

private val citiesRootBox: Box
    get() =
        flexContainer(
            displaySchemaElements(
                concept(
                    "Country",
                    fields = listOf(
                        SpecialField("name", "Country"),
                    ),
                    editorCells = listOf(
                        textCell("country"),
                        fieldCell("name", "Country"),
                        textCell("with capital:"),
                        fieldCell("capital", "Country"),
                    ),
                ),
                concept(
                    "City",
                    fields = listOf(
                        SpecialField("name", "City"),
                    ),
                    editorCells = listOf(
                        textCell("city"),
                        fieldCell("name", "City"),
                        textCell("("),
                        fieldCell("country", "City"),
                        textCell(")"),
                    ),
                ),
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
        spanStringText(countryName, getCountryId(countryName)),
        span("with capital:"),
        spanReference(capitalName, getCityId(capitalName)),
    )

private fun getCountryId(countryName: String): String =
    "idCountry$countryName"

private fun city(cityName: String, countryName: String): Box =
    flexContainer(
        span("city"),
        spanStringText(cityName, getCityId(cityName)),
        spanContainer(
            span("("),
            spanReference(countryName, getCountryId(countryName)),
            span(")"),
        ),
    )

private fun getCityId(cityName: String): String =
    "idCity$cityName"
