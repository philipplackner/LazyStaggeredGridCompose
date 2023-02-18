package com.plcoding.lazystaggeredgridcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.plcoding.lazystaggeredgridcompose.ui.theme.LazyStaggeredGridComposeTheme
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = (1..100).map { 
            ListItem(
                height = Random.nextInt(100, 300).dp,
                color = Color(
                    Random.nextLong(0xFFFFFFFF)
                ).copy(alpha = 1f)
            )
        }
        setContent {
            LazyStaggeredGridComposeTheme {
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Adaptive(50.dp),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(items) { item ->
                        RandomColorBox(item = item)
                    }
                }
            }
        }
    }
}

data class ListItem(
    val height: Dp,
    val color: Color
)

@Composable
fun RandomColorBox(item: ListItem) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(item.height)
        .clip(RoundedCornerShape(10.dp))
        .background(item.color))
}