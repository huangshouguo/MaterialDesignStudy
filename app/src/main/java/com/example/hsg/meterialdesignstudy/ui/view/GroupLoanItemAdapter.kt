package com.example.hsg.meterialdesignstudy.ui.view

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hsg.meterialdesignstudy.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_group_loan.view.*

/**
 * Created by hsg on 01/07/2017.
 */
public class GroupLoanItemAdapter(val dataList: List<GroupLoanBean>) : Adapter<GroupLoanItemAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindGroupLoanBean(dataList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_group_loan, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindGroupLoanBean(groupLoanBean: GroupLoanBean) {
            with(groupLoanBean) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.imgGroupLoanIcon)
                itemView.textGroupLoanName.text = name
                itemView.textRate.text = getInterestRateImpl()
                itemView.textDuration.text = duration.toString()
                itemView.textMinInvestAmount.text = getMinInvestAmountImpl()
            }
        }
    }
}