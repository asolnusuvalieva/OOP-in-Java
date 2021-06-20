package batch6;
import java.util.Scanner;
/*
row -> contestant
columns -> problems (1: solved, 0: not solved)

Условия:
Participant: Никто не смог решить ВСЕ проблемы, предоставленные ему
Participant: Каждый участник решил хоть одну проблему
Problem: Каждая индивидульная проблема была решена хоть одним человеком (необязательно один и тот же человек)
Problem: нет такой проблемы, которую решили все
 */
public class URI1514 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students, problems;

        while ((students = scanner.nextInt()) != 0 && (problems = scanner.nextInt()) != 0){
            int[][] info = new int[students][problems];

            //Initialization
            for(int i = 0; i < students; i++){
                for(int j = 0; j < problems; j++){
                    info[i][j] = scanner.nextInt();
                }
            }

            boolean condition1 = condition1(info);
            boolean condition2 = condition2(info);
            boolean condition3 = condition3(info);
            boolean condition4 = condition4(info);

            int count = 0;

            if(condition1)
                count++;

            if(condition2)
                count++;

            if (condition3)
                count++;

            if (condition4)
                count++;

            System.out.println(count);
        }
    }

    private static boolean condition4(int[][] info){
        /*
        Problem: нет такой проблемы, которую решили все
         */
        boolean[] everyoneSolvedTheseProblems = new boolean[info[0].length];

        for(int problem = 0; problem < info[0].length; problem++){
            boolean everyoneSolvedThisProblem = true;
            for(int student = 0; student < info.length; student++){
                if(info[student][problem] == 0){
                    everyoneSolvedThisProblem = false;
                    break;
                }
            }
            everyoneSolvedTheseProblems[problem] = everyoneSolvedThisProblem;
        }

        boolean noProblemThatEveryoneSolved = true; //нет такой проблемы, которую решили все
        for(int problem = 0; problem < everyoneSolvedTheseProblems.length; problem++){
            if(everyoneSolvedTheseProblems[problem]){
                noProblemThatEveryoneSolved = false;
                break;
            }
        }

        return noProblemThatEveryoneSolved;
    }

    private static boolean condition3(int[][] info){
        /*
        Problem: Каждая индивидульная проблема была решена хоть одним человеком
        (необязательно один и тот же человек)
         */
        boolean[] eachProblemWasSolved = new boolean[info[0].length];

        for(int problem = 0; problem < info[0].length; problem++){
            boolean wasSolved = false;
            for(int student = 0; student < info.length; student++){
                if(info[student][problem] == 1){
                    wasSolved = true;
                    break;
                }
            }
            eachProblemWasSolved[problem] = wasSolved;
        }

        boolean eachProblemWasSolvedAtSomePoint = true;
        for(int problem = 0; problem < eachProblemWasSolved.length; problem++){
            if(!eachProblemWasSolved[problem]){
                eachProblemWasSolvedAtSomePoint = false;
                break;
            }
        }
        return eachProblemWasSolvedAtSomePoint;
    }

    private static boolean condition2(int[][] info){
        /*
        Participant: Каждый участник решил хоть одну проблему
         */
        boolean[] eachSolvedAtLeastOneProblem = new boolean[info.length];

        for(int student = 0; student < info.length; student++){
            boolean solvedAtLeastOneProblem = false;
            for(int problem = 0; problem < info[student].length; problem++){
                if(info[student][problem] == 1){
                    solvedAtLeastOneProblem = true;
                    break;
                }
            }
            eachSolvedAtLeastOneProblem[student] = solvedAtLeastOneProblem;
        }

        boolean eachParticipantSolvedAtLeastOneProblem = true;
        for(int student = 0; student < eachSolvedAtLeastOneProblem.length; student++){
            if(!eachSolvedAtLeastOneProblem[student]){
                eachParticipantSolvedAtLeastOneProblem = false;
                break;
            }
        }

        return eachParticipantSolvedAtLeastOneProblem;
    }
    private static boolean condition1(int[][] info){
        /*
        Participant: Никто не смог решить ВСЕ проблемы, предоставленные ему
         */
        boolean[] eachSolvedAllProblems = new boolean[info.length];

        for(int student = 0; student < info.length; student++){
            boolean solvedAllProblems = true;
            for(int problem = 0; problem < info[student].length; problem++){
                if(info[student][problem] == 0){ //как только видим 0, репорт о нерешенной проблеме
                    solvedAllProblems = false;
                    break;
                }
            }
            eachSolvedAllProblems[student] = solvedAllProblems;
        }

        boolean nobodySolvedAllProblems = true;
        for(int student = 0; student < eachSolvedAllProblems.length; student++){
            if(eachSolvedAllProblems[student]){
                nobodySolvedAllProblems = false; //потому что кто то РЕШИЛ все bc of true
                break;
            }
        }
        return nobodySolvedAllProblems;
    }
}
//Accepted