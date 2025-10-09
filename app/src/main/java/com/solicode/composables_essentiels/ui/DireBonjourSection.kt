// ----------------  👇 [تصحيح 1] اسم الحزمة يجب أن يتطابق مع مسار المجلد ----------------
package com.solicode.composables_essentiels.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
// ---------------- 👇 [تصحيح 2] استيراد R يجب أن يكون من مشروعك الحالي ----------------
import com.solicode.composables_essentiels.R

@Composable
fun DireBonjourSection(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    var greetingName by rememberSaveable { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // --- 👇 [تصحيح 3] استيراد R الصحيح سيحل كل هذه الأخطاء ---
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(stringResource(R.string.label_firstname)) },
            placeholder = { Text(stringResource(R.string.ph_firstname)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth().testTag("tf_firstname")
        )

        Button(
            onClick = { greetingName = name.takeIf { it.isNotBlank() }?.trim() },
            enabled = name.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.btn_greet))
        }

        if (greetingName != null) {
            AssistChip(
                onClick = { /* no-op */ },
                // تأكد من أن 'msg_greeting' موجودة في strings.xml وتقبل متغيرًا
                // مثال: <string name="msg_greeting">Bonjour, %1$s !</string>
                label = { Text(stringResource(R.string.msg_greeting, greetingName!!)) }
            )
        }
    }
}
