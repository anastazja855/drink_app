package com.example.drinkapplication.repository

import android.text.Layout
import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.drinkapplication.model.Drink
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch
import javax.inject.Inject

class AlcoholicDrinkSource @Inject constructor(
    private val repository: CocktailRepository
) : PagingSource<Int, Drink>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Drink> {
        val page = params.key ?: 1
        val response = repository.getAlcoholicDrinks()
        return if (response.isSuccessful)
            return LoadResult.Page(
                response.body()?.drinks?: arrayListOf(),
                prevKey = null,
                nextKey = page+1
            )

        else LoadResult.Error(Exception())
    }

    override fun getRefreshKey(state: PagingState<Int, Drink>): Int? {
        return 1
    }
}

