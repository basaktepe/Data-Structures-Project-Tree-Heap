import java.util.ArrayList;


public class TreeNode {

    private NationalPark data;
    private TreeNode leftchild;
    private TreeNode rightchild;

    public TreeNode(NationalPark data)
    {
        this.data = data;

    }

    public NationalPark getData() {
        return data;
    }

    public void setData(NationalPark data) {
        this.data = data;
    }

    public TreeNode getLeftchild() {
        return leftchild;
    }

    public void setLeftchild(TreeNode leftchild) {
        this.leftchild = leftchild;
    }

    public TreeNode getRightchild() {
        return rightchild;
    }

    public void setRightchild(TreeNode rightchild) {
        this.rightchild = rightchild;
    }
    public void displayNode(){
        System.out.println(data);
    }


}

