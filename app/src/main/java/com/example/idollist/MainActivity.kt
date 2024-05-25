package com.example.idollist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

	val idolData = mutableListOf<List<String>>(
		listOf("eu", "이유", "에버글로우"), listOf("sihyeon", "시현", "에버글로우"),
		listOf("onda", "온다", "에버글로우"), listOf("aisha", "아샤", "에버글로우"),
		listOf("mia", "미아", "에버글로우"), listOf("yiren", "이런", "에버글로우"),
		listOf("juri", "쥬리", "로켓펀치"), listOf("yeonhee", "연희", "로켓펀치"),
		listOf("suyun", "수윤", "로켓펀치"), listOf("yunkyoung", "윤경", "로켓펀치"),
		listOf("sohee", "소희", "로켓펀치"), listOf("dahyun", "다현", "로켓펀치"),)
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



			list_item.addView(idolImageView)

		}

	}
}
