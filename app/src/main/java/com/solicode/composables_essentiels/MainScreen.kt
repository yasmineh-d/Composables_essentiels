package com.solicode.composables_essentiels

import androidx.compose.foundation.layout.Arrangement //pour gérer l'espacement vertical/horizontal
import androidx.compose.foundation.layout.Column //layout colonne
import androidx.compose.foundation.layout.fillMaxSize //pour remplir l'espace disponible
import androidx.compose.foundation.layout.padding // pour ajouter des marges
import androidx.compose.foundation.rememberScrollState //pour mémoriser l'etat du scroll
import androidx.compose.foundation.verticalScroll //pour rendre la colonne scrollable
import androidx.compose.runtime.Composable // annotation pour créer un composable
import androidx.compose.ui.Alignment // alignement horizontal/vertical
import androidx.compose.ui.Modifier // pour modifier les composants
import androidx.compose.ui.unit.dp // unité de mesure dp pour les marges et espacements

//Composable principal de l'applicayion qui affiche les sections
@Composable
fun MainScreen(modifier: Modifier = Modifier){
    column(
        modifier = modifier
            .fillMaxSize() //occuper tout l'espace disponible de l'écran
            .padding(16.dp) //
            .verticalArrangement = Arrangement.spacedBy(24.dp), // espace vertical entre les éléments de la colonne
            .horizontalAlignment = Alignment.CenterHorizontally // centre horizontalement les éléments
    ){
        DireBonjourSection()

        //Appel du composable pour la section "compteur"
        CompteurSection()
    }
}