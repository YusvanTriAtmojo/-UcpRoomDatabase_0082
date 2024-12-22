package com.example.ucp2.ui.navigation

interface AlamatNavigasi {
    val route: String
}

object DestinasiHome : AlamatNavigasi {
    override val route = "home"
}
object DestinasiInsertBrg : AlamatNavigasi {
    override val route: String = "insert_brg"
}

object DestinasiInsertSpr : AlamatNavigasi {
    override val route: String = "insert_spr"
}

object DestinasiListBrg : AlamatNavigasi {
    override val route = "listbrg"
}

object DestinasiListSpr : AlamatNavigasi {
    override val route = "homespr"
}

object DestinasiDetailBrg : AlamatNavigasi {
    override val route = "detailbrg"
    const val ID = "id"
    val routesWithArg = "$route/{$ID}"
}

object DestinasiUpdateBrg : AlamatNavigasi {
    override val route = "updatebrg"
    const val ID = "id"
    val routerWithArg = "$route/{$ID}"
}