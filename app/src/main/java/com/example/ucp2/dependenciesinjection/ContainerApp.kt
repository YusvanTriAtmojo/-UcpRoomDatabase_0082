package com.example.ucp2.dependenciesinjection

import android.content.Context
import com.example.ucp2.data.database.InvtDatabase
import com.example.ucp2.repository.LocalRepositoryBrg
import com.example.ucp2.repository.LocalRepositorySpr
import com.example.ucp2.repository.RepositoryBrg
import com.example.ucp2.repository.RepositorySpr

interface InterfaceContainerApp {
    val repositoryBrg: RepositoryBrg
    val repositorySpr: RepositorySpr
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryBrg: RepositoryBrg by lazy {
        LocalRepositoryBrg(InvtDatabase.getDatabase(context).barangDao())
    }
    override val repositorySpr: RepositorySpr by lazy {
        LocalRepositorySpr(InvtDatabase.getDatabase(context).suplierDao())
    }
}