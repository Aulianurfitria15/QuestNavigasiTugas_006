package com.example.questnavigasitugas1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    listPeserta: List<TampilData>,
    onNavigateToForm: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    ListScreen(
        listPeserta = listPeserta,
        onNavigateToForm = onNavigateToForm,
        onNavigateToHome = onNavigateToHome
    )
}

@Composable
fun WelcomeScreen(onMasukClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fbg),
            contentDescription = "Background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Selamat Datang",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )


            Image(
                painter = painterResource(id = R.drawable.aul),
                contentDescription = "Foto Profil",
                modifier = Modifier
                    .size(200.dp)
                    .padding(vertical = 12.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                "Aulia Nurfitria Dewi",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 25.sp,
                color = Color.Black)

            Text(
                "20230140006",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 36.dp))

            Button(
                onClick = onMasukClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = CircleShape,
                modifier = Modifier
                    .width(180.dp)
                    .height(48.dp)
            ) {
                Text(
                    "Masuk",
                    fontSize = 15.sp,
                    color = Color.White,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Medium)

            }
        }
    }
}

@Composable
fun ListScreen(
    listPeserta: List<TampilData>,
    onNavigateToForm: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fbg),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Scaffold(
            containerColor = Color.Transparent,
            bottomBar = {
                BottomNavigationBar(
                    currentScreen = "list",
                    onNavigateToHome = onNavigateToHome,
                    onNavigateToForm = onNavigateToForm
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(
                    text = "Data Karyawan",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    textAlign = TextAlign.Center
                )


                if (listPeserta.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            "Belum ada data yang tersimpan",
                            color = Color.Gray,
                            fontSize = 14.sp
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(listPeserta) { peserta ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Black.copy(alpha = 0.4f)
                                ),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 2.dp)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text("Nama: ${peserta.namaLengkap}", color = Color.White)
                                    Text("Jenis Kelamin: ${peserta.jenisKelamin}", color = Color.White)
                                    Text("Umur: ${peserta.umur}", color = Color.White)
                                    Text("Pekerjaan: ${peserta.pekerjaan}", color = Color.White)
                                    Text("Status: ${peserta.status}", color = Color.White)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun BottomNavigationBar(
    currentScreen: String,
    onNavigateToHome: () -> Unit,
    onNavigateToForm: () -> Unit
) {
    NavigationBar(containerColor = Color.DarkGray) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Beranda",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    "Beranda",
                    fontSize = 10.sp,
                    color = Color.White
                )
            },
            selected = currentScreen == "list",
            onClick = onNavigateToHome,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White.copy(alpha = 0.3f)
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Description,
                    contentDescription = "Formulir",
                    tint = Color.White
                )
            },
            label = {
                Text(
                    "Formulir",
                    fontSize = 10.sp,
                    color = Color.White
                )
            },
            selected = currentScreen == "form",
            onClick = onNavigateToForm,
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White.copy(alpha = 0.3f)
            )
        )
    }
}
