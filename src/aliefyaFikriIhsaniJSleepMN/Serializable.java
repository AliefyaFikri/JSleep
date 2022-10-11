package aliefyaFikriIhsaniJSleepMN;


import java.util.HashMap;
import java.util.Objects;
import java.util.Map;

/**
 * Write a description of class Serializable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Serializable
{
    // instance variables - replace the example below with your own
    public int id;
    private static HashMap<Class<?>,Integer>
    mapCounter = new HashMap();

    protected Serializable()
    {
        if(mapCounter.get(this.getClass())==null){
            Integer count = 0;
            mapCounter.put(this.getClass(),count);
            this.id = 0;
        }
        else {
            Integer count = mapCounter.get(this.getClass());
            mapCounter.put(this.getClass(), ++count);
            this.id = count;
        }
    }

    public int compareTo (Serializable content){
        return Integer.compare(this.id, content.id);
    }

    public boolean equals(Object content){
        if (content instanceof Serializable) {
            Serializable serializable = (Serializable) content;
            return serializable.id == this.id;
        }
        else {
            return false;
        }
    }

    public boolean equals(Serializable content){
        return this.id == content.id;
    }

    public <T> Integer getClosingId(Class<T> classNum){
        return mapCounter.get(classNum);
    }

    public static <T> Integer setClosingId(Class<T> classNum, int id) {
        mapCounter.replace(classNum, id);
        return mapCounter.get(classNum);
    }
}
