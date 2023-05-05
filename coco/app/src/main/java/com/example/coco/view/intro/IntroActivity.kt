package com.example.coco.view.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import com.example.coco.view.main.MainActivity
import com.example.coco.databinding.ActivityIntroBinding
import timber.log.Timber


// Splash 화면 만들기
// Handler -> 3초 뒤에 다른 액티비티(MainActivity)로 이동
class IntroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityIntroBinding

    private val viewModel : IntroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.d("onCreate")

        viewModel.checkFirstFlag()
        viewModel.first.observe(this, Observer {

            if(it){
                //처음 접속하는 유저가 아님
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                //처음 접속하는 유저
                binding.fragmentContainerView.visibility = View.VISIBLE
                binding.animationView.visibility = View.INVISIBLE
            }
        })

    }
}











