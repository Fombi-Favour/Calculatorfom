package application;


import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.math.BigDecimal;


public class Main extends Application {

    private boolean inputFieldDisplayed;
    private String operator;
    private BigDecimal left;
    private BigDecimal right;


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        final int SCREEN_WIDTH = 250;


        TextField inputField = new TextField();
        TextField answerField = new TextField();

        Button btn = new Button("C"); btn.setPrefWidth((double) SCREEN_WIDTH/4);
        btn.setOnAction(actionEvent -> {
            inputField.clear();
        });
        Button btn0 = new Button("÷"); btn0.setPrefWidth((double) SCREEN_WIDTH/4);
        Button btn1 = new Button("×"); btn1.setPrefWidth((double) SCREEN_WIDTH/4);
        Button btn2 = new Button("<-"); btn2.setPrefWidth((double) SCREEN_WIDTH/4);
        btn2.setOnAction(actionEvent -> {
            String currentText = inputField.getText();
            if(!currentText.isEmpty() && !inputFieldDisplayed){
                inputField.setText(currentText.substring(0, currentText.length() - 1));
            }
        });

        HBox hbox = new HBox(btn, btn0, btn1, btn2);

        Button btn3 = new Button("7"); btn3.setPrefWidth((double) SCREEN_WIDTH/4);
        Button btn4 = new Button("8"); btn4.setPrefWidth((double) SCREEN_WIDTH/4);
        Button btn5 = new Button("9"); btn5.setPrefWidth((double) SCREEN_WIDTH/4);
        Button btn6 = new Button("-"); btn6.setPrefWidth((double) SCREEN_WIDTH/4);

        HBox hbox0 = new HBox(btn3, btn4, btn5, btn6);

        Button button = new Button("4"); button.setPrefWidth((double) SCREEN_WIDTH/4);
        Button button0 = new Button("5"); button0.setPrefWidth((double) SCREEN_WIDTH/4);
        Button button1 = new Button("6"); button1.setPrefWidth((double) SCREEN_WIDTH/4);
        Button button2 = new Button("+"); button2.setPrefWidth((double) SCREEN_WIDTH/4);

        HBox hbox1 = new HBox(button, button0, button1,button2);

        Button button3 = new Button("1"); button3.setPrefWidth((double) SCREEN_WIDTH/4);
        Button button4 = new Button("2"); button4.setPrefWidth((double) SCREEN_WIDTH/4);
        Button button5 = new Button("3"); button5.setPrefWidth((double) SCREEN_WIDTH/4);
        Button button6 = new Button("="); button6.setPrefWidth((double) SCREEN_WIDTH/4);
        button6.setStyle("-fx-color: green");
        button6.setOnAction(actionEvent -> {
           double setAnswer = Double.parseDouble(answerField.getText());


        });
        button6.setDefaultButton(true);

        HBox hbox2 = new HBox(button3, button4, button5, button6);

        Button cop = new Button("%"); cop.setPrefWidth((double) SCREEN_WIDTH/4);
        Button cop0 = new Button("0"); cop0.setPrefWidth((double) SCREEN_WIDTH/4);
        Button cop1 = new Button("."); cop1.setPrefWidth((double) SCREEN_WIDTH/4);

        HBox hbox3 = new HBox(cop, cop0, cop1);

        VBox textPane = new VBox();
        textPane.getChildren().addAll(inputField, answerField);

        VBox linePane = new VBox();
        linePane.getChildren().addAll(hbox, hbox0, hbox1, hbox2, hbox3);

        VBox mainPane = new VBox();
        mainPane.getChildren().addAll(textPane, linePane);
        mainPane.setStyle("-fx-color: black");

        Button[] allButtons = new Button[] {btn0, btn1, btn3, btn4, btn5, btn6, button, button0, button1, button2, button3, button4, button5, cop, cop0, cop1};

        for(Button eachButton : allButtons){
            eachButton.setOnAction(actionEvent -> {
                String gottenText = inputField.getText();
                inputField.setText(gottenText + eachButton.getText());
            });
        }

        Scene mainScene = new Scene(mainPane);
        mainScene.setFill(Color.rgb(1,1,1,1));


        stage.setTitle("Calculator FX");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setScene(mainScene);
        stage.show();
    }

    public static BigDecimal calculate(String operator,BigDecimal left, BigDecimal right){

        switch (operator){
            case "+":
                return left.add(right);
            case  "-":
                return left.subtract(right);
            case "×":
                return left.multiply(right);
            case"÷":
                return left.divide(right);
            default:
        }
        return right;
    }
}