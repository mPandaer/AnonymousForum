package space.pandaer.anonymousforum.front.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import space.pandaer.anonymousforum.R

@Composable
fun ArticleItem(onClick : () -> Unit = {}) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(horizontal = 8.dp).clickable { onClick() }, shape = RoundedCornerShape(16.dp), elevation = 2.dp, color = MaterialTheme.colors.secondary) {
        Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Title(text = "Pandaer杂货铺", modifier = Modifier.padding(bottom = 2.dp))
            Content(text = "认识一下，我是爱吃糖的pandaer", modifier = Modifier.padding(2.dp))
            DateAndAvatar(date = "2022-11-02",R.drawable.image)
        }
    }
}

@Composable
fun DateAndAvatar(date:String,@DrawableRes resId:Int,modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth().padding(bottom = 2.dp), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
        Text(text = date, modifier = modifier.padding(end = 8.dp))
        Avatar(resId = resId, modifier = modifier
            .size(24.dp)
            .clip(CircleShape))
        Spacer(modifier = modifier.padding(end = 8.dp))
    }
}

@Composable
fun Content(text:String,modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.caption,
        fontWeight = FontWeight.Light,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}

@Composable
fun Title(text:String,modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Preview(showSystemUi = true)
@Composable
fun ItemPrev() {
    ArticleItem()
}
