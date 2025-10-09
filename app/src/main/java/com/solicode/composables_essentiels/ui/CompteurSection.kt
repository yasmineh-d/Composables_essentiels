// ----------------  👇 [تصحيح 1] اسم الحزمة يجب أن يتطابق مع مسار المجلد ----------------
package com.solicode.composables_essentiels.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
// ---------------- 👇 [تصحيح 2] استيراد R يجب أن يكون من مشروعك الحالي ----------------
import com.solicode.composables_essentiels.R

@Composable
fun CompteurSection(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }

    // --- 👇 [تصحيح 3] استيراد R الصحيح سيحل كل هذه الأخطاء ---
    val decrementCd = stringResource(R.string.cd_decrement)
    val incrementCd = stringResource(R.string.cd_increment)
    // ملاحظة: تأكد من أن 'cd_counter_value' موجود في strings.xml ويقبل متغيرًا (e.g. <string name="cd_counter_value">Valeur du compteur : %d</string>)
    val counterCd   = stringResource(R.string.cd_counter_value, count)

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // تأكد من وجود 'title_counter' في strings.xml
        Text(
            text = stringResource(R.string.title_counter),
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { if (count > 0) count-- },
                enabled = count > 0,
                modifier = Modifier
                    .size(48.dp)
                    .semantics { contentDescription = decrementCd }
            ) {
                Icon(
                    imageVector = Icons.Filled.Remove,
                    contentDescription = null // صحيح، لأن الوصف موجود في الـ parent
                )
            }

            Text(
                text = "$count",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .widthIn(min = 40.dp)
                    .semantics { contentDescription = counterCd }
            )

            IconButton(
                onClick = { count++ },
                modifier = Modifier
                    .size(48.dp)
                    .semantics { contentDescription = incrementCd }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null // صحيح
                )
            }
        }
    }
}
