package com.silaeva.client.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silaeva.client.R
import com.silaeva.client.presentation.ui.InputTextField
import com.silaeva.client.presentation.ui.PrimaryColorButton
import com.silaeva.clientserverapplication.ui.theme.ClientServerApplicationTheme
import com.silaeva.clientserverapplication.ui.theme.Spacing

@Composable
fun ClientScreen() {

    val viewModel = ClientViewModel()

    var ip by remember { mutableStateOf("") }
    var port by remember { mutableStateOf("") }
    var isRunning by remember { mutableStateOf(false) }

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val elementWidth = with(LocalDensity.current) {
        ((screenWidth.dp - (Spacing.medium * 4)) / 2)
    }

    Column(
        modifier = Modifier
            .padding(Spacing.medium)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConfigSection(
            buttonWidth = elementWidth,
            ip = ip,
            port = port,
            onConfigChange = { newIP, newPort ->
                ip = newIP
                port = newPort
            }
        )
        Spacer(
            modifier = Modifier
                .padding(vertical = Spacing.small)
        )
        PrimaryColorButton(
            modifier = Modifier.fillMaxWidth(),
            text = if (isRunning) stringResource(id = R.string.pause) else stringResource(id = R.string.start),
            onClick = { isRunning = !isRunning }
        )
    }
}

@Composable
fun ConfigSection(
    buttonWidth: Dp,
    ip: String,
    port: String,
    onConfigChange: (String, String) -> Unit
) {
    var newIp by remember { mutableStateOf(ip) }
    var newPort by remember { mutableStateOf(port) }
    var isEditing by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputTextField(
            text = newIp,
            title = stringResource(id = R.string.ip),
            hint = stringResource(id = R.string.hint_ip),
            isError = false,
            onTextChange = { newIp = it }
        )
        Spacer(
            modifier = Modifier
                .padding(vertical = Spacing.small)
        )
        InputTextField(
            text = newPort,
            title = stringResource(id = R.string.port),
            hint = stringResource(id = R.string.hint_port),
            isError = false,
            onTextChange = { newPort = it}
        )
        Spacer(
            modifier = Modifier
                .padding(vertical = Spacing.small)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PrimaryColorButton(
                modifier = Modifier.width(buttonWidth),
                text = stringResource(id = R.string.save),
                onClick = {
                    onConfigChange(newIp, newPort)
                    isEditing = false
                }
            )
            PrimaryColorButton(
                modifier = Modifier.width(buttonWidth),
                text = if (isEditing) {
                    stringResource(id = R.string.cancel)
                } else {
                    stringResource(id = R.string.edit)
                },
                onClick = {
                    isEditing = !isEditing
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClientScreenPreview() {
    ClientServerApplicationTheme{
        ClientScreen()
    }
}