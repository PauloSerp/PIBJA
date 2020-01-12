package com.example.pibja.Async

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.example.pibja.R
import java.lang.Exception
import java.net.URL

class DownloadImagem(val imageView: ImageView, val progress: ProgressBar): AsyncTask<String, Void, Bitmap>(){
    override fun doInBackground(vararg params: String?): Bitmap? {
        val url = params[0]

        try {
            val stream = URL(url).openStream()
            val bitmap = BitmapFactory.decodeStream(stream)

            return bitmap
        }catch (e: Exception){
            Log.e("DownloadImagem", ""+e)
            return null
        }

    }

    override fun onPostExecute(result: Bitmap?) {
        if (result != null){
            progress.visibility = View.GONE
            imageView.setImageBitmap(result)
            imageView.visibility = View.VISIBLE
        }else{
            progress.visibility = View.GONE
            imageView.setImageResource(R.drawable.errobaixar)
            Log.e("DownloadImagem", "Erro ao baixar")
        }

    }


}