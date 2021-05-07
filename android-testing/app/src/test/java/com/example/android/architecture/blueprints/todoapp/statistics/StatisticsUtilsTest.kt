package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StatisticsUtilsTest {


   @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        val tasks = listOf<Task>(
                Task("title","desc",false)
        )
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is` (100f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsHundredZero() {
        val tasks = listOf<Task>(
                Task("title","desc",true)
        )
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is` (100f))
        assertThat(result.activeTasksPercent, `is` (0f))
    }

    @Test
    fun getActiveAndCompletedStats_twoCompletedThreeActive_returnsFortySixty() {
        val tasks = listOf<Task>(
                Task("title1","desc1",true),
                Task("title2","desc2",true),
                Task("title3","desc3",false),
                Task("title4","desc4",false),
                Task("title5","desc5",false)
        )
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is` (40f))
        assertThat(result.activeTasksPercent, `is` (60f))
    }

    @Test
    fun getActiveAndCompletedStats_noTasks_returnsZeros() {
        val tasks = listOf<Task>()
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is` (0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        val result = getActiveAndCompletedStats(null)

        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is` (0f))
    }

    }