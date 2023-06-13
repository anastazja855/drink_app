package com.example.drinkapplication.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.drinkapplication.model.Drink
import javax.inject.Inject

class NonAlcoholicDrinkSource @Inject constructor(
    private val repository: CocktailRepository
) : PagingSource<Int, Drink>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Drink> {
        val page = params.key ?: 1
        val response = repository.getNonAlcoholicDrinks()
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
