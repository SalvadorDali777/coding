package sample;



import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import java.security.SecureRandom;
import sample.source.crypto;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = new AnchorPane();

            SecureRandom secureRandom = new SecureRandom();

            int nA = secureRandom.nextInt(100000000);
            int nB = secureRandom.nextInt(100000000);

            String kA = "fi1jr90j12k12fad";
            String kB = "jr120j-91-12fpq;";

            String nB1 = "" + nB;

            int nB_1 = nB-1;

            String nB1_1 = "" + nB_1;

            String initVector = "grn12nf=13f0m1lp";

            String k = "l12,r120vjd[-d1r";

            String M1 = crypto.encrypt(kA, initVector, nA+"@bob@" + k+ crypto.encrypt(kB, initVector, k+"@alice"));

            String M2 = crypto.encrypt(kB, initVector, k+"@alice");

            String M3 = crypto.encrypt(k, initVector, nB1);

            String M4 = crypto.encrypt(k, initVector, nB1_1);

            String decryptedM1 = crypto.decrypt(kA, initVector, M1);

            String decryptedM2 = crypto.decrypt(kB, initVector, M2);

            String decryptedM3 = crypto.decrypt(k, initVector, M3);

            Button button1 = new Button("Подготовка");
            Button button2 = new Button("Рабочий этап");



            TextArea textAreaAlice = new TextArea();
            TextArea textAreaBob = new TextArea();
            TextArea textAreaTreant = new TextArea();
            TextArea textAreaMiddle = new TextArea();
            Label labelAlice = new Label("Alice");
            Label labelTreant = new Label("Treant");
            Label labelBob = new Label("Bob");

            AnchorPane.setTopAnchor(labelAlice, 30.0);
            AnchorPane.setLeftAnchor(labelAlice, 50.0);

            AnchorPane.setTopAnchor(labelTreant, 30.0);
            AnchorPane.setLeftAnchor(labelTreant, 300.0);

            AnchorPane.setTopAnchor(labelBob, 30.0);
            AnchorPane.setLeftAnchor(labelBob, 550.0);

            AnchorPane.setBottomAnchor(button1, 150.0);
            AnchorPane.setTopAnchor(button1, 400.0);
            AnchorPane.setRightAnchor(button1, 550.0);
            AnchorPane.setLeftAnchor(button1, 50.0);

            AnchorPane.setBottomAnchor(button2, 50.0);
            AnchorPane.setTopAnchor(button2, 500.0);
            AnchorPane.setRightAnchor(button2, 550.0);
            AnchorPane.setLeftAnchor(button2, 50.0);

            AnchorPane.setBottomAnchor(textAreaAlice, 250.0);
            AnchorPane.setTopAnchor(textAreaAlice, 50.0);
            AnchorPane.setRightAnchor(textAreaAlice, 550.0);
            AnchorPane.setLeftAnchor(textAreaAlice, 50.0);

            AnchorPane.setBottomAnchor(textAreaBob, 250.0);
            AnchorPane.setTopAnchor(textAreaBob, 50.0);
            AnchorPane.setRightAnchor(textAreaBob, 50.0);
            AnchorPane.setLeftAnchor(textAreaBob, 550.0);

            AnchorPane.setBottomAnchor(textAreaTreant, 250.0);
            AnchorPane.setTopAnchor(textAreaTreant, 50.0);
            AnchorPane.setRightAnchor(textAreaTreant, 300.0);
            AnchorPane.setLeftAnchor(textAreaTreant, 300.0);

            AnchorPane.setBottomAnchor(textAreaMiddle, 50.0);
            AnchorPane.setTopAnchor(textAreaMiddle, 400.0);
            AnchorPane.setRightAnchor(textAreaMiddle, 100.0);
            AnchorPane.setLeftAnchor(textAreaMiddle, 400.0);

            root.getChildren().add(button1);
            root.getChildren().add(button2);
            root.getChildren().add(textAreaAlice);
            root.getChildren().add(textAreaBob);
            root.getChildren().add(textAreaTreant);
            root.getChildren().add(textAreaMiddle);
            root.getChildren().add(labelAlice);
            root.getChildren().add(labelTreant);
            root.getChildren().add(labelBob);


            button1.setCursor(Cursor.HAND);
            button1.setOnMouseClicked(mouseEvent -> {
                textAreaAlice.setText("nA = " + nA + "\n" +
                        "kA = " + kA);
                textAreaBob.setText("nB = " + nB + "\n" +
                        "kB = " + kB);
                textAreaTreant.setText("k = " + k + "\n" +
                        "kA = " + kA + "\n" +
                        "kB = " + kB);
            });


            button2.setCursor(Cursor.HAND);
            button2.setOnMouseClicked(mouseEvent -> {
                textAreaAlice.clear();
                textAreaBob.clear();
                textAreaTreant.clear();
                textAreaAlice.setText("nA = " + nA + "\n" +
                        "kA = " + kA + "\n\n" +
                        "1. M0 = alice@bob@" + nA + "\n\n" +
                        "2. M1 = " + M1 + "\n\n" +
                        "3. decryptedM1 = " + decryptedM1 + "\n" +
                        "nA найден. Подлинность сообщения выявлена.\n" +
                        "k = " + k + "\n" +
                        "M2 = " + M2 + "\n\n" +
                        "4. M3 = " + M3 + "\n\n" +
                        "5. decryptedM3 = nB" + decryptedM3 + "\n" +
                        "M4 = " + M4 + "\n\n" +
                        "6. k = " + k
                );
                textAreaTreant.setText("k = " + k + "\n" +
                        "kA = " + kA + "\n" +
                        "kB = " + kB + "\n\n" +
                        "1. M0 = alice@bob@" + nA + "\n\n" +
                        "2. M1 = " + M1);

                textAreaBob.setText("nB = " + nB + "\n" +
                        "kB = " + kB + "\n\n" +
                        "3. M2 = " + M2 + "\n\n" +
                        "4. decryptedM2 = k = " + decryptedM2 + "\n" +
                        "M3 = " + M3 + "\n\n" +
                        "5. M4 = " + M4 + "\n\n" +
                        "6. k = " + k
                );
                textAreaMiddle.setText("1.Алиса -> Трент:М0=А, В, nA\n\n" +
                        "2. Трент -> Алиса:М1 = EncryptA(nA, B, K, EncryptB(key, A))\n\n" +
                        "3. Алиса -> Боб: M2 = EncryptB(key, A)\n\n" +
                        "4. Боб -> Алиса: M3 = EncryptK(nB)\n\n" +
                        "5. Алиса -> Боб: M4 = EncryptK(nB-1)");
            });

            Scene scene = new Scene(root, 800, 600);
            primaryStage.setTitle("Lab_3");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {
        launch(args);
    }
}
