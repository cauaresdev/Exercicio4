package com.cauarosa.navegabilidadeentreastelas.util

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.cauarosa.navegabilidadeentreastelas.databinding.BottomSheetBinding
import com.cauarosa.navegabilidadeentreastelas.R

fun Fragment.initToolbar(toolbar: Toolbar) {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}





fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: Int,
    onClick: () -> Unit ={}
){
    val BottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val binding: BottomSheetBinding =
        BottomSheetBinding.inflate(layoutInflater, null, false)

    binding.textviewTitle.text = getText(titleDialog ?: R.string.text_title_warning)
    binding.textviewMessage.text = getText(message)
    binding.buttonOk.text = getText(titleButton ?: R.string.text_button_warning)
    binding.buttonOk.setOnClickListener {
        //Quando o botão buttonOk é clicado: O código executa o que foi definido no onClick. Depois, fecha o Bottom Sheet.
        onClick() //callback
        BottomSheetDialog.dismiss()
}

    BottomSheetDialog.setContentView(binding.root)
    BottomSheetDialog.show()

}
