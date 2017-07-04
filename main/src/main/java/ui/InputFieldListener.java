package ui;

import service.TrieService;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;

/**
 * Created by ysrbdlgn on 04-Jul-17.
 */
public class InputFieldListener implements KeyListener {

    private final int MIN_CHAR_INPUT = 3;
    private TrieService service;
    private JTextField textField;
    private JList listField;
    private int enteredCharCount;
    private boolean consumeNext;

    public InputFieldListener() {
        enteredCharCount = 0;
        consumeNext = false;
    }

    public void keyTyped(KeyEvent e) {
        if (consumeNext)
            e.consume();
        consumeNext = false;
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Pressed: " + e.getKeyCode());
        boolean isAlphanumeric = Character.isLetterOrDigit(e.getKeyChar());
        boolean isDeletion = e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE;
        boolean isEndKey = e.getKeyCode() == KeyEvent.VK_END;
        boolean isEnterKey = e.getKeyCode() == KeyEvent.VK_ENTER;

        if (isAlphanumeric || isDeletion || isEndKey || isEnterKey) {

            // TODO: Assumed that inserting and deleting is made one character at a time. Add selection case.
            if (isDeletion) {
                if (enteredCharCount > 0)
                    enteredCharCount--;
            } else if (isEndKey) {
                enteredCharCount = textField.getDocument().getLength();
            } else if (isEnterKey) {

                enteredCharCount = textField.getText().length();
                textField.requestFocus();

            } else if (isAlphanumeric) {

                if (textField.getDocument().getLength() > MIN_CHAR_INPUT)

                    try {
                        if (textField.getText().charAt(enteredCharCount) == e.getKeyChar()) {
                            consumeNext = true;
                            enteredCharCount++;
                            updateList();
                            return;
                        }
                    } catch (StringIndexOutOfBoundsException ex) {
                        // empty
                    }
                enteredCharCount++;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        updateList();
    }

    private void updateList() {

        final Thread updater = new Thread() {
            @Override
            public void run() {
                System.out.println("Text: " + textField.getText());
                String prefix = textField.getText().substring(0, enteredCharCount);
                final java.util.List<String> words = service.getWordsByPrefix(prefix);
                Collections.sort(words);
                final DefaultListModel model = new DefaultListModel();
                listField.setModel(model);
                for (String word : words) {
                    model.addElement(word);
                }

                int textFieldLen = textField.getDocument().getLength();
                if (textFieldLen > MIN_CHAR_INPUT) {
                    String suggestedFirstWord = words.get(0);
                    textField.setText(suggestedFirstWord);
                    textField.setCaretPosition(enteredCharCount);
                    textField.select(enteredCharCount, suggestedFirstWord.length());
                    System.out.println("enteredCharCount = " + enteredCharCount);
                }
            }
        };
        updater.start();

    }

    public void setService(TrieService service) {
        this.service = service;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public void setListField(JList listField) {
        this.listField = listField;
    }
}
