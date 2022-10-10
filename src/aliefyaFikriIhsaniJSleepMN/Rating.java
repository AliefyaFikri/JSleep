package aliefyaFikriIhsaniJSleepMN;

public class Rating
{
    private long total;
    private long count;
    
    public Rating(){
        total = 0;
        count = 0;
    }
    
    public void insert(int rating){
        total += rating;
        count++;
    }
    
    public double getAverage(){
        if (count == 0){
            return 0.0d;
        }
        return (double) total/count;
    }
    
    public long getCount(){
        return count;
    }
    
    public long getTotal(){
        return total;
    }
    
    public String toString(){
        String print = "Total: " + total +
                   "\nCount: " + count ;
        return print;
    }
    
    
}
