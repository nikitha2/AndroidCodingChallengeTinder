package com.example.androidcodingchallangetinder.features.hotposts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidcodingchallangetinder.R
import com.example.androidcodingchallangetinder.features.hotposts.model.HotPostsResponseModel
import javax.inject.Inject

class PostsListAdapter @Inject constructor(
    private var hotPostsResponseModel: HotPostsResponseModel,
    private val clickListener: (Int) -> Unit
) :
    RecyclerView.Adapter<PostsListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var postThumbnail: ImageView = itemView.findViewById(R.id.postThumbnail)
        var postTitle: TextView = itemView.findViewById(R.id.postTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_list_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val thumbnail = hotPostsResponseModel.data?.children?.get(position)?.data?.thumbnail
        Glide.with(holder.itemView.context).load(thumbnail)
            .placeholder(R.drawable.ic_launcher_foreground).fitCenter().into(holder.postThumbnail);

        holder.postTitle.text = hotPostsResponseModel.data?.children?.get(position)?.data?.title
        holder.itemView.setOnClickListener{ clickListener(position) }

    }

    override fun getItemCount(): Int {
        return hotPostsResponseModel.data?.children?.size ?: 0
    }


}