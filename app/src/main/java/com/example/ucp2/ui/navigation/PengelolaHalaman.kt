package com.example.ucp2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp2.ui.view.HomeView
import com.example.ucp2.ui.view.barang.DetailBrgView
import com.example.ucp2.ui.view.barang.InsertBrgView
import com.example.ucp2.ui.view.barang.ListBrgView
import com.example.ucp2.ui.view.barang.UpdateBrgView
import com.example.ucp2.ui.view.suplier.InsertSprView
import com.example.ucp2.ui.view.suplier.ListSprView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route) {

        composable(route = "home") {
            HomeView(
                keListBarang = {
                    navController.navigate(DestinasiListBrg.route)
                },
                keAddBarang = {
                    navController.navigate(DestinasiInsertBrg.route)
                } ,
                keListSuplier = {
                    navController.navigate(DestinasiListSpr.route)
                },
                keAddSuplier = {
                    navController.navigate(DestinasiInsertSpr.route)
                }
            )
        }

        composable(
            route = DestinasiListBrg.route
        ) {
            ListBrgView(
                onDetailClick = {id: Int ->
                    navController.navigate("${DestinasiDetailBrg.route}/$id")
                    println(
                        "PengelolaHalaman: id = $id"
                    )
                },
                onBack = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }
        composable(
            route = DestinasiInsertBrg.route
        ) {
            InsertBrgView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {

                },
                modifier = modifier,
            )
        }

        composable(
            DestinasiDetailBrg.routesWithArg,
            arguments = listOf(
                navArgument(DestinasiDetailBrg.ID) {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt(DestinasiDetailBrg.ID)

            id?.let { id ->
                DetailBrgView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdateBrg.route}/$id")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(
            DestinasiUpdateBrg.routerWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdateBrg.ID) {
                    type = NavType.IntType
                }
            )
        ) {

            UpdateBrgView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {

                },
                modifier = modifier,
            )
        }
        composable(
            route = DestinasiListSpr.route
        ) {
            ListSprView(
                onBack = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }
        composable(
            route = DestinasiInsertSpr.route
        ) {
            InsertSprView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {

                },
                modifier = modifier,
            )
        }
    }
}