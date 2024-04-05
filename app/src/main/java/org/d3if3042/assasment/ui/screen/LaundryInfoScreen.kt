package org.d3if3042.assasment.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.time.format.DateTimeFormatter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import org.d3if3042.assasment.model.LaundryInfo


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaundryInfoScreen(onSave: (LaundryInfo) -> Unit) {
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nama") }
        )
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") }
        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") },
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Date")
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = selectedDate.format(DateTimeFormatter.ISO_DATE),
                onValueChange = {},
                label = { },
                enabled = false
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = {}, modifier = Modifier.align(Alignment.CenterVertically)) {
                Text("Select")
            }
        }
        Button(
            onClick = {
                val formattedDate = selectedDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                val laundryInfo = LaundryInfo(name, address, phoneNumber, formattedDate)
                onSave(laundryInfo)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Simpan")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun LaundryInfoScreenPreview() {
    LaundryInfoScreen(onSave = {})
}