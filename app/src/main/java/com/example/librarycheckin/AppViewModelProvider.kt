package com.example.librarycheckin

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.librarycheckin.user.UserEntryViewModel

object AppViewModelProvider {

   val Factory = viewModelFactory {

       // Initializer for ItemEntryViewModel
       initializer {
           UserEntryViewModel(libraryApplication().container.usersRepository)
       }

   }


}

fun CreationExtras.libraryApplication(): LibraryApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LibraryApplication)
