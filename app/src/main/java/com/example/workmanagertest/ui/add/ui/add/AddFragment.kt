package com.example.workmanagertest.ui.add.ui.add

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.workmanagertest.MainActivity
import com.example.workmanagertest.MyApplication
import com.example.workmanagertest.R
import com.example.workmanagertest.util.MyViewModelFactory
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment() {
    private lateinit var title: EditText
    private lateinit var content: EditText

    companion object {
        fun newInstance() = AddFragment()
    }

    private lateinit var viewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.add_fragment, container, false)
        title = view.findViewById<EditText>(R.id.title_et)
        content = view.findViewById<EditText>(R.id.content_et)
        setHasOptionsMenu(true)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(
                this,
                MyViewModelFactory(activity?.application as MyApplication)
            )
                .get(AddViewModel::class.java)
        // TODO: Use the ViewModel
        val dateFormat = SimpleDateFormat("yy/MM/dd HH:mm");

        val date = Date(viewModel.created);
        val currentTime = dateFormat.format(date);
        activity?.title = currentTime
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)

        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_letter -> {
                viewModel.save(title.text.toString(), content.text.toString())
                val intentHome = Intent(context, MainActivity::class.java)
                startActivity(intentHome)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
