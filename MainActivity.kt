package com.danzz208.proxy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF050B1B)
private val Panel = Color(0xFF0D1933)
private val Blue = Color(0xFF168BFF)
private val Cyan = Color(0xFF45D9FF)
private val Muted = Color(0xFF91A8C9)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { DanzzApp() }
    }
}

@Composable
fun DanzzApp() {
    var connected by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("SMART") }
    MaterialTheme(colorScheme = darkColorScheme(
        background = Navy, surface = Panel, primary = Blue,
        onBackground = Color.White, onSurface = Color.White
    )) {
        Box(
            Modifier.fillMaxSize().background(
                Brush.verticalGradient(listOf(Color(0xFF0B1D3C), Navy, Color(0xFF030712)))
            )
        ) {
            Column(
                Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding().padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(42.dp).background(
                        Brush.linearGradient(listOf(Blue, Cyan)), RoundedCornerShape(13.dp)
                    ), contentAlignment = Alignment.Center) {
                        Icon(Icons.Default.Bolt, null, tint = Color.White)
                    }
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text("DANZZ 208 PROXY", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
                        Text("PREMIUM MOBILE NETWORK", color = Cyan, fontSize = 9.sp, letterSpacing = 2.sp)
                    }
                    Icon(Icons.Default.Settings, "Settings", tint = Muted)
                }
                Spacer(Modifier.height(28.dp))
                Surface(
                    color = Panel.copy(alpha = .9f),
                    shape = RoundedCornerShape(22.dp),
                    modifier = Modifier.fillMaxWidth().border(1.dp, Blue.copy(alpha = .45f), RoundedCornerShape(22.dp))
                ) {
                    Column(Modifier.padding(18.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Public, null, tint = Cyan)
                            Spacer(Modifier.width(8.dp))
                            Text("CONNECTION", color = Muted, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.weight(1f))
                            Surface(color = if (connected) Color(0xFF0B513D) else Color(0xFF28344A), shape = CircleShape) {
                                Text(if (connected) "● CONNECTED" else "● DISCONNECTED",
                                    Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    color = if (connected) Color(0xFF65F0B2) else Muted, fontSize = 9.sp)
                            }
                        }
                        Spacer(Modifier.height(26.dp))
                        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                            Box(
                                Modifier.size(190.dp).border(1.dp, Blue.copy(alpha = .28f), CircleShape)
                                    .padding(12.dp).border(1.dp, Cyan.copy(alpha = .2f), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Button(
                                    onClick = { connected = !connected },
                                    modifier = Modifier.size(142.dp),
                                    shape = CircleShape,
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = if (connected) Color(0xFF123C55) else Blue
                                    ),
                                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 12.dp)
                                ) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Icon(Icons.Default.Bolt, null, modifier = Modifier.size(32.dp))
                                        Text(if (connected) "DISCONNECT" else "CONNECT", fontWeight = FontWeight.ExtraBold, fontSize = 13.sp)
                                    }
                                }
                            }
                        }
                        Spacer(Modifier.height(18.dp))
                        Text(if (connected) "Connection active" else "Ready to establish secure tunnel",
                            Modifier.fillMaxWidth(), color = Muted, fontSize = 12.sp)
                    }
                }
                Spacer(Modifier.height(18.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    InfoCard("SESSION", if (connected) "00:00:01" else "--:--:--", Modifier.weight(1f))
                    InfoCard("PROTOCOL", "SOCKS5", Modifier.weight(1f))
                }
                Spacer(Modifier.height(18.dp))
                Surface(color = Panel.copy(alpha = .9f), shape = RoundedCornerShape(18.dp),
                    modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("SERVER HUNT", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        Spacer(Modifier.height(12.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            listOf("SMART", "ASN", "ISP").forEach { item ->
                                FilterChip(selected = selected == item, onClick = { selected = item },
                                    label = { Text(item, fontSize = 11.sp) })
                            }
                        }
                        Text("Choose a search mode to find a proxy endpoint.",
                            color = Muted, fontSize = 11.sp)
                    }
                }
                Spacer(Modifier.weight(1f))
                Text("DANZZ 208 PROXY  •  BUILD 1.0.0", color = Muted, fontSize = 9.sp, letterSpacing = 1.sp)
            }
        }
    }
}

@Composable
private fun InfoCard(title: String, value: String, modifier: Modifier = Modifier) {
    Surface(color = Panel, shape = RoundedCornerShape(16.dp), modifier = modifier) {
        Column(Modifier.padding(14.dp)) {
            Text(title, color = Muted, fontSize = 9.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(6.dp))
            Text(value, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Cyan)
        }
    }
}
