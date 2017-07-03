package trie;

import java.util.List;

/**
 * Created by ysrbdlgn on 03-Jul-17.
 */
public interface Trie {

    public static final int ALPHABET_SIZE = 26;
    public static final char TERMINATE = '$';

    public boolean isEmpty();
    public int wordCount();
    public Node getRoot();
    public void insert(String word);
    public boolean contains(String word);
    public List<String> startsWith(String prefix);


}
