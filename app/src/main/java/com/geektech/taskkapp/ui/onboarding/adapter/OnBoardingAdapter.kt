package com.geektech.taskkapp.ui.onboarding.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel
import androidx.recyclerview.widget.RecyclerView
import com.geektech.taskkapp.databinding.ItemOnboardingBinding
import com.geektech.taskkapp.model.OnBoard
import com.geektech.taskkapp.ui.task.utils.loadImage

class OnBoardingAdapter(private val onClick: (OnBoard) -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingHolder>() {

    private val data = arrayListOf(
        OnBoard(
            title = "Title 1",
            desc = "Desc 1",
            image = "https://tascoutsourcing.com//images/social-logo.png"
        ),
        OnBoard(
            title = "Title 2",
            desc = "Desc 2",
            "https://tascoutsourcing.com//images/social-logo.png"
        ),
        OnBoard(
            title = "Title 3",
            desc = "desc 3",
            "https://tascoutsourcing.com//images/social-logo.png"
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingHolder {
        return OnBoardingHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    }

    override fun onBindViewHolder(holder: OnBoardingHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingHolder(private val binding: ItemOnboardingBinding) : RecyclerView.
    ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.btnStart.setOnClickListener {
                onClick(onBoard)
            }
            binding.tvTitle.text = onBoard.title
            binding.tvDesk.text = onBoard.desc
            binding.ivBoard.loadImage(onBoard.image)
        }

    }

}