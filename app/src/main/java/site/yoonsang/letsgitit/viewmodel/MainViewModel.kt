package site.yoonsang.letsgitit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import site.yoonsang.domain.model.SearchedRepos
import site.yoonsang.domain.usecase.GetSearchedReposUseCase
import site.yoonsang.letsgitit.utils.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSearchedRepos: GetSearchedReposUseCase
): ViewModel() {

    val searchedRepos: LiveData<SearchedRepos>
        get() = _searchedRepos
    private val _searchedRepos = SingleLiveEvent<SearchedRepos>()

    fun searchRepos(query: String, page: Int) {
        viewModelScope.launch {
            val response = getSearchedRepos(query, page)
            _searchedRepos.value = response
        }
    }
}