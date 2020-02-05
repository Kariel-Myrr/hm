package hm13.parser;

import hm13.expression.*;

public class ExpressionParser {

    public static Object parse(final  String source){
        return parse(new StringExpSourse(source));
    }
    public static  Object parse(ExpSource source){
        return new ExpParser(source).parseExp();
    }

    private static class ExpParser extends BaseParser {
        public ExpParser(final ExpSource source){
            super(source);
            nextChar();
        }

        public Object parseExp() {
            final Object result = parseHeight();
            if (test('\0')) {
                return result;
            }
            throw error("End of Exp expected");


        }
        /*
            ws Exp ws sign ws Exp ws
        */
        public Exp parseHeight(){
            skipWhitespace();
            Exp first = parseLow();
            skipWhitespace();
            if(test('+')){
                return new Add(first, parseHeight());
            } else if(test('-')){
                return new Subtract(first, parseHeight());
            }
            return  first;

        }

        public Exp parseLow(){
            skipWhitespace();
            Exp first = parseUn();
            skipWhitespace();
            if(test('*')){
                return new Multiply(first, parseLow());
            } else if(test('/')){
                return new Divide(first, parseLow());
            }
            return  first;
        }

        public Exp parseUn(){
            skipWhitespace();
            if(test('(')){
                Exp buff =  parseHeight();
                if(test(')')){
                    return buff;
                }
                throw error("expected )");
            }
            if(test('-')){
                return  parseUn();
            }
            if(Character.isDigit(ch)){
                return parseConst();
            }
            if(Character.isLetter(ch)){
                return parseVarieble();
            }
            throw error("incorrect unar operation for '" + ch + "'");
        }

        private Variable parseVarieble() {
            if(ch == 'x' || ch == 'y' || ch == 'z'){
                return new Variable(next());
            }
            throw error("incorrect Varieble");
        }

        private Const parseConst() {
            return new Const((int)parseNumber());
        }

        private double parseNumber() {
            final StringBuilder sb = new StringBuilder();
            copyInteger(sb);

            /*
             * fraction
             *     ""
             *     '.' digits
             */
            if (test('.')) {
                sb.append('.');
                copyDigits(sb);
            }

            /*
             * exponent
             *     ""
             *     'E' sign digits
             *     'e' sign digits
             * sign
             *     ""
             *     '+'
             *     '-'
             */
            if (test('e') || test('E')) {
                sb.append('e');
                if (test('+')) {
                    // Do nothing
                } else if (test('-')) {
                    sb.append('-');
                }
                copyDigits(sb);
            }

            try {
                return Double.parseDouble(sb.toString());
            } catch (NumberFormatException e) {
                throw error("Invalid number " + sb);
            }
        }

        /*
         * digits
         *     digit
         *     digit digits
         *
         * digit
         *     '0'
         *     onenine
         */
        private void copyDigits(final StringBuilder sb) {
            while (between('0', '9')) {
                sb.append(ch);
                nextChar();
            }
        }

        /*
         * integer
         *     digit
         *     onenine digits
         *     '-' digit
         *     '-' onenine digits
         *
         * onenine
         *     '1' . '9'
         */
        private void copyInteger(final StringBuilder sb) {
            if (test('-')) {
                sb.append('-');
            }
            if (test('0')) {
                sb.append('0');
            } else if (between('1', '9')) {
                copyDigits(sb);
            } else {
                throw error("Invalid number");
            }
        }

        /*
         * ws
         *    ""
         *    '0020' ws
         *    '000A' ws
         *    '000D' ws
         *    '0009' ws
         */
        private void skipWhitespace() {
            while (test(' ') || test('\r') || test('\n') || test('\t')) {
                // skip
            }
        }
    }


}
