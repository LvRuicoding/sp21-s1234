package deque;

import org.apache.commons.collections.iterators.ArrayIterator;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>{
    private int size;
    private T[] items;
    private int nextfirst;
    private int nextlast;
    private class ArrayDequeIterator implements Iterator<T> {
        int tem = nextfirst;
        public boolean hasNext(){
            if (items[tem+1] != null){return true;}
            return false;
        }
        public T next(){
            if(! hasNext()){return null;}
            tem+=1;
            return items[tem];
        }
    }
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextfirst = 3;
        nextlast = 4;
    }
    public int size(){
        return size;
    }
    private void resize(int length){
        T[] tem = (T[]) new Object[length];
        int start = (length - size)/2;
        for(int i =0;i<size;i++){
            tem[start+i] = items[nextfirst+1+i];
        }
        nextfirst = start - 1;
        nextlast = start + size;
        items = tem;
    }
    public void addFirst(T item){
        if(nextfirst==-1){resize(items.length*2);}
        items[nextfirst] = item;
        size+=1;
        nextfirst-=1;
    }
    public void addLast(T item){
        if(nextlast==items.length){resize(items.length*2);}
        items[nextlast] = item;
        size+=1;
        nextlast+=1;
    }
    public T removeFirst(){
        if (size==0){return null;}
        T tem = items[nextfirst+1];
        if(items.length>16 && size*4<items.length){
            resize(items.length/2);
        }
        size-=1;
        nextfirst+=1;
        items[nextfirst] = null;
        return tem;
    }
    public T removeLast(){
        if (size==0){return null;}
        T tem = items[nextlast-1];
        if(items.length>16 && size*4<items.length){
            resize(items.length/2);
        }
        size-=1;
        nextlast-=1;
        items[nextlast] = null;
        return tem;
    }
    public void printDeque(){
        for(int i=0;i<size;i++){
            System.out.print(items[nextfirst+1+i]);
            System.out.print(" ");
        }
        System.out.println("");
    }
    public T get(int index){
        if(index>size){return null;}
        return items[nextfirst+index+1];
    }
    public Iterator<T> iterable(){
        return new ArrayIterator();
    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof ArrayDeque)) {
            return false;
        }
        ArrayDeque<T> oa = (ArrayDeque<T>) o;
        if (oa.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            if (!(oa.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }

}
