package com.slaviboy.features.trainScreen.entities

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.slaviboy.features.R

data class Item(
    @DrawableRes val leftIconResId: Int,
    @StringRes val titleResId: Int,
    @StringRes val subtitleResId: Int,
    @DrawableRes val checkedIconResId: Int = R.drawable.ic_checked,
    @DrawableRes val uncheckedIconResId: Int = R.drawable.ic_unchecked,
    @DrawableRes val chevronIconResId: Int = R.drawable.ic_right_arrow,
    val showCheckIcon: Boolean = false,
    val showChevronIcon: Boolean = true,
    val showDivider: Boolean = false
)