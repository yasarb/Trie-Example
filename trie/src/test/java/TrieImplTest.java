import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

/**
 * Created by ysrbdlgn on 03-Jul-17.
 */

public class TrieImplTest {
    @Test
    public void isEmpty() throws Exception {

        Trie trie = new TrieImpl();
        Assert.assertEquals(trie.isEmpty(), true);

        trie.insert("test");
        Assert.assertEquals(trie.isEmpty(), false);

    }

    @Test
    public void wordCount() throws Exception {

        Trie trie = new TrieImpl();
        Assert.assertEquals(trie.wordCount(), 0);

        trie.insert("test");
        Assert.assertEquals(trie.wordCount(), 1);

        trie.insert("trie");
        Assert.assertEquals(trie.wordCount(), 2);
    }

    @Test
    public void contains() throws Exception {

        Trie trie = new TrieImpl();
        trie.insert("computer");

        Assert.assertEquals(trie.contains("computer"), true);
        Assert.assertEquals(trie.contains("apple"), false);

    }

    @Test
    public void insert() throws Exception {

        Trie trie = new TrieImpl();
        trie.insert("ysrbdlgn");

        Assert.assertEquals(trie.isEmpty(), false);
        Assert.assertEquals(trie.wordCount(), 1);
        Assert.assertEquals(trie.contains("ysrbdlgn"), true);


    }

    @Test
    public void startsWith() throws Exception {
    }

}
