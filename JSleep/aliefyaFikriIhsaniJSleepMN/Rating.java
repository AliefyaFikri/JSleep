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
        total =+ rating;
        count = count+1;
    }
    
    public double getAverage(){
        return (total/count);
    }
    
    public long getCount(){
        return count;
    }
    
    public long getTotal(){
        return total;
    }
    
    
}
