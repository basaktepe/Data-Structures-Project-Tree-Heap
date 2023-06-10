import java.util.ArrayList;

public class maxHeap {
    private Node[] heapArr;
    private int size;
    private int heapSize;

    public maxHeap(int heapSize)
    {
        this.size = 0;
        this.heapSize = heapSize;
        heapArr = new  Node[heapSize];
    }

    public Node[] getHeapArr() {
        return heapArr;
    }

    public void setHeapArr(Node[] heapArr) {
        this.heapArr = heapArr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }
    private int parentNode(int position)
    {
        return (position - 1) / 2;
    }
    private int leftChild(int position)
    {
        return position*2 + 1;
    }
    private int rightChild(int position)
    {
        return position*2 + 2;
    }

    public void returnMaxThreeItems() // En büyük 3 milli parkı heapten çekerek gösterir
    {
        NationalPark np1 = remove().getData();
        NationalPark np2 = remove().getData();
        NationalPark np3 = remove().getData();
        System.out.println( "Yüz ölçümü en büyük 1. park:" + np1.toString() + "\n" +  "Yüz ölçümü en büyük 1. park:"+
                np2.toString() + "\n"+  "Yüz ölçümü en büyük 1. park:" + np3.toString()  + "\n" );
    } // End returnMaxThreeItems

    public void InsertAllItemsToHeap( ArrayList<NationalPark> npList)

    {
        for (NationalPark np : npList) {
            insert(np);
        }

    }
    public boolean insert(NationalPark np)
    {
        if(size == heapSize)
        {
            return false;
        }
        Node newNode = new Node(np);
        heapArr[size] = newNode;
        trickleUp(size++);
        return true;
    } // end insert()
    public  Node remove()
    {
        Node rootNode = heapArr[0];
        heapArr[0] = heapArr[--size];
        trickleDown(0);
        return rootNode;
    } // End Remove()
    public void trickleUp(int position)
    {
        int parent = parentNode(position);
        Node bottom = heapArr[position];

        while ((position > 0) && (heapArr[parent].getData().getAcreage()) < bottom.getData().getAcreage())
        {
            heapArr[position] = heapArr[parent];
            position = parent;
            parent = (parent - 1) / 2;
        } // End while
        heapArr[position] = bottom;
    } // End trickleUp
    public void trickleDown(int position)
    {
        int largerChild;
        Node top = heapArr[position];

        while (position < size / 2) //En azından 1 çocuğu olmalı
        {
            int leftChild = leftChild(position);
            int rightChild = rightChild(position);

            if (rightChild < size && heapArr[leftChild].getData().getAcreage() < heapArr[rightChild].getData().getAcreage())
            {
                largerChild = rightChild;
            }
            else
            {
                largerChild = leftChild;
            }
            if (top.getData().getAcreage() >= heapArr[largerChild].getData().getAcreage())
                break;
            heapArr[position] = heapArr[largerChild];
            position = largerChild;
        } // End While
        heapArr[position] = top;
    } // End trickleDown

    public Boolean isEmpty()
    {
        return size == 0;
    }

    public void printHeap()
    {
        System.out.println("Heap ' e dair dizi : ");
        for(int i = 0 ; i < heapSize ; i++)
        {
            if(heapArr[i] != null)
            System.out.println(" Milli Park:  " + heapArr[i].getData());
        }

    }

}

