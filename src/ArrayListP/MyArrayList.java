package ArrayListP;

public class MyArrayList<T> {

    private T arr[] ;
    private int size;

    public MyArrayList(){
        arr = (T[]) new Object[5];
        size=0;
    }
    public MyArrayList(int capacity){
        arr = (T[]) new Object[capacity];
        size=0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(T value){
        if(size==arr.length){
            resize(arr.length*2);
        }
        arr[size++]=value;
    }

    public void resize(int newCapacity){

        T temp[] = (T[]) new Object[newCapacity];

        for(int i=0;i<size;i++) {
            temp[i] = arr[i];
        }
        arr=temp;
    }

    public T get(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("index" + index);
        }
        return arr[index];
    }

    public void add(T value , int index){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("index" + index);
        }
        shiftRight(index);
        arr[index]=value;
    }
    private void shiftRight(int index){

        if(size==arr.length){
            resize(arr.length*2);
        }

        for(int i=size ; i>=index ; i--){
            arr[i]=arr[i-1];
        }
        size++;
    }

    public String toString(){

        StringBuilder res = new StringBuilder("[");
        for(int i=0;i<size;i++){
            res.append(arr[i]);
            if(i!=size-1){
                res.append(", ");
            }
        }
        return res.append("]").toString();
    }

    public void set(int index , T value){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("index" + index);
        }
        arr[index]=value;

    }

    public T remove(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("index" + index);
        }
        T oldValue=arr[index];
        shiftLeft(index);
        return oldValue;
    }

    public T remove(T value){
        if(indexOf(value)==-1){
            throw new IndexOutOfBoundsException("index" + value);
        }
        return remove(indexOf(value));
    }
    public int indexOf(T value){
        for(int i=0;i<size;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }

    private void shiftLeft(int index){

        for(int i=index ; i<size-1 ; i++){
            arr[i]=arr[i+1];
        }
        arr[--size]=null;
    }

    public void addAll(MyArrayList<T> other){
        for(int i=0 ; i<other.size() ; i++){
            this.add(other.get(i));
        }
    }

    public boolean contains(T value){
        return indexOf(value)!=-1;
    }

    public void addAll(MyArrayList<T> other, int index){

        for(int i=0 ; i<other.size() ; i++){
            this.add(other.get(i) , index++);
        }

    }

    public boolean containsAll(MyArrayList<T> other){
        for(int i=0 ; i<other.size() ; i++){
            if(!this.contains(other.get(i))){
                return false;
            }
        }
        return true;
    }

    public int lastIndexOf(T value){
        for(int i=size-1 ; i>=0 ; i--){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }

    public MyArrayList<T> subList(int fromIndex, int toIndex){

        MyArrayList<T> res = new MyArrayList<>();
        for(int i=fromIndex ; i<=toIndex ; i++){
            res.add(arr[i]);
        }
        return res;
    }

    public static void removeAllOdd(MyArrayList<Double> list){

        for(int i=0 ; i<list.size() ; i++){

            if(Math.floor(list.get(i))%2 !=0){
                list.remove(i);
                i--;
            }

        }


    }


}
