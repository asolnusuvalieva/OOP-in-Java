import java.util.Scanner;

public class URI1049Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String group1 = scanner.next();
        String group2 = scanner.next();
        String group3 = scanner.next();

        String animal = "";
        if (group1.equals("vertebrado")){
            if (group2.equals("ave")){
                if (group3.equals("carnivoro")){
                    animal = "aguia";
                }else{
                    animal = "pomba";
                }

            }else{
                //mamifero
                if (group3.equals("onivoro")){
                    animal = "homem";
                }else{
                    animal = "vaca";
                }
            }
        }else{
            if (group2.equals("inseto")){
                if (group3.equals("hematofago")){
                    animal = "pulga";
                }else{
                    animal = "lagarta";
                }

            }else {
                //anelideo
                if (group3.equals("hematofago")){
                    animal = "sanguessuga";
                }else{
                    animal = "minhoca";
                }
            }
        }

        System.out.println(animal);

    }
}

//accepted
