package MyStackP;

public class MyStackArr<T>{

    T arr[];
    int size;
    public MyStackArr(){
        size = 0;
        arr = (T[])new Object[5];
    }
    public void push(T item){
        if(size == arr.length){
            resize();
        }
        arr[size++]=item;
    }
    public T pop(){
        if(size==0){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T item = arr[size-1];
        size--;
        return item;
    }

    public T peek(){
        if(size==0){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return arr[size-1];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void resize(){
        T temp[] = (T[]) new Object[arr.length*2];
        for(int i=0; i<arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for(int i=size-1; i>=0 ;  i--){
            res.append(arr[i]);
            if(i!=0){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
