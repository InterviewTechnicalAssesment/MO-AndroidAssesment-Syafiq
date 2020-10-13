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

package com.mandiri.movieapps.view.adapter

import android.view.View
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow
import com.mandiri.movieapps.R
import com.mandiri.movieapps.models.entity.Genres
import com.mandiri.movieapps.view.viewholder.MovieListViewHolder

class GenreListAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Genres>())
    }


    fun addGenreList(genre: List<Genres>) {
        val section = sections()[0]
        section.addAll(genre)
        notifyItemRangeInserted(section.size + 1, genre.size)
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_genre

    override fun viewHolder(layout: Int, view: View) = MovieListViewHolder(view)
}