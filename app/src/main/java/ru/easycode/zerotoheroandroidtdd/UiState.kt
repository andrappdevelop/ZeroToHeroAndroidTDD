package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(textView: TextView, progressBar: ProgressBar, button: Button)

    object ShowProgress : UiState {
        override fun apply(textView: TextView, progressBar: ProgressBar, button: Button) {
            textView.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
            button.isEnabled = false
        }
    }

    object ShowData : UiState {
        override fun apply(textView: TextView, progressBar: ProgressBar, button: Button) {
            textView.visibility = View.VISIBLE
            progressBar.visibility = View.INVISIBLE
            button.isEnabled = true
        }
    }
}