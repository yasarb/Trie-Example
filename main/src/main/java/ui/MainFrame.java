package ui;

import service.TrieService;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Collections;

public class MainFrame extends JFrame {

    private JTextField textfield;
    private JList jlist;
    private JScrollPane scrollPane;
    private TrieService service;

    public MainFrame(String title, TrieService service) {

        setSize(new Dimension(400, 400));
        setTitle(title);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        renderComponents();

        this.service = service;
    }

    private void renderComponents() {

        renderTextField();
        renderListField();
        renderScrollPane();
    }

    private void renderTextField() {

        textfield = new JTextField();
        this.add(textfield, BorderLayout.NORTH);

        textfield.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateList(e);
            }

            public void removeUpdate(DocumentEvent e) {
                updateList(e);
            }

            private void updateList(DocumentEvent e) {

                final Thread updater = new Thread() {
                    @Override
                    public void run() {
                        final java.util.List<String> words = service.getWordsByPrefix(textfield.getText());
                        Collections.sort(words);
                        final DefaultListModel model = new DefaultListModel();
                        jlist.setModel(model);
                        for (String word : words) {
                            model.addElement(word);
                        }
                    }
                };
                updater.start();

            }

            public void changedUpdate(DocumentEvent e) {
                // empty
            }

        });

    }

    private void renderListField() {

        jlist = new JList();
        this.add(jlist, BorderLayout.CENTER);

    }

    private void renderScrollPane() {

        scrollPane = new JScrollPane(jlist);
        this.add(scrollPane, BorderLayout.CENTER);
    }



}