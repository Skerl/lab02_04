package org.example.lab02_04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Button ButtonDiv;

    @FXML
    private Button ButtonMode;

    @FXML
    private Button ButtonPip;

    @FXML
    private TextField myTextField;

    @FXML
    private TextField myTextField2;

    @FXML
    private Label myLabelNotEror;

    @FXML
    private Label myLabel;

    @FXML
    private Button myButtonSubmit;

    String textFieldContent;
    String textFieldContent2;
    String selectedCommand;

    public static void setLabelPropertiesErorPIP(Label myLabelNotEror) {
        myLabelNotEror.setFont(Font.font(15));
        myLabelNotEror.setText("Please insert enter the name \nof the file you want \nto copy and the name of the copy.\n\n Like: names.txt listnames.txt");
        myLabelNotEror.setTextFill(Color.RED);
        myLabelNotEror.setLayoutX(200);
    }
    public static void setLabelPropertiesNotEror(Label myLabelNotEror) {
        myLabelNotEror.setFont(Font.font(23));
        myLabelNotEror.setText("No errors");
        myLabelNotEror.setTextFill(Color.rgb(124, 252, 0));
        myLabelNotEror.setLayoutX(252);
    }


    public void submit(ActionEvent event) {
        try {
            textFieldContent = myTextField.getText();
            System.out.println(textFieldContent);

            if ((selectedCommand.equals("DIV")) && (textFieldContent.isEmpty())) {
                String[] command = {"cmd", "/c", "start", "cmd.exe", "/K", "dir"};
                Process process = Runtime.getRuntime().exec(command);
                setLabelPropertiesNotEror(myLabelNotEror);
            } else if((selectedCommand.equals("PIP")) && (textFieldContent.isEmpty())) {
                setLabelPropertiesErorPIP(myLabelNotEror);
            } else if(selectedCommand.equals("PIP")) {
                textFieldContent2 = myTextField2.getText();
                setLabelPropertiesNotEror(myLabelNotEror);
                String sourceFile = textFieldContent;
                String destinationFile = textFieldContent2;
                String[] command = {"cmd", "/c", "start", "cmd.exe", "/K", "copy", sourceFile, destinationFile};
                Process process = Runtime.getRuntime().exec(command);
            } else if (selectedCommand.equals("DIV")) {
                String[] command = {"cmd", "/c", "start", "cmd.exe", "/K", "dir", textFieldContent};
                Process process = Runtime.getRuntime().exec(command);
                setLabelPropertiesNotEror(myLabelNotEror);
            } else if (selectedCommand.equals("MODE") && (textFieldContent.isEmpty())) {
                String[] command = {"cmd", "/c", "start", "cmd.exe", "/K", "mode"};
                Process process = Runtime.getRuntime().exec(command);
                setLabelPropertiesNotEror(myLabelNotEror);
            } else if (selectedCommand.equals("MODE")) {
                String[] splitedTextFieldContent = textFieldContent.split(" ");
                if (splitedTextFieldContent.length == 6) {
                    String[] command = {"cmd", "/c", "start", "cmd.exe", "/K", "mode", splitedTextFieldContent[0], splitedTextFieldContent[1], splitedTextFieldContent[2], splitedTextFieldContent[3], splitedTextFieldContent[4], splitedTextFieldContent[5]};
                    Process process = Runtime.getRuntime().exec(command);
                    setLabelPropertiesNotEror(myLabelNotEror);
                }else if (splitedTextFieldContent.length == 5) {
                    String[] command = {"cmd", "/c", "start", "cmd.exe", "/K", "mode", splitedTextFieldContent[0], splitedTextFieldContent[1], splitedTextFieldContent[2], splitedTextFieldContent[3], splitedTextFieldContent[4]};
                    Process process = Runtime.getRuntime().exec(command);
                    setLabelPropertiesNotEror(myLabelNotEror);
                } else if (splitedTextFieldContent.length == 4) {
                    String[] command = {"cmd", "/c", "start", "cmd.exe", "/K", "mode", splitedTextFieldContent[0], splitedTextFieldContent[1], splitedTextFieldContent[2], splitedTextFieldContent[3]};
                    Process process = Runtime.getRuntime().exec(command);
                    setLabelPropertiesNotEror(myLabelNotEror);
                } else if (splitedTextFieldContent.length == 3) {
                    String[] command = {"cmd", "/c", "start", "cmd.exe", "/K", "mode", splitedTextFieldContent[0], splitedTextFieldContent[1], splitedTextFieldContent[2] };
                    Process process = Runtime.getRuntime().exec(command);
                    setLabelPropertiesNotEror(myLabelNotEror);
                } else if (splitedTextFieldContent.length == 2) {
                    String[] command = {"cmd", "/c", "start", "cmd.exe", "/K", "mode", splitedTextFieldContent[0], splitedTextFieldContent[1]};
                    Process process = Runtime.getRuntime().exec(command);
                    setLabelPropertiesNotEror(myLabelNotEror);
                } else if (splitedTextFieldContent.length == 1) {
                    String[] command = {"cmd", "/c", "start", "cmd.exe", "/K", "mode", splitedTextFieldContent[0]};
                    Process process = Runtime.getRuntime().exec(command);
                    setLabelPropertiesNotEror(myLabelNotEror);
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void divsubmit(ActionEvent event) {
        myLabel.setText("Selected DIV");
        selectedCommand = "DIV";
    }

    public void modesubmit(ActionEvent event) {
        myLabel.setText("Selected MODE");
        selectedCommand = "MODE";
    }

    public void pipsubmit(ActionEvent event) {
        myLabel.setText("Selected PIP");
        selectedCommand = "PIP";
    }
}