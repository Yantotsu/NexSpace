
package com.nexspace.gaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF080810)
private val CardColor = Color(0xFF151522)
private val Purple = Color(0xFF9B4DFF)
private val Blue = Color(0xFF527BFF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NexSpaceScreen()
        }
    }
}

@Composable
fun NexSpaceScreen() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Purple,
            background = Background,
            surface = CardColor
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(18.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "NexSpace",
                        color = Color.White,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Gaming System Utility",
                        color = Color.LightGray,
                        fontSize = 12.sp
                    )
                }

                Text("⚙",
                    color = Purple,
                    fontSize = 27.sp
                )
            }

            Spacer(Modifier.height(25.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(
                            listOf(
                                Color(0xFF31105D),
                                Color(0xFF172B59),
                                Color(0xFF171329)
                            ),
                            start = androidx.compose.ui.geometry.Offset.Zero,
                            end = androidx.compose.ui.geometry.Offset.Infinite
                        ),
                        RoundedCornerShape(24.dp)
                    )
                    .padding(22.dp)
            ) {
                Column {
                    Text(
                        "WELCOME TO NEXSPACE",
                        color = Color.White,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        "Your gaming environment starts here.",
                        color = Color.LightGray,
                        fontSize = 12.sp
                    )

                    Spacer(Modifier.height(20.dp))

                    Text(
                        "READY TO PLAY  →",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

            Text(
                "SYSTEM OVERVIEW",
                color = Color.LightGray,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                StatCard("CPU", "--", Modifier.weight(1f))
                StatCard("RAM", "--", Modifier.weight(1f))
                StatCard("BATTERY", "--", Modifier.weight(1f))
            }

            Spacer(Modifier.height(22.dp))

            Text(
                "GAMING CENTER",
                color = Color.LightGray,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(12.dp))

            FeatureCard("🎮", "Game Library", "Manage your games")
            FeatureCard("⚡", "Performance", "Gaming profiles")
            FeatureCard("📊", "Monitoring", "Device information")
            FeatureCard("🪟", "NexWindows", "Floating applications")

            Spacer(Modifier.weight(1f))

            Text(
                "NEXSPACE • VERSION 1.0.0",
                color = Color.Gray,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun StatCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(CardColor, RoundedCornerShape(16.dp))
            .padding(13.dp)
    ) {
        Text(title, color = Color.LightGray, fontSize = 10.sp)
        Spacer(Modifier.height(8.dp))
        Text(
            value,
            color = Purple,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun FeatureCard(
    icon: String,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 9.dp)
            .background(CardColor, RoundedCornerShape(15.dp))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(icon, fontSize = 23.sp)
        Spacer(Modifier.width(15.dp))

        Column {
            Text(title, color = Color.White, fontWeight = FontWeight.Bold)
            Text(description, color = Color.Gray, fontSize = 11.sp)
        }
    }
}
