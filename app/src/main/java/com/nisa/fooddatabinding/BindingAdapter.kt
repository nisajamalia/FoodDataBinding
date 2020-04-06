package com.nisa.fooddatabinding

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @BindingAdapter("app:popularityIcon")
    @JvmStatic
    fun popularityIcon(imageView: ImageView, popularity: MainObservableViewModel.LikeNumbers){
        val color = getAssociateLikeColor(popularity, imageView.context)
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
        imageView.setImageDrawable(getDrawableLikePopularity(popularity, imageView.context))

    }

    private fun getDrawableLikePopularity(
        popularity: MainObservableViewModel.LikeNumbers,
        context: Context
    ): Drawable? {
        return when(popularity){
            MainObservableViewModel.LikeNumbers.STAR -> ContextCompat.getDrawable(context, R.drawable.ic_favorite)
            MainObservableViewModel.LikeNumbers.POPULAR -> ContextCompat.getDrawable(context, R.drawable.ic_favorite)
            MainObservableViewModel.LikeNumbers.NORMAL -> ContextCompat.getDrawable(context, R.drawable.ic_rate_review)
        }
    }

    private fun getAssociateLikeColor(popularity: MainObservableViewModel.LikeNumbers, context: Context): Int {
        return when (popularity){
            MainObservableViewModel.LikeNumbers.STAR ->ContextCompat.getColor(context, R.color.colorStar)
            MainObservableViewModel.LikeNumbers.POPULAR -> ContextCompat.getColor(context, R.color.colorPopular)
            MainObservableViewModel.LikeNumbers.NORMAL -> ContextCompat.getColor(context, R.color.colorNormal)
        }
    }


    @BindingAdapter("app:unPopularityIcon")
    @JvmStatic
    fun unLikePopularityIcon(imageView: ImageView, unPopularity : MainObservableViewModel.UnLikeNumbers){
        val color = getAssociateUnLikeColor(unPopularity, imageView.context)
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
        imageView.setImageDrawable(getDrawableUnLikePopularity(unPopularity, imageView.context))
    }

    private fun getDrawableUnLikePopularity(unPopularity: MainObservableViewModel.UnLikeNumbers, context: Context): Drawable? {
        return when(unPopularity){
            MainObservableViewModel.UnLikeNumbers.UNSATISFYING -> ContextCompat.getDrawable(context, R.drawable.broken)
            MainObservableViewModel.UnLikeNumbers.NOTPOPULAR -> ContextCompat.getDrawable(context, R.drawable.broken )
            MainObservableViewModel.UnLikeNumbers.NORMAL -> ContextCompat.getDrawable(context, R.drawable.ic_sentiment_dissatisfied)
        }
    }

    private fun getAssociateUnLikeColor(unPopularity: MainObservableViewModel.UnLikeNumbers, context: Context): Int {
        return when(unPopularity){
            MainObservableViewModel.UnLikeNumbers.UNSATISFYING -> ContextCompat.getColor(context, R.color.colorDissatisfying)
            MainObservableViewModel.UnLikeNumbers.NOTPOPULAR -> ContextCompat.getColor(context, R.color.colorUnPopular)
            MainObservableViewModel.UnLikeNumbers.NORMAL -> ContextCompat.getColor(context, R.color.colorNormal)
        }
    }

}