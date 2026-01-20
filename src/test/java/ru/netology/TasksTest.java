package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Купить молоко");
        assertTrue(task.matches("молоко"));
        assertFalse(task.matches("хлеб"));
    }

    @Test
    public void shouldMatchEpic() {
        String[] subtasks = {"Сделать презентацию", "Написать отчёт", "Проверить почту"};
        Epic epic = new Epic(2, subtasks);
        assertTrue(epic.matches("отчёт"));
        assertFalse(epic.matches("звонок"));
    }

    @Test
    public void shouldMatchMeeting() {
        Meeting meeting = new Meeting(
                3,
                "Обсуждение бюджета",
                "Проект Альфа",
                "Понедельник 10:00"
        );
        assertTrue(meeting.matches("бюджет"));
        assertTrue(meeting.matches("Альфа"));
        assertFalse(meeting.matches("вторник"));
    }
}