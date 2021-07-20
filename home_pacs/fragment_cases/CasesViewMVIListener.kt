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

class CasesViewMVIListener(val listener: ProgressDownloadListener) {

    interface ProgressDownloadListener {
        fun update(bytesRead: Long, contentLength: Long, done: Boolean)
    }

    companion object {
        const val TAG = "CasesViewMVIListener"
    }

    private fun renderViewEffect(homePacsFragment: CasesViewFragment, viewEffect: CasesViewEffect) {

    }

    private fun renderViewState(homePacsFragment: CasesViewFragment, viewState: CasesViewState) {

    }

    fun process(homePacsVM: CasesViewVM, homePacsEvent: CasesViewEvent) {

        when (homePacsEvent) {

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
