import java.util.Arrays;

/**
 * 二叉堆
 */
public class MyBinaryHeap {
    public static void main(String[] args) throws Exception {
        MyBinaryHeap maxHeap = new MyBinaryHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(3);


        System.out.println(Arrays.toString(maxHeap.heap));
        maxHeap.delete(5);
        System.out.println(Arrays.toString(maxHeap.heap));
        maxHeap.delete(2);
        System.out.println(Arrays.toString(maxHeap.heap));
    }
    
    int[] heap;
    int heapSize;
    int childNodeNum=2;

    public MyBinaryHeap(int capacity) {
        heap=new int[capacity+1];
        heapSize=0;
        Arrays.fill(heap,-1);
    }

    public void insert(int num) throws Exception {
        if(isFull()){
            throw new Exception("Full");
        }
        heap[heapSize]=num;
        heapSize++;
        heapifyUp(heapSize-1);
    }

    public int delete(int i) throws Exception {
        if(isEmpty()){
            throw new Exception("Empty");
        }
        int ele=heap[i];
        heap[i]=heap[heapSize-1];
        heapSize--;
        heapifyDown(i);
        return ele;
    }

    public int findMax() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty");
        }
        return heap[0];
    }

    private void heapifyDown(int i) {
        int value=heap[i];
        while (kthChild(i,1)<heapSize){
            int child=maxChild(i);
            if(heap[i]>=heap[child]){
                break;
            }
            heap[i]=heap[child];
            i=child;
        }
        heap[i]=value;
    }

    private int maxChild(int i) {
        int l=kthChild(i,1);
        int r=kthChild(i,2);
        return heap[l]>heap[r]?l:r;
    }

    private int kthChild(int i,int k) {
        return childNodeNum*i+k;
    }

    private void heapifyUp(int i) {
        int value=heap[i];
        while (i>0&&heap[i]>heap[parent(i)]){
            heap[i]=heap[parent(i)];
            i=parent(i);
        }
        heap[i]=value;
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    private boolean isFull(){
        return heapSize==heap.length;
    }

    private boolean isEmpty(){
        return heapSize==0;
    }
}
