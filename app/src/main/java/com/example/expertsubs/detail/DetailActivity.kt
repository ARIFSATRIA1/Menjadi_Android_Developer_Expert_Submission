package com.example.expertsubs.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.expertsubs.R
import com.example.expertsubs.core.domain.model.Users
import com.example.expertsubs.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val detailViewModel: DetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val detailUser = intent.getParcelableExtra<Users>(EXTRA_DATA)
        showDetailUser(detailUser)


    }

    private fun showDetailUser(detailUsers: Users?) {
        detailUsers?.let {
            binding.repoTv.text = it.repo
            binding.usernameTv.text = it.username
            Glide.with(this)
                .load(it.image)
                .into(binding.imgView)

            var statusFavorite = it.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteGithubUsers(detailUsers, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.baseline_favorite_24
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.baseline_favorite_border_24
                )
            )
        }
    }


    companion object {
        const val EXTRA_DATA = "extra_data"
    }


}