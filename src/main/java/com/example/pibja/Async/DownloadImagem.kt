package com.example.pibja.Async

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import java.net.URL

class DownloadImagem(val imageView: ImageView, val progress: ProgressBar): AsyncTask<String, Void, Bitmap>(){
    override fun doInBackground(vararg params: String?): Bitmap {
        val url = params[0]

        val stream = URL(url).openStream()
        val bitmap = BitmapFactory.decodeStream(stream)

        return bitmap
    }

    override fun onPostExecute(result: Bitmap?) {
        progress.visibility = View.GONE
        imageView.setImageBitmap(result)
    }


}