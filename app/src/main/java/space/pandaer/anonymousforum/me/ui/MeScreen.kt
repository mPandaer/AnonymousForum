package space.pandaer.anonymousforum.me.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import space.pandaer.anonymousforum.R
import space.pandaer.anonymousforum.front.ui.Avatar

@Composable
fun MeScreen() {
    Card(
        Modifier
            .fillMaxSize()
            .padding(vertical = 64.dp)
            .padding(horizontal = 48.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(32.dp),
        border = BorderStroke(4.dp, MaterialTheme.colors.primary),
        backgroundColor = MaterialTheme.colors.onPrimary
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                Card(shape = CircleShape,border = BorderStroke(4.dp, MaterialTheme.colors.primary)) {
                    Avatar(resId = R.drawable.image, Modifier.size(64.dp))
                }
                Text(text = "Pandaer", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 6.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            ArticleInfo()
        }
    }
}

@Composable
fun ArticleInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
    ) {
        Text(text = "跟踪的文章", modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "我的文章", modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun UserInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Avatar(
            resId = R.drawable.ic_launcher_foreground, modifier = Modifier
                .size(48.dp)
                .padding(bottom = 8.dp)
        )
        Text(text = "Pandaer", style = MaterialTheme.typography.body1)
    }
}


@Preview(showSystemUi = true)
@Composable
fun MePrev() {
    MeScreen()
}