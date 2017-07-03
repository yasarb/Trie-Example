import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        trie.insert("computer");

        Assert.assertEquals(trie.isEmpty(), false);
        Assert.assertEquals(trie.wordCount(), 1);
        Assert.assertEquals(trie.contains("computer"), true);

        trie.insert("computing");
        Assert.assertEquals(trie.isEmpty(), false);
        Assert.assertEquals(trie.wordCount(), 2);
        Assert.assertEquals(trie.contains("computing"), true);

        trie.insert("garden");
        Assert.assertEquals(trie.isEmpty(), false);
        Assert.assertEquals(trie.wordCount(), 3);
        Assert.assertEquals(trie.contains("garden"), true);

        trie.insert("compute");
        Assert.assertEquals(trie.contains("compute"), true);

    }

    @Test
    public void startsWith() throws Exception {

        Trie trie = new TrieImpl();
        trie.insert("trace");
        trie.insert("tracing");
        trie.insert("traceback");
        trie.insert("track");
        trie.insert("tracking");
        trie.insert("trackback");

        Assert.assertEquals(equalLists(trie.startsWith("trace"), new ArrayList<String>() {{
            add("trace");
            add("traceback");
        }}), true);

        Assert.assertEquals(equalLists(trie.startsWith("track"), new ArrayList<String>() {{
            add("track");
            add("tracking");
            add("trackback");
        }}), true);

        Assert.assertEquals(equalLists(trie.startsWith("trac"), new ArrayList<String>() {{
            add("trace");
            add("tracing");
            add("traceback");
            add("track");
            add("tracking");
            add("trackback");
        }}), true);


    }

    private boolean equalLists(List<String> one, List<String> two) {
        // https://stackoverflow.com/a/13501200

        if (one == null && two == null) {
            return true;
        }

        if ((one == null && two != null)
                || one != null && two == null
                || one.size() != two.size()) {
            return false;
        }

        one = new ArrayList<String>(one);
        two = new ArrayList<String>(two);

        Collections.sort(one);
        Collections.sort(two);
        return one.equals(two);
    }

}
