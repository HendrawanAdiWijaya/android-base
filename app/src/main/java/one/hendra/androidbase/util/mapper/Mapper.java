package one.hendra.androidbase.util.mapper;

public interface Mapper<I, O> {

    O map(I input);

    I reverseMap(O output);

}
