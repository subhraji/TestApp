package com.example.testapp.views.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat
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
    var listView: ListView? = null
    var list: ArrayList<String>? = null
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //getMarsProperty()
        listView = findViewById(R.id.listView)

        list = ArrayList()
        list!!.add("Apple")
        list!!.add("Banana")
        list!!.add("Pineapple")
        list!!.add("Orange")
        list!!.add("Lychee")
        list!!.add("Gavava")
        list!!.add("Peech")
        list!!.add("Melon")
        list!!.add("Watermelon")
        list!!.add("Papaya")

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list!!)
        listView!!.setAdapter(adapter);

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

       /* val searchItem = menu?.findItem(R.id.search_item)
        val searchView = searchItem?.actionView as SearchView*/

        val searchItem = menu?.findItem(R.id.search_item)
        val searchView = searchItem?.actionView as SearchView
        searchView.setQueryHint("Search View Hint")

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                adapter?.getFilter()?.filter(newText);
                Toast.makeText(this@MainActivity, "No Match found", Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // task HERE
                searchView.clearFocus();
                return false
            }

        })
        return super.onCreateOptionsMenu(menu);
    }

    private fun getMarsProperty(){
        marsViewModel.getMarsProperty().observe(this, Observer { outcome->
            when (outcome) {
                is Outcome.Success -> {
                    val marsProperty = outcome.data

                    if (marsProperty.size != 0){
                        fillRecyclerView(marsProperty)
                    }

                }
                is Outcome.Failure -> {
                    Log.i("Error",outcome.e.message.toString())
                    outcome.e.printStackTrace()
                }
            }

        })
    }

    private fun fillRecyclerView(marsProperty: List<MarsProperty>) {
        mars_property_recyclerview.adapter = MarsPropertiesAdapter(marsProperty)
    }

}