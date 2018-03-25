package com.oakkub.survey.ui.surveys.list.adapter.dot

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.eggdigital.trueyouedc.extensions.views.inflate
import com.oakkub.survey.R
import kotlinx.android.extensions.LayoutContainer

/**
 * Created by oakkub on 25/3/2018 AD.
 */
class DotViewHolder private constructor(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(selectedPosition: Int) {
        containerView.isSelected = selectedPosition == adapterPosition
    }

    companion object {
        fun create(parent: ViewGroup): DotViewHolder {
            return DotViewHolder(parent.inflate(R.layout.item_dot))
        }
    }

}