package com.example.idollist

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class idolInfo : AppCompatActivity()  {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.idol_view)
		Log.d("idol-data", "intent")
		val intent = intent
		val idolData:Array<String>? = intent.extras?.getStringArray("idol-data")

		if (idolData != null){
			val imageView = findViewById<ImageView>(R.id.face)
			val name = findViewById<TextView>(R.id.name)
			val group = findViewById<TextView>(R.id.group)
			val faceId:Int = resources.getIdentifier(idolData[0], "drawable", packageName)
			imageView.setImageDrawable(resources.getDrawable(faceId, this.theme))
			name.text = idolData[1]
			group.text = idolData[2]
		}
	}
}