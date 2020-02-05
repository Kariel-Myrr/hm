package hm12.parser;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class BaseParser {
    private final ExpSource source;
    protected char ch;

    protected BaseParser(final  ExpSource source) {
        this.source = source;
    }

    protected void  nextChar() {
        ch = source.hasNext() ? source.next() : '\0';
    }

    public char next(){
        char buff = ch;
        nextChar();
        return buff;
    }

    protected  boolean test(char expected) {
        if(ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected  void expect(final char c){
        if(ch != c){
            throw error("Expected '" + c + "', found '" + ch + "'");
        }
        nextChar();
    }

    protected  void  expect(String value) {
        for (char c : value.toCharArray()) {
            expect(c);
        }
    }

    protected EPExeption error(final String message) {
        return source.error(message);
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }
}
