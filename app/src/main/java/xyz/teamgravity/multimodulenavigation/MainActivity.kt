package xyz.teamgravity.multimodulenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import xyz.teamgravity.feature_a.ScreenA
import xyz.teamgravity.feature_a.ScreenB
import xyz.teamgravity.feature_b.ScreenC
import xyz.teamgravity.multimodulenavigation.ui.theme.MultiModuleNavigationTheme
import xyz.teamgravity.navigation.Graph
import xyz.teamgravity.navigation.Route

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MultiModuleNavigationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    val controller = rememberNavController()

                    NavHost(
                        navController = controller,
                        startDestination = Graph.FeatureA,
                        modifier = Modifier.padding(padding)
                    ) {
                        navigation<Graph.FeatureA>(
                            startDestination = Route.ScreenA
                        ) {
                            composable<Route.ScreenA> {
                                ScreenA(
                                    onNavigate = {
                                        controller.navigate(Route.ScreenB)
                                    }
                                )
                            }
                            composable<Route.ScreenB> {
                                ScreenB(
                                    onNavigate = {
                                        controller.navigate(Route.ScreenC)
                                    }
                                )
                            }
                        }
                        navigation<Graph.FeatureB>(
                            startDestination = Route.ScreenC
                        ) {
                            composable<Route.ScreenC> {
                                ScreenC(
                                    onNavigate = {
                                        controller.navigate(
                                            route = Graph.FeatureA,
                                            builder = {
                                                popUpTo<Graph.FeatureA>(
                                                    popUpToBuilder = {
                                                        inclusive = true
                                                    }
                                                )
                                            }
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}