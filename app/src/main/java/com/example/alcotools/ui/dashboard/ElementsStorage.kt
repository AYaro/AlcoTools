package com.example.alcotools.ui.dashboard

import com.example.alcotools.R

object ElementsStorage {

    fun getElementsList(): List<DashElement> {
        return listOf(
            DashElement(
                "Настройки",
                R.drawable.ic_launcher_background,
                "",
                1
            ),
            DashElement(
                "Выйти от сюда",
                R.drawable.ic_launcher_background,
                "",
                1
            ),
            DashElement(
                "Тесты",
                R.drawable.ic_launcher_background,
                "",
                0
            ),
            DashElement(
                "Начать пить",
                R.drawable.ic_launcher_background,
                "",
                0
            )

        )
    }
}