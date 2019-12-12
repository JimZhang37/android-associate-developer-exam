package com.example.workmanagertest.ui.list.ui.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workmanagertest.MyApplication
import com.example.workmanagertest.R
import com.example.workmanagertest.data.Letter

import com.example.workmanagertest.util.MyViewModelFactory

class ListFragment : Fragment() {
    lateinit var letterListRV: RecyclerView
    private lateinit var adapterRV: ListAdapter
    private lateinit var layoutManagerRV: GridLayoutManager

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.list_fragment, container, false)

        adapterRV = ListAdapter()
        layoutManagerRV = GridLayoutManager(context,2)
        letterListRV = view.findViewById<RecyclerView>(R.id.recycler).apply {
            adapter = adapterRV
            layoutManager = layoutManagerRV
        }




        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this, MyViewModelFactory(activity?.application as MyApplication))
                .get(ListViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.data.observe(this, Observer<PagedList<Letter>> {
            Log.d("Letter refreshed","Observer: ${it.size}")

            adapterRV.submitList(it)
        })
    }

}
