package com.rsypj.tugas1.adapter

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.rsypj.tugas1.R
import kotlinx.android.synthetic.main.layout_grid_item.view.*

/**
 * Created by dhadotid on 20:15 | 2020-04-19.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class GridViewAdapter(private var filePath: Array<String?>,
                      private var fileName: Array<String?>): BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(p2?.context).inflate(R.layout.layout_grid_item, p2, false)
        val bmp = BitmapFactory.decodeFile(filePath[p0])
        view.photos.setImageBitmap(bmp)
        return view
    }

    override fun getCount(): Int {
        return filePath.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
}