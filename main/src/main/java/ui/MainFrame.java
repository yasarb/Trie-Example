package ui;

import service.TrieService;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTextField textField;
    private JList jlist;
    private JScrollPane scrollPane;
    private TrieService service;

    public MainFrame(String title, TrieService service) {

        this.service = service;
        setSize(new Dimension(400, 400));
        setTitle(title);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        renderComponents();
        registerListeners();
    }

    private void renderComponents() {

        renderTextField();
        renderListField();
        renderScrollPane();
    }

    private void registerListeners() {

        InputFieldListener listener = new InputFieldListener();
        listener.setService(service);
        listener.setTextField(textField);
        listener.setListField(jlist);
        textField.addKeyListener(listener);

    }

    private void renderTextField() {

        textField = new JTextField();
        this.add(textField, BorderLayout.NORTH);
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