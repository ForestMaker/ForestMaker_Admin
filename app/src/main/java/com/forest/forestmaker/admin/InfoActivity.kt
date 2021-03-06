package com.forest.forestmaker.admin

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.forest.forestmaker.admin.data.AdminListResponse
import com.forest.forestmaker.admin.data.ReceiptData
import com.forest.forestmaker.admin.network.RequestToServer
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_info.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class InfoActivity : AppCompatActivity() {

    var type = ""
    var id = ""
    lateinit var dialog: Dialog
    lateinit var infoAdapter: InfoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        type = intent.getStringExtra("type").toString()

        getData()
        setDialogViewAndRv()

    }

    private fun getData() {
        val JsonData = JSONObject()
        JsonData.put("type", type)
        val body = JsonParser.parseString(JsonData.toString()) as JsonObject

        RequestToServer.service.requestAdminList(body).enqueue(object :Callback<ArrayList<AdminListResponse>>{
            override fun onResponse(
                call: Call<ArrayList<AdminListResponse>>,
                response: Response<ArrayList<AdminListResponse>>
            ) {
                if (response.isSuccessful) {
                    Log.e("success", response.body().toString())
                    for (item in response.body()!!) {
                        infoAdapter.datas.apply {
                            add(
                                ReceiptData(
                                    item._id,
                                    item.date.substring(0,5),
                                    item.date.substring(6,item.date.length),
                                    item.name,
                                    item.address,
                                    item.date,
                                    item.payment.item,
                                    item.state
                                )
                            )
                        }
                    }
                    infoAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ArrayList<AdminListResponse>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        })
    }

    private fun setDialogViewAndRv() {
        dialog = Dialog(this)     // Dialog ?????????
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // ????????? ??????
        dialog.setContentView(R.layout.item_dialog)

        val itemDate = dialog.findViewById<TextView>(R.id.item_date)
        val itemTime = dialog.findViewById<TextView>(R.id.item_time)
        val itemTree = dialog.findViewById<TextView>(R.id.item_tree)
        val itemLocation = dialog.findViewById<TextView>(R.id.item_location)
        val itemPlantDate = dialog.findViewById<TextView>(R.id.item_plantDate)
        val itemProduct = dialog.findViewById<TextView>(R.id.item_product)

        infoAdapter = InfoAdapter(this, object : InfoAdapter.OnClickItem {
            override fun onClickButton(position: Int) {
                if (infoAdapter.datas[position].status==0) {
                    id = infoAdapter.datas[position]._id
                    itemDate.text = infoAdapter.datas[position].date
                    itemTime.text = infoAdapter.datas[position].time
                    itemTree.text = infoAdapter.datas[position].tree
                    itemLocation.text = infoAdapter.datas[position].location
                    itemPlantDate.text = infoAdapter.datas[position].date
                    itemProduct.text = infoAdapter.datas[position].product

                    showDialog()

                }
            }

        })

        act_info_recyclerview.adapter = infoAdapter
        act_info_recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    // dialog01??? ??????????????? ??????
    private fun showDialog() {
        dialog.show() // ??????????????? ?????????

        dialog.findViewById<ImageView>(R.id.item_button).setOnClickListener {

            val idJson = JSONObject()
            idJson.put("_id", id)
            val body = JsonParser.parseString(idJson.toString()) as JsonObject

            RequestToServer.service.requestAdminOk(body).enqueue(object: Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.e("Success", response.toString())
                    this@InfoActivity.infoAdapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.e("Error", t.message.toString())
                }

            })
            dialog.dismiss()

        }
    }

}