import model.VigenereModel;
import view.VigenereView;
import controller.VigenereController;

public class VigenereMain {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VigenereModel model = new VigenereModel();
                VigenereView view = new VigenereView();
                new VigenereController(model, view);
                view.setVisible(true);
            }
        });
    }
}
