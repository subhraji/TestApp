package com.example.testapp.views.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.testapp.R
import com.example.testapp.model.pojo.mars_property.MarsProperty
import com.example.testapp.model.repos.Outcome
import com.example.testapp.viewmodel.MarsViewModel
import com.example.testapp.views.adapter.MarsPropertiesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val marsViewModel: MarsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMarsProperty()
    }

    private fun getMarsProperty(){
        marsViewModel.getMarsProperty().observe(this, Observer { outcome->
            when (outcome) {
                is Outcome.Success -> {
                    val marsProperty = outcome.data
                    if (marsProperty.id!=null) {
                        fillRecyclerView()
                    }
                }
                is Outcome.Failure -> {
                    Toast.makeText(this,"Error Occurred",Toast.LENGTH_SHORT).show()
                    outcome.e.printStackTrace()
                }
            }

        })
    }

    private fun fillRecyclerView(marsProperty: List<MarsProperty>) {
        mars_property_recyclerview.adapter = MarsPropertiesAdapter(marsProperty)
    }

}