package com.madura.bankingappui.screens.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madura.bankingappui.R
import com.madura.bankingappui.data.Card
import com.madura.bankingappui.ui.theme.BlueEnd
import com.madura.bankingappui.ui.theme.BlueStart
import com.madura.bankingappui.ui.theme.GreenEnd
import com.madura.bankingappui.ui.theme.GreenStart
import com.madura.bankingappui.ui.theme.OrangeEnd
import com.madura.bankingappui.ui.theme.OrangeStart
import com.madura.bankingappui.ui.theme.PurpleEnd
import com.madura.bankingappui.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardName = "Business",
        balance = 45.89,
        cardNumber = "366 566 345 567",
        color = getGradiant(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "Master Card",
        cardName = "Business",
        balance = 45.89,
        cardNumber = "366 566 345 567",
        color = getGradiant(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "Visa",
        cardName = "School",
        balance = 45.89,
        cardNumber = "366 566 345 567",
        color = getGradiant(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "Master Card",
        cardName = "School",
        balance = 45.89,
        cardNumber = "366 566 345 567",
        color = getGradiant(GreenStart, GreenEnd)
    )
)

fun getGradiant(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}

@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp

    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(
        id = R.drawable.visa_card
    )

    if (card.cardType == "Master Card") {
        image = painterResource(
            id = R.drawable.master_card
        )
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }


}

