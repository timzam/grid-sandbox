package gridSandbox.data.input

import gridSandbox.data.box.Box

data class BoxTask constructor(
    val outputFileName: String,
    val title: String,
    val rootBox: Box,
) {

    fun toPageTask(): PageTask =
        PageTask(outputFileName, title) { body ->
            val block = rootBox.getBlock(1)
            block(body)
        }

}
