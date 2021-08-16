package com.forest.forestmaker.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnSetting -> {
                val intent = Intent(this, MyPageActivity::class.java)
                startActivity(intent)
            }
            R.id.btnTree -> {
                val intent = Intent(this, InfoActivity::class.java)
                intent.putExtra("type", "나무")
                startActivity(intent)
            }
            R.id.btnGongbang -> {
                val intent = Intent(this, InfoActivity::class.java)
                intent.putExtra("type", "공방")
                startActivity(intent)
            }
            R.id.btnStore -> {
                val intent = Intent(this, InfoActivity::class.java)
                intent.putExtra("type", "상점")

                startActivity(intent)
            }
        }
    }
}