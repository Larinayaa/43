import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Programmer> programmers = new ArrayList<>(); //создаем программистов с задачами
        programmers.add(new Programmer("Анна", "Саарбрюккен", List.of(
                new Task(1, "Написать текст", "В процесса", 2),
                new Task(2, "Преобразовать картинки", "Выполнено", 6)
        )));
        programmers.add(new Programmer("Иван", "Берлин", List.of(
                new Task(3, "Проверить код", "В процессе", 10)
        )));
        programmers.add(new Programmer("Дмитрий", "Мюнхен", List.of(
                new Task(4, "Оформить сайт", "Новая задача", 0),
                new Task(5, "Оптимизировать код", "В процессе", 4)
        )));
        programmers.add(new Programmer("Олег", "Берлин", List.of(
                new Task(6, "Создать описание", "Новая задача", 1),
                new Task(7, "Оформить сайт", "В процессе", 6)
        )));
        List<Task> spisokTasks = new ArrayList<>(); //лист задач
        System.out.println("-----1a----Сформировать лист из всех задач--------");
        for (Programmer programmer : programmers) { //у всех программистов перебираем задачи и добавляем в лист
            spisokTasks.addAll(programmer.getTasks());
        }
        for (Task task : spisokTasks) { //печатаем задачи
            System.out.println(task);
        }
        System.out.println("----1b--Берлин, задачи отличаются от выполненных и более 5 дней в обработке");
        List<Task> berlinTasks = berlinTasksNoDone(programmers); //добавляем в лист всех из метода про берлин
        for (Task task : berlinTasks) {
            System.out.println(task);
        }
        System.out.println("----2a---Map,true - в обработке меньше 3 дней, false - остальные");
        int dney = 3; // меньше 3 дней в обработке
        Map<Boolean, List<Task>> taskMap = taksVobrabotkeMenshe3(spisokTasks, dney);
        System.out.println("В процессе меньше " + dney + " дней:");
        taskMap.get(true).forEach(System.out::println);
        System.out.println("Остальные:");
        taskMap.get(false).forEach(System.out::println);
        System.out.println("----2b---Map, ключ сколько дней в обработке, значение - список задач");
        Map<Integer, List<Task>> tasksPoDnyamMap = tasksPoDnyamVobrabotke(spisokTasks);
        for (Map.Entry<Integer, List<Task>> entry : tasksPoDnyamMap.entrySet()) {
            System.out.println("Дней: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
            System.out.println();
        }
    }
    public static List<Task> berlinTasksNoDone(List<Programmer> programmers) {//фильтруем берлин
    List<Task> result = new ArrayList<>();
    for (Programmer programmer : programmers) {
        if (programmer.getCity().equalsIgnoreCase("Берлин")) {//если берлин
            for (Task task : programmer.getTasks()) { //проверяем чтоб не выполнено и больше 5 дней висят
                if (!task.getStatus().equalsIgnoreCase("Завершено") && task.getDaysInProcessing() > 5) {
                    result.add(task);
                }
            }
        }
    }
    return result;
}
public static Map<Boolean, List<Task>> taksVobrabotkeMenshe3(List<Task> tasks, int dney) {
    Map<Boolean, List<Task>> result = new HashMap<>();
    result.put(true, new ArrayList<>());  //менее 3 дней
    result.put(false, new ArrayList<>()); //остальные
    for (Task task : tasks) {
        if (task.getDaysInProcessing() < dney) {
            result.get(true).add(task);
        } else {
            result.get(false).add(task);
        }
    }
    return result;
}
    public static Map<Integer, List<Task>> tasksPoDnyamVobrabotke(List<Task> tasks) {
        Map<Integer, List<Task>> result = new HashMap<>();
        for (Task task : tasks) {
            int day = task.getDaysInProcessing();
            result.putIfAbsent(day, new ArrayList<>());
            result.get(day).add(task);
        }
        return result;
    }
}