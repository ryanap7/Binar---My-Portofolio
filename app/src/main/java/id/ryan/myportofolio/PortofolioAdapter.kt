package id.ryan.myportofolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ryan.myportofolio.Portofolio
import id.ryan.myportofolio.R

class PortofolioAdapter(private val listPortofolio: ArrayList<Portofolio>) :
	RecyclerView.Adapter<PortofolioAdapter.ListViewHolder>() {
	
	private lateinit var onItemClickCallback: OnItemClickCallback
	
	fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
		this.onItemClickCallback = onItemClickCallback
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
		val view: View =
			LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
		return ListViewHolder(view)
	}
	
	override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
		val portofolio = listPortofolio[position]
		
		Glide.with(holder.itemView.context)
			.load(portofolio.photo)
			.apply(RequestOptions().override(302, 300))
			.into(holder.imgPhoto)
		
		holder.itemView.setOnClickListener { onItemClickCallback.onItemClick(listPortofolio[holder.adapterPosition]) }
	}
	
	override fun getItemCount(): Int {
		return listPortofolio.size
	}
	
	inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
	}
	
	interface OnItemClickCallback {
		fun onItemClick(data: Portofolio)
	}
}