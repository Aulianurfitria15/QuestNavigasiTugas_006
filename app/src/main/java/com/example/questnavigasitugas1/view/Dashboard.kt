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
import androidx.compose.ui.text.font.FontWeight
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
            Text(
                text = "Selamat Datang",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.aul),
                contentDescription = "Logo Employee",
                modifier = Modifier
                    .size(200.dp)
                    .padding(vertical = 12.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                "Aulia Nurfitria Dewi",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black)

            Text(
                "20230140006",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
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
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(24.dp)
                )

