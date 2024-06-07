package com.silaeva.server.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.clientserverapplication.ui.theme.Colors
import com.silaeva.server.presentation.ui.PrimaryColorButton
import com.silaeva.server.R
import com.silaeva.server.presentation.ui.theme.Spacing

@Composable
fun ServerScreen() {

    val viewModel = ServerViewModel()

    var port by remember { mutableIntStateOf(8080) }
    val logList: List<String> by viewModel.logList.collectAsState()
    var isLogsShown by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(Spacing.medium)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PrimaryColorButton(
            text = stringResource(id = R.string.config),
            onClick = {  }
        )
        PrimaryColorButton(
            text = stringResource(id = R.string.start),
            onClick = {  }
        )
        PrimaryColorButton(
            text = stringResource(id = R.string.stop),
            onClick = {  }
        )
        PrimaryColorButton(
            text = stringResource(id = R.string.logs),
            onClick = { isLogsShown = !isLogsShown }
        )
        if (isLogsShown) {
            LazyColumn(
                modifier = Modifier
                    .padding(Spacing.small)
                    .border(
                    width = Spacing.default,
                    color = Colors.grey,
                    shape = RoundedCornerShape(Spacing.medium)
                )
            ) {
                items(logList) { item ->
                    Row(
                        modifier = Modifier
                            .padding(Spacing.small)
                            .fillMaxWidth()
                    ) {
                        Text(text = item)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServerScreenPreview() {
    ServerScreen()
}