package com.example.drinkapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoriteDrink")
data class Drink(
    @PrimaryKey
    @ColumnInfo (name = "drinkId")
    val idDrink: String,
    @ColumnInfo(name = "drinkName")
    val strDrink: String,
    @ColumnInfo(name = "drinkThumb")
    val strDrinkThumb: String,
//    val strAlcoholic: String,
    @ColumnInfo(name = "ingredient1")
    val strIngredient1: String,
    @ColumnInfo(name = "ingredient2")
    val strIngredient2: String,
    @ColumnInfo(name = "ingredient3")
    val strIngredient3: String,
    @ColumnInfo(name = "ingredient4")
    val strIngredient4: String,
    @ColumnInfo (name = "measure1")
    val strMeasure1: String,
    @ColumnInfo (name = "measure2")
    val strMeasure2: String?,
    @ColumnInfo (name = "measure3")
    val strMeasure3: String?,
    @ColumnInfo (name = "measure4")
    val strMeasure4: String?,
    @ColumnInfo (name = "measure5")
    val strMeasure5: String?,
//    val strMeasure6: Any,
//    val strMeasure7: Any,
//    val strMeasure8: Any,
//    val strMeasure9: Any,
//    val strMeasure10: Any,
//    val strMeasure11: Any,
//    val strMeasure12: Any,
//    val strMeasure13: Any,
//    val strMeasure14: Any,
//    val strMeasure15: Any


)