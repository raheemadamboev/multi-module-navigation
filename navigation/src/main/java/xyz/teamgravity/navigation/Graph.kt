package xyz.teamgravity.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Graph {

    @Serializable
    data object FeatureA : Graph

    @Serializable
    data object FeatureB : Graph
}
