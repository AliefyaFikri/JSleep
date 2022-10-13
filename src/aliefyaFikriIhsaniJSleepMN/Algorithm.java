package aliefyaFikriIhsaniJSleepMN;
import java.util.function.Predicate;
import java.util.*;

public class Algorithm {
    private Algorithm(){

    }

    public static <T> List<T> collect(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }
    public static <T> List<T> collect(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }
    public static <T> List<T> collect(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }
    public static <T> List<T> collect(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }
    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }
    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred){
        List<T> newlist = new ArrayList<>();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.test(current))
                newlist.add(current);
        }
        return newlist;
    }

    public static <T> int count(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }
    public static <T> int count(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }
    public static <T> int count(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }
    public static <T> int count(T [] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int count = 0;
        while(iterator.hasNext()){
            T current = iterator.next();
            if(pred.test(current)){
                count++;
            }
        }
        return count;
    }

    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }
    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }
    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }
    public static <T> boolean exists(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()){
            T current = iterator.next();
            if (pred.test(current))
                return true;
        }
        return false;
    }

    public static <T> T find(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }

    public static <T> T find(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    public static <T> T find(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.test(current)) {
                return current;
            }
        }
        return null;
    }
    
}
