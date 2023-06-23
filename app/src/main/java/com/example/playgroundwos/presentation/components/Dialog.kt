package com.example.playgroundwos.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.dialog.Alert
import androidx.wear.compose.material.dialog.Dialog
import androidx.wear.compose.material.rememberScalingLazyListState
import com.example.playgroundwos.R

@Composable
fun DialogConfirm(
    showDialog: Boolean,
    onCloseDialog: () -> Unit,
    exercise: String
) {
    val scrollState = rememberScalingLazyListState()

    Dialog(
        onDismissRequest = { onCloseDialog() },
        scrollState = scrollState,
        showDialog = showDialog
    ) {
        Alert(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_fitness_center_24),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp)
                        .wrapContentSize(align = Alignment.Center)
                )
            },
            title = { Text(text = "Iniciar ${exercise}?", textAlign = TextAlign.Center) },
            negativeButton = {
                Button(onClick = { onCloseDialog() }, colors = ButtonDefaults.buttonColors(
                    MaterialTheme.colors.surface)) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_clear_24),
                        contentDescription = ""
                    )
                }
            },
            positiveButton = {
                Button(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_done_24),
                        contentDescription = ""
                    )
                }
            },
        )
    }
}