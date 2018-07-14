package cubex.mahesh.restwstest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import cubex.mahesh.restwstest.beans.PNRStatusBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener({

            var r = Retrofit.Builder().
                    addConverterFactory(GsonConverterFactory.create()).
                    baseUrl("https://api.railwayapi.com/")
                    .build()
           var  api = r.create(RailwayAPI::class.java)
            var call = api.getPnrInfo(et1.text.toString())
            call.enqueue(object:Callback<PNRStatusBean>{
                override fun onFailure(call: Call<PNRStatusBean>?, t: Throwable?) {
            Toast.makeText(this@MainActivity,
                    "Failed to Load Data...",
                    Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<PNRStatusBean>?,
                                        response: Response<PNRStatusBean>?) {
                var ps_bean =    response!!.body()
                var list = mutableListOf<String>()
                list.add("PNR No :"+ps_bean!!.pnr)
                list.add("Train No :"+ps_bean!!.train.number)
                list.add("Train Name :"+ps_bean!!.train.name)
                list.add("DOJ :"+ps_bean.doj)
                list.add("To Station :"+ps_bean.toStation.name)
                list.add("No Of Psgrs :"+ps_bean.totalPassengers)
                list.add("From Station :"+ps_bean.fromStation.name)
                for(x in ps_bean.passengers!!){
                    list.add("BStatus :"+x.bookingStatus+
                            ",CStatus"+x.currentStatus)
                }
                var myadapter = ArrayAdapter<String>(this@MainActivity,
                        android.R.layout.simple_list_item_single_choice,list)
                 lview.adapter = myadapter
                }

            })

        })
    }
}
