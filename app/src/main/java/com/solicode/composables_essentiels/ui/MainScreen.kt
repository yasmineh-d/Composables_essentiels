// ----------------  👇 [تصحيح 1] اسم الحزمة يجب أن يتطابق مع مسار المجلد ----------------
package com.solicode.composables_essentiels.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
// ---------------- 👇 [تصحيح 2] إضافة جمل الاستيراد المفقودة ----------------
import com.solicode.composables_essentiels.ui.CompteurSection
import com.solicode.composables_essentiels.ui.DireBonjourSection

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- 👇 [تصحيح 3] هذه الدوال ستعمل الآن بفضل جمل الاستيراد الصحيحة ---
        DireBonjourSection()
        CompteurSection()
    }
}
