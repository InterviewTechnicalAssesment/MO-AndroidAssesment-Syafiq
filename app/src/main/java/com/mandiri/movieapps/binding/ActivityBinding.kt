/*
 * Designed and developed by 2020 Syafiq Muhammad
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mandiri.movieapps.binding

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.mandiri.movieapps.R
import com.mandiri.movieapps.extension.checkIsMaterialVersion
import com.mandiri.movieapps.extension.getStatusBarSize

fun AppCompatActivity.simpleToolbarWithHome(toolbar: MaterialToolbar, title_: String = "") {
  setSupportActionBar(toolbar)
  supportActionBar?.run {
    setDisplayHomeAsUpEnabled(true)
    setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
    title = title_
  }
  if (checkIsMaterialVersion() && toolbar.layoutParams is CollapsingToolbarLayout.LayoutParams) {
    toolbar.layoutParams = (toolbar.layoutParams as CollapsingToolbarLayout.LayoutParams).apply {
      topMargin = getStatusBarSize()
    }
  }
}

@BindingAdapter("simpleToolbarWithHome", "simpleToolbarTitle")
fun bindToolbarWithTitle(toolbar: MaterialToolbar, activity: AppCompatActivity, title: String) {
  activity.simpleToolbarWithHome(toolbar, title)
}