public class TreeNodeST {
    private String word;
    private  int count;
    private TreeNodeST leftchild;
    private TreeNodeST rightchild;

    public TreeNodeST(String word)
    {
        this.word = word;
        count = 1;
    }
    public void increaseount(){
        count++;
    }
    public void displayNodeST()
    {
        System.out.println("Kelime:  " + getWord()  + " Kullanılma sayısı : " + getCount());
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TreeNodeST getLeftchild() {
        return leftchild;
    }

    public void setLeftchild(TreeNodeST leftchild) {
        this.leftchild = leftchild;
    }

    public TreeNodeST getRightchild() {
        return rightchild;
    }

    public void setRightchild(TreeNodeST rightchild) {
        this.rightchild = rightchild;
    }

}
