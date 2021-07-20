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

import aacmvi.AacMviFragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.uetailab.aipacs.R
import kotlinx.android.synthetic.main.dialog_login.*

class SearchViewFragment: AacMviFragment<SearchViewState, SearchViewEffect, SearchViewEvent, SearchViewVM>() {

    interface OnDataPass {
        fun onDataPass(data: String)
        fun onViewModelPass(viewModel: SearchViewVM)
    }

    lateinit var dataPasser: OnDataPass

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as OnDataPass
    }

    fun passData(data: String){
        dataPasser.onViewModelPass(viewModel)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_playback, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bt_ok.setOnClickListener {
            viewModel.addCountToMessage()
            ed_full_name.setText(viewModel.getMessage())
            passData(viewModel.getMessage())
        }
    }



    override val viewModel: SearchViewVM by viewModels()
//        get() = TODO("Not yet implemented")


    override fun renderViewState(viewState: SearchViewState) {
//        TODO("Not yet implemented")
    }

    override fun renderViewEffect(viewEffect: SearchViewEffect) {

//        TODO("Not yet implemented")
    }

}