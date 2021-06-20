package semester1;

import java.util.Scanner;
/*
Input:
List of submissions

Output:
Score

Possible Situations (care only about correct ones):
- Unique and correct
- Repeated (incorrect) and finally, correct
 */
public class URI1367 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tests;
        while ((tests = scanner.nextInt()) != 0){
            scanner.nextLine(); //TODO: To avoid Scanner misreading

            Problem[] problems = new Problem[tests];
            int correctProblems = 0;
            int totalTime = 0;

            for(int i = 0; i < tests; i++){
                String identifier = scanner.next();
                int time = scanner.nextInt();
                String status = scanner.next();
                Problem problem = new Problem(identifier, time, status);

                if(status.equals("correct")){
                    correctProblems++;
                    ProblemHistory problemHistory = submittedBefore(problems, problem, i);
                    if(problemHistory.submittedBefore){
                        totalTime += 20 * problemHistory.submittedBeforeTimes + problem.time;
                    }else{
                        totalTime += problem.time;
                    }
                }
                problems[i] = problem;
            }

            System.out.println(correctProblems + " " + totalTime);
        }

    }

    public static ProblemHistory submittedBefore(Problem[] problems, Problem problem, int indexOfProblem){
        boolean found = false;
        int incorrectTimes = 0;

        for(int i = 0; i < indexOfProblem; i++){
            if(problems[i].identifier.equals(problem.identifier)){
                found = true;
                incorrectTimes++;
            }
        }
        return new ProblemHistory(found, incorrectTimes);
    }
}

class Problem{
    String identifier;
    int time;
    String status;

    Problem (String identifier, int time, String status){
        this.identifier = identifier;
        this.time = time;
        this.status = status;
    }
}

class ProblemHistory{
    boolean submittedBefore;
    int submittedBeforeTimes;

    ProblemHistory(boolean submittedBefore, int submittedBeforeTimes){
        this.submittedBefore = submittedBefore;
        this.submittedBeforeTimes = submittedBeforeTimes;
    }
}
//Accepted and pushed
