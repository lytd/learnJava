package singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Regeiser {
    private static Map<String ,Object> map=new ConcurrentHashMap<String,Object>();

    public Regeiser getInstance(String name){
        if(null==name){
            name=Regeiser.class.getName();
        }
        if(null==map.get(name)){
            map.put(name,new Regeiser());

        }
        return (Regeiser) map.get(name);
    }

}
