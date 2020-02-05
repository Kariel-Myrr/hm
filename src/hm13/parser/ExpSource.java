package hm13.parser;

public interface ExpSource {
    boolean hasNext();
    char next();
    EPExeption error(final String massege);

}
