package com.forest.forestmaker.admin

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    lateinit var dialog: Dialog
    lateinit var infoAdapter: InfoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        dialog = Dialog(this)     // Dialog 초기화
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // 타이틀 제거
        dialog.setContentView(R.layout.item_dialog);


        infoAdapter = InfoAdapter(this, object : InfoAdapter.OnClickItem {
            override fun onClickButton(position: Int) {
                if (!infoAdapter.datas[position].status) {
                    showDialog()
                    if (dialog.isShowing) {
                        infoAdapter.datas[position].status = true
                        infoAdapter.notifyItemChanged(position)
                    }
                }
            }

        })

        act_info_recyclerview.adapter = infoAdapter
        act_info_recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        setData()
    }

    // dialog01을 디자인하는 함수
    private fun showDialog() {
        dialog.show(); // 다이얼로그 띄우기

        /* 이 함수 안에 원하는 디자인과 기능을 구현하면 된다. */

        dialog.findViewById<ImageView>(R.id.item_button).setOnClickListener {
            dialog.dismiss()
            return@setOnClickListener
        }
    }

    private fun setData() {
        infoAdapter.datas.apply {
            add(
                ReceiptData(
                    "08-03 (일, 오늘)",
                    "13:00",
                    "소나무",
                    "경기도 하남시 위례중앙로",
                    "2021.06.02 (일)",
                    "식물영양제 1개 / 주사액 1개",
                    false
                )
            )

            add(
                ReceiptData(
                    "08-02 (토)",
                    "14:00",
                    "소나무",
                    "경기도 하남시 위례중앙로",
                    "2021.06.02 (일)",
                    "식물영양제 1개 / 주사액 1개",
                    true
                )
            )

            add(
                ReceiptData(
                    "08-02 (토)",
                    "14:00",
                    "소나무",
                    "경기도 하남시 위례중앙로",
                    "2021.06.02 (일)",
                    "식물영양제 1개 / 주사액 1개",
                    false
                )
            )

            add(
                ReceiptData(
                    "08-02 (토)",
                    "14:00",
                    "소나무",
                    "경기도 하남시 위례중앙로",
                    "2021.06.02 (일)",
                    "식물영양제 1개 / 주사액 1개",
                    false
                )
            )

            add(
                ReceiptData(
                    "08-02 (토)",
                    "14:00",
                    "소나무",
                    "경기도 하남시 위례중앙로",
                    "2021.06.02 (일)",
                    "식물영양제 1개 / 주사액 1개",
                    true
                )
            )
        }

        infoAdapter.notifyDataSetChanged()
    }
}