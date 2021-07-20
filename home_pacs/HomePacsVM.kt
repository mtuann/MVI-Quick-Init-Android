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

import aacmvi.AacMviViewModel
import android.app.Application

class HomePacsVM(application: Application) : AacMviViewModel<HomePacsState, HomePacsEffect, HomePacsEvent>(application) {
    companion object {
        const val TAG = "HomePacsVM"
    }
    init {
        viewState = HomePacsState(
            status = HomePacsStatus.Start,
            message = "Start-HomePacs-Activity"
        )
    }



    fun reduce(reducer: HomePacsReducer) {
        val result = reducer.reduce()
        reduce(result)
    }


    fun reduce(result: HomePacsObject) {
        result.viewState?.let { viewState = it }
        result.viewEffect?.let { viewEffect = it }
    }
}