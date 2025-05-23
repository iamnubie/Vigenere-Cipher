package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VigenereView extends JFrame {

    private JTextArea inputText;
    private JTextArea outputText;
    private JTextField keyField;
    public JButton encBtn;
    public JButton decBtn;
    public JButton writeButton;
    public JButton readButton;

    public VigenereView() {
        setTitle("Thuật Toán Mã Hóa Vigenere Cipher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        // Ô nhập văn bản gốc
        inputText = new JTextArea(3, 30);
        JScrollPane inputScroll = new JScrollPane(inputText);
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Plaintext:"));
        inputPanel.add(inputScroll);

        // Nhập khóa
        keyField = new JTextField(15);
        JPanel keyPanel = new JPanel();
        keyPanel.add(new JLabel("Key:"));
        keyPanel.add(keyField);

        // Nút mã hóa/giải mã
        encBtn = new JButton("▼ Encrypt ▼");
        decBtn = new JButton("▲ Dencypt ▲");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(encBtn);
        buttonPanel.add(decBtn);

        // Hiển thị kết quả
        outputText = new JTextArea(3, 30);
        JScrollPane outputScroll = new JScrollPane(outputText);
        JPanel outputPanel = new JPanel();
        outputPanel.add(new JLabel("Ciphertext :"));
        outputPanel.add(outputScroll);

        writeButton = new JButton("Ghi file");
        readButton = new JButton("Đọc file");
        JPanel fileButtonPanel = new JPanel();
        fileButtonPanel.add(writeButton);
        fileButtonPanel.add(readButton);

        add(inputPanel);
        add(keyPanel);
        add(buttonPanel);
        add(outputPanel);
        add(fileButtonPanel);

        setResizable(false);
    }

    // Các phương thức getter/setter để Controller tương tác

    public String getInputText() {
        return inputText.getText();
    }

    public String getOutputText() {
        return outputText.getText();
    }

    public String getKey() {
        return keyField.getText();
    }

    public void setOutputText(String text) {
        outputText.setText(text);
    }

    public void addEncryptListener(ActionListener listener) {
        encBtn.addActionListener(listener);
        encBtn.setActionCommand("Encrypt");
    }

    public void addDecryptListener(ActionListener listener) {
        decBtn.addActionListener(listener);
        decBtn.setActionCommand("Decrypt");
    }

    public void addWriteFileListener(ActionListener listener) {
        writeButton.addActionListener(listener);
        writeButton.setActionCommand("Write File");
    }

    public void addReadFileListener(ActionListener listener) {
        readButton.addActionListener(listener);
        readButton.setActionCommand("Read File");
    }
}
