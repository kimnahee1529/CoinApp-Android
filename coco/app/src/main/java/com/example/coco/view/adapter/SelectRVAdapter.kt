package com.example.coco.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coco.R
import com.example.coco.dataModel.CurrentPriceResult
import timber.log.Timber

class SelectRVAdapter(val context : Context, val coinPriceList : List<CurrentPriceResult>)
    : RecyclerView.Adapter<SelectRVAdapter.ViewHolder>(){

    val selectedCoinList = ArrayList<String>()

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val coinName : TextView = view.findViewById(R.id.coinName)
            val cointPriceUpDown : TextView = view.findViewById(R.id.coinPriceUpDown)
            val likeImage : ImageView = view.findViewById(R.id.likeBtn)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.intro_coin_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.coinName.text = coinPriceList[position].coinName

        val flucate_24H = coinPriceList[position].coinInfo.fluctate_24H

        if(flucate_24H.contains("-")){
            holder.cointPriceUpDown.text = "하락입니다."
            holder.cointPriceUpDown.setTextColor(Color.parseColor("#114fed"))
        }else{
            holder.cointPriceUpDown.text = "상승입니다."
            holder.cointPriceUpDown.setTextColor(Color.parseColor("#ed2e11"))
        }

        val likeImage = holder.likeImage
        val currentCoin = coinPriceList[position].coinName

        //view를 그려줄 때
        if(selectedCoinList.contains(currentCoin)){
            likeImage.setImageResource(R.drawable.like_red)
        }
        //포함하지 않으면
        else{
            likeImage.setImageResource(R.drawable.like_grey)
        }

        likeImage.setOnClickListener{

            Timber.d(currentCoin)
            //포함하면
            if(selectedCoinList.contains(currentCoin)){
                selectedCoinList.remove(currentCoin)
                likeImage.setImageResource(R.drawable.like_grey)
            }
            //포함하지 않으면
            else{
                selectedCoinList.add(currentCoin)
                likeImage.setImageResource(R.drawable.like_red)
            }

            Timber.d(selectedCoinList.toString())

        }


    }

    override fun getItemCount(): Int {
        return coinPriceList.size
    }
}