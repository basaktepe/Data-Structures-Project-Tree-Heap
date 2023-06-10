public class BubbleSortImplementation {

    private int[] bubbleArr;
    private int count; // eleman sayısı

    public BubbleSortImplementation(int maxSize) {

        bubbleArr = new int[maxSize]; // dizi boyutunu tanımladık
        count = 0; //henüz hiç eleman yok

    }
    public void insert(int item)
    {
        bubbleArr[count++] = item;
    }
    public void  bubbleSort()
    {
        int temp;
        for(int i = 0 ; i < count ; i++)
        {
            for(int j = 1 ; j < (count - 1) ; j++)
            {
                if(bubbleArr[j-1] > bubbleArr[j]) {
                    temp = bubbleArr[j - 1]; // Kaybetmemek için tempe atadık
                    bubbleArr[j - 1] = bubbleArr[j];
                    bubbleArr[j] = temp;
                }

            }//End for
        } //End for
    } //End bubbleSort()
    public void displayArr()
    {
        for (int n:bubbleArr)
        {
            System.out.println("Sıradaki sayı: " + n);

        }
    }// end displayArr()
} // End Class
