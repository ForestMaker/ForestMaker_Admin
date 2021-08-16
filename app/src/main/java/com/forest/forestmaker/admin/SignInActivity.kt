package com.forest.forestmaker.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.forest.forestmaker.admin.data.SignInResponse
import com.forest.forestmaker.admin.network.RequestToServer
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        act_signin_btn_signin.setOnClickListener {

            val signInData = JSONObject()
            signInData.put("id", act_signin_edit_id.text.toString())
            signInData.put("pw", act_signin_edit_password.text.toString())

            RequestToServer.service.requestSignIn(JsonParser.parseString(signInData.toString()) as JsonObject).enqueue(object : Callback<SignInResponse>{
                override fun onResponse(
                    call: Call<SignInResponse>,
                    response: Response<SignInResponse>
                ) {
                    if (response.isSuccessful){
                        val intent = Intent(this@SignInActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                    Log.e("Error", t.message.toString())
                }

            })
        }
    }
}