import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.io.*;


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

  
	private static class Slika{
		public HashSet<String> tags;
		public char ori;
		public int ID;
		
		public Slika(int ID, char orientation, HashSet<String> tags){
				this.orientation = orientation;
				this.ID = ID;
				this.tags = tags;
		}
		
		
		
	}
	
	/*private static class Slide{
		public Slika 
		public String[] tags;
		public int ID1;
		public int ID2;
		
		public Slide(int ID, Slika s){
			
		}
		
	}*/

}

