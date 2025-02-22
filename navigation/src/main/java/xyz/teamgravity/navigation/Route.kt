package xyz.teamgravity.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Route(
    val graph: Graph
) {

    @Serializable
    data object ScreenA : Route(Graph.FeatureA)

    @Serializable
    data object ScreenB : Route(Graph.FeatureA)

    @Serializable
    data object ScreenC : Route(Graph.FeatureB)
}