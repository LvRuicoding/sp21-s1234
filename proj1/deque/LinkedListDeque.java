package deque;

import java.util.Iterator;

public class LinkedListDeque<T> {
    private int size;
    private Node sentinal;
    public class Node{
        public T item;
        public Node prev;
        public Node next;
        public Node(Node p,Node n,T i){
            prev = p;
            next = n;
            item = i;
        }
    }
    private class LinkedListDequeIterator implements Iterator<T> {
        private Node tem = sentinal;
        @Override
        public boolean hasNext() {
            if (tem.next==sentinal){return false;}
            return true;
        }

        @Override
        public T next() {
            if(! hasNext()){return null;}
            tem = tem.next;
            return tem.item;
        }
    }
    public void addFirst(T item){
        Node tem = sentinal.next;
        sentinal.next= new Node(sentinal,tem,item);

        if(isEmpty()){
            sentinal.prev=sentinal.next;
            sentinal.next.next = sentinal;
        }
        size+=1;
    }
    public void addLast(T item){
        Node tem = sentinal.prev;
        sentinal.prev = new Node(tem,sentinal,item);
        sentinal.prev.prev.next = sentinal.prev;
        if(isEmpty()){
            sentinal.next=sentinal.prev;
            sentinal.prev.prev = sentinal;
        }
        size+=1;
    }

    public boolean isEmpty(){
        if(size==0){return true;}
        return false;
    }
    public int size(){
        return this.size;
    }
    public void printDeque(){
        Node tem = sentinal.next;
        for(int i=0;i<size;i++){
            System.out.print(tem.item);
            System.out.print(" ");
            tem=tem.next;
        }
        System.out.println("");
    }
    public T removeFirst(){
        if(isEmpty()){return null;}
        Node tem = sentinal.next;
        sentinal.next=sentinal.next.next;
        sentinal.next.prev=sentinal;
        size-=1;
        return tem.item;
    }
    public T removeLast(){
        if(isEmpty()){return null;}
        Node tem = sentinal.prev;
        sentinal.prev=sentinal.prev.prev;
        sentinal.prev.next=sentinal;
        size-=1;
        return tem.item;
    }

    public LinkedListDeque(){
        size = 0;
        sentinal = new Node(null,null,null);
        sentinal.next = sentinal;
        sentinal.prev = sentinal;
    }
    public T get(int index){
        if(index>size){return null;}
        Node tem = sentinal;
        for (int i=0;i<index;i++){
            tem = tem.next;
        }
        return tem.next.item;
    }
    public T getRecursive(int index){
        if(index>size){return null;}
        return get_recursive(index,sentinal);
    }
    private T get_recursive(int index,Node n){
        if (index == 0){return n.item;}
        return get_recursive(index - 1,n.next);
    }
    public Iterator<T> iterator(){
        return new LinkedListDequeIterator();
    }

    public boolean equals(Object o){
        if(o instanceof LinkedListDeque){
            if(((LinkedListDeque<?>) o).isEmpty() && this.isEmpty()){return true;}
            for(int i=0;i<this.size;i++){
                if(this.get(i)!=((LinkedListDeque<?>) o).get(i)){
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
