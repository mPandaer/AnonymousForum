package space.pandaer.anonymousforum.front.ui

import androidx.compose.runtime.*

class EditTextState() {
    private var _text by mutableStateOf("")
    val text : String
    get() = _text
    fun onTextChange(newText:String) {
        _text = newText
    }
}

@Composable
fun rememberEditTextState() = remember {
    EditTextState()
}