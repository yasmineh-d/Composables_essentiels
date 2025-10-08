package com.solicode.composables_essentiels

import androidx.compose.foundation.layout.* //Column, Row, Arrangement, etc.
import androidx.compose.material.icons.Icons // accès aux icones Materiel
import androidx.compose.material.icons.filled.Add //icone "+"
import androidx.compose.material.icons.filled.Remove //icone "-"
import androidx.compose.material3.* // composants Material3 : Text , IconButton, MaterialTheme...
import androidx.compose.runtime.* // state, composable,etc.
import androidx.compose.runtime.saveable.rememberSaveable // pour sauvegarder L'etat entre configurations
import androidx.compose.ui.Alignment // alignements (CenterVertivally)
import androidx.compose.ui.Modifier // modifier pour la mise en page
import androidx.compose.ui.unit.dp //unites dp

@composable
fun CompteurSection(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableSetOf(0)) }

    column(modifier = modifier) {
        Text(
            text = "Compteur",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            IconButton(
                onClick = { if (count > 0) count-- },
                enabled = count > 0
            ) {
                Icon(Icons.Filled.Remove, contentDescription = "Diminuer")
            }
            Text(
                text = "$count",
                style = MaterialTheme.typography.headlineSmall
            )
            IconButton(onClick = { count++}) {
                Icon(Icons.Filled.Add, contentDescription = "Augmenter")
            }
            }
        }
    }

