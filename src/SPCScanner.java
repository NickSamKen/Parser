import java.util.ArrayList;
import java.util.List;
public class SPCScanner {
    keyWords[] tokenKeyWord = keyWords.values();
    public List<String> symbolTable = new ArrayList<>();//This is the symbol table
    public keyWords strInput(String firstToken)
    {
        //basic regex filter to determine if the input is a double literal
        if (firstToken.matches("^-?\\d+(\\.\\d+)?$"))
        {
            keyWords.DOUBLE_LIT.setLexemes(firstToken);
            return keyWords.DOUBLE_LIT;
        }
        if(firstToken.matches("(//.*?$)|(/\\*.*?\\*/)"))
        //basic regex filter to determine if the input is a comment
        {
            keyWords.COMMENT.setLexemes(firstToken);
            return keyWords.COMMENT;
        }
        //basic regex filter to discern whether the token has acceptation lexica rules for a variable or keyword
        if (firstToken.matches("^[a-zA-Z_$][a-zA-Z_$0-9]*$")) {
            if(firstToken.matches("^[a-z]*$"))//takes only strings made of letters
            {
                for (keyWords keyword : tokenKeyWord )//Iterates through the keyword table
                {
                    if(keyword.getLexemes().equals(firstToken))//searches for matching keyword
                    {
                        return keyword;//Returns the matching keyword object
                    }
                }
                keyWords.IDENTIFIERS.setLexemes(firstToken);//Return the keyword as an Identifier object since the input is a valid identifier
                if(!symbolTable.contains(firstToken))//Checks whether the identifier exists in the Symbol table
                {
                    symbolTable.add(firstToken);// new identifier is added to Symbol table
                }
                return keyWords.IDENTIFIERS;//Return the keyword as an Identifier object since the input is a valid identifier

            }
            keyWords.IDENTIFIERS.setLexemes(firstToken);//Return the keyword as an Identifier object since the input is a valid identifier
            if(!symbolTable.contains(firstToken))//Checks whether the identifier exists in the Symbol table
            {
                symbolTable.add(firstToken);// new identifier is added to Symbol table
            }
            return keyWords.IDENTIFIERS;//Return the keyword as an Identifier object since the input is a valid identifier
        }
        for (keyWords keyword : tokenKeyWord )
        {
            if(keyword.getLexemes().equals(firstToken))//Checks for any matching keyword neither a scl keyword or an identifier
            {
                return keyword;
            }
        }
        keyWords.UNKNOWN_KEYWORD.setLexemes(firstToken);//Sets the UNKNOWN string attribute to any other value
        System.out.println("Encountered an unknown invalid KEYWORD or Identifier: " + keyWords.UNKNOWN_KEYWORD.getLexemes());//Prints an Error mission listing the problem string
        return keyWords.UNKNOWN_KEYWORD;//Return the UNKNOWN object, All unknown returned are words located within string comments and either didn't have the correct pattern or the keyword it had wasn't used in the keyword subset
    }
}
