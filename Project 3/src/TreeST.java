import java.text.Collator;
import java.util.Locale;

public class TreeST {

    private TreeNodeST root;

    public TreeST() {
        root = null;
    }

    public TreeNodeST getRoot() {
        return root;
    }

    public void setRoot(TreeNodeST root) {
        this.root = root;
    }

    public void Insert(String st) {

        TreeNodeST newNode = new TreeNodeST(st);

        if (getRoot() == null) {
            setRoot(newNode);
        }
        else
        {
            TreeNodeST currentNode = root;
            TreeNodeST parent;
            while (true) {
                parent = currentNode;
                if(compareTR(st, currentNode.getWord()) == 0){
                    currentNode.increaseount();
                    return;
                }
                else if (compareTR(st, currentNode.getWord()) < 0)
                {
                    currentNode = currentNode.getLeftchild();
                    if (currentNode == null)
                    {
                        parent.setLeftchild(newNode);
                        return;
                    }
                }
                else
                {
                    currentNode = currentNode.getRightchild();
                    if (currentNode == null) {
                        parent.setRightchild(newNode);
                        return;
                    } // End if
                } // End else
            } // End While
        } //End else
    } // End Insert

    public void printTreeST(){
        printTreeST(root);
    }
    private void printTreeST(TreeNodeST currentRoot){
        if (currentRoot != null) {
            printTreeST(currentRoot.getLeftchild());
            currentRoot.displayNodeST();
            printTreeST(currentRoot.getRightchild());
        } // End if
    }
    public int compareTR(String st1, String st2) { //Türkçe karakterli stringleri karşılaştıran metot
        Locale localeTR = new Locale("tr", "TR");
        Collator collator = Collator.getInstance(localeTR);
        return collator.compare(st1, st2);
    }
} // End of the class
