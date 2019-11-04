import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
public class Main {

    public static void main(String[] args) {

        File file = new File(""); //Give the File Path
        try {
            Scanner scanner = new Scanner(file);

            String[] movies = new String[100];
            int i = 0;
            while (scanner.hasNextLine()) {
                String movie_name = scanner.nextLine();
                movies[i++] = movie_name;
            }

            Random generator = new Random();
            int rand_movie = generator.nextInt(i);
            String rand = movies[rand_movie];
            Movie movie = new Movie(rand);
            int wrong=0;
            Scanner in = new Scanner(System.in);
            String wrong_letters="";
            while(!rand.equals(movie.chosen())){
                System.out.println("You are guessing: '"+ movie.chosen()+"'");
                System.out.print("You have guessed "+wrong+" wrong letters: " );
                if(wrong>0)
                    System.out.print(wrong_letters);
                System.out.print("\nGuess a letter: ");
                char letter = in.next().charAt(0);
                boolean status = false;
                for(i=0;i<rand.length();i++)
                {
                    if(rand.charAt(i)==letter)
                    {
                        status = true;
                        movie.modify(i,letter);
                    }
                }
                if(!status) {
                    wrong++;
                    wrong_letters = wrong_letters+' '+letter;
                    movie.reduce();
                }
                if(movie.chance()==0) {
                    System.out.println("Chances are over. Game Over! The movie is "+movies[rand_movie]);
                    break;
                }
                }
            if(rand.equals(movie.chosen())) {
                System.out.println("You won!");
            }



        }catch (FileNotFoundException f){
            System.out.println("File Not found");
        }
    }
}
