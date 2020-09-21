package one.hendra.androidbase.util.mapper;

import java.util.ArrayList;
import java.util.List;

public class ListMapperImpl<I, O> implements ListMapper<I, O> {

    private Mapper<I, O> mMapper;

    @Override
    public List<O> map(List<I> input) {
        if (input==null)
            return null;
        else{
            List<O> newO = new ArrayList<>();
            for (int i = 0; i < input.size(); i++) {
                newO.add(mMapper.map(input.get(i)));
            }
            return newO;
        }
    }

    @Override
    public List<I> reverseMap(List<O> output) {
        if (output==null)
            return null;
        else{
            List<I> newI = new ArrayList<>();
            for (int i = 0; i < output.size(); i++) {
                newI.add(mMapper.reverseMap(output.get(i)));
            }
            return newI;
        }
    }
}
