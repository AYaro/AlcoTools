package com.example.alcotools.ui.dashboard

import com.example.alcotools.R

object ElementsStorage {

    fun getElementsList(): List<DashElement> {
        return listOf(
            DashElement(
                "Изменить параметры",
                R.drawable.ic_launcher_background,
                "",
                1
            ),
            DashElement(
                "Выход из приожения",
                R.drawable.ic_launcher_background,
                "",
                1
            ),
            DashElement(
                "Тест на опьянение",
                R.drawable.ic_launcher_background,
                "",
                0
            ),
            DashElement(
                "История",
                R.drawable.ic_launcher_background,
                "",
                0
            )

        )
    }
}