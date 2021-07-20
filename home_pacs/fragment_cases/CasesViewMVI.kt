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

package com.uetailab.aipacs.home_pacs.fragment_cases

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CasesViewMVI {

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: CasesViewMVI? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: CasesViewMVI()
                        .also { instance = it }
            }

        const val TAG = "CasesViewMVI"

        fun process(casesViewVM: CasesViewVM, CasesViewEvent: CasesViewEvent) {
            getInstance().process(casesViewVM, CasesViewEvent)
        }

        fun renderViewState(casesViewFragment: CasesViewFragment, viewState: CasesViewState) {
            getInstance().renderViewState(casesViewFragment, viewState)
        }

        fun renderViewEffect(casesViewFragment: CasesViewFragment, viewEffect: CasesViewEffect) {
            getInstance().renderViewEffect(casesViewFragment, viewEffect)
        }
    }

    private fun renderViewEffect(casesViewFragment: CasesViewFragment, viewEffect: CasesViewEffect) {

    }

    private fun renderViewState(casesViewFragment: CasesViewFragment, viewState: CasesViewState) {

    }

    fun process(casesViewVM: CasesViewVM, casesViewEvent: CasesViewEvent) {

        when (casesViewEvent) {

        }
    }

    inner class Reducer(viewModel: CasesViewVM, viewState: CasesViewState, val viewEvent: CasesViewEvent)
        : CasesViewReducer(viewModel, viewState, viewEvent) {
        override fun reduce(): CasesViewObject {
            when(viewEvent) {

            }
            return CasesViewObject()
        }

    }

    inner class ReducerAsync(viewModel: CasesViewVM, viewState: CasesViewState, viewEvent: CasesViewEvent) : CasesViewReducer(viewModel, viewState, viewEvent) {

        override fun reduce(): CasesViewObject {
            viewModel.viewModelScope.launch {
                val result = asyncRun()
                viewModel.viewStates().value?.let {
                    viewModel.reduce(CasesViewObject())
                }
            }
            return CasesViewObject()
        }

        suspend fun asyncRun() : Int = withContext(Dispatchers.IO) {
            repeat(100000000) {
                100*100
            }
            return@withContext 1234
        }
    }
}
