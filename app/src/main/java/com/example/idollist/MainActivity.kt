package com.example.idollist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

	val idolData = arrayOf(
		arrayOf("eu", "이유", "에버글로우"), arrayOf("sihyeon", "시현", "에버글로우"),
		arrayOf("onda", "온다", "에버글로우"), arrayOf("aisha", "아샤", "에버글로우"),
		arrayOf("mia", "미아", "에버글로우"), arrayOf("yiren", "이런", "에버글로우"),
		arrayOf("juri", "쥬리", "로켓펀치"), arrayOf("yeonhee", "연희", "로켓펀치"),
		arrayOf("suyun", "수윤", "로켓펀치"), arrayOf("yunkyoung", "윤경", "로켓펀치"),
		arrayOf("sohee", "소희", "로켓펀치"), arrayOf("dahyun", "다현", "로켓펀치"),)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val list_item = findViewById<LinearLayoutCompat>(R.id.list_item)
		val inflater= LayoutInflater.from(this@MainActivity)
		idolData.forEach{
			val idolImageView = inflater.inflate(R.layout.item_view, null)
			val idolImage = idolImageView.findViewById<ImageView>(R.id.face)
			val name = idolImageView.findViewById<TextView>(R.id.name)
			val group = idolImageView.findViewById<TextView>(R.id.group)
			val faceId:Int = resources.getIdentifier(it[0], "drawable", packageName)
			idolImage.setImageDrawable(resources.getDrawable(faceId, this.theme))
			name.text = it[1]
			group.text = it[2]
			val idolData = it
			idolImageView.setOnClickListener {
				val intent = Intent(this@MainActivity, idolInfo::class.java)
				intent.putExtra("idol-data", idolData)
				Log.d("idol-data", idolData[1])
				startActivity(intent)
			}

			list_item.addView(idolImageView)

		}

	}
}
