package com.example.questnavigasitugas1.view

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class TampilData(
    val namaLengkap: String = "",
    val jenisKelamin: String = "",
    val umur: String = "",
    val jabatan: String = "",
    val status: String = ""
)

}