package ru.babaets.catfacts.presentation.facts

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.babaets.catfacts.R
import ru.babaets.catfacts.common.color
import ru.babaets.catfacts.common.formatApiDateTime
import ru.babaets.catfacts.data.model.Fact
import ru.babaets.catfacts.databinding.FragmentFactsBinding
import ru.babaets.catfacts.presentation.common.BaseFragment

class FactsFragment : BaseFragment<FactsViewModel>() {

    override val layoutRes: Int = R.layout.fragment_facts

    override val viewModel: FactsViewModel by viewModel<FactsViewModelImpl>()

    private val binding: FragmentFactsBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            btnNewFact.setOnClickListener {
                viewModel.onNewFactPressed()
            }
            btnHistory.setOnClickListener {
                viewModel.onHistoryPressed()
            }
        }

        viewModel.factLiveData.observe(viewLifecycleOwner, ::populateFact)
        viewModel.pictureLiveData.observe(viewLifecycleOwner, ::populatePicture)
    }

    override fun populateProgress(isLoading: Boolean) {
        binding.progress.isVisible = isLoading
    }

    override fun populateError(exception: Throwable?) {
        binding.layoutError.root.isVisible = exception != null
        exception ?: return

        binding.layoutError.run {
            tvErrorMessage.text = exception.message
            btnErrorAction.run {
                setText(R.string.retry)
                setOnClickListener {
                    viewModel.onRetryPressed()
                }
            }
        }
    }

    private fun populatePicture(url: String) {
        binding.ivPicture.setBackgroundColor(color(android.R.color.darker_gray))
        Picasso
            .get()
            .load(url)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .networkPolicy(NetworkPolicy.NO_CACHE)
            .resize(0, 400)
            .placeholder(R.drawable.image_placeholder)
            .error(R.drawable.image_error)
            .into(binding.ivPicture)
    }

    private fun populateFact(fact: Fact) {
        binding.run {
            tvFact.text = fact.text
            tvUpdatedAt.text = fact.updatedAt.formatApiDateTime(requireContext())
        }
    }
}
