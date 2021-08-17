package br.com.juniorbraga.frameworkteste.ui.main.fragment.albuns

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.juniorbraga.frameworkteste.databinding.FragmentAlbunsBinding
import br.com.juniorbraga.frameworkteste.model.Album
import kotlinx.android.synthetic.main.fragment_albuns.*

class AlbunsFragment : Fragment() {

    private lateinit var albunsViewModel: AlbunsViewModel
    private var _binding: FragmentAlbunsBinding? = null

    private val binding get() = _binding!!

    var albunAdapter: AlbunsAdapter? = null
    val albunListUpdateObserver: Observer<List<Album>> =
        Observer<List<Album>> { albuntArrayList ->
            albunAdapter = AlbunsAdapter(albuntArrayList,this.context)
            rvAlbum.setLayoutManager(LinearLayoutManager(this.context))
            rvAlbum.setAdapter(this.albunAdapter) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        albunsViewModel =
            ViewModelProvider(this).get(AlbunsViewModel::class.java)

        _binding = FragmentAlbunsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        this.albunsViewModel.albunsList?.observe(this.viewLifecycleOwner, this.albunListUpdateObserver);
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}