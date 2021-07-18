package homeWork5;

import java.util.*;

public class Metods {
    // Напишите метод, который на вход получает коллекцию объектов любого типа, а возвращает коллекцию, но уже без дубликатов;
    public static <T> List<T> GetNoDuplicate(List<T> list) {
        return new ArrayList<>(new HashSet(list));
    }

    //public static <T> T GetNoDuplicate(T list){
    //    Set setElem = new HashSet ((Collection) list);
    //    return (T) setElem;
    //}


    public static <K, V> Map<V, Collection<K>> inverse(Map<K, V> map) {
        Map mapNew = new HashMap();
        for (var i : map.entrySet()) {
            mapNew.put(i.getValue(), i.getKey());
        }
        return mapNew;
    }
}
