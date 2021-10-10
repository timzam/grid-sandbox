package gridSandbox

import gridSandbox.data.input.PageTask
import gridSandbox.data.output.PageOutput
import kotlinx.html.body
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.lang
import kotlinx.html.title

fun getPageResult(pageTask: PageTask): PageOutput {
    val (title, bodyText) = pageTask.page
    val document =
        createHTMLDocument().html {
            lang = "en"
            head {
                title(title)
            }
            body {
                +bodyText
            }
        }
    val htmlText = document.serialize()
    return PageOutput(pageTask.outputFileName, htmlText)
}
