package gridSandbox.main.entryPoint

import gridSandbox.data.box.Box
import gridSandbox.data.box.flexContainer
import gridSandbox.data.box.span
import gridSandbox.data.box.spanContainer
import gridSandbox.data.box.spanReference
import gridSandbox.data.box.spanStringText
import gridSandbox.data.concept.RefField
import gridSandbox.data.concept.SpecialField
import gridSandbox.data.concept.fieldCell
import gridSandbox.data.concept.spanCell
import gridSandbox.data.concept.textCell
import gridSandbox.data.input.BoxTask

internal val citiesTask: BoxTask
    get() = BoxTask("cities.html", "Cities", citiesRootBox)

private const val COUNTRY_COUNTRY_CELL_ID: String = "CellCountryCountry"
private const val WITH_CAPITAL_CELL_ID: String = "CellCountryWithCapital"

private val citiesRootBox: Box
    get() =
        flexContainer(
            displaySchemaElements(
                concept(
                    "Country",
                    fields = listOf(
                        SpecialField("name", "Country"),
                        RefField("capital", "Country", "City"),
                    ),
                    editorCells = listOf(
                        textCell("country", COUNTRY_COUNTRY_CELL_ID),
                        fieldCell("name", "Country"),
                        textCell("with capital:", WITH_CAPITAL_CELL_ID),
                        fieldCell("capital", "Country"),
                    ),
                ),
                concept(
                    "City",
                    fields = listOf(
                        SpecialField("name", "City"),
                        RefField("country", "City", "Country"),
                    ),
                    editorCells = listOf(
                        textCell("city"),
                        fieldCell("name", "City"),
                        spanCell(
                            textCell("("),
                            fieldCell("country", "City"),
                            textCell(")"),
                        ),
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
        span("with capital:", WITH_CAPITAL_CELL_ID),
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
