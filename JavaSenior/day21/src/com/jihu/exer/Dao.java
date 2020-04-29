package com.jihu.exer;

import java.util.*;

public class Dao<T> {

    private Map<String,T> map = new HashMap<String,T>();

    public void save(String id,T entity){
        map.put(id,entity);
    }

    public T get(String id){
       return map.get(id);
    }

    public void update(String id,T entity){
        if(map.containsKey(id)){
            map.put(id,entity);
        }
    }

    public List<T> list(){
        //错误的
//        Collection<T> values = map.values();
//        return (List<T>) values;
        List<T> list = new ArrayList<>(map.values());
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }
}
