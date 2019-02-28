import java.util.*;
import java.io.*;


public class Resitev{
  
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new FileReader(args[0]));

    int numberOfPhotos = Integer.parseInt(br.readLine());
    
    Slika[] slike = new Slika[numberOfPhotos];

    for(int i = 0; i < slike.length; i++){
      String[] data = br.readLine().split(" ");
      char usmerjenost = data[0].toCharArray()[0];
      int numberOfTags = Integer.parseInt(data[1]);
      if(numberOfTags < 2){
        continue;
      }
      HashSet<String> set = new HashSet<>();
      for(int j = 2; j < data.length; j++){
        set.add(data[j]);
      }

      Slika novaSlika = new Slika(i, usmerjenost, set);
      slike[i] = novaSlika;
    }

    Slide one = new Slide(0, slike[0]);
    Slide two = new Slide(1, slike[3]);

    System.out.println(one.Scoring(two));

  }
  private static class Slideshow{

      public ArrayList<Slide> slides;

      public void print(){
        for(int i = 0; i < slides.size(); i++){
          System.out.println(slides.get(i).tags.toString());
        }
      }

  }

  
	private static class Slika{
		public HashSet<String> tags;
		public char ori;
		public int ID;
		
		public Slika(int ID, char orientation, HashSet<String> tags){
				this.ori = orientation;
				this.ID = ID;
				this.tags = tags;
		}
		
		
		
	}
	
	private static class Slide{
		public HashSet<String> tags;
		public char numOfPics;
		public int ID1;
		public int ID2;
		
		public Slide(int ID, Slika s){
			this.ID1 = ID;
			this.numOfPics = 1;
			this.tags = s.tags;
		}
		
		public Slide(int ID1, int ID2, Slika s1, Slika s2){
			this.ID1 = ID1;
			this.ID2 = ID2;
			this.numOfPics = 2;
			this.tags = new HashSet<String>();
			tags.addAll(s1.tags);
			tags.addAll(s2.tags);
		}
		
		public int Scoring(Slide s){
			HashSet<String> t = new HashSet<String>();
			t.addAll(this.tags);
			t.retainAll(s.tags);
			int presek = t.size();
			
			t = new HashSet<String>();
			t.addAll(this.tags);
			t.removeAll(s.tags);
			int razlika1 = t.size();
      
      t = new HashSet<String>();
			t.addAll(s.tags);
			t.removeAll(this.tags);
			int razlika2 = t.size();
			
			return Math.min(Math.min(presek, razlika1), razlika2);
			
		}
		
	}
	
	
}

