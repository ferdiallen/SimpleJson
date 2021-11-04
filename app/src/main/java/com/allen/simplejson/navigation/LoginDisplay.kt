package com.allen.simplejson.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.allen.simplejson.R

@Composable
fun LoginDisplay(navcon: NavHostController) {
    val typho = MaterialTheme.typography
    var loginusername by remember {
        mutableStateOf("")
    }
    val tfcolor = Color.White
    val sf = FontFamily(
        Font(R.font.sfregular, FontWeight.Normal)
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Halo!",
            style = typho.h4,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 8.dp, start = 12.dp, end = 12.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(R.string.greetings),
            Modifier.padding(start = 16.dp, end = 16.dp),
            color = Color.White,
            fontFamily = sf,
            fontSize = 34.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = loginusername,
            onValueChange = {
                loginusername = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                unfocusedIndicatorColor = tfcolor,
                focusedIndicatorColor = tfcolor,
                unfocusedLabelColor = Color.Black, focusedLabelColor = tfcolor
            ), label = {
                Text(text = "Username")
            }, maxLines = 1, modifier = Modifier.padding(start = 16.dp)
        )
    }
}