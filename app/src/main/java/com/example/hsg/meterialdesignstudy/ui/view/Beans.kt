package com.example.hsg.meterialdesignstudy.ui.view

import java.util.*

/**
 * Created by hsg on 29/06/2017.
 */

data class ListResponse(val total: Int,
                        val count: Int,
                        val items: List<GroupLoanBean>)

data class GroupLoanBean(val groupLoanId: Long,
                         val loanId: Long,
                         val priority: Long,
                         val name: String,
                         val fullName: String,
                         val label: String,
                         val description: String,
                         val enableInvest: String,
                         val enableTrade: String,
                         val enableAutoReinvest: String,
                         val openTime: Date,
                         val openAmount: Double,
                         val investedAmount: Double,
                         val interestRate: Double,
                         val interestUpRate: Double,
                         val interestDownRate: Double,
                         val duration: Int,
                         val durationUnit: CodeNameBean,
                         val repaymentType: CodeNameBean,
                         val guaranteeType: CodeNameBean,
                         val minInvestAmount: Double,
                         val maxInvestAmount: Double,
                         val minInvestUnit: Double,
                         val accumulatedInvestAmount: Double,
                         val accumulatedInvestTime: Int,
                         val accumulatedInvestInterest: Double,
                         val interestRateConfig: String,
                         val maxInvestTimes: Int,
                         val iconUrl: String,
                         val durationAsDay: Int,
                         val riskLevel: CodeNameBean,
                         val riskTestProvider: String,
                         val quitRule: String) {
    fun getInterestRateImpl(): String = if (interestDownRate == interestUpRate) String.format("%.2f", interestUpRate) else String.format("%.2f ~ %.2f", interestDownRate * 100, interestUpRate * 100)

    fun getMinInvestAmountImpl():String = String.format("起投金额%.2f元", minInvestAmount)
}

data class CodeNameBean(val code: String, val name: String)