import java.util.List;

/**
 * Created by ysrbdlgn on 03-Jul-17.
 */
public class Node {

    private Node parent;
    private Node[] children;
    private char letter;

    public Node(Node parent, char letter) {
        setParent(parent);
        setLetter(letter);
        setChildren(new Node[Trie.ALPHABET_SIZE + 1]);
    }

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

    public boolean isLeaf() {

        boolean childFound = false;
        for (Node n : getChildren()) {
            if (n != null) {
                childFound = true;
                break;
            }
        }
        return !childFound;
    }

    @Override
    public String toString() {
        return String.valueOf(this.letter);
    }

    public boolean isTerminating() {
        return (getLetter() == Trie.TERMINATE);
    }
}
