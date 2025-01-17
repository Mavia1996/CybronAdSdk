package com.sarmad.adsdk.demo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.sarmad.admobify.adsdk.app_open_ad.SplashOpenAppAd

import com.sarmad.adsdk.demo.databinding.ActivityInterstitialAdsBinding

class SplashOpenAdActivity : AppCompatActivity() {

    private val binding: ActivityInterstitialAdsBinding by lazy {
        ActivityInterstitialAdsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnLoadShow.text = "Load and Show open ad"
            btnLoadShow.visibility = View.VISIBLE
            btnLoad.text = "Load open ad"
            btnShow.text = "Show open ad"

            btnLoadShow.setOnClickListener {
                loadAndShow()
            }
            btnLoad.setOnClickListener {
                loadOpenAd()
            }
            btnShow.setOnClickListener {
                showOpenAd()
            }

        }
    }


    fun loadAndShow() {
        SplashOpenAppAd.loadOpenAppAd(this@SplashOpenAdActivity,
            getString(R.string.open_app_ad),
            remote = true,
            adLoaded = {
                SplashOpenAppAd.showOpenAppAd(
                    this@SplashOpenAdActivity,
                    adShowFullScreen = {},
                    adFailedToShow = {},
                    adDismiss = {})

            },
            adFailed = null,
            adValidate = {})
    }

    fun loadOpenAd() {
        SplashOpenAppAd.loadOpenAppAd(this@SplashOpenAdActivity,
            getString(R.string.open_app_ad),
            remote = true,
            adLoaded = {},
            adFailed = {},
            adValidate = {})
    }

    fun showOpenAd() {
        SplashOpenAppAd.showOpenAppAd(
            this@SplashOpenAdActivity,
            adShowFullScreen = {},
            adFailedToShow = {},
            adDismiss = {})

    }
}
