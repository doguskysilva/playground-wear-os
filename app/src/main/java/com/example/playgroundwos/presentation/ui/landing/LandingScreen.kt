package com.example.playgroundwos.presentation.ui.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.ScalingLazyColumnDefaults
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.itemsIndexed
import androidx.wear.compose.material.rememberScalingLazyListState
import com.example.playgroundwos.R
import com.example.playgroundwos.presentation.components.DialogConfirm

@Composable
fun LandingScreen(
    onClickSomething: (String) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    val listState = rememberScalingLazyListState()

    var exerciseSelected by remember {
        mutableStateOf("")
    }
    val list = listOf(
        "Treino de Peito",
        "Treino de Costas",
        "Treino de Pernas",
        "Treino de Ombro",
        "Treino de Braço"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    ) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = listState,
            flingBehavior = ScalingLazyColumnDefaults.snapFlingBehavior(state = listState)
        ) {
            itemsIndexed(list) { index, exercise ->

                val numberOfExercices = (6..10).random()

                Chip(
                    onClick = {
                        exerciseSelected = exercise
                        //showDialog = true
                        onClickSomething(exercise)

                    },
                    enabled = true,
                    label = {
                        Text(
                            text = exercise,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    secondaryLabel = {
                        Text(text = "${numberOfExercices} Exercicios")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_fitness_center_24),
                            contentDescription = "",
                            modifier = Modifier
                                .size(ChipDefaults.IconSize)
                                .wrapContentSize(align = Alignment.Center),
                        )
                    },
                    colors = ChipDefaults.chipColors(backgroundColor = MaterialTheme.colors.surface)
                )
            }
        }

        DialogConfirm(
            showDialog = showDialog,
            onCloseDialog = { showDialog = false },
            exercise = exerciseSelected
        )
    }
}