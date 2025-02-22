package xyz.teamgravity.feature_b

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun ScreenC(
    onNavigate: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 10.dp,
            alignment = Alignment.CenterVertically
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(
                id = R.string.feature_b_screen_c
            )
        )
        Button(
            onClick = onNavigate
        ) {
            Text(
                text = stringResource(
                    id = R.string.navigate
                )
            )
        }
    }
}