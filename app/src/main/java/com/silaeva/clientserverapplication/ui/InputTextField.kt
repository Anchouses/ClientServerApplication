package com.silaeva.clientserverapplication.ui.common_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.clientserverapplication.R
import com.silaeva.clientserverapplication.ui.theme.Colors
import com.silaeva.clientserverapplication.ui.theme.Spacing


@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    text: String,
    title: String,
    hint: String,
    isError: Boolean,
    onTextChange: (String) -> Unit
) {
    var text by remember { mutableStateOf(text) }
    var expanded by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(isError) }

    Column {
        Text(
            text = title,
            color = Colors.black,
            modifier = Modifier
                .padding(bottom = Spacing.medium)
        )
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                onTextChange(text)
                error = newText.isBlank()
            },
            modifier = modifier
                .onFocusChanged { focusState ->
                    expanded = focusState.isFocused
                }
                .fillMaxWidth()
                .height(Spacing.extraLarge),
            placeholder = {
                Text(
                    text = hint,
                    color = Colors.grey
                )
            },
            isError = error,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            singleLine = true,
            shape = RoundedCornerShape(Spacing.medium),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Colors.white,
                unfocusedContainerColor = Colors.white,
                errorContainerColor = Colors.white,
                focusedTextColor = Colors.black,
                unfocusedTextColor = Colors.black,
                focusedPlaceholderColor = Colors.grey,
                unfocusedPlaceholderColor = Colors.grey,
                errorPlaceholderColor = Colors.onPrimary,
                focusedBorderColor = Colors.black,
                unfocusedBorderColor = Colors.grey,
                errorBorderColor = Colors.onPrimary,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputTextFieldPreview() {
    InputTextField(
        text = "",
        title = stringResource(id = R.string.ip),
        hint = stringResource(id = R.string.hint_ip),
        isError = true,
        onTextChange = {}
    )
}