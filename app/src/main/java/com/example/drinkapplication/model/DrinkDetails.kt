package com.example.drinkapplication.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class DrinkDetails(

    val dateModified: String?,

    @SerializedName("idDrink")
    val idDrink: String,

    val strAlcoholic: String?,
    val strCategory: String?,
    val strCreativeCommonsConfirmed: String?,
    @SerializedName("strDrink")
    val strDrink: String?,
    val strDrinkAlternate: String?,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String?,
    val strGlass: String?,
    val strIBA: String?,
    val strImageAttribution: String?,
    val strImageSource: String?,
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
    @SerializedName("strInstructionsZH_HANS")
    val strInstructionsZH_HANS: String?,
    @SerializedName("strInstructionsZH_HANT")
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
)


    //: Parcelable {
//    constructor(parcel: Parcel):this(
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(dateModified)
//        parcel.writeString(idDrink)
//        parcel.writeString(strAlcoholic)
//        parcel.writeString(strCategory)
//        parcel.writeString(strCreativeCommonsConfirmed)
//        parcel.writeString(strDrink)
//        parcel.writeString(strDrinkAlternate)
//        parcel.writeString(strDrinkThumb)
//        parcel.writeString(strGlass)
//        parcel.writeString(strIBA)
//        parcel.writeString(strImageAttribution)
//        parcel.writeString(strImageSource)
//        parcel.writeString(strIngredient1)
//        parcel.writeString(strIngredient2)
//        parcel.writeString(strIngredient3)
//        parcel.writeString(strIngredient4)
//        parcel.writeString(strIngredient5)
//        parcel.writeString(strIngredient6)
//        parcel.writeString(strIngredient7)
//        parcel.writeString(strIngredient8)
//        parcel.writeString(strIngredient9)
//        parcel.writeString(strIngredient10)
//        parcel.writeString(strIngredient11)
//        parcel.writeString(strIngredient12)
//        parcel.writeString(strIngredient13)
//        parcel.writeString(strIngredient14)
//        parcel.writeString(strIngredient15)
//        parcel.writeString(strInstructions)
//        parcel.writeString(strInstructionsDE)
//        parcel.writeString(strInstructionsES)
//        parcel.writeString(strInstructionsFR)
//        parcel.writeString(strInstructionsIT)
//        parcel.writeString(strInstructionsZH_HANS)
//        parcel.writeString(strInstructionsZH_HANT)
//        parcel.writeString(strMeasure1)
//        parcel.writeString(strMeasure2)
//        parcel.writeString(strMeasure3)
//        parcel.writeString(strMeasure4)
//        parcel.writeString(strMeasure5)
//        parcel.writeString(strMeasure6)
//        parcel.writeString(strMeasure7)
//        parcel.writeString(strMeasure8)
//        parcel.writeString(strMeasure9)
//        parcel.writeString(strMeasure10)
//        parcel.writeString(strMeasure11)
//        parcel.writeString(strMeasure12)
//        parcel.writeString(strMeasure13)
//        parcel.writeString(strMeasure14)
//        parcel.writeString(strMeasure15)
//        parcel.writeString(strTags)
//        parcel.writeString(strVideo)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<DrinkDetails> {
//        override fun createFromParcel(parcel: Parcel): DrinkDetails {
//            return DrinkDetails(parcel)
//        }
//        override fun newArray(size: Int): Array<DrinkDetails?> {
//            return arrayOfNulls(size)
//        }
//    }
//
//}
