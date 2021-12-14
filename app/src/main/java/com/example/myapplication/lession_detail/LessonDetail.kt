package com.example.myapplication.lession_detail


import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.myapplication.databinding.DialogFragmentLessionDetailBinding
import com.example.myapplication.model.*


class LessonDetail(private val lesson: Lesson) : DialogFragment(), GroupAdapter.ClickListener {
    
    private lateinit var binding: DialogFragmentLessionDetailBinding
    private val adapter: GroupAdapter by lazy { GroupAdapter(this) }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentLessionDetailBinding.inflate(layoutInflater)
        dialog?.setCanceledOnTouchOutside(false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter
        binding.txtTitle.text = lesson.name
        binding.ivBack.setOnClickListener {
            dismiss()
        }
        adapter.items = lesson.groups
    }
    
    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window!!.setLayout(width, height)
        }
    }
    
    override fun onGroupClick(group: Group, position: Int) {
        group.isSelected = !group.isSelected
        adapter.notifyItemChanged(position)
    }
}