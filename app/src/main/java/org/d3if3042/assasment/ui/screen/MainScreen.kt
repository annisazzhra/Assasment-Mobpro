package org.d3if3042.assasment.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.d3if3042.assasment.model.Laundry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Laundry(laundry: Laundry, onClick: () -> Unit = {}) {
    val showInfo = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = laundry.imageResId),
            contentDescription = "Laundry Icon",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Aplikasi Laundry",
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "Cuci dan setrika pakaian Anda dengan mudah dan cepat!",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Lanjutkan")
        }
        Button(
            onClick = { showInfo.value = !showInfo.value },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = if (showInfo.value) "Sembunyikan Informasi" else "Tentang Aplikasi")
        }
        if (showInfo.value) {
            Text(
                text = "Ini adalah aplikasi laundry yang memudahkan Anda dalam mencuci dan menyetrika pakaian. Dengan fitur-fitur yang canggih dan user-friendly, Anda dapat dengan mudah mengelola layanan laundry Anda.",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
