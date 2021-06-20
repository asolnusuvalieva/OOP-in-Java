package semester1;

import java.util.Scanner;
/*
The Native Language of the country: English
Either English or X_LANGUAGE (in this case, all speakers should have the same native languages)
Solution: once you find two different languages, the language is English
 */
public class URI1581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            int numberOfPeople = scanner.nextInt();
            String[] languages = new String[numberOfPeople];

            for(int j = 0; j < numberOfPeople; j++){
                languages[j] = scanner.next();
            }

            String currentLanguage = languages[0];
            boolean isEnglish = false;
            for(int l = 1; l < languages.length; l++){
                if(!languages[l].equals(currentLanguage)){
                    isEnglish = true;
                    break;
                }
            }

            if(isEnglish){
                System.out.println("ingles");
            }else{
                System.out.println(currentLanguage);
            }
        }
    }
}
//Accepted and pushed