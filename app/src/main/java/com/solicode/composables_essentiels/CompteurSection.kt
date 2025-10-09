package com.solicode.composables_essentiels

import androidx.compose.foundation.layout.* // Column, Row, Arrangement, etc.
import androidx.compose.material.icons.Icons // accès aux icônes Material
import androidx.compose.material.icons.filled.Add // icône "+"
import androidx.compose.material.icons.filled.Remove // icône "-"
import androidx.compose.material3.* // composants Material3 : Text, IconButton, MaterialTheme...
import androidx.compose.runtime.* // state, composable, etc.
import androidx.compose.runtime.saveable.rememberSaveable // pour sauvegarder l'état entre configurations
import androidx.compose.ui.Alignment // alignements (CenterVertically)
import androidx.compose.ui.Modifier // modifier pour la mise en page
import androidx.compose.ui.unit.dp // unités dp

@Composable // annotation obligatoire pour déclarer une fonction composable
fun CompteurSection(modifier: Modifier = Modifier) {
    // variable d'état "count" sauvegardée entre les changements de configuration
    var count by rememberSaveable { mutableStateOf(0) }

    // disposition verticale des éléments
    Column(
        modifier = modifier
            .fillMaxWidth() // occuper toute la largeur
            .padding(16.dp) // marge intérieure
    ) {
        // titre de la section
        Text(
            text = "Compteur",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // disposition horizontale : boutons + compteur
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp) // espace entre les éléments
        ) {
            // bouton "-" (désactivé quand count == 0)
            IconButton(
                onClick = { if (count > 0) count-- },
                enabled = count > 0
            ) {
                Icon(
                    imageVector = Icons.Filled.Remove,
                    contentDescription = "Diminuer"
                )
            }

            // affichage du compteur
            Text(
                text = "$count",
                style = MaterialTheme.typography.headlineSmall
            )

            // bouton "+"
            IconButton(onClick = { count++ }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Augmenter"
                )
            }
        }
    }
}
