import java.util.Scanner;

import engine.SearchEngine;
import model.Document;

public class Main {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        SearchEngine engine=new SearchEngine();

        int id=1;

        while(true){

            System.out.println("\n===== MINI SEARCH ENGINE =====");

            System.out.println("1 Add Document");
            System.out.println("2 AutoComplete");
            System.out.println("3 Single Word Search");
            System.out.println("4 Multi Word Search");
            System.out.println("5 Phrase Search");
            System.out.println("6 Delete Document");
            System.out.println("7 Show Vocabulary");
            System.out.println("8 Show Search History");
            System.out.println("9 Exit");

            System.out.print("Enter choice: ");

            int ch=sc.nextInt();
            sc.nextLine();

            switch(ch){

                case 1:

                    System.out.println("Enter document text:");
                    String text=sc.nextLine();

                    engine.addDocument(new Document(id,text));

                    System.out.println("Document added ID "+id);
                    id++;

                    break;

                case 2:

                    System.out.print("Enter prefix: ");
                    engine.autoComplete(sc.nextLine());
                    break;

                case 3:

                    System.out.print("Enter word: ");
                    String w=sc.nextLine();
                    // System.out.print("Enter Top K results: ");
                    // int k=sc.nextInt();
                    // sc.nextLine();  
                    engine.searchSingleWord(w);
                    break;

                case 4:
                    System.out.print("Enter multiple words(enter with comma): ");
                    engine.searchMultipleWords(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter phrase: ");
                    engine.phraseSearch(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter document ID: ");
                    engine.deleteDocument(sc.nextInt());
                    sc.nextLine();
                    break;

                case 7:
                    engine.showVocabulary();
                    break;

                case 8:
                    engine.showHistory();
                    break;

                case 9:
                    sc.close();
                   return;
            }

        }
       
       
    }
       
}