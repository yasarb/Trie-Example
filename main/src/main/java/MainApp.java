import service.TrieService;
import service.TrieServiceImpl;
import trie.Trie;
import trie.TrieImpl;
import ui.MainFrame;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by ysrbdlgn on 04-Jul-17.
 */
public class MainApp {

    public static void main(String[] args) {

        String[] words = loadWords();

        TrieService service = new TrieServiceImpl();
        Trie trie = new TrieImpl();
        service.setTrie(trie);
        service.buildTrie(words);

        MainFrame mainFrame = new MainFrame("Auto-complete By trie.Trie", service);
        mainFrame.setVisible(true);
    }

    private static String[] loadWords() {

        InputStream is = MainApp.class.getResourceAsStream("google-10000-english.txt");
        String[] wordsArr = new String[10000];
        Scanner sc = new Scanner(is);

        int i = 0;
        while(sc.hasNext()) {
            wordsArr[i] = sc.nextLine();
            i++;
        }

        return wordsArr;
    }

}
