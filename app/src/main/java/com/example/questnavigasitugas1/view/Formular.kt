package com.example.questnavigasitugas1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.questnavigasitugas1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirScreen(
    onSubmit: (TampilData) -> Unit,
    onKembali: () -> Unit
) {
    var namaLengkap by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var umur by remember { mutableStateOf("") }
    var jabatan by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var showPopup by remember { mutableStateOf(false) }
    var expandedStatus by remember { mutableStateOf(false) }

    val statusOptions = listOf("Aktif", "Non Akitf")

    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    Image(
        painter = painterResource(id = R.drawable.fbg),
        contentDescription = "Background",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Formulir Data Karyawan",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
            )

            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White),
                elevation = CardDefaults.cardElevation(
                    4.dp),
                modifier = Modifier.
                fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    if (showError) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFFE6E6)),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(12.dp)
                            ) {
                                Spacer(modifier = Modifier
                                    .width(8.dp))
                                Text(
                                    text = "Data tidak boleh kosong",
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    }