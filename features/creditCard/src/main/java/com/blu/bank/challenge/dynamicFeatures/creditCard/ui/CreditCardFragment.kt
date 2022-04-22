package com.blu.bank.challenge.dynamicFeatures.creditCard.ui

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.blu.bank.challenge.common.base.BaseFragment
import com.blu.bank.challenge.common.extentions.getCardNumberInRows
import com.blu.bank.challenge.dynamicFeatures.creditCard.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_credit_card.*
import kotlinx.android.synthetic.main.layout_credit_card_content.*
import kotlinx.android.synthetic.main.layout_credit_card_progress.*
import kotlinx.android.synthetic.main.layout_credit_cord_bottom_sheet.*
import java.lang.StringBuilder


class CreditCardFragment : BaseFragment<CreditCardViewModel>() {


    override fun layoutId(): Int = R.layout.fragment_credit_card

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectLoginFeature()
    }


    private var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>? = null
    private var bottomSheetBehaviorProgress: BottomSheetBehavior<ConstraintLayout>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpBottomSheet()
        setUpCardFlipAnimation()
        setUpListeners()
        fetchData()

    }
    private fun setUpBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetCreditCard)
        bottomSheetBehavior?.isFitToContents = false
        bottomSheetBehavior?.halfExpandedRatio = 0.65f
        bottomSheetBehavior?.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        bottomSheetBehaviorProgress = BottomSheetBehavior.from(bottomSheetCreditCardProgress)
        bottomSheetBehaviorProgress?.isFitToContents = false
        bottomSheetBehaviorProgress?.halfExpandedRatio = 0.65f
        bottomSheetBehaviorProgress?.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        bottomSheetBehaviorProgress?.isDraggable = false
        bottomSheetBehavior?.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetCreditCard.background = ContextCompat.getDrawable(
                        requireContext(),
                        com.blu.bank.challenge.app.R.color.white
                    )
                } else {
                    bottomSheetCreditCard.background = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.bg_bottom_sheet
                    )
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

        })
    }

    private lateinit var frontAnimation: AnimatorSet
    private lateinit var backAnimation: AnimatorSet
    var isFront = true
    private fun setUpCardFlipAnimation() {
        var scale = activity?.applicationContext?.resources?.displayMetrics?.density
        clCreditCardFront.cameraDistance = 8000 * (scale ?: 0f)
        clCreditCardBack.cameraDistance = 8000 * (scale ?: 0f)
        frontAnimation = AnimatorInflater.loadAnimator(
            activity?.applicationContext,
            R.animator.credit_card_animator_fornt
        ) as AnimatorSet
        backAnimation = AnimatorInflater.loadAnimator(
            activity?.applicationContext,
            R.animator.credit_card_animator_back
        ) as AnimatorSet



    }

    private fun setUpListeners() {
        clCreditCardFront.setOnClickListener {
            bottomSheetBehavior?.state = BottomSheetBehavior.STATE_COLLAPSED
            if (isFront) {
                frontAnimation.setTarget(clCreditCardFront);
                backAnimation.setTarget(clCreditCardBack);
                frontAnimation.start()
                backAnimation.start()
                isFront = false

            } else {
                frontAnimation.setTarget(clCreditCardBack)
                backAnimation.setTarget(clCreditCardFront)
                backAnimation.start()
                frontAnimation.start()
                isFront = true

            }
        }

        btnCreditCardExport.setOnClickListener {

        }

        btnCreditCardDynamicPass.setOnClickListener {

        }
        btnCreditCardProgressDynamicPass.setOnClickListener {

        }

        btnCreditCardFreeze.setOnClickListener {
            toggleCreditCardFreeze.toggle()
        }

        btnCreditCardSecurity.setOnClickListener {
            Toast.makeText(
                requireActivity().applicationContext,
                "go to security setting",
                Toast.LENGTH_SHORT
            ).show()
        }
        btnCreditCardBlock.setOnClickListener {
            Toast.makeText(
                requireActivity().applicationContext,
                "go to block card",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun fetchData() {
        viewModel.progress.observe(viewLifecycleOwner) {
            handleProgressAnimations(it ?: false)
        }

        viewModel.getCardDetails()
        viewModel.cardDetailResult.observe(viewLifecycleOwner) {
            it?.let {
                tvCreditCardOwnerName.text = StringBuilder().append(it.cardOwnerFirstName?:"").append("\n").append(it.cardOwnerLastName?:"")
                tvCreditCardNumber.text = (it.cardNumber ?: "").getCardNumberInRows()
                tvCreditCardExp.text = (it.expDate ?: "")
                tvCreditCardCVV2.text = (it.cvv2 ?: "")

            }
        }
    }

    private fun handleProgressAnimations(it: Boolean) {
        if (it) {

            layoutCreditCardProgress.visibility = View.VISIBLE
            layoutCreditCardContent.visibility = View.GONE

            val alphaAnimation = AnimationUtils.loadAnimation(
                activity?.applicationContext,
                R.anim.animation_alpha_progress
            )


            groupCreditCardProgressAnimates.postDelayed({
                groupCreditCardProgressAnimates.referencedIds.forEach {
                    view?.findViewById<View>(it)?.startAnimation(alphaAnimation)
                    clCreditCardProgress.startAnimation(alphaAnimation)
                }
            }, 500)
        } else {
            layoutCreditCardProgress.visibility = View.GONE
            layoutCreditCardContent.visibility = View.VISIBLE

            groupCreditCardProgressAnimates.postDelayed({
                groupCreditCardProgressAnimates.referencedIds.forEach {
                    view?.findViewById<View>(it)?.clearAnimation()
                    clCreditCardProgress.clearAnimation()
                }
            }, 100)
        }
    }




}








