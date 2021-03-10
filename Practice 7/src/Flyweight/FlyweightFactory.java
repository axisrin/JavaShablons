package Flyweight;

import java.util.HashMap;
import java.util.Hashtable;

public class FlyweightFactory {

    HashMap<Integer, ConcreteFlyweight> hashMap = new HashMap<>();

    public Flyweight GetFlyweight(int key) {
        if (!hashMap.containsKey(key))
            hashMap.put(key, new ConcreteFlyweight());

        return hashMap.get(key);
    }

}
