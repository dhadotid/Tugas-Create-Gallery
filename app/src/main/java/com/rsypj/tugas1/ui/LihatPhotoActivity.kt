package com.rsypj.tugas1.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rsypj.tugas1.R
import kotlinx.android.synthetic.main.activity_photo_detail.*

/**
 * Created by dhadotid on 20:26 | 2020-04-19.
 * -> ✉ : yudhapurbajagad@gmail.com <-
 */

class LihatPhotoActivity: AppCompatActivity() {

    private lateinit var filePathString: Array<String?>
    private lateinit var fileNameString: Array<String?>
    private var position: Int = 0

    companion object{
        const val KEY_FILE_PATH = "filepath"
        const val KEY_FILE_NAME = "filename"
        const val KEY_POSITION = "position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)

        intent.extras?.let {
            it.apply {
                if (it.containsKey(KEY_FILE_PATH)){
                    getStringArray(KEY_FILE_PATH)?.let {filePath ->
                        filePathString = filePath
                    }
                }
                if (it.containsKey(KEY_FILE_NAME)){
                    getStringArray(KEY_FILE_NAME)?.let { fileName ->
                        fileNameString = fileName
                    }
                }
                if (it.containsKey(KEY_POSITION)){
                    getInt(KEY_POSITION)?.let { posisions ->
                        position = posisions
                    }
                }
            }
        }

        full_text.text = fileNameString[position]
        val bmp = BitmapFactory.decodeFile(filePathString[position])
        full_photos.setImageBitmap(bmp)
    }
}