package com.madura.bankingappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madura.bankingappui.screens.composable.BottomNavigationBar
import com.madura.bankingappui.screens.composable.CardSection
import com.madura.bankingappui.screens.composable.FinanceSection
import com.madura.bankingappui.screens.composable.SetBarColor
import com.madura.bankingappui.screens.composable.WalletSection
import com.madura.bankingappui.ui.theme.BankingAppUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppUiTheme {
                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreen() {
    Scaffold(bottomBar = {
        BottomNavigationBar()

    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            WalletSection()
            CardSection()
            Spacer(modifier = Modifier.height(16.dp))
            FinanceSection()
        }
    }

}



