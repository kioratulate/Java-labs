package org.lab2.calculator;

import java.util.*;

/**
 * Класс калькулятора содержащий парсер и вычислитель выражения, встроенные с возможностью добавления функции и переменные
 */
public class Calculator {
    public HashMap<String, Function> functionTable;
    public void addFunction(String name, Function func){
        if (functionTable.containsKey(name))
            throw new RuntimeException("Redefining of function");
        functionTable.put(name, func);
    }

    public void addVariable(String name, double value){
        if (variableTable.containsKey(name))
            throw new RuntimeException("Redefining of variable");
        variableTable.put(name, value);
    }
    public void editVariable(String name, double newValue){
        if (!variableTable.containsKey(name))
            throw new RuntimeException("No variable with this name");
        variableTable.put(name, newValue);
    }

    public double getVariable(String name){
        if (!variableTable.containsKey(name))
            throw new RuntimeException("No variable with this name");
        return variableTable.get(name);
    }

    public HashMap<String, Double> variableTable;

    public Calculator() {
        functionTable = getFunctionMap();
        variableTable = new HashMap<>();
    }

    /**
     * Обработка выражения, внутри вызывающая сперва лексический анализ, затем собственно вычисление, возвращает результат выражения
     * @param expression выражение которое необходимо вычислить
     * @return результат вычисленного выражения
     */
    public double processExpression(String expression){
        List<Lexeme> lexemes = lexAnalyze(expression);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        return expr(lexemeBuffer);
    }

    /**
     * Используемые лексемы
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
     * Лексемы на которые разбивается выражение
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
     * Заполняет таблицу функций функциями по-умолчанию
     * @return полученную таблицу функций по умолчанию
     */
    private HashMap<String, Function> getFunctionMap()
     {
        HashMap<String, Function> functionTable = new HashMap<>();
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
     * Считывание значения переменной из входного потока консоил
     * @param name имя считываемой переменной
     * @return считанное значение
     */
     private double getUserVariable(String name){
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter value for variable " + name + ": ");
         return scanner.nextDouble();
     }

    /**
     * Лексический анализ выражения, разбиение на токены
     * @param expressionText разбираемое выражение
     * @return список присуствующих лексем
     */
    private List<Lexeme> lexAnalyze(String expressionText){
         ArrayList<Lexeme> lexemes = new ArrayList<>();
         int position = 0;
         while(position<expressionText.length())
         {
             char c = expressionText.charAt(position);
             switch (c){
                 case '(':{
                     lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                     position+=1;
                     continue;
                 }
                 case ')': {
                     lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                     position+=1;
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
         return lexemes;
    }

    /**
     * Буффер лексем, по которому перемещается калькулятор во время вычисления
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
     * Вычисление выражения, точка начала спуска по приоритетам операция, начиная с меньшего приоритета:
     * plusminus -> multdiv -> factor -> function
     * @param lexemeBuffer обрабатываемый буфер лексем
     * @return результат вычисленного выражения
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
     * Вычисление выражений арифметического сложения
     * @param lexemeBuffer обрабатываемый буфер лексем
     * @return результат вычисленного выражения
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
     * Вычисление выражений умножения и деления
     * @param lexemeBuffer обрабатываемый буфер лексем
     * @return результат вычисленного выражения
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
     * Вычисление самого внутреннего множителя
     * @param lexemeBuffer обрабатываемый буфер лексем
     * @return результат вычисленного выражения
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
     * Вычисление используемых функций
     * @param lexemeBuffer обрабатываемый буфер лексем
     * @return результат вычисленного выражения
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
