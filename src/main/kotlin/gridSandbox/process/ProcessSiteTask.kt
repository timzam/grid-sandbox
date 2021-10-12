package gridSandbox.process

import gridSandbox.data.input.BoxTask
import gridSandbox.data.output.SiteOutput
import gridSandbox.getPageResult
import java.io.File

fun processBoxTasks(boxTasks: List<BoxTask>) {
    val pageOutputs =
        boxTasks.map { boxTask ->
            val pageTask = boxTask.toPageTask()
            getPageResult(pageTask)
        }
    val siteOutput = SiteOutput(pageOutputs)
    writeSiteOutput(siteOutput)
}

private fun writeSiteOutput(siteOutput: SiteOutput) {
    for (pageOutput in siteOutput.pageOutputs) {
        println(pageOutput.htmlText)
        File(pageOutput.outputFileName).writeText(pageOutput.htmlText)
    }
}
