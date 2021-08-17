package br.com.juniorbraga.frameworkteste.ui.main.fragment.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.juniorbraga.frameworkteste.databinding.FragmentPostBinding
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.juniorbraga.frameworkteste.model.Post
import kotlinx.android.synthetic.main.fragment_post.*


class PostFragment : Fragment() {

    private lateinit var dashboardViewModel: PostViewModel
    private var _binding: FragmentPostBinding? = null
    private val binding get() = _binding!!

    var postAdapter: PostAdapter? = null
    val postListUpdateObserver: Observer<List<Post>> =
        Observer<List<Post>> { postArrayList ->
            postAdapter = PostAdapter(postArrayList,this.context)
            rvPost.setLayoutManager(LinearLayoutManager(this.context))
            rvPost.setAdapter(this.postAdapter) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.dashboardViewModel =
            ViewModelProvider(this).get(PostViewModel::class.java)

        this._binding = FragmentPostBinding.inflate(inflater, container, false)
        val root: View = this.binding.root

        this.dashboardViewModel.postList?.observe(this.viewLifecycleOwner, this.postListUpdateObserver);
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}