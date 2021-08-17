package com.steve.bottomnavigationcompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.steve.bottomnavigationcompose.ui.theme.*



@ExperimentalFoundationApi
@Composable
fun Home(navController: NavHostController) {
        Box(modifier = Modifier
            .background(DeepBlue)
            .fillMaxHeight()) {
            Column {
                Gretings()
                ChipsSection(chips = listOf("Retrofit", "Paging","WorkManager","Navigation", "Dager-Hilt","Koin"))
                CurrentMedia()


            }
        }
    }




@Composable
fun Gretings(name:String="Stephen Chacha"){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()) {

        Column(verticalArrangement = Arrangement.Center) {

            Text(text = "Good Morning, $name",
                style = MaterialTheme.typography.h5,
                color = Color.White)

            Text(text = "Good Day!",
                style = MaterialTheme.typography.body2,
                color = Color.White)
        }
        Icon(imageVector = Icons.Filled.Search, contentDescription ="Play" ,
            tint = Color.Black,
            modifier = Modifier.size(16.dp))


    }
}

@Composable
fun ChipsSection(chips: List<String>){
    var selectChip by remember {
        mutableStateOf(0)
    }
    LazyRow{
        items (chips.size){
            Box(modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                .clickable {
                    selectChip = it

                }
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (selectChip == it) ButtonBlue
                    else DarkerButtonBlue
                )
                .padding(15.dp)
            )
            {
                Text(text = chips[it],color= TextWhite)
            }

        }
    }

}
@Composable
fun CurrentMedia(color: Color= LightRed){

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 20.dp)) {

        Column {
            Text(text = "Jetpack Compose",
                style = MaterialTheme.typography.h5)

            Text(text = "Let's do it!",
                style = MaterialTheme.typography.h6, color= TextWhite)

        }
        Box(modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(ButtonBlue)
            .padding(10.dp))
        {
            Icon(imageVector = Icons.Filled.Star, contentDescription ="Play" ,
                tint = Color.White,
                modifier = Modifier.size(16.dp))
        }


    }
}




@Preview(showBackground = true)
@Composable
fun PreviewHome(){
    val navController = rememberNavController()
   BottomNavigation {

   }
}

