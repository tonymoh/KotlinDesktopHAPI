import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

/**
 * Could not find any simple Kotlin examples of HL7 code - so adapted some JAVA examples.
 * Hope it helps any one starting off in their HL7 Kotlin adventures.
 */

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {

        // Simple Parser
        Example1()

        // Simple builder and sending a message
        Example2()
    }
}

