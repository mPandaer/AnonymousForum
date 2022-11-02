package space.pandaer.anonymousforum.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import space.pandaer.anonymousforum.front.ui.FrontEvent
import space.pandaer.anonymousforum.front.ui.FrontScreen
import space.pandaer.anonymousforum.me.ui.MeScreen

@Composable
fun NavigationTo() {
    val controller = rememberNavController()
    NavHost(navController = controller, startDestination = "front"){
        composable("front"){
            FrontScreen{
                when(it) {
                    FrontEvent.Me -> controller.navigate("me")
                    FrontEvent.Detail -> {}
                    FrontEvent.New -> {}
                }
            }
        }

        composable("me"){
            MeScreen()
        }
    }
}