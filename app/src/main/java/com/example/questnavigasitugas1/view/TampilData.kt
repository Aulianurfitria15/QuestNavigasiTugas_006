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

class PesertaViewModel : ViewModel() {

    private val _listPeserta = MutableStateFlow(
        listOf(
            TampilData(
                namaLengkap = "Gita Anggraini",
                jenisKelamin = "Perempuan",
                umur = "40",
                jabatan = "Security",
                status = "Aktif"
            ),
            TampilData(
                namaLengkap = "Farhan Yusuf",
                jenisKelamin = "Laki-Laki",
                umur = "30",
                jabatan = "Manager",
                status = "Cuti"
            ),
            TampilData(
                namaLengkap = "Citra Lestari",
                jenisKelamin = "Perempuan",
                umur = "25",
                jabatan = "Finance",
                status = "Aktif"
            ),
            TampilData(
                namaLengkap = "Hari Wijaya",
                jenisKelamin = "Laki-Laki",
                umur = "27",
                jabatan = "Staff IT Support",
                status = "Kontrak"
            ),
            TampilData(
                namaLengkap = "Ayu",
                jenisKelamin = "Perempuan",
                umur = "25",
                jabatan = "Finance",
                status = "Aktif"
        ),
        TampilData(
                namaLengkap = "Wildan",
                jenisKelamin = "Laki-Laki",
                umur = "27",
                jabatan = "Staff IT Support",
                status = "Kontrak"
        )
        )
    )

    val listPeserta: StateFlow<List<TampilData>> = _listPeserta.asStateFlow()

    fun addPeserta(data: TampilData) {
        _listPeserta.value = _listPeserta.value + data
    }
}