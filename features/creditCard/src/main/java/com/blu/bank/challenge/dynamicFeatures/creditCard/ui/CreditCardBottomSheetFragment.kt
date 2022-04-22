package com.blu.bank.challenge.dynamicFeatures.creditCard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blu.bank.challenge.dynamicFeatures.creditCard.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreditCardBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.layout_credit_cord_bottom_sheet, container, false)

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}