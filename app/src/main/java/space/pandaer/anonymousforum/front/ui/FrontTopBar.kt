package space.pandaer.anonymousforum.front.ui

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import space.pandaer.anonymousforum.R

@Composable
fun FrontTopBar(onClick: () -> Unit = {}) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 8.dp).padding(top = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 2.dp,
        color = MaterialTheme.colors.background
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = "DashBoard",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "2022-10-11",
                    style = MaterialTheme.typography.body1,
                    color = Color.Gray,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            Avatar(
                resId = R.drawable.image, modifier = Modifier
                    .clip(CircleShape)
                    .clickable { onClick() }
                    .size(48.dp)
            )
            Spacer(modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TopBarPrev() {
    FrontTopBar()
}