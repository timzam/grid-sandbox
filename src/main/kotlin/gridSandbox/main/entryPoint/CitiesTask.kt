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

private const val CITY_CITY_CELL_ID: String = "CellCityCity"
private const val OPEN_PAREN_CELL_ID: String = "CellCityOpenParen"
private const val CLOSE_PAREN_CELL_ID: String = "CellCityCloseParen"

private const val COUNTRY_NAME_FIELD_ID: String = "FieldCountryName"
private const val CITY_NAME_FIELD_ID: String = "FieldCityName"
private const val CAPITAL_FIELD_ID: String = "FieldCountryCapital"
private const val COUNTRY_FIELD_ID: String = "FieldCityCountry"

private val citiesRootBox: Box
    get() =
        flexContainer(
            displaySchemaElements(
                concept(
                    "Country",
                    fields = listOf(
                        SpecialField("name", "Country", COUNTRY_NAME_FIELD_ID),
                        RefField("capital", "Country", "City", CAPITAL_FIELD_ID),
                    ),
                    editorCells = listOf(
                        textCell("country", COUNTRY_COUNTRY_CELL_ID),
                        fieldCell("name", "Country", COUNTRY_NAME_FIELD_ID),
                        textCell("with capital:", WITH_CAPITAL_CELL_ID),
                        fieldCell("capital", "Country", CAPITAL_FIELD_ID),
                    ),
                ),
                concept(
                    "City",
                    fields = listOf(
                        SpecialField("name", "City", CITY_NAME_FIELD_ID),
                        RefField("country", "City", "Country", COUNTRY_FIELD_ID),
                    ),
                    editorCells = listOf(
                        textCell("city", CITY_CITY_CELL_ID),
                        fieldCell("name", "City", CITY_NAME_FIELD_ID),
                        spanCell(
                            textCell("(", OPEN_PAREN_CELL_ID),
                            fieldCell("country", "City", COUNTRY_FIELD_ID),
                            textCell(")", CLOSE_PAREN_CELL_ID),
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
        span("country", COUNTRY_COUNTRY_CELL_ID),
        spanStringText(countryName, getCountryId(countryName), originReferenceId = COUNTRY_NAME_FIELD_ID),
        span("with capital:", WITH_CAPITAL_CELL_ID),
        spanReference(capitalName, getCityId(capitalName), CAPITAL_FIELD_ID),
    )

private fun getCountryId(countryName: String): String =
    "idCountry$countryName"

private fun city(cityName: String, countryName: String): Box =
    flexContainer(
        span("city", CITY_CITY_CELL_ID),
        spanStringText(cityName, getCityId(cityName), originReferenceId = CITY_NAME_FIELD_ID),
        spanContainer(
            span("(", OPEN_PAREN_CELL_ID),
            spanReference(countryName, getCountryId(countryName), COUNTRY_FIELD_ID),
            span(")", CLOSE_PAREN_CELL_ID),
        ),
    )

private fun getCityId(cityName: String): String =
    "idCity$cityName"
