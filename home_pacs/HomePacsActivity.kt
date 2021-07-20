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

import aacmvi.AacMviActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.uetailab.aipacs.R

class HomePacsActivity : AacMviActivity<HomePacsState, HomePacsEffect, HomePacsEvent, HomePacsVM>(){

    companion object {
        const val TAG = "HomePacsActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homePacs)


    }
    override val viewModel: HomePacsVM by viewModels()

    override fun renderViewState(viewState: HomePacsState) {
//        TODO("Not yet implemented")
    }

    override fun renderViewEffect(viewEffect: HomePacsEffect) {
//        TODO("Not yet implemented")
    }

//    override fun onDataPass(data: String) {
//        Log.w(TAG, "onDataPass: ${data}")
//    }
//
//    override fun onViewModelPass(viewModel: CasesViewVM) {
//        toast(viewModel.getMessage())
//        frag_video_playback_bottom.ed_phone.setText(viewModel.getMessage())
//    }

}
