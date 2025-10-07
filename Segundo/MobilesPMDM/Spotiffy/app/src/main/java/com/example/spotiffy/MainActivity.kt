package com.example.spotiffy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spotiffy.ui.theme.SpotiffyTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola1", "Como estas?dfgsdfgsfghfghjghkjfdfghsfghddfgbfghdgfhsghsdfgsdfgsdfgsdfgsdfgsdfgsdfsdfgsdfgsdfg"),
    MyMessage("Hola2", "Como estasdsdfgsdfgsdfgsdfg?"),
    MyMessage("Hola3", "Como estas?"),
    MyMessage("Hola4", "Como estas?dfgsdfgsfghfjgukyuoluioliuoluiolhuilyioluyluyuil"),
    MyMessage("Hola5", "Como estas?"),
    MyMessage("Hola6", "Como estas?"),
    MyMessage("Hola7", "Como estas?"),
    MyMessage("Hola8", "Como estas?"),
    MyMessage("Hola9", "Como estas?"),
    MyMessage("Hola10", "Como estas?"),
    MyMessage("Hola11", "Como estas?"),
    MyMessage("Hola12", "Como estas?"),
    MyMessage("Hola13", "Como estas?"),
    MyMessage("Hola14", "Como estas?"),
    MyMessage("Hola15", "Como estas?"),
    MyMessage("Hola16", "Como estas?"),
    MyMessage("Hola17", "Como estas?"),
    MyMessage("Hola18", "Como estas?"),
    MyMessage("Hola19", "Como estas?"),
    MyMessage("Hola20", "Como estas?")

)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotiffyTheme {
                MyMessages(messages)
            }

        }

    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyComponents(message: MyMessage) {
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp))
        {
        MyImages()
        MyTexts(message)
    }
}
@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message ->
            MyComponents(message)
        }

    }

}

@Composable
fun MyTexts(message: MyMessage) {

    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(start = 5.dp)
        .clickable {expanded = !expanded}) {

        MyText(
            message.title,
            MaterialTheme.colorScheme.tertiary,
            MaterialTheme.typography.labelLarge
        )
        MyText(
            message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodySmall,
            if (expanded) Int.MAX_VALUE else 1
        )
    }
}

@Composable
fun MyImages() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription= "Mi imagen de prueba",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)

    )
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text, color = color,style = style,
        maxLines = lines)

}



@Preview(showSystemUi = true)
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES )
@Composable
fun PreviewComponentsDark() {
    SpotiffyTheme {
        MyMessages(messages)
    }
}