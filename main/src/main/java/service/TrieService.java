package service;

import trie.Trie;

import java.util.List;

/**
 * Created by ysrbdlgn on 03-Jul-17.
 */
public interface TrieService {

    public void buildTrie(String[] words);

    public List<String> getWordsByPrefix(String prefix);

    public void setTrie(Trie trie);

    public Trie getTrie();


}
