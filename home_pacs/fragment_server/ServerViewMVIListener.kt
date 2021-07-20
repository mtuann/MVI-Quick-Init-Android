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

package com.uetailab.aipacs.home_pacs.fragment_server

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ServerViewMVIListener(val listener: ProgressDownloadListener) {

    interface ProgressDownloadListener {
        fun update(bytesRead: Long, contentLength: Long, done: Boolean)
    }

    companion object {
        const val TAG = "ServerViewMVIListener"
    }

    private fun renderViewEffect(homePacsFragment: ServerViewFragment, viewEffect: ServerViewEffect) {

    }

    private fun renderViewState(homePacsFragment: ServerViewFragment, viewState: ServerViewState) {

    }

    fun process(homePacsVM: ServerViewVM, homePacsEvent: ServerViewEvent) {

        when (homePacsEvent) {

        }
    }

    inner class Reducer(viewModel: ServerViewVM, viewState: ServerViewState, val viewEvent: ServerViewEvent)
        : ServerViewReducer(viewModel, viewState, viewEvent) {
        override fun reduce(): ServerViewObject {
            when(viewEvent) {

            }
            return ServerViewObject()
        }

    }

    inner class ReducerAsync(viewModel: ServerViewVM, viewState: ServerViewState, viewEvent: ServerViewEvent) : ServerViewReducer(viewModel, viewState, viewEvent) {

        override fun reduce(): ServerViewObject {
            viewModel.viewModelScope.launch {
                val result = asyncRun()
                viewModel.viewStates().value?.let {
                    viewModel.reduce(ServerViewObject())
                }
            }
            return ServerViewObject()
        }

        suspend fun asyncRun() : Int = withContext(Dispatchers.IO) {
            repeat(100000000) {
                100*100
            }
            return@withContext 1234
        }
    }
}
