import java.awt.*;

//The subset of Keywords
public enum keyWords //table of KEYWORDS for the scanner
{
    COMMA(1, ","),
    MULTIPLICATION_OP(2, "*"),
    ASSIGNMENT_OP(3, "="),
    LEFT_BRACKET(4, "("),
    RIGHT_BRACKET(5, ")"),
    STRING_LIT(6, "\""),
    SUBTRACTION(7, "-"),
    ADDITION(8, "+"),
    EXPONENT(9, "^"),
    TYPE(10, "type"),
    BEGIN(11, "begin"),
    RETURN(12, "return"),
    PARAMETERS(14, "parameter"),
    DISPLAY(15, "display"),
    INPUT(16, "input"),
    ENDFUN(17, "endfun"),
    EXIT(18, "exit"),
    DOUBLE(19, "double"),
    STRING(20, "string"),
    IS(21, "is"),
    FORWARD(22, "forward"),
    DECLARATION(23, "declaration"),
    VARIABLES(24, "variables"),
    IDENTIFIERS(25, ""),
    DEFINE(26, "define"),
    DOUBLE_LIT(27, ""),
    SET(28, "set"),
    IMPORT(29, "import"),
    CONSTANTS(30, "constants"),
    STRUCTURES(31, "structures"),
    OF(32, "of"),
    SCL(33,"scl.h"),
    COMMENT(34,""),
    UNKNOWN_KEYWORD(35,""); //This is a custom keyword that will return to the parser an that the scanner encountered an unknown token

    private String lexemes;

    private int KeywordNum;

    public int getKeywordNum() {
        return KeywordNum;
    }

    public String getLexemes() {
        return lexemes;
    }

    public void setLexemes(String new_lexemes)
    {
        lexemes = new_lexemes;
    }

    public void setKeywordNum(int KeywordNum)
    {
        this.KeywordNum = KeywordNum;
    }

    private keyWords(int KeywordNum, String lexemes)// Creates an object for each keyword.
    {
        this.KeywordNum = KeywordNum;
        this.lexemes = lexemes;
    }
}

