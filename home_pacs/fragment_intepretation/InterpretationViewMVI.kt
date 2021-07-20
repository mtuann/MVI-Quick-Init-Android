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

package com.uetailab.aipacs.home_pacs.fragment_intepretation

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InterpretationViewMVI {

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: InterpretationViewMVI? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: InterpretationViewMVI()
                        .also { instance = it }
            }

        const val TAG = "InterpretationViewMVI"

        fun process(interpretationViewVM: InterpretationViewVM, InterpretationViewEvent: InterpretationViewEvent) {
            getInstance().process(interpretationViewVM, InterpretationViewEvent)
        }

        fun renderViewState(interpretationViewFragment: InterpretationViewFragment, viewState: InterpretationViewState) {
            getInstance().renderViewState(interpretationViewFragment, viewState)
        }

        fun renderViewEffect(interpretationViewFragment: InterpretationViewFragment, viewEffect: InterpretationViewEffect) {
            getInstance().renderViewEffect(interpretationViewFragment, viewEffect)
        }
    }

    private fun renderViewEffect(interpretationViewFragment: InterpretationViewFragment, viewEffect: InterpretationViewEffect) {

    }

    private fun renderViewState(interpretationViewFragment: InterpretationViewFragment, viewState: InterpretationViewState) {

    }

    fun process(interpretationViewVM: InterpretationViewVM, interpretationViewEvent: InterpretationViewEvent) {

        when (interpretationViewEvent) {

        }
    }

    inner class Reducer(viewModel: InterpretationViewVM, viewState: InterpretationViewState, val viewEvent: InterpretationViewEvent)
        : InterpretationViewReducer(viewModel, viewState, viewEvent) {
        override fun reduce(): InterpretationViewObject {
            when(viewEvent) {

            }
            return InterpretationViewObject()
        }

    }

    inner class ReducerAsync(viewModel: InterpretationViewVM, viewState: InterpretationViewState, viewEvent: InterpretationViewEvent) : InterpretationViewReducer(viewModel, viewState, viewEvent) {

        override fun reduce(): InterpretationViewObject {
            viewModel.viewModelScope.launch {
                val result = asyncRun()
                viewModel.viewStates().value?.let {
                    viewModel.reduce(InterpretationViewObject())
                }
            }
            return InterpretationViewObject()
        }

        suspend fun asyncRun() : Int = withContext(Dispatchers.IO) {
            repeat(100000000) {
                100*100
            }
            return@withContext 1234
        }
    }
}
