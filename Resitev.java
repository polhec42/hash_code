import java.io.BufferedReader;
import java.io.*;
import java.util.*;
public class Resitev{
  
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new FileReader(args[0]));

    int numberOfPhotos = Integer.parseInt(br.readLine());

    Slika slike = new Slika[numberOfPhotos];

    for(int i = 0; i < slike.length; i++){
      String[] data = br.readLine().split(" ");
      char usmerjenost = (char)Integer.parseInt(data[0]);
      int numberOfTags = Integer.parseInt(data[1]);
      
      HashSet<String> set = new HashSet<>();
      for(int j = 2; j < data.length; j++){
        set.add(data[j]);
      }

      Slika novaSlika = new Slika(i, usmerjenost, set);
    
    }

  }

  
}

