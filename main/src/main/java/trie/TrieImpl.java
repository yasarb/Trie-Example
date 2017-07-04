package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysrbdlgn on 03-Jul-17.
 */
public class TrieImpl implements Trie {

    private Node root;
    private int wordCount;

    public TrieImpl() {
        this.root = new Node(null, '*');
        wordCount = 0;
    }

    public boolean isEmpty() {
        return root == null || wordCount == 0;
    }

    public int wordCount() {
        return wordCount;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(String word) {

        Node currentNode = getRoot();
        int n = word.length();
        int i = 0;

        while (i < n) {
            Node tempNode = currentNode.getChildren()[getIndex(word.charAt(i))];
            if (tempNode != null) {
                currentNode = tempNode;
                i++;
            } else {
                break;
            }
        }

        while (i < n) {
            currentNode.getChildren()[getIndex(word.charAt(i))] = new Node(currentNode, word.charAt(i));
            currentNode = currentNode.getChildren()[getIndex(word.charAt(i))];
            i++;
        }
        currentNode.getChildren()[Trie.ALPHABET_SIZE] = new Node(currentNode, '$');
        wordCount++;
    }

    /**
     * Searches for exact matching
     *
     * @param word word to be searched in trie
     * @return True if word is exactly existed. Otherwise false.
     */
    public boolean contains(String word) {

        boolean isContains = false;
        Node currentNode = getRoot();
        int n = word.length();
        int i = 0;

        while (i < n) {
            Node tempNode = currentNode.getChildren()[getIndex(word.charAt(i))];
            if (tempNode != null) {
                currentNode = tempNode;
                i++;
            } else {
                break;
            }
        }

        if (i == n)
            isContains = true;

        return isContains;
    }

    public List<String> startsWith(String prefix) {

        Node currentNode = getRoot();
        int n = prefix.length();
        int i = 0;

        if(!contains(prefix))
            return new ArrayList<String>();

        while (i < n) {
            Node tempNode = currentNode.getChildren()[getIndex(prefix.charAt(i))];
            if (tempNode != null) {
                currentNode = tempNode;
                i++;
            } else {
                break;
            }
        }

        List<String> allWordsByPrefix = traverse(currentNode, prefix, new ArrayList<String>());

        return allWordsByPrefix;
    }

    private int getIndex(char c) {
        return c - 'a';
    }

    private List<String> traverse(Node node, String s, List<String> list) {

        if (node.isTerminating()) {
            list.add(s);
            return list;
        }

        for (Node n : node.getChildren()) {
            if (n != null) {
                if(n.isTerminating())
                    traverse(n, s, list);
                else
                    traverse(n, s + n.getLetter(), list);
            }
        }

        return list;
    }

}
