package com.example.composestate

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel


class WellnessViewModel : ViewModel(){
    private val _task = getWellnessTasks().toMutableStateList()
    val tasks:List<WellnessTask>
        get() = _task

    fun remove(wellnessTask: WellnessTask){
        _task.remove(wellnessTask)
    }

    fun changeTaskChecked(wellnessTask: WellnessTask,checked:Boolean) = tasks.find {it.id == wellnessTask.id}?.let {task->
        task.checked = checked
    }
}

fun getWellnessTasks() = List(30){item->
    WellnessTask(item,"Task # $item")
}