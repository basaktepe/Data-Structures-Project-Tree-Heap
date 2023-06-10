import java.util.ArrayList;

    public class Heap {
        private HeapNode[] heapArr;
        private int size;
        private int heapSize;

        public Heap(int heapSize)
        {
            this.size = 0;
            this.heapSize = heapSize;
            heapArr = new  HeapNode[heapSize];
        }

        public HeapNode[] getHeapArr() {
            return heapArr;
        }

        public void setHeapArr(HeapNode[] heapArr) {
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

        public void InsertAllItemsToHeap( ArrayList<Integer> arrlist)

        {
            for (int n : arrlist) {
                insert(n);
            }

        }
        public boolean insert(int n)
        {
            if(size == heapSize)
            {
                return false;
            }
            HeapNode newNode = new HeapNode(n);
            heapArr[size] = newNode;
            trickleUp(size++);
            return true;
        } // end insert()
        public  HeapNode remove()
        {
            HeapNode rootNode = heapArr[0];
            heapArr[0] = heapArr[--size];
            trickleDown(0);
            return rootNode;
        } // End Remove()
        public void trickleUp(int position)
        {
            int parent = parentNode(position);
            HeapNode bottom = heapArr[position];

            while ((position > 0) && (heapArr[parent].getData()) < bottom.getData())
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
            HeapNode top = heapArr[position];

            while (position < size / 2) //En azından 1 çocuğu olmalı
            {
                int leftChild = leftChild(position);
                int rightChild = rightChild(position);

                if (rightChild < size && heapArr[leftChild].getData() < heapArr[rightChild].getData())
                {
                    largerChild = rightChild;
                }
                else
                {
                    largerChild = leftChild;
                }
                if (top.getData() >= heapArr[largerChild].getData())
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
                    System.out.println(" Sayı: " + heapArr[i].getData());
            }

        }

    }


