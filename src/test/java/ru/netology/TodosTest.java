package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить хлеб");
        Epic epic = new Epic(2, new String[]{"Сходить в магазин", "Оплатить счета"});
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "НетоБанк", "Завтра");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("магазин");
        Task[] expected = {epic};
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldSearchMultipleMatches() {
        SimpleTask task1 = new SimpleTask(1, "дом");
        SimpleTask task2 = new SimpleTask(2, "дом");
        Epic epic = new Epic(3, new String[]{"дом"});

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);
        todos.add(epic);

        Task[] result = todos.search("дом");
        Task[] expected = {task1, task2, epic};

        assertArrayEquals(expected, result);
    }
}