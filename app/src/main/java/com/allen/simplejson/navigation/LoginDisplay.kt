package com.allen.simplejson.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
    var pwusername by remember {
        mutableStateOf("")
    }
    val tfcolor = Color.White
    val sf = FontFamily(
        Font(R.font.sfregular, FontWeight.Normal)
    )
    var isDisabled by remember {
        mutableStateOf(false)
    }
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
                if (it.length <= 50)
                    loginusername = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                unfocusedIndicatorColor = tfcolor,
                focusedIndicatorColor = tfcolor,
                unfocusedLabelColor = Color.Gray, focusedLabelColor = tfcolor
            ),
            label = {
                Text(text = "Username")
            },
            maxLines = 1,
            modifier = Modifier
                .padding(start = 16.dp, end = 12.dp)
                .fillMaxWidth(0.7F), singleLine = true
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            "${loginusername.length}/50",
            modifier = Modifier.padding(start = 16.dp),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = pwusername,
            onValueChange = {
                if (it.length <= 50)
                    pwusername = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                unfocusedIndicatorColor = tfcolor,
                focusedIndicatorColor = tfcolor,
                unfocusedLabelColor = Color.Gray, focusedLabelColor = tfcolor
            ),
            label = {
                Text(text = "Password")
            },
            maxLines = 1,
            modifier = Modifier
                .padding(start = 16.dp, end = 12.dp)
                .fillMaxWidth(0.7F), singleLine = true, trailingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Lock,
                    contentDescription = "password",
                    tint = Color.White
                )
            }, visualTransformation = PasswordVisualTransformation()
        )
    }
}