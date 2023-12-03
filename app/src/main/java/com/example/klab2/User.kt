package com.example.klab2

data class Private(val password:String, val emailorphone:String)
data class Word(val full:Int, val word1:String, val word2:String, val word3:String, val word4:String, val word5:String)

data class GetItems(val exciting_bgm:ItemSet, val sea_bgm:ItemSet,val soft_bgm:ItemSet,val crown_set:ItemSet,val hanbok_set:ItemSet,val swim_set:ItemSet,val spring_theme:ItemSet,val summer_theme:ItemSet,val autumn_theme:ItemSet, val winter_theme:ItemSet,val forest_bgm:ItemSet, val forest_theme:ItemSet, val forest_set:ItemSet)

data class ItemSet(val bought:Int, val chose:Int)