package service;

import trie.Trie;

import java.util.List;

/**
 * Created by ysrbdlgn on 03-Jul-17.
 */
public class TrieServiceImpl implements TrieService {

    private Trie trie;

    public void buildTrie(String[] words) {

        for (String word : words) {
            trie.insert(word);
        }
    }

    public List<String> getWordsByPrefix(String prefix) {

        return trie.startsWith(prefix);

    }

    public Trie getTrie() {
        return trie;
    }

    public void setTrie(Trie trie) {
        this.trie = trie;
    }
}
