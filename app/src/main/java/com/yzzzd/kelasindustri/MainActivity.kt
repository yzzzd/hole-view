package com.yzzzd.kelasindustri

import android.os.Bundle
import com.crocodic.core.base.activity.NoViewModelActivity
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.yzzzd.kelasindustri.data.Item
import com.yzzzd.kelasindustri.databinding.ActivityMainBinding
import com.yzzzd.kelasindustri.databinding.ItemDataBinding

class MainActivity : NoViewModelActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val adapter by lazy {
        val _adapter = ReactiveListAdapter<ItemDataBinding, Item>(R.layout.item_data)
        binding.rvList.adapter = _adapter
        _adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        generateItem()
    }

    private fun generateItem() {
        val items = ArrayList<Item>()
        repeat(50) {
            items.add(
                Item(
                    resources.getStringArray(R.array.array_title).random(),
                    resources.getStringArray(R.array.array_content).random()
                )
            )
        }
        adapter.submitList(items)
    }
}