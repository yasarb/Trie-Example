/**
 * Created by ysrbdlgn on 03-Jul-17.
 */
public interface Trie {

    public boolean isEmpty();
    public int wordCount();
    public Node getRoot();
    public void insert(String word);
    public boolean contains(String word);
    public String[] startsWith(String prefix);


}
