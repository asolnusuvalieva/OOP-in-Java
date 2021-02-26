import java.util.Arrays;
import java.util.Scanner;
/*
Goal is to kill 151 pokemons
 */
public class URI2174 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int pokemonsKilled = scanner.nextInt();
            String[] pokemons = new String[pokemonsKilled];

            //Filling the array
            for(int i = 0; i < pokemonsKilled; i++) {
                pokemons[i] = scanner.next().toLowerCase();
            }

            //Sorting the array in an alphabetical order
            Arrays.sort(pokemons);

            String startingPokemon = pokemons[0];
            int pokemonsActuallyKilled = 1; //Even pokemons are repetitive, it still presents 1 pokemon (startingPokemon)

            for(int i = 1; i < pokemonsKilled; i++){
                String currentPokemon = pokemons[i];
                if(!startingPokemon.equals(currentPokemon)){
                    pokemonsActuallyKilled++;
                    startingPokemon = currentPokemon;
                }
            }
            System.out.printf("Falta(m) %d pomekon(s).%n", 151 - pokemonsActuallyKilled);
        }
    }
}

//Accepted and pushed