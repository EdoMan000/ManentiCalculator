package com.example.manenti_calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Calculator extends Application{
    Label label0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlu;
    Button buttonMin;
    Button buttonMul;
    Button buttonDiv;
    Button buttonEqu;
    Button buttonCan;
    Button buttonNDS;
    Button buttonNGT;
    Button buttonDot;
    int op=-1;
    float num1=0;
    float num2=0;
    float res=0;
    int i=0;
    int dot=0;
    double pow=1;
    String text="";

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        stage.setTitle("CALCULATOR");
        Pane root = new Pane();

        Scene scene = new Scene(root, 300, 500);
        stage.setScene(scene);
        stage.setResizable(false);

        label0 = new Label("0");
        label0.setScaleX(4);
        label0.setScaleY(4);
        label0.setLayoutX(150);
        label0.setLayoutY(100);

        button0 = new Button("0");
        button0.setScaleX(2.2);
        button0.setScaleY(2.2);
        button0.setLayoutX(100);
        button0.setLayoutY(425);
        button0.setOnAction(event -> ButtonActions(0));

        button1 = new Button("1");
        button1.setScaleX(2.2);
        button1.setScaleY(2.2);
        button1.setLayoutX(45);
        button1.setLayoutY(245);
        button1.setOnAction(event -> ButtonActions(1));

        button2 = new Button("2");
        button2.setScaleX(2.2);
        button2.setScaleY(2.2);
        button2.setLayoutX(100);
        button2.setLayoutY(245);
        button2.setOnAction(event -> ButtonActions(2));

        button3 = new Button("3");
        button3.setScaleX(2.2);
        button3.setScaleY(2.2);
        button3.setLayoutX(155);
        button3.setLayoutY(245);
        button3.setOnAction(event -> ButtonActions(3));

        button4 = new Button("4");
        button4.setScaleX(2.2);
        button4.setScaleY(2.2);
        button4.setLayoutX(45);
        button4.setLayoutY(305);
        button4.setOnAction(event -> ButtonActions(4));

        button5 = new Button("5");
        button5.setScaleX(2.2);
        button5.setScaleY(2.2);
        button5.setLayoutX(100);
        button5.setLayoutY(305);
        button5.setOnAction(event -> ButtonActions(5));

        button6 = new Button("6");
        button6.setScaleX(2.2);
        button6.setScaleY(2.2);
        button6.setLayoutX(155);
        button6.setLayoutY(305);
        button6.setOnAction(event -> ButtonActions(6));

        button7 = new Button("7");
        button7.setScaleX(2.2);
        button7.setScaleY(2.2);
        button7.setLayoutX(45);
        button7.setLayoutY(365);
        button7.setOnAction(event -> ButtonActions(7));

        button8 = new Button("8");
        button8.setScaleX(2.2);
        button8.setScaleY(2.2);
        button8.setLayoutX(100);
        button8.setLayoutY(365);
        button8.setOnAction(event -> ButtonActions(8));

        button9 = new Button("9");
        button9.setScaleX(2.2);
        button9.setScaleY(2.2);
        button9.setLayoutX(155);
        button9.setLayoutY(365);
        button9.setOnAction(event -> ButtonActions(9));

        buttonPlu = new Button("+");
        buttonPlu.setScaleX(2.2);
        buttonPlu.setScaleY(2.2);
        buttonPlu.setLayoutX(235);
        buttonPlu.setLayoutY(305);
        buttonPlu.setOnAction(event -> {
            ButtonOperations();
            text = text + "+";
            label0.setText(text);
            op = 0;
        });

        buttonMin = new Button("- ");
        buttonMin.setScaleX(2.2);
        buttonMin.setScaleY(2.2);
        buttonMin.setLayoutX(235);
        buttonMin.setLayoutY(365);
        buttonMin.setOnAction(event -> {
            ButtonOperations();
            text = text + "-";
            label0.setText(text);
            op = 1;
        });

        buttonMul = new Button("x ");
        buttonMul.setScaleX(2.2);
        buttonMul.setScaleY(2.2);
        buttonMul.setLayoutX(235);
        buttonMul.setLayoutY(245);
        buttonMul.setOnAction(event -> {
            ButtonOperations();
            text = text + "x";
            label0.setText(text);
            op = 2;
        });

        buttonDiv = new Button("??");
        buttonDiv.setScaleX(2.2);
        buttonDiv.setScaleY(2.2);
        buttonDiv.setLayoutX(235);
        buttonDiv.setLayoutY(185);
        buttonDiv.setOnAction(event -> {
            ButtonOperations();
            text = text + "??";
            label0.setText(text);
            op = 3;

        });

        buttonEqu = new Button("=");
        buttonEqu.setScaleX(2.2);
        buttonEqu.setScaleY(2.2);
        buttonEqu.setLayoutX(235);
        buttonEqu.setLayoutY(425);
        buttonEqu.setStyle("-fx-background-color: Orange");
        buttonEqu.setOnAction(event -> {
            if ((op != -1) && (op != 4)) {
                switch (op) {
                    case 0 -> res = num2 + num1;
                    case 1 -> res = num2 - num1;
                    case 2 -> res = num2 * num1;
                    case 3 -> res = num2 / num1;
                }
                if(Float.isInfinite(res)){
                    label0.setText("Math Error");
                    op=5;
                    buttonCan.fire();
                }else {
                    text = String.valueOf(res);
                    label0.setText(text);
                    dot = 0;
                    pow = 1;
                    op = 4;
                }
            }
        });

        buttonCan = new Button("CE");
        buttonCan.setScaleX(2.2);
        buttonCan.setScaleY(2.2);
        buttonCan.setLayoutX(45);
        buttonCan.setLayoutY(185);
        buttonCan.setStyle("-fx-background-color: Orange");
        buttonCan.setOnAction(event -> {
                num2 = 0;
                num1 = 0;
                dot = 0;
                pow = 1;
                text = "";
                if(op!=5) {
                    label0.setText("0");
                }
                op = -1;
        });

        buttonNGT = new Button("??");
        buttonNGT.setScaleX(2.2);
        buttonNGT.setScaleY(2.2);
        buttonNGT.setLayoutX(45);
        buttonNGT.setLayoutY(425);
        buttonNGT.setOnAction(event -> {
            if(op==4){
                num2 = -1*res;
                res = num2;
                num1 = 0;
                text = String.valueOf(num2);
                label0.setText(text);
            }else if(op==-1) {
                num1=-1*num1;
                res=num1;
                text = String.valueOf(num1);
                label0.setText(text);
                op=4;
            }
        });

        buttonDot = new Button(".");
        buttonDot.setScaleX(2.2);
        buttonDot.setScaleY(2.2);
        buttonDot.setLayoutX(155);
        buttonDot.setLayoutY(425);
        buttonDot.setOnAction(event -> {
            if((dot==0)&&(op!=4)){
                dot=1;
                text=text+".";
                label0.setText(text);
            }
        });

        buttonNDS = new Button("???");
        buttonNDS.setLayoutX(25);
        buttonNDS.setLayoutY(25);
        buttonNDS.setScaleX(2.2);
        buttonNDS.setScaleY(2.2);
        buttonNDS.setStyle("-fx-background-color: Orange");
        buttonNDS.setOnAction(event -> {
            if(i==1){
                shift("???", "Black", "white", root);

            }else{
                shift("???","white","Black",root);
            }
            i=(i+1)%2;
        });

        root.getChildren().addAll(label0,button0,button1,button2,button3,button4,button5,button6,button7,button8,
                button9,buttonPlu,buttonMin,buttonMul,buttonDiv,buttonEqu,buttonCan,buttonNDS,buttonNGT,buttonDot);
        stage.show();
        buttonNDS.fire();
    }

    private void shift(String s, String col1, String col2, Pane root) {
        buttonNDS.setText(s);
        root.setStyle("-fx-background-color: "+ col1);
        label0.setStyle("-fx-text-fill: "+ col2);
        button0.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        button1.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        button2.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        button3.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        button4.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        button5.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        button6.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        button7.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        button8.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        button9.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        buttonPlu.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        buttonMin.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        buttonMul.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        buttonDiv.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        buttonNGT.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
        buttonDot.setStyle("-fx-background-color: "+col1+";-fx-text-fill: "+col2);
    }

    private void ButtonActions(int num){
        if(op==4){
            buttonCan.fire();
        }
        if(dot==0){
            num1 = (num1 * 10) + num;

        }else{
            num1 = num1 + (float)(num*Math.pow(10,-pow));
            pow++;
        }
        text = text + num;
        label0.setText(text);
    }

    private void ButtonOperations() {
        if(op==4){
            num2= res;
            num1 = 0;
            text = String.valueOf(num2);
        }
        else if (op == -1) {
            num2 = num1;
            num1 = 0;
        }else{
            buttonEqu.fire();
            num2= res;
            num1 = 0;
            text = String.valueOf(num2);
        }
        if(dot==1){
            dot=0;
            pow =1;
        }
    }
}