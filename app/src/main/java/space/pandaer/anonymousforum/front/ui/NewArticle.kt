package space.pandaer.anonymousforum.front.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


sealed interface NewArticle {
    object CancelEvent : NewArticle
    class ConfirmEvent(val content:String) : NewArticle
}


@Composable
fun NewArticle(onEvent: (NewArticle) -> Unit = {}) {
    Surface(modifier = Modifier.fillMaxSize(), elevation = 4.dp) {
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {
            val editTextState = rememberEditTextState()
            TopEditBar(
                onCancel = { onEvent(NewArticle.CancelEvent) },
                onConfirm = { onEvent(NewArticle.ConfirmEvent(editTextState.text)) })
            EditPage(editTextState)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TopEditBar(onCancel: () -> Unit = {}, onConfirm: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "取消",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.button,
            modifier = Modifier.clickable { onCancel() })
        Text(
            text = "吐槽一下",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "确定",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.button,
            modifier = Modifier.clickable { onConfirm() })
    }
}

@Composable
fun EditPage(state: EditTextState) {
    Box(
        modifier = Modifier.border(
            border = BorderStroke(2.dp, MaterialTheme.colors.primary),
            shape = RoundedCornerShape(8.dp)
        )
    ) {
        TextField(
            value = state.text,
            onValueChange = state::onTextChange,
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = MaterialTheme.colors.background
            ),
            placeholder = {
                Text(text = "吐槽一下...")
            }
        )
    }

}

@Preview
@Composable
fun EditPrev() {
    NewArticle()
}