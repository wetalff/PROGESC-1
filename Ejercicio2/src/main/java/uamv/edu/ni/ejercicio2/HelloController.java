package uamv.edu.ni.ejercicio2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;


public class HelloController {
    List<Integer> numeros = new ArrayList<>();


    public void Nums(){
        numeros.add(10);
        numeros.add(1);
        numeros.add(4);
        numeros.add(2);
        numeros.add(6);
        numeros.add(15);
        numeros.add(11);
        numeros.add(12);
        numeros.add(13);
        numeros.add(19);

    }

    @FXML
    private Label welcomeText;
    @FXML
    private TextField txtNum;
    @FXML
    private Label lblenc;
    @FXML
    private Label lblpos;

    @FXML
    protected void onHelloButtonClick() {
        Nums();
        seEncuentra();

    }

    private void seEncuentra(){
        int num = Integer.parseInt(txtNum.getText());
        if(numeros.contains(num)){
            lblenc.setText("Si");
            lblpos.setText("" + (numeros.indexOf(num)+1));
        }
        else{lblenc.setText("No");
             lblpos.setText("...");}
    }


}
