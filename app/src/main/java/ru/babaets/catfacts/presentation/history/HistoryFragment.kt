package ru.babaets.catfacts.presentation.history

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.babaets.catfacts.R
import ru.babaets.catfacts.data.model.Fact
import ru.babaets.catfacts.databinding.FragmentHistoryBinding
import ru.babaets.catfacts.presentation.common.BaseFragment

class HistoryFragment : BaseFragment<HistoryViewModel>() {

    override val layoutRes: Int = R.layout.fragment_history

    override val viewModel: HistoryViewModel by viewModel<HistoryViewModelImpl>()

    private val binding: FragmentHistoryBinding by viewBinding()

    private val factsAdapter: FactsAdapter by lazy {
        FactsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            toolbar.setNavigationOnClickListener {
                viewModel.onBackPressed()
            }
            rvFacts.adapter = factsAdapter
        }

        viewModel.factsLiveData.observe(viewLifecycleOwner, ::populateFacts)
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

    private fun populateFacts(facts: List<Fact>) {
        factsAdapter.submitList(facts)
    }
}
