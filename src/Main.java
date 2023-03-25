import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        SPCScanner scanner = new SPCScanner();//instantiates a scanner
        SPCParser parser = new SPCParser();
        List<keyWords> object = new ArrayList<>();
        String source = "";
        try {
            Scanner input = new Scanner(System.in);
            File file = new File("src/welcome.scl"); //what ever file we want to scan is named here
            input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();//take the text as a string.
                source = source + line; //add to the original string
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        StringTokenizer st = new StringTokenizer(source," ,^()\"", true);// tokenizes the string and sets which delimiters will be treated as input.
        while (st.hasMoreTokens()) {//will iterate until the there are no more tokens
            String lexemes = st.nextToken(" ,()^\n\t\"");//sets the next variable to be split by the listed delimiters
            if(!lexemes.matches("\\s+"))
            {
                object.add(scanner.strInput(lexemes));
            }
        }
        /*for (keyWords token:object
             ) {
            parser.begin(token);
        }*/
        for (String identifiers : scanner.symbolTable) {
            System.out.print(identifiers + " ");//Prints identifiers in the symbol table
        }
        System.out.println();
        for (keyWords tokens: object
             ) {
            System.out.println(tokens.getLexemes() + " : " + tokens.name());
        }
        //System.out.print(object + object.);//Prints the returned keyword objects

    }
}