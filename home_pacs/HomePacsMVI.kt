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

package com.uetailab.aipacs.home_pacs

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomePacsMVI {

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: HomePacsMVI? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: HomePacsMVI()
                        .also { instance = it }
            }

        const val TAG = "HomePacsMVI"

        fun process(homePacsVM: HomePacsVM, HomePacsEvent: HomePacsEvent) {
            getInstance().process(homePacsVM, HomePacsEvent)
        }

        fun renderViewState(homePacsActivity: HomePacsActivity, viewState: HomePacsState) {
            getInstance().renderViewState(homePacsActivity, viewState)
        }

        fun renderViewEffect(homePacsActivity: HomePacsActivity, viewEffect: HomePacsEffect) {
            getInstance().renderViewEffect(homePacsActivity, viewEffect)
        }
    }

    private fun renderViewEffect(homePacsActivity: HomePacsActivity, viewEffect: HomePacsEffect) {

    }

    private fun renderViewState(homePacsActivity: HomePacsActivity, viewState: HomePacsState) {

    }

    fun process(homePacsVM: HomePacsVM, homePacsEvent: HomePacsEvent) {

        when (homePacsEvent) {

        }
    }

    inner class Reducer(viewModel: HomePacsVM, viewState: HomePacsState, val viewEvent: HomePacsEvent)
        : HomePacsReducer(viewModel, viewState, viewEvent) {
        override fun reduce(): HomePacsObject {
            when(viewEvent) {

            }
            return HomePacsObject()
        }

    }

    inner class ReducerAsync(viewModel: HomePacsVM, viewState: HomePacsState, viewEvent: HomePacsEvent) : HomePacsReducer(viewModel, viewState, viewEvent) {

        override fun reduce(): HomePacsObject {
            viewModel.viewModelScope.launch {
                val result = asyncRun()
                viewModel.viewStates().value?.let {
                    viewModel.reduce(HomePacsObject())
                }
            }
            return HomePacsObject()
        }

        suspend fun asyncRun() : Int = withContext(Dispatchers.IO) {
            repeat(100000000) {
                100*100
            }
            return@withContext 1234
        }
    }
}