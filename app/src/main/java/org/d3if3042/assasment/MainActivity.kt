package org.d3if3042.assasment

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import org.d3if3042.assasment.model.Laundry
import org.d3if3042.assasment.ui.screen.LaundryInfoScreen
import org.d3if3042.assasment.ui.theme.AssasmentTheme

class MainActivity : ComponentActivity() {

    private val data = getData()
    private var index = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssasmentTheme {
                val showLaundryInfoScreen = remember { mutableStateOf(false) }
                val showAboutScreen = remember { mutableStateOf(false) }

                if (showLaundryInfoScreen.value) {
                    LaundryInfoScreen { info ->
                        index = if (index == data.size - 1) 0 else index + 1
                        showLaundryInfoScreen.value = false
                    }
                } else if (showAboutScreen.value) {
                    AboutScreen {
                        showAboutScreen.value = false
                    }
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        GetStartedButton {
                            showLaundryInfoScreen.value = true
                        }

                        AboutButton {
                            showAboutScreen.value = true
                        }
                    }
                }
            }
        }
    }

    private fun getData(): List<Laundry> {
        return listOf(
            Laundry("Laundry", R.drawable.ic_laundry)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetStartedButton(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_laundry),
            contentDescription = "Laundry Icon"
        )
        Text(
            text = "Laundryku",
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Get Started")
        }
    }
}

@Composable
fun AboutButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "About")
    }
}

@Composable
fun AboutScreen(onBackClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "About Screen")
        Button(onClick = { onBackClick() }) {
            Text(text = "Back")
        }
    }
}