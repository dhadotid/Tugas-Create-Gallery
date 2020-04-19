package com.rsypj.tugas1.ui

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rsypj.tugas1.R
import com.rsypj.tugas1.adapter.GridViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

/**
 * Created by dhadotid on 19:57 | 2020-04-19.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class MainActivity: AppCompatActivity() {

    private lateinit var filePathString: Array<String?>
    private lateinit var fileNameString: Array<String?>
    private lateinit var listFile: Array<File?>
    private lateinit var adapter: GridViewAdapter
    private lateinit var file: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Environment.getExternalStorageState() != Environment.MEDIA_MOUNTED){
            Toast.makeText(this, "Masukan kartu memori", Toast.LENGTH_LONG)
                .show()
        }else{
            file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString() + File.separator + "Camera")
            file?.mkdir()
        }

        if (file?.isDirectory){
            listFile = file?.listFiles()
            filePathString = arrayOfNulls(listFile.size)
            fileNameString = arrayOfNulls(listFile.size)

            for (b in listFile.indices){
                filePathString[b] = listFile[b]?.absolutePath
                fileNameString[b] = listFile[b]?.name
            }
        }

        adapter = GridViewAdapter(
            filePathString,
            fileNameString
        )
        main_gridView.adapter = adapter
        main_gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val b = Intent(this@MainActivity, LihatPhotoActivity::class.java)
                b.putExtra(LihatPhotoActivity.KEY_FILE_PATH, filePathString)
                b.putExtra(LihatPhotoActivity.KEY_FILE_NAME, fileNameString)
                b.putExtra(LihatPhotoActivity.KEY_POSITION, position)
                startActivity(b)
            }
    }
}