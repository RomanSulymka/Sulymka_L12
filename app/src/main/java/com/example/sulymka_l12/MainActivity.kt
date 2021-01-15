package com.example.sulymka_l12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.afollestad.materialdialogs.MaterialDialog
import com.example.sulymka_l12.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet_with_xml.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout> by lazy {
        BottomSheetBehavior.from(
                binding.root.bottomSheetParentContainer
        )
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupListeners()
        setupBottomSheet()
    }

    private fun setupListeners() {
        binding.btnMaterialDialog.setOnClickListener {
            showMaterialDialog()
        }
        binding.btnDialogFragment.setOnClickListener {
            showDialogFragment()
        }
        binding.btnBottomSheetDialog.setOnClickListener {
            showBottomSheet()
        }
        binding.btnBottomSheetDialogFragment.setOnClickListener {
            showBottomSheetFragment()
        }

    }

    private fun showDialogFragment() {
        supportFragmentManager.beginTransaction()
                .add(MyDialogFragment(), "TAG")
                .commitAllowingStateLoss()
    }

    private fun setupBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
    }

    private fun showBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun showBottomSheetFragment() {
        supportFragmentManager.beginTransaction().add(MyBottomSheetDialogFragment(), "TAG")
                .commitNowAllowingStateLoss()

    }

    private fun showMaterialDialog() {
        MaterialDialog(this).show {
            title(text = "Show dialog")
            message(text = "Press any button?")
            positiveButton(text = "Yes") { dialog ->
                Toast.makeText(this@MainActivity, "\"YES\" pressed", Toast.LENGTH_SHORT).show()
            }
            negativeButton(text = "No") { dialog ->
                Toast.makeText(this@MainActivity, "\"NO\" pressed", Toast.LENGTH_SHORT).show()
            }
        }
    }


}