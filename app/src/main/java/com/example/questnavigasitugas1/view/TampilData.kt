package com.example.questnavigasitugas1.view

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class TampilData(
    val namaLengkap: String = "",
    val jenisKelamin: String = "",
    val umur: String = "",
    val pekerjaan: String = "",
    val status: String = ""
)

class PesertaViewModel : ViewModel() {

    private val _listPeserta = MutableStateFlow(
        listOf(
            TampilData(
                namaLengkap = "Yasmin Dwi",
                jenisKelamin = "Perempuan",
                umur = "40",
                pekerjaan = "Security",
                status = "Aktif"
            ),
            TampilData(
                namaLengkap = "Yusuf Maulana",
                jenisKelamin = "Laki-Laki",
                umur = "30",
                pekerjaan = "Manager",
                status = "Cuti"
            ),
            TampilData(
                namaLengkap = "Sari Mulia",
                jenisKelamin = "Perempuan",
                umur = "25",
                pekerjaan = "Finance",
                status = "Aktif"
            ),
            TampilData(
                namaLengkap = "Putra Ahmad",
                jenisKelamin = "Laki-Laki",
                umur = "27",
                pekerjaan = "Staff IT Support",
                status = "Kontrak"
            ),
            TampilData(
                namaLengkap = "Ayu",
                jenisKelamin = "Perempuan",
                umur = "25",
                pekerjaan = "Finance",
                status = "Aktif"
        ),
        TampilData(
                namaLengkap = "Wildan",
                jenisKelamin = "Laki-Laki",
                umur = "27",
                pekerjaan = "Staff IT Support",
                status = "Kontrak"
        )
        )
    )

    val listPeserta: StateFlow<List<TampilData>> = _listPeserta.asStateFlow()

    fun addPeserta(data: TampilData) {
        _listPeserta.value = _listPeserta.value + data
    }
}