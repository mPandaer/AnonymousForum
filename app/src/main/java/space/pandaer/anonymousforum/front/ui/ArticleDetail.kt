package space.pandaer.anonymousforum.front.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import space.pandaer.anonymousforum.R

@Composable
fun ArticleDetail() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .padding(top = 4.dp)
    ) {
        DetailTitle()
        DetailUserInfo()
        DetailContent()
        DetailBar()
    }
}

@Composable
fun DetailBar() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(end = 8.dp), horizontalArrangement = Arrangement.End
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Card(
                Modifier.padding(end = 8.dp),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.background
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.commont),
                    contentDescription = "commont",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }

            Card(
                Modifier.padding(end = 8.dp),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.background
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = "like",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }

            Card(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.background
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "star",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }

        }
    }
}

@Composable
fun DetailContent() {
    Text(text = "今天我又吃了一颗糖", fontWeight = FontWeight.Light, fontSize = 12.sp)
}

@Composable
fun DetailUserInfo() {
    Card(
        Modifier
            .padding(bottom = 16.dp), shape = RoundedCornerShape(36.dp),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Avatar(
                resId = R.drawable.image, modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "2022-11-2", fontWeight = FontWeight.Light, color = Color.Gray)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun DetailTitle() {
    Text(
        text = "Pandaer的日常",
        fontSize = 40.sp,
        color = MaterialTheme.colors.secondary,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )
}

@Preview
@Composable
fun DetailPrev() {
    ArticleDetail()
}
