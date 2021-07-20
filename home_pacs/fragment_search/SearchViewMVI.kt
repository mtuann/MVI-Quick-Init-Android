/*
 * Copyright 2021 UET-AILAB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uetailab.aipacs.home_pacs.fragment_search

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewMVI {

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: SearchViewMVI? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: SearchViewMVI()
                        .also { instance = it }
            }

        const val TAG = "SearchViewMVI"

        fun process(searchViewVM: SearchViewVM, SearchViewEvent: SearchViewEvent) {
            getInstance().process(searchViewVM, SearchViewEvent)
        }

        fun renderViewState(searchViewFragment: SearchViewFragment, viewState: SearchViewState) {
            getInstance().renderViewState(searchViewFragment, viewState)
        }

        fun renderViewEffect(searchViewFragment: SearchViewFragment, viewEffect: SearchViewEffect) {
            getInstance().renderViewEffect(searchViewFragment, viewEffect)
        }
    }

    private fun renderViewEffect(searchViewFragment: SearchViewFragment, viewEffect: SearchViewEffect) {

    }

    private fun renderViewState(searchViewFragment: SearchViewFragment, viewState: SearchViewState) {

    }

    fun process(searchViewVM: SearchViewVM, searchViewEvent: SearchViewEvent) {

        when (searchViewEvent) {

        }
    }

    inner class Reducer(viewModel: SearchViewVM, viewState: SearchViewState, val viewEvent: SearchViewEvent)
        : SearchViewReducer(viewModel, viewState, viewEvent) {
        override fun reduce(): SearchViewObject {
            when(viewEvent) {

            }
            return SearchViewObject()
        }

    }

    inner class ReducerAsync(viewModel: SearchViewVM, viewState: SearchViewState, viewEvent: SearchViewEvent) : SearchViewReducer(viewModel, viewState, viewEvent) {

        override fun reduce(): SearchViewObject {
            viewModel.viewModelScope.launch {
                val result = asyncRun()
                viewModel.viewStates().value?.let {
                    viewModel.reduce(SearchViewObject())
                }
            }
            return SearchViewObject()
        }

        suspend fun asyncRun() : Int = withContext(Dispatchers.IO) {
            repeat(100000000) {
                100*100
            }
            return@withContext 1234
        }
    }
}
