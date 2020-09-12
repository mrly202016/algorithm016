/**
 * leetcode做题-设计循环双端队列  https://leetcode-cn.com/problems/design-circular-deque/
 */
public class MyCircularDeque {
    private int capacity;
    private int[] arr;
    private int front;
    private int end;

    public MyCircularDeque(int k) {
        capacity=k+1;
        arr=new int[capacity];
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front=(front+capacity-1)%capacity;
        arr[front]=value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[end] = value;
        end = (end + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front=(front+1)%capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        end=(end+capacity-1)%capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(end+capacity-1)%capacity];
    }

    public boolean isEmpty(){
        return front==end;
    }

    public boolean isFull() {
        return (end+1)%capacity==front;
    }
}
