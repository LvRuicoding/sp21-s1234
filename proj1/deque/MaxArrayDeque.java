package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque {
    private Comparator cmp;


    public MaxArrayDeque(Comparator<T> c){
        super();
        cmp = c;
    }
    public T max(){
        T tem = (T) new Object();
        if(isEmpty()){return null;}
        tem = (T) this.get(0);
        for(int i = 0;i<size;i++){
            if (cmp.compare(tem,this.get(i))>0){
                tem = (T) this.get(i);
            }
        }
        return tem;
    }
    public T max(Comparator<T> c){
        T tem = (T) new Object();
        if(isEmpty()){return null;}
        tem = (T) this.get(0);
        for(int i = 0;i<size;i++){
            if (c.compare(tem,(T) this.get(i))>0){
                tem = (T) this.get(i);
            }
        }
        return tem;
    }

}

