package gridSandbox

import gridSandbox.data.input.PageTask
import java.io.File

internal fun processPageTask(pageTask: PageTask) {
    val pageOutput = getPageResult(pageTask)
    println(pageOutput.htmlText)
    File(pageTask.outputFileName).writeText(pageOutput.htmlText)
}
