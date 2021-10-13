package gridSandbox

import gridSandbox.data.input.PageTask
import gridSandbox.data.output.PageOutput
import kotlinx.html.body
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.serialize
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.lang
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script
import kotlinx.html.title

fun getPageResult(pageTask: PageTask): PageOutput {
    val document =
        createHTMLDocument().html {
            lang = "en"
            head {
                meta("viewport", "width=device-width, initial-scale=1")
                title(pageTask.title)
                /*
                link("https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css", "stylesheet") {
                    integrity =
                        "sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
                    attributes["crossorigin"] = "anonymous"
                    attributes["referrerpolicy"] = "no-referrer"
                }
                */
                link("assets/css/grid-sandbox.css", "stylesheet")
                script("text/javascript", "assets/js/grid-sandbox.js") {}
            }
            body {
                pageTask.textSupplier(this)
            }
        }
    val htmlText = document.serialize()
    return PageOutput(pageTask.outputFileName, htmlText)
}
