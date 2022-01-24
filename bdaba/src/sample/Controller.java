package sample;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.IMathLogic;
import logic.MathLogic;

public class Controller {

    private IMathLogic mathLogic;

    @FXML TextField screen;

    @FXML Button one;
    @FXML Button two;
    @FXML Button three;
    @FXML Button four;
    @FXML Button five;
    @FXML Button six;
    @FXML Button seven;
    @FXML Button eight;
    @FXML Button nine;
    @FXML Button zero;
    @FXML Button dot;
    @FXML Button plus;
    @FXML Button minus;
    @FXML Button product;
    @FXML Button div;
    @FXML Button equal;
    @FXML Button ce;
    @FXML Button back;
    @FXML Button sqrt;
    @FXML Button log;
    @FXML Button sin;
    @FXML Button cos;
    @FXML Button pi;
    @FXML Button sinh;
    @FXML Button mod;
    @FXML Button cosh;
    @FXML Button inx;
    @FXML Button tan;
    @FXML Button tanh;
    @FXML Button x2;
    @FXML Button x3;
    @FXML Button round;
    @FXML Button bin;
    @FXML Button hex;
    @FXML Button plusMinus;

    public void initialize() {
        init();
        screen.setEditable(false);
    }

    private void writeNum(Node node) {
        String toAdd = ((Button) node).getText();
        boolean result = mathLogic.validate(toAdd, screen.getText());

        if (result) {
            screen.appendText(toAdd);
        }
    }

    private void clear() {
        screen.clear();
    }

    private void removeLast() {
        String text = screen.getText();
        if (text.isEmpty()) return;
        screen.setText(text.substring(0, text.length() - 1));
    }

    private void setResult(String result) {
        screen.setText(result);
    }

    private void appendResult(String result) {
        screen.appendText(result);
    }

    private void initializeListeners() {
        one.setOnAction(event -> writeNum(one));
        two.setOnAction(event -> writeNum(two));
        three.setOnAction(event -> writeNum(three));
        four.setOnAction(event -> writeNum(four));
        five.setOnAction(event -> writeNum(five));
        six.setOnAction(event -> writeNum(six));
        seven.setOnAction(event -> writeNum(seven));
        eight.setOnAction(event -> writeNum(eight));
        nine.setOnAction(event -> writeNum(nine));
        zero.setOnAction(event -> writeNum(zero));
        dot.setOnAction(event -> writeNum(dot));
        plus.setOnAction(event -> writeNum(plus));
        minus.setOnAction(event -> writeNum(minus));
        product.setOnAction(event -> writeNum(product));
        div.setOnAction(event -> writeNum(div));
        equal.setOnAction(event -> setResult(mathLogic.calculate(screen.getText())));
        ce.setOnAction(event -> clear());
        back.setOnAction(event -> removeLast());
        sqrt.setOnAction(event -> setResult(mathLogic.sqrt(screen.getText())));
        log.setOnAction(event -> setResult(mathLogic.log(screen.getText())));
        sin.setOnAction(event -> setResult(mathLogic.sin(screen.getText())));
        cos.setOnAction(event -> setResult(mathLogic.cos(screen.getText())));
        pi.setOnAction(event -> appendResult(mathLogic.pi()));
        sinh.setOnAction(event -> setResult(mathLogic.sinh(screen.getText())));
        mod.setOnAction(event -> appendResult(mathLogic.mod()));
        cosh.setOnAction(event -> setResult(mathLogic.cosh(screen.getText())));
        inx.setOnAction(event -> setResult(mathLogic.inx(screen.getText())));
        tan.setOnAction(event -> setResult(mathLogic.tan(screen.getText())));
        tanh.setOnAction(event -> setResult(mathLogic.tanh(screen.getText())));
        x2.setOnAction(event -> setResult(mathLogic.x2(screen.getText())));
        x3.setOnAction(event -> setResult(mathLogic.x3(screen.getText())));
        round.setOnAction(event -> setResult(mathLogic.round(screen.getText())));
        bin.setOnAction(event -> setResult(mathLogic.bin(screen.getText())));
        hex.setOnAction(event -> setResult(mathLogic.hex(screen.getText())));
        plusMinus.setOnAction(event -> setResult(mathLogic.plusMinus(screen.getText())));

    }

    private void init() {
        initializeListeners();
        mathLogic = new MathLogic();
    }
}