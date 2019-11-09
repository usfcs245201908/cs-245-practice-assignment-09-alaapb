import java.util.Arrays;

public class BinaryHeap{
    public int[] list;
    public int size;

    public BinaryHeap() {
        list = new int[10];
        size = 0;
    }

    public void growArray() {
        int[] copy = Arrays.copyOfRange(list, 0, list.length*2);
        list = copy;
    }

    public void add(int item) { // add the item to the list depending on the priority
        if(list.length == size) {
            growArray();
        }
        list[size++] = item;
        int child = size - 1;
        int parent = (child - 1) / 2;
        while(child != 0 && list[child] < list[parent]) {
            swap(list, child, parent);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public int remove() { // remove the highest priority
        try {
            if(size == 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Not valid");
        }
        swap(list, 0 , size - 1);
        size--;
        if(size > 0) {
            siftDown(0);
        }
        return list[size];
    }

    public void siftDown(int pos) {
        int parent = pos;
        int lChild = 2 * parent + 1;
        int rChild = 2 * parent + 2;

        if (lChild >= size || rChild >= size) {
            return;
        }

        if (list[lChild] > list[rChild] && list[rChild] < list[parent]) {
            swap(list, parent, rChild);
            siftDown(rChild);
        } else if (list[rChild] > list[lChild] && list[lChild] < list[parent]) {
            swap(list, parent, lChild);
            siftDown(lChild);
        }
    }

    private void swap(int[] list, int pos, int child) {
        int temp = list[pos];
        list[pos] = list[child];
        list[child] = temp;
    }
}
