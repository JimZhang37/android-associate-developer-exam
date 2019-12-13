package com.example.workmanagertest.ui.main


import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.workmanagertest.R
import com.example.workmanagertest.databinding.MainFragmentBinding
import com.example.workmanagertest.ui.add.AddActivity
import com.example.workmanagertest.ui.setting.SettingsActivity
import com.example.workmanagertest.ui.list.ListActivity
class MainFragment : Fragment() {
    lateinit var myButton: Button
    lateinit var binding: MainFragmentBinding
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater)
//        val view = inflater.inflate(R.layout.main_fragment, container, false)
//        myButton = view.findViewById<Button>(R.id.button)
        binding.button.setOnClickListener {
            onBtnClick()
        }

        setHasOptionsMenu(true)
//        activity?.title= "ABC"
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        binding.viewModel = viewModel
        viewModel.navigateToSearch.observe(viewLifecycleOwner,
            Observer<Boolean> { navigate ->
                if(navigate) {
//                    val navController = findNavController()
//                    navController.navigate(R.id.action_homeFragment_to_gdgListFragment)
                    openAddLetter()

                }
            })    }

    fun onBtnClick() {
        viewModel.notifyUser()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.main_menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
                settings()
                true
            }
            R.id.add_letter_activity -> {
                viewModel.onFabClicked()
                //showHelp()
                true
            }
            R.id.list_letter_activity -> {
                val intentList = Intent(context, ListActivity::class.java)
                startActivity(intentList)
                //showHelp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun openAddLetter() {
        val intentAdd = Intent(context, AddActivity::class.java)
        startActivity(intentAdd)
        viewModel.onNavigatedToSearch()
    }

    private fun settings() {
        val intent = Intent(context, SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun showHelp() {
        Toast.makeText(context, "Help!", Toast.LENGTH_SHORT).show()
    }
}
