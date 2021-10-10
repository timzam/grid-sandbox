package gridSandbox.process

import gridSandbox.data.input.SiteTask
import gridSandbox.data.output.SiteOutput
import gridSandbox.getPageResult
import java.io.File

fun processSiteTask(siteTask: SiteTask) {
    val pageOutputs =
        siteTask.pageTasks.map { pageTask -> getPageResult(pageTask) }
    val siteOutput = SiteOutput(pageOutputs)
    writeSiteOutput(siteOutput)
}

private fun writeSiteOutput(siteOutput: SiteOutput) {
    for (pageOutput in siteOutput.pageOutputs) {
        println(pageOutput.htmlText)
        File(pageOutput.outputFileName).writeText(pageOutput.htmlText)
    }
}
