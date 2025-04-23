package controller;

import model.VigenereModel;
import view.VigenereView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VigenereController implements ActionListener {
    private VigenereModel model;
    private VigenereView view;

    public VigenereController(VigenereModel model, VigenereView view) {
        this.model = model;
        this.view = view;
        this.view.addEncryptListener(this);
        this.view.addDecryptListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        model.setKeyword(view.getKey());

        if (command.equals("Encrypt")) {
            String encrypted = model.encrypt(view.getInputText());
            view.setOutputText(encrypted);
        } else if (command.equals("Decrypt")) {
            String decrypted = model.decrypt(view.getInputText());
            view.setOutputText(decrypted);
        }
    }
}
