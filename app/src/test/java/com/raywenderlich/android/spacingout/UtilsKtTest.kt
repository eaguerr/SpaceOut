package com.raywenderlich.android.spacingout

import androidx.lifecycle.ViewModel
import io.mockk.mockkConstructor
import io.mockk.verify
import org.junit.Test

class UtilsKtTest {
    @Test
    fun `the log extension logs provided event`() {
        mockkConstructor(SpacingAnalytics::class)

        val viewModel = object : ViewModel() {}

        viewModel.logEvent("Test Event")

        verify { anyConstructed<SpacingAnalytics>().logEvent("Test Event", mapOf("Logging View Model" to viewModel::class.java.simpleName)) }
    }
}