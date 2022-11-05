package space.pandaer.anonymousforum.front.ui

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import space.pandaer.anonymousforum.R

@Composable
fun ArticleItem(onClick: () -> Unit = {}) {
    Column(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        ItemAvatar(R.drawable.image, userName = "pandaer", time = "2022-11-5")
        Spacer(modifier = Modifier.height(8.dp))
        TextContent("你好呀，我是爱吃糖的pandaer")
        ExpandButton(onClick = onClick)
        Spacer(modifier = Modifier.height(4.dp))
        BottomFuncBar(0, 2, 3)
    }
}

@Composable
fun ItemAvatar(
    resId: Int = R.drawable.image,
    userName: String,
    time: String,
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = resId),
            contentDescription = "user avatar",
            Modifier
                .size(48.dp)
                .clip(
                    CircleShape
                )
        )
        Column(modifier = Modifier.padding(start = 8.dp), horizontalAlignment = Alignment.Start) {
            Text(
                text = userName,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                color = Color.Black
            )
            Text(text = time, fontWeight = FontWeight.Light, color = Color.Gray)
        }
    }
}

@Composable
fun TextContent(content: String) {
    Text(
        text = content,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Black,
        maxLines = 5,
        softWrap = true,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun ExpandButton(onClick: () -> Unit = {}) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onClick() }) {
        Text(text = "查看全文", color = Color(0xFF4169E1), fontWeight = FontWeight.SemiBold)
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "查看全文",
            tint = Color(0xFF4169E1)
        )
    }

}

@Composable
fun BottomFuncBar(likeNum: Int, commentNum: Int, starNum: Int) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        BarItem(imageVector = Icons.Default.FavoriteBorder, num = likeNum)
        BarItem(imageVector = ImageVector.vectorResource(id = R.drawable.commont), num = commentNum)
        BarItem(imageVector = ImageVector.vectorResource(id = R.drawable.star), num = starNum)
    }


}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BarItem(imageVector: ImageVector, num: Int) {
    AnimatedContent(targetState = num) {
        val iconColor = if (num > 0) Color(0xFFFFA500) else Color.LightGray
        val textColor = if (num > 0) Color(0xFFFFA500) else Color.LightGray
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = imageVector,
                contentDescription = "icon",
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "$num",
                color = textColor,
                modifier = Modifier.padding(start = 4.dp),
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ItemPrev() {
    ArticleItem()
}
