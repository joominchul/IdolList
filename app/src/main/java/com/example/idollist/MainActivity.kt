package com.example.idollist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

class MainActivity : AppCompatActivity() {

	val idolInfo = mutableListOf<List<String>>(
		listOf("eu", "이유", "에버글로우"), listOf("sihyeon", "시현", "에버글로우"),
		listOf("onda", "온다", "에버글로우"), listOf("aisha", "아샤", "에버글로우"),
		listOf("mia", "미아", "에버글로우"), listOf("yiren", "이런", "에버글로우"),
		listOf("juri", "쥬리", "로켓펀치"), listOf("yeonhee", "연희", "로켓펀치"),
		listOf("suyun", "수윤", "로켓펀치"), listOf("yunkyoung", "윤경", "로켓펀치"),
		listOf("sohee", "소희", "로켓펀치"), listOf("dahyun", "다현", "로켓펀치"),)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val idolList = mutableListOf<idol>()

		for (n in 0..(idolInfo.size-1)){
			idolList.add(idol(idolInfo[n][0], idolInfo[n][1], idolInfo[n][2]))
		}

		val list_item = findViewById<LinearLayoutCompat>(R.id.list_item)
		val inflater= LayoutInflater.from(this@MainActivity)
		idolList.forEach{
			val idolImageView = inflater.inflate(R.layout.item_view, null)
			val idolImage = idolImageView.findViewById<ImageView>(R.id.face)
			val name = idolImageView.findViewById<TextView>(R.id.name)
			val group = idolImageView.findViewById<TextView>(R.id.group)
			val faceId:Int = resources.getIdentifier(it.face, "drawable", packageName)
			idolImage.setImageDrawable(resources.getDrawable(faceId, this.theme))
			name.text = it.name
			group.text = it.group

			list_item.addView(idolImageView)

		}

	}
}

class idol(val face:String, val name:String, val group: String){

}