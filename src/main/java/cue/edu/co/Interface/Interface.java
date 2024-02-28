package cue.edu.co.Interface;

import java.util.List;

public interface Interface <T>{
    List<T> list();
    T byId(long id);
    void save(T t);
    void delete(long id);

}
