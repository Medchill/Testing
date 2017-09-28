import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.tabs.Tabs;
import static org.dreambot.api.methods.MethodProvider.sleep;

import org.sikuli.api.*;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;
import org.sikuli.ocr.*;
import sun.font.Script;

import static java.lang.Integer.parseInt;


import javax.swing.*;

import static org.sikuli.api.API.*;

public class Main{
    public static void main(String[] args) throws MalformedURLException {
        final String[] ScriptNum = new String[1];
        final String[] Switch = new String[1];
        final int[] ScriptNumber = new int[1];

        JFrame frame1 = new JFrame();
        frame1.setTitle("Script Switcher");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setPreferredSize(new Dimension(300, 170));
        frame1.getContentPane().setLayout(new BorderLayout());

        JPanel settingPanel1 = new JPanel();
        settingPanel1.setLayout(new GridLayout(0, 2));

        JLabel ScriptNumLabel = new JLabel();
        ScriptNumLabel.setText("How many scripts to switch?");
        settingPanel1.add(ScriptNumLabel);

        //JTextField ScriptSwitchText = new JTextField();
        //settingPanel1.add(ScriptSwitchText);

        JComboBox<String> ScriptSwitchCombo = new JComboBox<>(new String[]{
           "1","2","3","4","5"
        });
        settingPanel1.add(ScriptSwitchCombo);


        frame1.getContentPane().add(settingPanel1, BorderLayout.CENTER);
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new FlowLayout());

        JButton Start1 = new JButton();
        Start1.setText("Start");
        Start1.addActionListener(k -> {
            //ScriptNum[0] = ScriptSwitchText.toString();
            Switch[0] = ScriptSwitchCombo.getSelectedItem().toString();
            frame1.dispose();
        });
        buttonPanel1.add(Start1);
        frame1.getContentPane().add(buttonPanel1, BorderLayout.SOUTH);

        frame1.pack();
        frame1.setVisible(true);

        while (frame1.isVisible()){
            sleep(1);
        }

        if (parseInt(Switch[0]) == 1) {
            Switch1();
        }
        if (parseInt(Switch[0]) == 2) {
            Switch2();
        }
        if (parseInt(Switch[0]) == 3) {
            Switch3();
        }
        if (parseInt(Switch[0]) == 4) {
            Switch4();
        }
        if (parseInt(Switch[0]) == 5) {
            Switch5();
        }
    }
    private static void Switch1() throws MalformedURLException{
        final String[] CategoryName = new String[1];
        final String[] Script = new String[1];
        final String[] Account = new String[1];
        final String[] Time = new String[1];
        int CategoryCoordY = 0;



        JFrame frame = new JFrame();
        frame.setTitle("Script Selector");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 170));
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel settingPanel = new JPanel();
        settingPanel.setLayout(new GridLayout(0, 2));

        JLabel CategoryLabel = new JLabel();
        CategoryLabel.setText("Script Category:");
        settingPanel.add(CategoryLabel);

        JComboBox<String> CategoryCombo = new JComboBox<>(new String[]{
                "Local", "Free", "Premium", "All"});
        settingPanel.add(CategoryCombo);

        JLabel ScriptNum = new JLabel();
        ScriptNum.setText("Script Number:");
        settingPanel.add(ScriptNum);

        JTextField ScriptTextNum = new JTextField();
        settingPanel.add(ScriptTextNum);

        JLabel AccLabel = new JLabel();
        AccLabel.setText("Account Number:");
        settingPanel.add(AccLabel);

        JComboBox<String> AccCombo = new JComboBox<>(new String[]{
                "1", "2", "3", "4", "5", "6", "7"});
        settingPanel.add(AccCombo);

        JLabel TimeSwitch = new JLabel();
        TimeSwitch.setText("Time before switch:");
        settingPanel.add(TimeSwitch);

        JTextField TimeText = new JTextField();
        settingPanel.add(TimeText);

        frame.getContentPane().add(settingPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton Start = new JButton();
        Start.setText("Start");
        Start.addActionListener(l -> {
            CategoryName[0] = CategoryCombo.getSelectedItem().toString();
            Script[0] = ScriptTextNum.getText();
            Account[0] = AccCombo.getSelectedItem().toString();
            Time[0] = TimeText.getText();
            frame.dispose();
        });
        buttonPanel.add(Start);

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        while (frame.isVisible()){
            sleep(1000);
        }

        ScreenRegion s = new DesktopScreenRegion();
        URL StartButton = new URL("http://i66.tinypic.com/16aa453.png");
        Target imageTarget = new ImageTarget(StartButton);
        ScreenRegion r1 = s.wait(imageTarget, 3000);
        Canvas canvas1 = new DesktopCanvas();
        canvas1.addLabel(r1, "Clicking here").display(3);
        Mouse mouse1 = new DesktopMouse();
        mouse1.click(r1.getCenter());


        URL ScriptSel = new URL("http://i67.tinypic.com/155m0iv.png");
        Target ScriptSelTarget = new ImageTarget(ScriptSel);
        ScreenRegion r2 = s.wait(ScriptSelTarget, 3000);
        Mouse mouse2 = new DesktopMouse();
        Canvas canvas2 = new DesktopCanvas();

        if (CategoryName[0] == "Local"){
            CategoryCoordY = 50;
        }
        if (CategoryName[0] == "Free"){
            CategoryCoordY = 100;
        }
        if (CategoryName[0] == "Premium"){
            CategoryCoordY = 150;
        }
        if (CategoryName[0] == "All"){
            CategoryCoordY = 200;
        }

        mouse2.click(r2.getRelativeScreenLocation(50,CategoryCoordY));

        if (parseInt(Script[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(250, 100));
        }
        if (parseInt(Script[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(350, 100));
        }
        if (parseInt(Script[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(250, 200));
        }
        if (parseInt(Script[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(350, 200));
        }
        if (parseInt(Script[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(250, 300));
        }
        if (parseInt(Script[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(350, 300));

        }
        if (parseInt(Script[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(250, 450));
        }
        if (parseInt(Script[0]) == 8){
            mouse2.click(r2.getRelativeScreenLocation(350, 450));
        }


        mouse2.click(r2.getRelativeScreenLocation(20, 460));
        if (parseInt(Account[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(20, 320));
        }
        if (parseInt(Account[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(20, 340));
        }
        if (parseInt(Account[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(20, 360));
        }
        if (parseInt(Account[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(20, 380));
        }
        if (parseInt(Account[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(20, 400));
        }
        if (parseInt(Account[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(20, 420));
        }
        if (parseInt(Account[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(20, 440));
        }
        mouse2.click(r2.getRelativeScreenLocation(20, 480));

        sleep(parseInt(Time[0])*60*1000);

        mouse1.click(r1.getRelativeScreenLocation(90,5));
    }
    private static void Switch2() throws MalformedURLException{
        final String[] CategoryName1 = new String[1];
        final String[] CategoryName2 = new String[1];
        final String[] Script1 = new String[1];
        final String[] Script2 = new String[1];
        final String[] Account1 = new String[1];
        final String[] Account2 = new String[1];
        final String[] Time1 = new String[1];
        final String[] Time2 = new String[1];
        int CategoryCoordY = 0;



        JFrame frame = new JFrame();
        frame.setTitle("Script Selector");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 200));
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel settingPanel = new JPanel();
        settingPanel.setLayout(new GridLayout(0, 3));

        JLabel Blank1 = new JLabel();
        Blank1.setText("");
        settingPanel.add(Blank1);

        JLabel ScriptLabel1 = new JLabel();
        ScriptLabel1.setText("1st Script");
        settingPanel.add(ScriptLabel1);

        JLabel ScriptLabel2 = new JLabel();
        ScriptLabel2.setText("2nd Script");
        settingPanel.add(ScriptLabel2);

        JLabel CategoryLabel = new JLabel();
        CategoryLabel.setText("Script Category:");
        settingPanel.add(CategoryLabel);

        JComboBox<String> CategoryCombo1 = new JComboBox<>(new String[]{
                "Local", "Free", "Premium", "All"});
        settingPanel.add(CategoryCombo1);

        JComboBox<String> CategoryCombo2 = new JComboBox<>(new String[]{
                "Local", "Free", "Premium", "All"});
        settingPanel.add(CategoryCombo2);

        JLabel ScriptNum = new JLabel();
        ScriptNum.setText("Script Number:");
        settingPanel.add(ScriptNum);

        JTextField ScriptTextNum1 = new JTextField();
        settingPanel.add(ScriptTextNum1);

        JTextField ScriptTextNum2 = new JTextField();
        settingPanel.add(ScriptTextNum2);

        JLabel AccLabel = new JLabel();
        AccLabel.setText("Account Number:");
        settingPanel.add(AccLabel);

        JComboBox<String> AccCombo1 = new JComboBox<>(new String[]{
                "1", "2", "3", "4", "5", "6", "7"});
        settingPanel.add(AccCombo1);

        JComboBox<String> AccCombo2 = new JComboBox<>(new String[]{
                "1", "2", "3", "4", "5", "6", "7"});
        settingPanel.add(AccCombo2);

        JLabel TimeSwitch = new JLabel();
        TimeSwitch.setText("Minutes before switch:");
        settingPanel.add(TimeSwitch);

        JTextField TimeText1 = new JTextField();
        settingPanel.add(TimeText1);

        JTextField TimeText2 = new JTextField();
        settingPanel.add(TimeText2);

        frame.getContentPane().add(settingPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton Start = new JButton();
        Start.setText("Start");
        Start.addActionListener(l -> {
            CategoryName1[0] = CategoryCombo1.getSelectedItem().toString();
            CategoryName2[0] = CategoryCombo2.getSelectedItem().toString();
            Script1[0] = ScriptTextNum1.getText();
            Script2[0] = ScriptTextNum2.getText();
            Account1[0] = AccCombo1.getSelectedItem().toString();
            Account2[0] = AccCombo2.getSelectedItem().toString();
            Time1[0] = TimeText1.getText();
            Time2[0] = TimeText2.getText();
            frame.dispose();
        });
        buttonPanel.add(Start);

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        while (frame.isVisible()){
            sleep(1000);
        }

        ScreenRegion s = new DesktopScreenRegion();
        URL StartButton = new URL("http://i66.tinypic.com/16aa453.png");
        Target imageTarget = new ImageTarget(StartButton);
        ScreenRegion r1 = s.wait(imageTarget, 3000);
        Canvas canvas1 = new DesktopCanvas();
        canvas1.addLabel(r1, "Clicking here").display(3);
        Mouse mouse1 = new DesktopMouse();
        mouse1.click(r1.getCenter());


        URL ScriptSel = new URL("http://i67.tinypic.com/155m0iv.png");
        Target ScriptSelTarget = new ImageTarget(ScriptSel);
        ScreenRegion r2 = s.wait(ScriptSelTarget, 3000);
        Mouse mouse2 = new DesktopMouse();
        Canvas canvas2 = new DesktopCanvas();

        if (CategoryName1[0] == "Local"){
            CategoryCoordY = 50;
        }
        if (CategoryName1[0] == "Free"){
            CategoryCoordY = 100;
        }
        if (CategoryName1[0] == "Premium"){
            CategoryCoordY = 150;
        }
        if (CategoryName1[0] == "All"){
            CategoryCoordY = 200;
        }

        mouse2.click(r2.getRelativeScreenLocation(50,CategoryCoordY));

        if (parseInt(Script1[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(250, 100));
        }
        if (parseInt(Script1[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(350, 100));
        }
        if (parseInt(Script1[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(250, 200));
        }
        if (parseInt(Script1[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(350, 200));
        }
        if (parseInt(Script1[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(250, 300));
        }
        if (parseInt(Script1[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(350, 300));

        }
        if (parseInt(Script1[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(250, 450));
        }
        if (parseInt(Script1[0]) == 8){
            mouse2.click(r2.getRelativeScreenLocation(350, 450));
        }


        mouse2.click(r2.getRelativeScreenLocation(20, 460));
        if (parseInt(Account1[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(20, 320));
        }
        if (parseInt(Account1[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(20, 340));
        }
        if (parseInt(Account1[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(20, 360));
        }
        if (parseInt(Account1[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(20, 380));
        }
        if (parseInt(Account1[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(20, 400));
        }
        if (parseInt(Account1[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(20, 420));
        }
        if (parseInt(Account1[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(20, 440));
        }
        mouse2.click(r2.getRelativeScreenLocation(20, 480));

        sleep(parseInt(Time1[0])*60*1000);

        mouse1.click(r1.getRelativeScreenLocation(90,5));

        //if (Account1.toString() != Account2.toString()){
        //    sleep(900000);
        //}

        sleep(10000);

        mouse1.click(r1.getCenter());

        if (CategoryName2[0] == "Local"){
            CategoryCoordY = 50;
        }
        if (CategoryName2[0] == "Free"){
            CategoryCoordY = 100;
        }
        if (CategoryName2[0] == "Premium"){
            CategoryCoordY = 150;
        }
        if (CategoryName2[0] == "All"){
            CategoryCoordY = 200;
        }

        mouse2.click(r2.getRelativeScreenLocation(50,CategoryCoordY));

        if (parseInt(Script2[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(250, 100));
        }
        if (parseInt(Script2[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(350, 100));
        }
        if (parseInt(Script2[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(250, 200));
        }
        if (parseInt(Script2[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(350, 200));
        }
        if (parseInt(Script2[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(250, 300));
        }
        if (parseInt(Script2[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(350, 300));

        }
        if (parseInt(Script2[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(250, 450));
        }
        if (parseInt(Script2[0]) == 8){
            mouse2.click(r2.getRelativeScreenLocation(350, 450));
        }


        mouse2.click(r2.getRelativeScreenLocation(20, 460));
        if (parseInt(Account2[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(20, 320));
        }
        if (parseInt(Account2[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(20, 340));
        }
        if (parseInt(Account2[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(20, 360));
        }
        if (parseInt(Account2[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(20, 380));
        }
        if (parseInt(Account2[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(20, 400));
        }
        if (parseInt(Account2[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(20, 420));
        }
        if (parseInt(Account2[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(20, 440));
        }
        mouse2.click(r2.getRelativeScreenLocation(20, 480));

        sleep(parseInt(Time2[0])*60*1000);

        mouse1.click(r1.getRelativeScreenLocation(90,5));
    }
    private static void Switch3() throws MalformedURLException{
        final String[] CategoryName1 = new String[1];
        final String[] CategoryName2 = new String[1];
        final String[] CategoryName3 = new String[1];
        final String[] Script1 = new String[1];
        final String[] Script2 = new String[1];
        final String[] Script3 = new String[1];
        final String[] Account1 = new String[1];
        final String[] Account2 = new String[1];
        final String[] Account3 = new String[1];
        final String[] Time1 = new String[1];
        final String[] Time2 = new String[1];
        final String[] Time3 = new String[1];
        int CategoryCoordY = 0;



        JFrame frame = new JFrame();
        frame.setTitle("Script Selector");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 200));
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel settingPanel = new JPanel();
        settingPanel.setLayout(new GridLayout(0, 4));

        JLabel Blank1 = new JLabel();
        Blank1.setText("");
        settingPanel.add(Blank1);

        JLabel ScriptLabel1 = new JLabel();
        ScriptLabel1.setText("1st Script");
        settingPanel.add(ScriptLabel1);

        JLabel ScriptLabel2 = new JLabel();
        ScriptLabel2.setText("2nd Script");
        settingPanel.add(ScriptLabel2);

        JLabel ScriptLabel3 = new JLabel();
        ScriptLabel3.setText("3rd Script");
        settingPanel.add(ScriptLabel3);

        JLabel CategoryLabel = new JLabel();
        CategoryLabel.setText("Script Category:");
        settingPanel.add(CategoryLabel);

        JComboBox<String> CategoryCombo1 = new JComboBox<>(new String[]{
                "Local", "Free", "Premium", "All"});
        settingPanel.add(CategoryCombo1);

        JComboBox<String> CategoryCombo2 = new JComboBox<>(new String[]{
                "Local", "Free", "Premium", "All"});
        settingPanel.add(CategoryCombo2);

        JComboBox<String> CategoryCombo3 = new JComboBox<>(new String[]{
                "Local", "Free", "Premium", "All"});
        settingPanel.add(CategoryCombo3);

        JLabel ScriptNum = new JLabel();
        ScriptNum.setText("Script Number:");
        settingPanel.add(ScriptNum);

        JTextField ScriptTextNum1 = new JTextField();
        settingPanel.add(ScriptTextNum1);

        JTextField ScriptTextNum2 = new JTextField();
        settingPanel.add(ScriptTextNum2);

        JTextField ScriptTextNum3 = new JTextField();
        settingPanel.add(ScriptTextNum3);

        JLabel AccLabel = new JLabel();
        AccLabel.setText("Account Number:");
        settingPanel.add(AccLabel);

        JComboBox<String> AccCombo1 = new JComboBox<>(new String[]{
                "1", "2", "3", "4", "5", "6", "7"});
        settingPanel.add(AccCombo1);

        JComboBox<String> AccCombo2 = new JComboBox<>(new String[]{
                "1", "2", "3", "4", "5", "6", "7"});
        settingPanel.add(AccCombo2);

        JComboBox<String> AccCombo3 = new JComboBox<>(new String[]{
                "1", "2", "3", "4", "5", "6", "7"});
        settingPanel.add(AccCombo3);

        JLabel TimeSwitch = new JLabel();
        TimeSwitch.setText("Minutes before switch:");
        settingPanel.add(TimeSwitch);

        JTextField TimeText1 = new JTextField();
        settingPanel.add(TimeText1);

        JTextField TimeText2 = new JTextField();
        settingPanel.add(TimeText2);

        JTextField TimeText3 = new JTextField();
        settingPanel.add(TimeText3);

        frame.getContentPane().add(settingPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton Start = new JButton();
        Start.setText("Start");
        Start.addActionListener(l -> {
            CategoryName1[0] = CategoryCombo1.getSelectedItem().toString();
            CategoryName2[0] = CategoryCombo2.getSelectedItem().toString();
            CategoryName3[0] = CategoryCombo3.getSelectedItem().toString();
            Script1[0] = ScriptTextNum1.getText();
            Script2[0] = ScriptTextNum2.getText();
            Script3[0] = ScriptTextNum3.getText();
            Account1[0] = AccCombo1.getSelectedItem().toString();
            Account2[0] = AccCombo2.getSelectedItem().toString();
            Account3[0] = AccCombo3.getSelectedItem().toString();
            Time1[0] = TimeText1.getText();
            Time2[0] = TimeText2.getText();
            Time3[0] = TimeText2.getText();
            frame.dispose();
        });
        buttonPanel.add(Start);

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        while (frame.isVisible()){
            sleep(1000);
        }

        ScreenRegion s = new DesktopScreenRegion();
        URL StartButton = new URL("http://i66.tinypic.com/16aa453.png");
        Target imageTarget = new ImageTarget(StartButton);
        ScreenRegion r1 = s.wait(imageTarget, 3000);
        Canvas canvas1 = new DesktopCanvas();
        canvas1.addLabel(r1, "Clicking here").display(3);
        Mouse mouse1 = new DesktopMouse();
        mouse1.click(r1.getCenter());


        URL ScriptSel = new URL("http://i67.tinypic.com/155m0iv.png");
        Target ScriptSelTarget = new ImageTarget(ScriptSel);
        ScreenRegion r2 = s.wait(ScriptSelTarget, 3000);
        Mouse mouse2 = new DesktopMouse();
        Canvas canvas2 = new DesktopCanvas();

        if (CategoryName1[0] == "Local"){
            CategoryCoordY = 50;
        }
        if (CategoryName1[0] == "Free"){
            CategoryCoordY = 100;
        }
        if (CategoryName1[0] == "Premium"){
            CategoryCoordY = 150;
        }
        if (CategoryName1[0] == "All"){
            CategoryCoordY = 200;
        }

        mouse2.click(r2.getRelativeScreenLocation(50,CategoryCoordY));

        if (parseInt(Script1[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(250, 100));
        }
        if (parseInt(Script1[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(350, 100));
        }
        if (parseInt(Script1[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(250, 200));
        }
        if (parseInt(Script1[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(350, 200));
        }
        if (parseInt(Script1[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(250, 300));
        }
        if (parseInt(Script1[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(350, 300));

        }
        if (parseInt(Script1[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(250, 450));
        }
        if (parseInt(Script1[0]) == 8){
            mouse2.click(r2.getRelativeScreenLocation(350, 450));
        }


        mouse2.click(r2.getRelativeScreenLocation(20, 460));
        if (parseInt(Account1[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(20, 320));
        }
        if (parseInt(Account1[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(20, 340));
        }
        if (parseInt(Account1[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(20, 360));
        }
        if (parseInt(Account1[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(20, 380));
        }
        if (parseInt(Account1[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(20, 400));
        }
        if (parseInt(Account1[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(20, 420));
        }
        if (parseInt(Account1[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(20, 440));
        }
        mouse2.click(r2.getRelativeScreenLocation(20, 480));

        sleep(parseInt(Time1[0])*60*1000);

        mouse1.click(r1.getRelativeScreenLocation(90,5));

        //if (Account1.toString() != Account2.toString()){
        //    sleep(900000);
        //}

        sleep(10000);

        mouse1.click(r1.getCenter());

        if (CategoryName2[0] == "Local"){
            CategoryCoordY = 50;
        }
        if (CategoryName2[0] == "Free"){
            CategoryCoordY = 100;
        }
        if (CategoryName2[0] == "Premium"){
            CategoryCoordY = 150;
        }
        if (CategoryName2[0] == "All"){
            CategoryCoordY = 200;
        }

        mouse2.click(r2.getRelativeScreenLocation(50,CategoryCoordY));

        if (parseInt(Script2[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(250, 100));
        }
        if (parseInt(Script2[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(350, 100));
        }
        if (parseInt(Script2[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(250, 200));
        }
        if (parseInt(Script2[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(350, 200));
        }
        if (parseInt(Script2[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(250, 300));
        }
        if (parseInt(Script2[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(350, 300));

        }
        if (parseInt(Script2[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(250, 450));
        }
        if (parseInt(Script2[0]) == 8){
            mouse2.click(r2.getRelativeScreenLocation(350, 450));
        }


        mouse2.click(r2.getRelativeScreenLocation(20, 460));
        if (parseInt(Account2[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(20, 320));
        }
        if (parseInt(Account2[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(20, 340));
        }
        if (parseInt(Account2[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(20, 360));
        }
        if (parseInt(Account2[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(20, 380));
        }
        if (parseInt(Account2[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(20, 400));
        }
        if (parseInt(Account2[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(20, 420));
        }
        if (parseInt(Account2[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(20, 440));
        }
        mouse2.click(r2.getRelativeScreenLocation(20, 480));
        sleep(parseInt(Time2[0])*60*1000);
        mouse1.click(r1.getRelativeScreenLocation(90,5));
        sleep(10000);

        mouse1.click(r1.getCenter());
        if (CategoryName3[0] == "Local"){
            CategoryCoordY = 50;
        }
        if (CategoryName3[0] == "Free"){
            CategoryCoordY = 100;
        }
        if (CategoryName3[0] == "Premium"){
            CategoryCoordY = 150;
        }
        if (CategoryName3[0] == "All"){
            CategoryCoordY = 200;
        }

        mouse2.click(r2.getRelativeScreenLocation(50,CategoryCoordY));

        if (parseInt(Script3[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(250, 100));
        }
        if (parseInt(Script3[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(350, 100));
        }
        if (parseInt(Script3[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(250, 200));
        }
        if (parseInt(Script3[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(350, 200));
        }
        if (parseInt(Script3[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(250, 300));
        }
        if (parseInt(Script3[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(350, 300));

        }
        if (parseInt(Script3[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(250, 450));
        }
        if (parseInt(Script3[0]) == 8){
            mouse2.click(r2.getRelativeScreenLocation(350, 450));
        }


        mouse2.click(r2.getRelativeScreenLocation(20, 460));
        if (parseInt(Account3[0]) == 1){
            mouse2.click(r2.getRelativeScreenLocation(20, 320));
        }
        if (parseInt(Account3[0]) == 2){
            mouse2.click(r2.getRelativeScreenLocation(20, 340));
        }
        if (parseInt(Account3[0]) == 3){
            mouse2.click(r2.getRelativeScreenLocation(20, 360));
        }
        if (parseInt(Account3[0]) == 4){
            mouse2.click(r2.getRelativeScreenLocation(20, 380));
        }
        if (parseInt(Account3[0]) == 5){
            mouse2.click(r2.getRelativeScreenLocation(20, 400));
        }
        if (parseInt(Account3[0]) == 6){
            mouse2.click(r2.getRelativeScreenLocation(20, 420));
        }
        if (parseInt(Account3[0]) == 7){
            mouse2.click(r2.getRelativeScreenLocation(20, 440));
        }
        mouse2.click(r2.getRelativeScreenLocation(20, 480));

        sleep(parseInt(Time2[0])*60*1000);

        mouse1.click(r1.getRelativeScreenLocation(90,5));
    }
    private static void Switch4() throws MalformedURLException{

    }
    private static void Switch5() throws MalformedURLException{

    }
}