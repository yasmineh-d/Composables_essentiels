// ----------------  👇 [تصحيح] اسم الحزمة يجب أن يتطابق مع مسار المجلد ----------------
package com.solicode.composables_essentiels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
// ---------------- 👇 [تصحيح] مسارات الاستيراد يجب أن تستخدم اسم الحزمة الصحيح ----------------
import com.solicode.composables_essentiels.ui.MainScreen
import com.solicode.composables_essentiels.ui.theme.ComposablesEssentielsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // استدعاء الـ Theme والمكون الرئيسي للتطبيق
            ComposablesEssentielsTheme {
                MainScreen()
            }
        }
    }
}

// Preview لعرض MainScreen في وضع التصميم
@Preview(showBackground = true, widthDp = 360)
@Composable
fun PreviewMainScreen() {
    ComposablesEssentielsTheme { // من الأفضل استخدام الـ Theme الخاص بك هنا أيضاً
        MainScreen()
    }
}

// Composable إضافي لعرض صورة مع شارة
@Composable
fun AvatarWithBadge() {
    Box(modifier = Modifier.size(72.dp)) {
        Image(
            // --- 👇 [تصحيح] استيراد R الصحيح سيحل هذه المشكلة ---
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null, // الوصف مهم لإمكانية الوصول (accessibility)
            modifier = Modifier.matchParentSize()
        )
        Surface(
            color = MaterialTheme.colorScheme.error,
            shape = CircleShape,
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.BottomEnd)
        ) {}
    }
}
