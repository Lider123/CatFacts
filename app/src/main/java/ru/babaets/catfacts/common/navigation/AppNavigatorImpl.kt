package ru.babaets.catfacts.common.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import ru.babaets.catfacts.R

class AppNavigatorImpl : AppNavigator {

    override var controller: NavController? = null

    private val navBuilder: NavOptions.Builder
        get() = NavOptions.Builder()
            .setEnterAnim(R.anim.fade_in)
            .setExitAnim(R.anim.fade_out)
            .setPopEnterAnim(R.anim.fade_in)
            .setPopExitAnim(R.anim.fade_out)

    override fun forward(action: NavDirections) {
        navBuilder
            .build()
            .let {
                controller?.navigate(action, it)
            }
    }

    override fun replaceWith(vararg actions: NavDirections) {
        actions.forEachIndexed { index, action ->
            if (index == 0) replaceWith(action) else forward(action)
        }
    }

    override fun replaceWith(action: NavDirections) {
        navBuilder
            .setPopUpTo(controller?.currentDestination!!.id, true)
            .build()
            .let {
                controller?.navigate(action, it)
            }
    }

    override fun newStack(action: NavDirections) {
        navBuilder
            .setPopUpTo(R.id.nav_graph, true)
            .build()
            .let {
                controller?.navigate(action, it)
            }
    }

    override fun back() {
        controller?.navigateUp()
    }
}
