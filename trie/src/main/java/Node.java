/**
 * Created by ysrbdlgn on 03-Jul-17.
 */
public class Node {

    private Node parent;
    private Node[] children;
    private char letter;



    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}
