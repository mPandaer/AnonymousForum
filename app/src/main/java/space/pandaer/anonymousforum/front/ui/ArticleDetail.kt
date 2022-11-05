package space.pandaer.anonymousforum.front.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import space.pandaer.anonymousforum.R


sealed interface ArticleDetail {
    object BackEvent : ArticleDetail
}

@Composable
fun ArticleDetail(onEvent: (ArticleDetail) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        DetailTopBar { onEvent(ArticleDetail.BackEvent) }
        Spacer(modifier = Modifier.height(8.dp))
        MainContent(content = "你好呀，我是特别特别特别爱吃糖的pandaer", modifier = Modifier.weight(1f))
        DetailBottomBar()
        var text by remember {
            mutableStateOf("")
        }
        EditComment(value = text, { text = it }, {/*评论*/ })
        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
fun DetailTopBar(onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(Modifier.weight(1f), horizontalArrangement = Arrangement.Start) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back",
                modifier = Modifier
                    .clickable { onClick() }
            )
        }

        Text(text = "详情", fontSize = 18.sp)
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier, content: String = "") {
    Column(modifier.fillMaxWidth()) {
        ItemAvatar(userName = "padnaer", time = "2022-11-5")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = content)
    }
}

@Composable
fun DetailBottomBar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BottomBarItem(Icons.Default.Favorite, "喜欢", false)
        BottomBarItem(ImageVector.vectorResource(id = R.drawable.commont), "评论", false)
        BottomBarItem(ImageVector.vectorResource(id = R.drawable.star), "收藏", false)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomBarItem(imageVector: ImageVector, des: String, isClick: Boolean) {
    AnimatedContent(targetState = isClick) {
        val color = if (isClick) Color(0xFFFF7F50) else Color(0xFFF5F5F5)
        Surface(
            Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .width(65.dp)
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(32.dp),
            color = color
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Icon(
                    imageVector = imageVector,
                    contentDescription = "icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFFDCDCDC)
                )
                Text(text = des, color = Color(0xFFDCDCDC))
            }

        }
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun EditComment(value: String, onTextChange: (String) -> Unit, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Surface(
            color = Color(0xFFF5F5F5), modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f), shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "edit",
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFFDCDCDC)
                )
                Text(text = "写写你的想法...", color = Color(0xFFDCDCDC))
            }
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailPrev() {
    ArticleDetail()
}
