import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        ArrayList<NationalPark> NpList = ReadFileMakeNPList("src/NationalData.txt");
        ArrayList<NationalPark> newNPList = ReadFileAddParagraphs("src/paragraphs.txt", NpList);
        Tree tree = new Tree();
        tree.InsertAllParks(newNPList);
        int depht =   tree.FindTreeHeight();
        System.out.println("*********************** Ağacın Derinliğini Bulma ******************************************");
        System.out.println("Ağaç derinliği : " + depht);
        System.out.println("*********************** Ağacı Dolaşıp Bilgileri Yazdırma ***********************************");
        tree.traverseTree();
        System.out.println("*********************** Ağacın Düğüm Sayısını Bulma ***************************************");
        int numberOfNodes = tree.FindCount();
        System.out.println("Ağacın düğüm sayısı : " + numberOfNodes);
        System.out.println("********************* Dengeli Bir Ağaç Olsaydı Derinliği Kaç olurdu? **********************");
        int balancedHeight =  tree.FindBalancedHeight();
        System.out.println(balancedHeight);
        System.out.println("************************* Adının ilk 3 harfi verilen parkı bulma **************************");
        searchName(tree);
        System.out.println("*************** Ağacı gezerek paragraflardaki kelimelerden yeni ağaç oluşturma**************");
        TreeST wordTree = new TreeST();
        tree.traverseAndGetNodes(currentNode ->{
            for (String i: currentNode.getData().getParagraphs())
            {
                i.replaceAll("[,-]","");
                for(String j : i.split(" "))
                {
                    wordTree.Insert(j);
                }
            }
        });
        wordTree.printTreeST();
        System.out.println("************************************* Hash Table ******************************************");
        Hashtable<String,NationalPark> hashtable = new Hashtable<>();
        for(NationalPark np : newNPList)
        {
            hashtable.put(np.getPark_name(), np);
        }
        System.out.println(hashtable);
        System.out.println("***********************İsmini verdiğimiz parkın tarihini değiştirme************************");
        updateHashTable(hashtable);
        System.out.println(hashtable);
        System.out.println("************************************* Heap ************************************************");
        maxHeap heap = new maxHeap(newNPList.size());
        heap.InsertAllItemsToHeap(newNPList);
        System.out.println("************************** En büyük yüzölçümlü 3 parkı döndürme **************************");
        heap.returnMaxThreeItems();
        System.out.println("***************************************Bubble Sort*****************************************");
        int arraySize = 5;
        BubbleSortImplementation bubbleSortImplementation = new BubbleSortImplementation(arraySize);
        bubbleSortImplementation.insert(3);
        bubbleSortImplementation.insert(10);
        bubbleSortImplementation.insert(6);
        bubbleSortImplementation.insert(8);
        bubbleSortImplementation.insert(22);
        bubbleSortImplementation.bubbleSort();
        bubbleSortImplementation.displayArr();




        }
        static maxHeap InsertAllItemsToHeap(maxHeap heap, ArrayList<NationalPark> npList)

        {
            for (NationalPark np : npList) {
                heap.insert(np);
            }
            return heap;
        } // End InsertAllItemsToHeap()

    static ArrayList<NationalPark> ReadFileMakeNPList(String pathname) throws FileNotFoundException {
        ArrayList<NationalPark> NpList = new ArrayList<>();
        File file = new File(pathname);
        Scanner sc = new Scanner(file);
        String[] variables;
        NationalPark current_np;
        while (sc.hasNextLine())
        {

            variables = sc.nextLine().split("\t");
            current_np = new NationalPark(variables[0], variables[1], stToInt(variables[2]),
                    variables[3]);
            NpList.add(current_np);

        }
        return NpList;
    }
    static ArrayList<NationalPark> ReadFileAddParagraphs(String pathname, ArrayList<NationalPark> NpList) throws
            FileNotFoundException {
        File file = new File(pathname);
        Scanner sc = new Scanner(file);
        String[] lineArr;
        int count = 0;
        while (sc.hasNextLine())
        {
            lineArr = sc.nextLine().split("\\. ");
            ArrayList<String> variables= new  ArrayList<> (Arrays.asList(lineArr));
            NpList.get(count).setParagraphs(variables);
            count++;

        } // End While
        return NpList;
    } // End ReadFileAddParagraphs

    static int stToInt(String st){
        String new_string = st.replace("," , "");
        int newInt = Integer.parseInt(new_string);
        return newInt;
    }// End stToInt
    static void searchName(Tree tree){
        System.out.println("Parkın ilk üç harfini giriniz.");
        Scanner scan = new Scanner(System.in);
        String searchedName = scan.nextLine();
        TreeNode searchedNP = tree.FindNP(tree.getRoot(), searchedName);
        if(searchedNP == null)
            System.out.println("Park bulunamadı");
        else
            System.out.println("Bu milli park, " + searchedNP.getData().getCity_name() + " il ve ilçelerinde bulunur");

    }
    static Hashtable<String,NationalPark> updateHashTable(Hashtable<String,NationalPark> hashtable)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("İlan tarihini değiştirmek istediğiniz parkın ismini giriniz");
        String name = scanner.nextLine();
        name = name + " ";
        System.out.println("Yeni ilan tarihini giriniz");
        String newDate = scanner.nextLine();
        if(hashtable.get(name) == null)
        {
            System.out.println("Böyle bir park yok.");
            return hashtable;
        }
        hashtable.get(name).setDate(newDate);
        return hashtable;
    }

} // End of the Main






