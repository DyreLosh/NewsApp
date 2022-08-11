package ru.dyrelosh.newsapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.dyrelosh.newsapp.data.api.NewsRepository
import ru.dyrelosh.newsapp.models.NewsResponse
import ru.dyrelosh.newsapp.utils.Resource
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    val searchNewLiveData: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val pageNumber = 1

    fun getSearchNews(query: String) {
        viewModelScope.launch {
            searchNewLiveData.postValue(Resource.Loading())
            val response = repository.searchNews(query, pageNumber)
            if (response.isSuccessful) {
                response.body().let { res ->
                    searchNewLiveData.postValue(Resource.Success(res))
                }
            } else {
                searchNewLiveData.postValue(Resource.Error(response.message()))
            }
        }
    }

}