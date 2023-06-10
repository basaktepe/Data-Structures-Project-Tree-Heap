import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Consumer;


public class Tree {
    private TreeNode root;

    public void traverseAndGetNodes(Consumer<TreeNode> consumer) {
        traverseAndGetNodes(root, consumer);
    }
    private void traverseAndGetNodes(TreeNode currentNode, Consumer<TreeNode> consumer ) {
        if (currentNode != null) {
            traverseAndGetNodes(currentNode.getLeftchild(), consumer);
            consumer.accept(currentNode);
            traverseAndGetNodes(currentNode.getRightchild(), consumer);
        } // End if
    }

    public Tree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void InsertAllParks(ArrayList<NationalPark> NPList) { // Arraylistteki National Park nesnelerini Tree'ye ekle
        //yen metot
        for (NationalPark nationalPark : NPList) {
            Insert(nationalPark);
        }
    } // End InsertAllParks()

    public void Insert(NationalPark np) {

        TreeNode newNode = new TreeNode(np);
        String newName = newNode.getData().getPark_name();
        if (getRoot() == null) {
            setRoot(newNode);
        } else {
            TreeNode currentNode = root;
            TreeNode parent;
            while (true) {
                parent = currentNode;

                if (compareTR(newName, currentNode.getData().getPark_name()) < 0) {
                    currentNode = currentNode.getLeftchild();
                    if (currentNode == null) {
                        parent.setLeftchild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightchild();
                    if (currentNode == null) {
                        parent.setRightchild(newNode);
                        return;
                    } // End if
                } // End else
            } // End While
        } //End else
    } // End Insert

    public int FindTreeHeight() {
        return FindTreeHeight(root);
    }
    private int FindTreeHeight(TreeNode root) {
        if (root != null)
            return 1 + Math.max(FindTreeHeight(root.getLeftchild()), FindTreeHeight(root.getRightchild()));
        else
            return 0;
    } // End FindTreeHeight

    public void traverseTree() {
        traverseTree(root);
    }
    private void traverseTree(TreeNode currentRoot) {
        if (currentRoot != null) {
            traverseTree(currentRoot.getLeftchild());
            currentRoot.displayNode();
            traverseTree(currentRoot.getRightchild());
        } // End if
    }// End PrintTree

    public int count = 0;
    public int FindCount() {
        return FindCount(root);
    }
    private int FindCount(TreeNode node) {
        if (node == null)
            return count;
        count++;
        count = FindCount(node.getLeftchild());
        count = FindCount(node.getRightchild());
        return count;
    } // End FindCount

    public int FindBalancedHeight() // 2^(n+1) - 1
                                                // log2 tabanında (h+1) - 1
    {
        int count = FindCount();
        double logResult = (int) (Math.log(count + 1 ) / Math.log(2));
        if (logResult == (int)logResult)
            return (int) logResult; // Tam doluysa
        else
            return (int) logResult + 1; // Tam + 0.xxxx

    } // End FindBalancedHeight()

    public TreeNode FindNP(TreeNode currentRoot ,String searchedName) {

        while (true) {
            if (currentRoot == null) {
                return null;
            } // End if
            if (compareTR( searchedName , currentRoot.getData().getPark_name().substring(0, 3)) > 0) {
                return FindNP(currentRoot.getRightchild(),searchedName);
            } else if (compareTR( searchedName , currentRoot.getData().getPark_name().substring(0, 3)) < 0) {
                return FindNP(currentRoot.getLeftchild(),searchedName);
            }
            else{
                return currentRoot;
            } // End Else
        }// End While
    } // End FindNP

    public int compareTR(String st1, String st2 ){ //Türkçe karakterli stringleri karşılaştıran metot
        Locale localeTR = new Locale("tr", "TR");
        Collator collator = Collator.getInstance(localeTR);

        return collator.compare(st1,st2);
    } // End compareTR



} // End of the class
