package com.silaeva.server.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ServerViewModel: ViewModel() {

    private val _logList = MutableStateFlow(getLogList())
    val logList = _logList.asStateFlow()

    private fun getLogList(): List<String> {
        return listOf("fdgdfds", "vsfdsdgfsa", "gsdfsdfas")
    }
}