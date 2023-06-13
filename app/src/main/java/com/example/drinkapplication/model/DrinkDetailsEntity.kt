package com.example.drinkapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drinkDetails")
data class DrinkDetailsEntity(

    val dateModified: String?,

    @PrimaryKey
    @ColumnInfo(name = "drinkId")
    val idDrink: String,

    @ColumnInfo(name = "drinkName")
    val strAlcoholic: String?,
    val strCategory: String?,
    val strCreativeCommonsConfirmed: String?,
    val strDrink: String?,
    val strDrinkAlternate: String?,
    @ColumnInfo(name = "drinkThumb")
    val strDrinkThumb: String?,
    val strGlass: String?,
    val strIBA: String?,
    val strImageAttribution: String?,
    val strImageSource: String?,
    @ColumnInfo(name = "ingredient1")
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strInstructions: String?,
    val strInstructionsDE: String?,
    val strInstructionsES: String?,
    val strInstructionsFR: String?,
    val strInstructionsIT: String?,
    val strInstructionsZH_HANS: String?,
    val strInstructionsZH_HANT: String?,
    val strMeasure1: String?,
    val strMeasure2: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?,
    val strTags: String?,
    val strVideo: String?
) {
    fun toDrinkDetails() =
        DrinkDetails(
            dateModified = dateModified,
            idDrink = idDrink,
            strAlcoholic = strAlcoholic,
            strCategory = strCategory,
            strCreativeCommonsConfirmed = strCreativeCommonsConfirmed,
            strDrink = strDrink,
            strDrinkAlternate = strDrinkAlternate,
            strDrinkThumb = strDrinkThumb,
            strGlass = strGlass,
            strIBA = strIBA,
            strImageAttribution = strImageAttribution,
            strImageSource = strImageSource,
            strIngredient1 = strIngredient1,
            strIngredient2 = strIngredient2,
            strIngredient3 = strIngredient3,
            strIngredient4 = strIngredient4,
            strIngredient5 = strIngredient5,
            strIngredient6 = strIngredient6,
            strIngredient7 = strIngredient7,
            strIngredient8 = strIngredient8,
            strIngredient9 = strIngredient9,
            strIngredient10 = strIngredient10,
            strIngredient11 = strIngredient11,
            strIngredient12 = strIngredient12,
            strIngredient13 = strIngredient13,
            strIngredient14 = strIngredient14,
            strIngredient15 = strIngredient15,
            strInstructions = strInstructions,
            strInstructionsDE = strInstructionsDE,
            strInstructionsES = strInstructionsES,
            strInstructionsFR = strInstructionsFR,
            strInstructionsIT = strInstructionsIT,
            strInstructionsZH_HANS = "",
            strInstructionsZH_HANT = "",
            strMeasure1 = strMeasure1,
            strMeasure2 = strMeasure2,
            strMeasure3 = strMeasure3,
            strMeasure4 = strMeasure4,
            strMeasure5 = strMeasure5,
            strMeasure6 = strMeasure6,
            strMeasure7 = strMeasure7,
            strMeasure8 = strMeasure8,
            strMeasure9 = strMeasure9,
            strMeasure10 = strMeasure10,
            strMeasure11 = strMeasure11,
            strMeasure12 = strMeasure12,
            strMeasure13 = strMeasure13,
            strMeasure14 = strMeasure14,
            strMeasure15 = strMeasure15,
            strTags = strTags,
            strVideo = strVideo
        )
}