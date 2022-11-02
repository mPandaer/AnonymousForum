package space.pandaer.anonymousforum.front.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import space.pandaer.anonymousforum.R

sealed interface FrontEvent {
    object Me : FrontEvent //跳转到个人中心的事件
    object Detail : FrontEvent //进入文章详情页面
    object New : FrontEvent //创建文章页面
}


@Composable
fun FrontScreen(onEvent: (FrontEvent) -> Unit = {}) {
    Scaffold(
        topBar = {
            FrontTopBar {
                onEvent(FrontEvent.Me)
            }
        },

        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, contentColor = MaterialTheme.colors.primary) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.edit),
                    contentDescription = "new article",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }
        },
        content = {
            Column(
                Modifier
                    .padding(top = it.calculateTopPadding())
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                ArticleItem()

            }
        }
    )
}

@Composable
fun Avatar(@DrawableRes resId: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,
        modifier = modifier,

        )
}

@Preview
@Composable
fun FrontPrev() {
    FrontScreen()
}
