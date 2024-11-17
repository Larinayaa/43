public class Task {
    private int number;
    private String description;
    private String status;
    private int daysInProcessing;

    public Task(int number, String description, String status, int daysInProcessing) {
        this.number = number;
        this.description = description;
        this.status = status;
        this.daysInProcessing = daysInProcessing;
    }
    public String getStatus() {
        return status;
    }
    public int getDaysInProcessing() {
        return daysInProcessing;
    }
    @Override
    public String toString() {
        return String.format("%d. %s - статус задачи: %s. Сколько выполняется дней: %d.", number, description, status, daysInProcessing );
    }
}
