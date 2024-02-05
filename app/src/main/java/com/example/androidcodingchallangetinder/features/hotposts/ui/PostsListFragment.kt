package com.example.androidcodingchallangetinder.features.hotposts.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcodingchallangetinder.R
import com.example.androidcodingchallangetinder.core.ResourceHolderStates
import com.example.androidcodingchallangetinder.databinding.FragmentPostsListBinding
import com.example.androidcodingchallangetinder.features.hotposts.model.HotPostsResponseModel
import com.example.androidcodingchallangetinder.features.hotposts.viewmodel.HotPostsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PostsListFragment : Fragment() {
    private var _binding: FragmentPostsListBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    private val hotPostsViewModel: HotPostsViewModel by viewModels()

    @Inject
    lateinit var postsListAdapter: PostsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        fetchPosts()
        setupObservers()

    }
    private fun gotoFragment() {
        findNavController().navigate(R.id.action_to_DetailsFragment)
    }

    private fun setupAdapter() {
        binding.apply {
            postsListAdapter = PostsListAdapter(HotPostsResponseModel()){}
//            { position ->
//                gotoFragment()
//            }
            postsRecyclerView.adapter = postsListAdapter
            val verticalLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            postsRecyclerView.layoutManager = verticalLayoutManager
            postsRecyclerView.addItemDecoration(
                DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            )

        }
    }

    private fun fetchPosts() {
            //lifecycleScope.launch {
                hotPostsViewModel.getAllHotPosts()
           // }

    }

    private fun setupObservers() {
        binding.apply {
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    hotPostsViewModel.hotPostsResponseModel.collect { uiState ->
                        when (uiState) {
                            is ResourceHolderStates.Success -> {
                                val value = uiState.value as HotPostsResponseModel
                                postsListAdapter = PostsListAdapter(value){ }
                                postsRecyclerView.adapter = postsListAdapter
                               hideProgressBar()
                            }

                            is ResourceHolderStates.Error -> {
                                val e = uiState.exception.message.toString()
                                Toast.makeText(context, e, Toast.LENGTH_LONG).show()
                            }

                            is ResourceHolderStates.Loading -> {
                                showProgressBar()
                            }

                            is ResourceHolderStates.Always -> {
                                hideProgressBar()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun hideProgressBar() {
        binding.apply {
            progressBar.visibility = View.INVISIBLE
        }
    }

    private fun showProgressBar() {
        binding.apply {
            progressBar.visibility = View.VISIBLE
        }
    }
}