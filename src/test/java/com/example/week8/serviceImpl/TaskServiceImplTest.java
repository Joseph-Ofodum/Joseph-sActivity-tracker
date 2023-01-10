package com.example.week8.serviceImpl;

import com.example.week8.dto.TaskDto;
import com.example.week8.entity.Task;
import com.example.week8.repositories.TaskRepo;
import com.example.week8.service.TaskService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class TaskServiceImplTest {

    @Autowired
    private TaskService task;

    @Autowired
    TaskRepo taskRepo;

    long taskId;
    @BeforeEach
   void setup(){
        TaskDto dto = new TaskDto();
        dto.setUserId(1L);
        dto.setTitle("check");
        dto.setTaskDescription("testing the create task method");
        Task taskCreated = task.createTask(dto);
        taskId = taskCreated.getTaskId();

    }
    @AfterEach
    void teardown(){
        TaskDto taskDto = new TaskDto();
        taskDto.setUserId(1L);
        taskDto.setTaskId(taskId);
        task.deleteTaskByItId(taskDto);
    }

    @Test
    void createTask() {
        TaskDto dto = new TaskDto();
        dto.setUserId(1L);
        dto.setTitle("Test");
        dto.setTaskDescription("testing the create task method");
        Task taskCreated = task.createTask(dto);
        assertEquals("Test", taskCreated.getTitle());
        dto.setTaskId(taskCreated.getTaskId());
        task.deleteTaskByItId(dto);

    }

    @Test
    void updateTask() {
        TaskDto update = new TaskDto();
        update.setUserId(1L);
        update.setTaskId(taskId);
        update.setTitle("Kings Meal");
        update.setTaskDescription("Serving breakfast");
        assertEquals("Kings Meal", task.updateTask(update).getTitle());
    }

    @Test
    void updateTaskToDone() {
        TaskDto moveToDone = new TaskDto();
        moveToDone.setUserId(1L);
        moveToDone.setTaskId(taskId);

        assertEquals("Done", task.updateTaskToDone(moveToDone).getStatus().name());
    }

    @Test
    void updateTaskToPending() {
        TaskDto moveToPending = new TaskDto();
        moveToPending.setUserId(1L);
        moveToPending.setTaskId(taskId);
        assertEquals("Pending", task.updateTaskToPending(moveToPending).getStatus().name());
    }

    @Test
    void updateTaskToInProgress() {
        TaskDto moveToInProgress = new TaskDto();
        moveToInProgress.setUserId(1L);
        moveToInProgress.setTaskId(2L);
        assertEquals("InProgress", task.updateTaskToInProgress(moveToInProgress).getStatus().name());
    }

//    @Test
//    void deleteTaskByItId() {
//        TaskDto taskDto = new TaskDto();
//        taskDto.setUserId(1L);
//        taskDto.setTaskId(taskId);
//        assertEquals(0, task.deleteTaskByItId(taskDto));
//    }
}