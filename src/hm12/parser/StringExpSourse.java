package hm12.parser;

public class StringExpSourse implements  ExpSource{
    private final String data;
    private int pos;

    public StringExpSourse(final  String data){
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public char next() {
        return data.charAt(pos++);
    }

    @Override
    public EPExeption error(String massege) {
        return new EPExeption(pos + ": " + massege);
    }
}
