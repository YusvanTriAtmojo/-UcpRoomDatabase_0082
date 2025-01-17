package com.example.ucp2.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2.InventarisApp

object PenyediaViewModel {

    val Factory = viewModelFactory {
        initializer {
            BarangViewModel(
                inventarisApp().containerApp.repositoryBrg
            )
        }
        initializer {
            ListBrgViewModel(
                inventarisApp().containerApp.repositoryBrg
            )
        }
        initializer {
            DetailBrgViewModel(
                createSavedStateHandle(),
                inventarisApp().containerApp.repositoryBrg
            )
        }
        initializer {
            UpdateBrgViewModel(
                createSavedStateHandle(),
                inventarisApp().containerApp.repositoryBrg
            )
        }
    }

    val Factory1 = viewModelFactory {
        initializer {
            SuplierViewModel(
                inventarisApp().containerApp.repositorySpr
            )
        }
        initializer {
            ListSprViewModel(
                inventarisApp().containerApp.repositorySpr
            )
        }
    }
}


fun CreationExtras.inventarisApp(): InventarisApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as InventarisApp)