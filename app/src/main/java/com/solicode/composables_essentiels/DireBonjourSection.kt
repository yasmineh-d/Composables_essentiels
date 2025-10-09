package com.solicode.composables_essentiels

import androidx.compose.foundation.layout.* // Column, Arrangement, fillMaxWidth, spacing
import androidx.compose.foundation.text.KeyboardOptions // options clavier
import androidx.compose.material3.* // Text, Button, OutlinedTextField, AssistChip, Material3...
import androidx.compose.runtime.* // mutableStateOf, Composable
import androidx.compose.runtime.saveable.rememberSaveable // pour sauvegarder l'état après rotation
import androidx.compose.ui.Modifier // Modifier pour gérer la mise en page
import androidx.compose.ui.text.input.ImeAction // pour gérer l'action du clavier
import androidx.compose.ui.unit.dp // unité pour les espacements

// Composable pour la section "dire bonjour"
@Composable
fun DireBonjourSection(modifier: Modifier = Modifier) {
    // variable pour stocker le prénom saisi par l'utilisateur
    var name by rememberSaveable { mutableStateOf("") }
    // variable pour stocker le prénom validé pour l'affichage du message
    var greetingName by rememberSaveable { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // champ de saisie pour le prénom
        OutlinedTextField(
            value = name, // valeur actuelle du champ
            onValueChange = { name = it }, // mise à jour de la variable name à chaque saisie
            label = { Text("Prénom") }, // étiquette du champ
            placeholder = { Text("Entrez votre prénom") }, // texte indicatif
            singleLine = true, // une seule ligne
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done), // action "Done" sur le clavier
            modifier = Modifier.fillMaxWidth() // occupe toute la largeur
        )

        // bouton pour valider le prénom et afficher le message
        Button(
            onClick = { greetingName = name.takeIf { it.isNotBlank() }?.trim() }, // si non vide, trim et stocker dans greetingName
            enabled = name.isNotBlank(), // activé seulement si le champ n'est pas vide
            modifier = modifier.fillMaxWidth() // bouton pleine largeur
        ) {
            Text("Dire bonjour") // texte du bouton
        }

        // affiche le message de bienvenue si greetingName n'est pas null
        if (greetingName != null) {
            AssistChip(
                onClick = {}, // pas d'action au clic
                label = { Text("Bonjour, $greetingName !") } // texte du message
            )
        }
    }
}
