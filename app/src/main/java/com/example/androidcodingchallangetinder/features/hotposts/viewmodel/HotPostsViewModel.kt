package com.example.androidcodingchallangetinder.features.hotposts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcodingchallangetinder.core.ResourceHolderStates
import com.example.androidcodingchallangetinder.features.hotposts.repository.HotPostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotPostsViewModel @Inject constructor(
    private val hotPostsRepository: HotPostsRepository
): ViewModel() {
    private val _hotPostsResponseModel = MutableStateFlow<ResourceHolderStates>(ResourceHolderStates.Loading())
    var hotPostsResponseModel: StateFlow<ResourceHolderStates> = _hotPostsResponseModel

    fun getAllHotPosts(){
        viewModelScope.launch {
            hotPostsRepository.getAllHotPosts().catch {
                    exception -> notifyError(_hotPostsResponseModel, exception)
            }
                .collect { latestPhotos ->
                    // Update View with the latestPhotos
                    _hotPostsResponseModel.value = ResourceHolderStates.Success(latestPhotos)
                }
        }
    }

    private fun notifyError(
        responseModel: MutableStateFlow<ResourceHolderStates>,
        exception: Throwable
    ) {
        responseModel.value = ResourceHolderStates.Error(exception)
    }

}