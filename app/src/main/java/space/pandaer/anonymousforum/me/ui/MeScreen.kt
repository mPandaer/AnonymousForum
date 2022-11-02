package space.pandaer.anonymousforum.me.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import space.pandaer.anonymousforum.R
import space.pandaer.anonymousforum.front.ui.Avatar

@Composable
fun MeScreen() {
    Scaffold {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it.calculateTopPadding())) {
                UserInfo()
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