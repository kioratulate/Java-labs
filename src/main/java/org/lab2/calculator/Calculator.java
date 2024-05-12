package org.lab2.calculator;

import java.util.*;

/**
 * Calculator class containing a parser and expression evaluator, with built-in functionality for adding functions and variables.
 */
public class Calculator {
    /**
     * Table of functions that calculator can use
     */
    public HashMap<String, IFunction> functionTable;

    /**
     * Adds a user-defined function to the calculator.
     *
     * @param name The name of the function to add.
     * @param func The implementation of the function, implementing the IFunction interface.
     * @throws RuntimeException If a function with the same name already exists in the function table.
     */
    public void addFunction(String name, IFunction func) throws RuntimeException{
        if (functionTable.containsKey(name))
            throw new RuntimeException("Redefining of function");
        functionTable.put(name, func);
    }

    /**
     * Adds a variable outside the calculation expression.
     * @param name Name of the variable.
     * @param value Value of the variable.
     * @throws RuntimeException If a variable with the same name already exists in the variable table.
     */
    public void addVariable(String name, double value) throws RuntimeException{
        if (variableTable.containsKey(name))
            throw new RuntimeException("Redefining of variable");
        variableTable.put(name, value);
    }
    /**
     * Edits a variable outside the calculation expression.
     * @param name Name of the variable.
     * @param newValue New value of the variable.
     * @throws RuntimeException If a variable with the given name not exists in the variable table.
     */
    public void editVariable(String name, double newValue){
        if (!variableTable.containsKey(name))
            throw new RuntimeException("No variable with this name");
        variableTable.put(name, newValue);
    }

    /**
     * Retrieves a variable from the variable table.
     * @param name Name of the variable.
     * @return Value of the variable that was got.
     * @throws RuntimeException If a variable with the given name not exists in the variable table.
     */
    public double getVariable(String name){
        if (!variableTable.containsKey(name))
            throw new RuntimeException("No variable with this name");
        return variableTable.get(name);
    }

    /**
     * Table of variables that the calculator can use.
     */
    public HashMap<String, Double> variableTable;

    /**
     * Default constructor.
     */
    public Calculator() {
        functionTable = getFunctionMap();
        variableTable = new HashMap<>();
    }

    /**
     * Processes the expression, first performing lexical analysis, then actual computation, and returns the result of the expression.
     * @param expression The expression to be evaluated.
     * @return The result of the evaluated expression.
     */
    public double processExpression(String expression){
        List<Lexeme> lexemes = lexAnalyze(expression);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        return expr(lexemeBuffer);
    }

    /**
     * Lexeme types used.
     */
    private enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
        NUMBER,
        COMMA,
        FUNCTION_NAME, VARIABLE_NAME,
        EOF

    }
    @Override
    public String toString() {
        ArrayList<String> lexemes = new ArrayList<>();
        for(LexemeType lexemeType: LexemeType.values()) {
            lexemes.add(lexemeType.name());
        }
        return "Calculator with support of "+ lexemes + " lexeme types, and "+ functionTable.keySet() + " functions";
    }

    /**
     * Lexemes into which the expression is split.
     */
    private class Lexeme {
        final LexemeType type;
        final String value ;

         public Lexeme(LexemeType type, String value) {
             this.type = type;
             this.value = value;
         }
         public Lexeme(LexemeType type, Character value) {
             this.type = type;
             this.value = value.toString();
         }
     }

    /**
     * Fills the function table with default functions.
     * @return The obtained default function table.
     */
    private HashMap<String, IFunction> getFunctionMap() throws RuntimeException
     {
        HashMap<String, IFunction> functionTable = new HashMap<>();
        functionTable.put("min", args -> {
            if (args.isEmpty()){
                throw new RuntimeException("No arguments for function min");
            }
            double min = args.getFirst();
            for (double val:args){
                if (val<min)
                    min = val;
            }
            return min;
        });
         functionTable.put("max", args -> {
             if (args.isEmpty()){
                 throw new RuntimeException("No arguments for function min");
             }
             double max = args.getFirst();
             for (double val:args){
                 if (val>max)
                     max = val;
             }
             return max;
         });
         functionTable.put("pow", args -> {
             if (args.isEmpty()){
                 throw new RuntimeException("No arguments for function pow");
             }
             if (args.size()!=2){
                 throw new RuntimeException("Wrong number of arguments for pow");
             }
             return Math.pow(args.getFirst(), args.getLast());
         });
         functionTable.put("rand", args -> {
             double MAX = 1000;
             double MIN = 0;
             if (args.size()>2)
                 throw new RuntimeException("Too much arguments for rand");
             if (args.size()==2) MIN = args.getFirst();
             MAX = args.getLast();

             return (int)(MIN + (Math.random() * (MAX - MIN)));
         });
         functionTable.put("mean", args -> {
             if (args.isEmpty()){
                 throw new RuntimeException("No arguments for function pow");
             }
             double sum=0;
             for (double val: args)
                 sum+=val;
             return sum/args.size();
         });
        return functionTable;
     }

    /**
     * Reads the value of a variable from the console input stream.
     * @param name Name of the variable to be read.
     * @return The read value.
     */
     private double getUserVariable(String name){
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter value for variable " + name + ": ");
         return processExpression(scanner.next());
     }

    /**
     * Lexical analysis of the expression, breaking it down into tokens.
     * @param expressionText The expression to be parsed.
     * @return The list of present lexemes.
     */
    private List<Lexeme> lexAnalyze(String expressionText){
         ArrayList<Lexeme> lexemes = new ArrayList<>();
         int position = 0;
         int bracketBalance = 0;
         while(position<expressionText.length())
         {
             char c = expressionText.charAt(position);
             switch (c){
                 case '(':{
                     lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                     position+=1;
                     bracketBalance+=1;
                     continue;
                 }
                 case ')': {
                     lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                     position+=1;
                     bracketBalance-=1;
                     continue;
                 }
                 case '+': {
                     lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                     position+=1;
                     continue;
                 }
                 case '-': {
                     lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                     position+=1;
                     continue;
                 }
                 case '*':{
                     lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                     position+=1;
                     continue;
                 }
                 case '/': case ':': {
                     lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                     position+=1;
                     continue;
                 }
                 case ',':{
                     lexemes.add((new Lexeme(LexemeType.COMMA, c)));
                     position+=1;
                     continue;
                 }
                 default:
                     if (c>='0'&&c<='9')
                     {
                         StringBuilder num = new StringBuilder();
                         do {
                             num.append(c);
                             position++;
                             if (position>=expressionText.length())
                                 break;
                             c = expressionText.charAt(position);
                         }while(c>='0'&&c<='9'||c==','||c=='.');
                         if (num.indexOf(",")==num.length()-1)
                         {
                             position-=1;
                             num.deleteCharAt(num.length()-1);
                         }

                         lexemes.add(new Lexeme(LexemeType.NUMBER, num.toString().replace(',','.')));
                     }
                     else {
                         //пропускаемые символы
                         if (c!=' '){
                             if (c>='a' && c<='z' || c>='A' && c<='Z'){
                                 StringBuilder funcvar = new StringBuilder();
                                 do {
                                     funcvar.append(c);
                                     position++;
                                     if (position>=expressionText.length())
                                         break;
                                     c = expressionText.charAt(position);
                                 }while(c>='a' && c<='z' || c>='A' && c<='Z'||c>='0'&&c<='9'||c=='_');

                                 if (functionTable.containsKey(funcvar.toString()))
                                 {
                                     lexemes.add(new Lexeme(LexemeType.FUNCTION_NAME, funcvar.toString()));
                                 }
                                 else {
                                     if (!variableTable.containsKey(funcvar.toString())){
                                         double value = getUserVariable(funcvar.toString());
                                         variableTable.put(funcvar.toString(), value);
                                     }
                                     lexemes.add(new Lexeme(LexemeType.VARIABLE_NAME, funcvar.toString()));
                                 }
                             }
                         } else {
                             position += 1;
                         }
                     }
             }
         }
         lexemes.add(new Lexeme(LexemeType.EOF, "" ));
         if (bracketBalance!=0)
         {
             throw  new RuntimeException("Bracket imbalance");
         }
         return lexemes;
    }

    /**
     * Lexeme buffer, which the calculator traverses during computation.
     */
    private class LexemeBuffer{
        private int position;
        public List<Lexeme> lexemes;
        public LexemeBuffer(List<Lexeme> lexemes){
            this.lexemes = lexemes;
        }
        public Lexeme next(){
            return lexemes.get(position++);
        }
        public void back(){
             position--;
        }
        public int getPosition() {
            return position;
         }
     }

    /**
     * Evaluates the expression, starting with the lowest priority operation:
     * plusminus -> multdiv -> factor -> function
     * @param lexemeBuffer The processed lexeme buffer.
     * @return The result of the evaluated expression.
     */
    private  double expr(LexemeBuffer lexemeBuffer)
    {
            Lexeme lexeme = lexemeBuffer.next();
            if (lexeme.type == LexemeType.EOF){
                return 0;
            } else {
                lexemeBuffer.back();
                return plusminus(lexemeBuffer);
            }
    }

    /**
     * Evaluates arithmetic addition expressions.
     * @param lexemeBuffer The processed lexeme buffer.
     * @return The result of the evaluated expression.
     */
    private double plusminus(LexemeBuffer lexemeBuffer)
    {
        double value = multdiv(lexemeBuffer);
        while (true){
            Lexeme lexeme = lexemeBuffer.next();
            switch (lexeme.type){
                case OP_PLUS:
                    value += multdiv(lexemeBuffer);
                    break;
                case OP_MINUS:
                    value -= multdiv(lexemeBuffer);
                    break;
                case EOF: case RIGHT_BRACKET: case COMMA:
                    lexemeBuffer.back();
                    return value;
                default:
                    throw new RuntimeException("Wrong syntax at "+ lexemeBuffer.getPosition());
            }
        }
    }

    /**
     * Evaluates multiplication and division expressions.
     * @param lexemeBuffer The processed lexeme buffer.
     * @return The result of the evaluated expression.
     */
    private double multdiv(LexemeBuffer lexemeBuffer)
    {
        double value = factor(lexemeBuffer);
        while (true){
            Lexeme lexeme = lexemeBuffer.next();
            switch (lexeme.type){
                case OP_MUL:
                    value *= factor(lexemeBuffer);
                    break;
                case OP_DIV:
                    value /= factor(lexemeBuffer);
                    break;
                case EOF: case RIGHT_BRACKET: case COMMA: case OP_PLUS: case OP_MINUS:
                    lexemeBuffer.back();
                    return value;
                default:
                    throw new RuntimeException("Wrong syntax at "+ lexemeBuffer.getPosition());
            }
        }
    }

    /**
     * Evaluates the innermost factor.
     * @param lexemeBuffer The processed lexeme buffer.
     * @return The result of the evaluated expression.
     */
    private double factor(LexemeBuffer lexemeBuffer)
     {
        Lexeme lexeme = lexemeBuffer.next();
         double value;
        switch (lexeme.type){
            case FUNCTION_NAME:
            lexemeBuffer.back();
            return func(lexemeBuffer);
            case VARIABLE_NAME:
                return variableTable.get(lexeme.value);
            case OP_MINUS:
                value = factor(lexemeBuffer);
                return -value;
            case NUMBER:
                return Double.parseDouble(lexeme.value);
            case LEFT_BRACKET:
                value = expr(lexemeBuffer);
                lexeme = lexemeBuffer.next();
                if (lexeme.type!=LexemeType.RIGHT_BRACKET)
                {
                    throw  new RuntimeException("Bracket imbalance: expected '(' found " + lexeme.value +" at position"+ lexemeBuffer.getPosition());
                }
                return value;
            default:
                    throw new RuntimeException("Unexpected character found " + lexeme.value +" at position"+ lexemeBuffer.getPosition());
        }
     }

    /**
     * Evaluates the used functions.
     * @param lexemeBuffer The processed lexeme buffer.
     * @return The result of the evaluated expression.
     */
    private double func(LexemeBuffer lexemeBuffer){
         String functionName = lexemeBuffer.next().value;
         Lexeme lexeme = lexemeBuffer.next();

         if (lexeme.type != LexemeType.LEFT_BRACKET){
            throw new RuntimeException("Wrong function call syntax: " + lexeme.value);
         }
         ArrayList<Double> args = new ArrayList<>();
         lexeme = lexemeBuffer.next();
         if (lexeme.type!= LexemeType.RIGHT_BRACKET){
             lexemeBuffer.back();
             do {
                    args.add(expr(lexemeBuffer));
                    lexeme = lexemeBuffer.next();

                    if (lexeme.type != LexemeType.COMMA && lexeme.type!=LexemeType.RIGHT_BRACKET){
                        throw new RuntimeException("Wrong function call syntax: " + lexeme.value);
                    }

             }while (lexeme.type==LexemeType.COMMA);
         }
        return functionTable.get(functionName).apply(args);
    }
}
