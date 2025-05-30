package com.codentmind.gemlens.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.codentmind.gemlens.R
import com.codentmind.gemlens.presentation.navigation.SetApi
import com.codentmind.gemlens.presentation.navigation.TopBar
import com.codentmind.gemlens.presentation.theme.DecentBlue
import com.codentmind.gemlens.utils.AnalyticsHelper.logButtonClick
import com.codentmind.gemlens.utils.AnalyticsHelper.logScreenView
import com.codentmind.gemlens.utils.Constant.Analytics.Companion.SCREEN_SETTINGS


@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen(navController: NavHostController) {

    LaunchedEffect(Unit) {
        logScreenView(SCREEN_SETTINGS)
    }

    Scaffold(
        topBar = {
            TopBar(
                name = stringResource(id = R.string.settings),
                navController = navController
            )
        }
    ) {
        Column(
            Modifier
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.background)
                .padding(top = it.calculateTopPadding() * 2)
        ) {
            Button(
                onClick = {
                    logButtonClick("Change Api Key")
                    navController.navigate(SetApi.route)
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DecentBlue,
                    contentColor = Color.White
                )
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Change Api Key",
                    fontSize = 15.sp
                )
            }
        }
    }
}