package com.allen.simplejson.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.allen.simplejson.data.PostValuesData
import com.allen.simplejson.expcard.ExpandablesComment
import com.allen.simplejson.viewmodel.MainViewModels

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun MainDisplay(navcon: NavHostController, vm: MainViewModels) {
    val typho = MaterialTheme.typography
    val choices = BooleanArray(2)
    val res = produceState<List<PostValuesData>>(initialValue = emptyList(), producer = {
        this.value = vm.tester()
    })
    var sizestate by remember {
        mutableStateOf(120.dp)
    }
    sizestate += 50.dp
    val sizegrows by animateDpAsState(targetValue = sizestate, spring())
    choices[0] = true
    var select1 by remember {
        mutableStateOf(choices[0])
    }
    var select2 by remember {
        mutableStateOf(choices[1])
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Pilih apa yang\n")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Ingin kamu pelajari hari ini ?")
                    }
                },
                style = typho.h3,
                modifier = Modifier.padding(start = 12.dp, top = 24.dp), fontSize = 28.sp,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.TopStart)
                    .padding(start = 20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(45.dp)
                        .width(sizegrows)
                        .clip(
                            RoundedCornerShape(
                                topStart = 34.dp,
                                topEnd = 34.dp,
                                bottomStart = 34.dp,
                                bottomEnd = 34.dp
                            )
                        )
                        .background(
                            color = when (select1) {
                                true -> {
                                    sizestate = 130.dp
                                    Color.Black
                                }
                                false -> {
                                    Color.Gray
                                }
                            }
                        )
                        .clickable {
                            select1 = true
                            select2 = false
                        }, contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Brainstorming",
                        fontSize = 14.sp,
                        color = when (select1) {
                            true -> {
                                Color.White
                            }
                            false -> Color.Black
                        },
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .height(45.dp)
                        .width(120.dp)
                        .padding(start = 12.dp)
                        .clickable {
                            select2 = true
                            select1 = false
                        }
                        .clip(
                            RoundedCornerShape(
                                topStart = 34.dp,
                                topEnd = 34.dp,
                                bottomStart = 34.dp,
                                bottomEnd = 34.dp
                            )
                        )
                        .background(
                            color = when (select2) {
                                true -> {
                                    sizestate = 120.dp
                                    sizestate -= 50.dp
                                    Color.Black
                                }
                                false -> {
                                    Color.Gray
                                }
                            }
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Reading Books",
                        fontSize = 14.sp,
                        color = when (select2) {
                            true -> {
                                Color.White
                            }
                            false -> {
                                Color.Black
                            }
                        },
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            LazyColumn(modifier = Modifier.padding(bottom = 8.dp)) {
                items(items = res.value) { get ->
                    ExpandablesComment(title = get.title, desc = get.body)
                }
            }
        }
    }
}