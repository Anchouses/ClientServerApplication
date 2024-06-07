package com.silaeva.server.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.silaeva.clientserverapplication.ui.theme.Colors
import com.silaeva.server.presentation.ui.theme.Spacing
import com.silaeva.server.R


@Composable
fun PrimaryColorButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(Spacing.small)
            .fillMaxWidth()
            .height(Spacing.large),
        shape = RoundedCornerShape(Spacing.medium),
        colors = ButtonDefaults.buttonColors(
            contentColor = Colors.onPrimary,
            containerColor = Colors.onPrimary
        )
    ) {
        Text(
            text = text,
            color = Colors.white,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryColorButtonPreview() {
    PrimaryColorButton(
        text = stringResource(id = R.string.config),
        onClick = {}
    )
}