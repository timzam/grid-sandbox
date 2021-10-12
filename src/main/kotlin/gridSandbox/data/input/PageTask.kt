package gridSandbox.data.input

import kotlinx.html.BODY

data class PageTask internal constructor(
    val outputFileName: String,
    val title: String,
    val textSupplier: (BODY) -> Unit,
)
