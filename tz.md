1.
a )  Дан список Programmer(String name, String city, List<Task>  tasks). 
Каждый программист  имеет список задач               
Task (int Number, String description, String status, int daysInProcessing) .
Сформировать лист из всех задач.

b)  Дан список Programmer(String name, String city, List<Task>  tasks).
Каждый программист  имеет список задач              
Task (int Number, String description, String status, int daysInProcessing) .
Сформировать лист из всех задач, которые относятся к программистам из Берлина, 
не завершены (т.е. имеют статус, отличный от «done») и висят в обработке более 5 дней.
2.
a)  Дан список Programmer(String name, String city, List<Task>  tasks).
Каждый программист  имеет список задач             
Task (int number, String description, String status, int daysInProcessing) . 
Сформировать Map<Boolean, Task> , где ключу true будут соответствовать
задачи находящиеся в обработке (поле daysInProcessing)  менее заданного
количества дней, false - остальные
b)  Дан список Programmer(String name, String city, List<Task>  tasks). 
Каждый программист  имеет список задач Task (int number, String description, 
status, int daysInProcessing) . Сформировать Map<Integer, Task> ,
где ключ сколько дней задача в обработке, значение - список задач.


