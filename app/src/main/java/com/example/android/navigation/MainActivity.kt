
package com.example.android.navigation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.navigation.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        getProducts()

    }


    private fun getProducts(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:8080/admin/")
            .build()
            .create(IProducts::class.java)

        val data = retrofitBuilder.getData()

        data.enqueue(object : Callback<List<Products>?> {
            override fun onResponse(
                call: Call<List<Products>?>,
                response: Response<List<Products>?>
            ){
                val responseBody = response.body()!!
                val myStringBuiler = StringBuilder()
                for(myData in responseBody){
                    myStringBuiler.append(myData.name)
                    myStringBuiler.append(myData.price)
                    myStringBuiler.append("\n")
                }

                //val textV = findViewById<TextView>(R.id.product)
                //textV.text = responseBody.toString()
            }

            override fun onFailure(call: Call<List<Products>?>, t: Throwable) {
                Log.d("RulesFragment", "Error while fetching" + t.message)
            }
        })
    }


}
