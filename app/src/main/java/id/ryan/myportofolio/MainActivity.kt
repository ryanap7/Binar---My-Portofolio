package id.ryan.myportofolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
	private lateinit var rvMyWorks: RecyclerView
	private lateinit var imgProfile: ImageView
	private var list: ArrayList<Portofolio> = arrayListOf()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		rvMyWorks = findViewById(R.id.rv_my_works)
		rvMyWorks.setHasFixedSize(true)
		
		list.addAll(PortofoliosData.listData)
		showRecyclerList()
		
		imgProfile = findViewById(R.id.about_page)
		imgProfile.setOnClickListener(this)
		
	}
	
	private fun showRecyclerList() {
		rvMyWorks.layoutManager = LinearLayoutManager(this)
		val listPortofolioAdapter = PortofolioAdapter(list)
		rvMyWorks.adapter = listPortofolioAdapter
	}
	
	override fun onClick(v: View?) {
		when(v?.id){
			R.id.about_page -> {
				val intent = Intent(this@MainActivity, ProfileActivity::class.java)
				startActivity(intent)
			}
		}
	}
}