public class FutureTuition {
    public static void main(String[] args) {
        double currentTuition = 10000;
        double increaseValue = 0.07;
        int count = 0;

        while (currentTuition < 20000){
            currentTuition += currentTuition * increaseValue;
            count++;
        }

        System.out.println("The tuition will be doubled in " + count + " years!");
        System.out.printf("Tuition will be $%.2f in %1d years", currentTuition, count);
    }
}
