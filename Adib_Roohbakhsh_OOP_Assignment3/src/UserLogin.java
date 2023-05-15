//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class UserLogin extends JFrame {
    ArrayList<String> cities;
    User user;
    ArrayList<MobilePlan> plans;
    Login login;
    private JTextField IDFindText;
    private JRadioButton businessChoise;
    private ButtonGroup buttonGroup1;
    private JTextField capText;
    private JButton changeButton;
    private JLabel cityABNLabel;
    private JCheckBox cityChoice;
    private JComboBox<String> cityCombo;
    private JTextField cityOrABNText;
    private JTextField cityText;
    private JTextField dateFilterText;
    private JTextField dayText;
    private JButton delBut;
    private JButton findBut;
    private JTextField idText;
    private JTextField internetText;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private JTextField memoryText;
    private JTextField modelFilterText;
    private JTextField modelText;
    private JTextField monthText;
    private JTextField nameText;
    private JLabel noEmpLabel;
    private JTextField noEmpText;
    private JTextField passwordText;
    private JRadioButton personalChoise;
    private JTextArea planArea;
    private JTextField planIDText;
    private JTable planTable;
    private JTable planTable1;
    private JPopupMenu planTablePopUp;
    private JTextField planUsernameText;
    private JTextField priceText;
    private JCheckBox sort;
    private JTextField streetNumText;
    private JTextField streetText;
    private JTextField suburbText;
    private JComboBox<String> typeText;
    private JButton updateBut;
    private JTextField yearText;

    public UserLogin(User user, Login login, ArrayList<String> cities) {
        this.user = user;
        plans = MobilePlan.shallowCopy(user.getPlans());
        this.login = login;
        this.cities = cities;
        this.initComponents();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.planTablePopUp = new JPopupMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.idText = new JTextField();
        this.cityText = new JTextField();
        this.nameText = new JTextField();
        this.streetNumText = new JTextField();
        this.passwordText = new JTextField();
        this.streetText = new JTextField();
        this.suburbText = new JTextField();
        this.cityChoice = new JCheckBox();
        this.cityCombo = new JComboBox();
        this.changeButton = new JButton();
        this.jPanel2 = new JPanel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.jLabel20 = new JLabel();
        this.jLabel21 = new JLabel();
        this.jLabel22 = new JLabel();
        this.cityABNLabel = new JLabel();
        this.noEmpLabel = new JLabel();
        this.planUsernameText = new JTextField();
        this.planIDText = new JTextField();
        this.cityOrABNText = new JTextField();
        this.memoryText = new JTextField();
        this.priceText = new JTextField();
        this.internetText = new JTextField();
        this.modelText = new JTextField();
        this.typeText = new JComboBox();
        this.monthText = new JTextField();
        this.yearText = new JTextField();
        this.noEmpText = new JTextField();
        this.dayText = new JTextField();
        this.capText = new JTextField();
        this.personalChoise = new JRadioButton();
        this.businessChoise = new JRadioButton();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jPanel5 = new JPanel();
        this.findBut = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.planArea = new JTextArea();
        this.IDFindText = new JTextField();
        this.jLabel23 = new JLabel();
        this.jPanel3 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.planTable = new JTable();
        this.updateBut = new JButton();
        this.delBut = new JButton();
        this.jPanel4 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.planTable1 = new JTable();
        this.modelFilterText = new JTextField();
        this.jLabel24 = new JLabel();
        this.jLabel25 = new JLabel();
        this.dateFilterText = new JTextField();
        this.jButton3 = new JButton();
        this.sort = new JCheckBox();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1.setText("Delete");
        this.jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UserLogin.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.planTablePopUp.add(this.jMenuItem1);
        this.jMenuItem2.setText("Update");
        this.jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UserLogin.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.planTablePopUp.add(this.jMenuItem2);
        this.setDefaultCloseOperation(3);
        this.jTabbedPane1.setForeground(new Color(0, 64, 255));
        this.jTabbedPane1.setFont(new Font("Calibri", 0, 18));
        this.jTabbedPane1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                UserLogin.this.jTabbedPane1StateChanged(evt);
            }
        });
        this.jTabbedPane1.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                UserLogin.this.jTabbedPane1FocusGained(evt);
            }
        });
        this.jLabel1.setFont(new Font("Calibri", 0, 18));
        this.jLabel1.setText("User ID");
        this.jLabel2.setFont(new Font("Calibri", 0, 18));
        this.jLabel2.setText("Name");
        this.jLabel4.setFont(new Font("Calibri", 0, 18));
        this.jLabel4.setText("Password");
        this.jLabel5.setFont(new Font("Calibri", 0, 18));
        this.jLabel5.setText("Address Information");
        this.jLabel6.setFont(new Font("Calibri", 0, 18));
        this.jLabel6.setText("Street Num");
        this.jLabel7.setFont(new Font("Calibri", 0, 18));
        this.jLabel7.setText("Street");
        this.jLabel8.setFont(new Font("Calibri", 0, 18));
        this.jLabel8.setText("Suburb");
        this.jLabel9.setFont(new Font("Calibri", 0, 18));
        this.jLabel9.setText("City");
        this.idText.setEditable(false);
        this.idText.setFont(new Font("Calibri", 0, 18));
        this.idText.setEnabled(false);
        this.cityText.setFont(new Font("Calibri", 0, 18));
        this.cityText.setEnabled(false);
        this.nameText.setFont(new Font("Calibri", 0, 18));
        this.streetNumText.setFont(new Font("Calibri", 0, 18));
        this.passwordText.setFont(new Font("Calibri", 0, 18));
        this.streetText.setFont(new Font("Calibri", 0, 18));
        this.suburbText.setFont(new Font("Calibri", 0, 18));
        this.cityChoice.setFont(new Font("Calibri", 0, 18));
        this.cityChoice.setText("New City");
        this.cityChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                UserLogin.this.cityChoiceItemStateChanged(evt);
            }
        });
        this.cityCombo.setFont(new Font("Calibri", 0, 18));
        this.changeButton.setFont(new Font("Calibri", 0, 18));
        this.changeButton.setForeground(new Color(51, 71, 255));
        this.changeButton.setText("Change");
        this.changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UserLogin.this.changeButtonActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel5).addGroup(Alignment.TRAILING, jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel9).addComponent(this.jLabel8).addComponent(this.jLabel7).addComponent(this.jLabel6))).addGap(25, 25, 25).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.streetText, -2, 112, -2).addComponent(this.streetNumText, -2, 112, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addComponent(this.changeButton).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.cityCombo, 0, -1, 32767).addComponent(this.suburbText, -1, 112, 32767)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.cityText, -2, 112, -2))).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.cityChoice)))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jLabel2).addComponent(this.jLabel1, -2, 108, -2)).addGap(29, 29, 29).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.idText, -2, 112, -2).addComponent(this.nameText, -2, 112, -2).addComponent(this.passwordText, -2, 112, -2)))).addContainerGap(1158, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(38, 38, 38).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel1, -2, 29, -2).addComponent(this.idText)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.nameText)).addGap(18, 18, 18).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.passwordText)).addGap(18, 18, 18).addComponent(this.jLabel5).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.streetNumText)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.streetText)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.suburbText)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.cityText).addComponent(this.cityChoice).addComponent(this.cityCombo, -2, -1, -2)).addGap(33, 33, 33).addComponent(this.changeButton).addContainerGap(321, 32767)));
        this.jTabbedPane1.addTab("Edit User Information", this.jPanel1);
        this.jLabel10.setFont(new Font("Calibri", 0, 18));
        this.jLabel10.setText("Username");
        this.jLabel11.setFont(new Font("Calibri", 0, 18));
        this.jLabel11.setText(" Plan ID");
        this.jLabel12.setFont(new Font("Calibri", 0, 18));
        this.jLabel12.setText("Memory Size");
        this.jLabel13.setFont(new Font("Calibri", 0, 18));
        this.jLabel13.setText("Mobile Phone");
        this.jLabel14.setFont(new Font("Calibri", 0, 18));
        this.jLabel14.setText("Model");
        this.jLabel15.setFont(new Font("Calibri", 0, 18));
        this.jLabel15.setText("OS Type");
        this.jLabel16.setFont(new Font("Calibri", 0, 18));
        this.jLabel16.setText("Internet Quota");
        this.jLabel17.setFont(new Font("Calibri", 0, 18));
        this.jLabel17.setText("Price");
        this.jLabel18.setFont(new Font("Calibri", 0, 18));
        this.jLabel18.setText("Month");
        this.jLabel19.setFont(new Font("Calibri", 0, 18));
        this.jLabel19.setText("Cap Limit");
        this.jLabel20.setFont(new Font("Calibri", 0, 18));
        this.jLabel20.setText("Expiry Date");
        this.jLabel21.setFont(new Font("Calibri", 0, 18));
        this.jLabel21.setText("Day");
        this.jLabel22.setFont(new Font("Calibri", 0, 18));
        this.jLabel22.setText("Year");
        this.cityABNLabel.setFont(new Font("Calibri", 0, 18));
        this.cityABNLabel.setHorizontalAlignment(2);
        this.cityABNLabel.setText("City");
        this.noEmpLabel.setFont(new Font("Calibri", 0, 18));
        this.noEmpLabel.setText("No. of Employees");
        this.planUsernameText.setFont(new Font("Calibri", 0, 18));
        this.planIDText.setFont(new Font("Calibri", 0, 18));
        this.cityOrABNText.setFont(new Font("Calibri", 0, 18));
        this.memoryText.setFont(new Font("Calibri", 0, 18));
        this.priceText.setFont(new Font("Calibri", 0, 18));
        this.internetText.setFont(new Font("Calibri", 0, 18));
        this.modelText.setFont(new Font("Calibri", 0, 18));
        this.typeText.setFont(new Font("Calibri", 0, 18));
        this.typeText.setModel(new DefaultComboBoxModel(new String[]{"IOS", "ANDROID", "WINDOWS"}));
        this.monthText.setFont(new Font("Calibri", 0, 18));
        this.yearText.setFont(new Font("Calibri", 0, 18));
        this.noEmpText.setFont(new Font("Calibri", 0, 18));
        this.dayText.setFont(new Font("Calibri", 0, 18));
        this.capText.setFont(new Font("Calibri", 0, 18));
        this.buttonGroup1.add(this.personalChoise);
        this.personalChoise.setFont(new Font("Calibri", 0, 18));
        this.personalChoise.setSelected(true);
        this.personalChoise.setText("Personal Plan");
        this.personalChoise.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                UserLogin.this.personalChoseStateChanged(evt);
            }
        });
        this.buttonGroup1.add(this.businessChoise);
        this.businessChoise.setFont(new Font("Calibri", 0, 18));
        this.businessChoise.setText("Business Plan");
        this.jButton1.setFont(new Font("Calibri", 0, 18));
        this.jButton1.setForeground(new Color(51, 78, 255));
        this.jButton1.setText("ADD");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    UserLogin.this.jButton1ActionPerformed(evt);
                } catch (PlanException | PlanExceptionUserName e) {
                    e.printStackTrace();
                }
            }
        });
        this.jButton2.setFont(new Font("Calibri", 0, 18));
        this.jButton2.setForeground(new Color(51, 95, 255));
        this.jButton2.setText("CLEAR");
        this.jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UserLogin.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(61, 61, 61).addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel19).addComponent(this.jLabel16).addComponent(this.jLabel20)).addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel11).addComponent(this.jLabel13).addComponent(this.jLabel10)).addGroup(jPanel2Layout.createSequentialGroup().addGap(48, 48, 48).addComponent(this.personalChoise).addGap(18, 18, 18).addComponent(this.businessChoise)))).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel15).addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(144, 144, 144).addComponent(this.jLabel14)).addGroup(jPanel2Layout.createSequentialGroup().addGap(35, 35, 35).addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel22).addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addComponent(this.noEmpLabel).addGroup(jPanel2Layout.createSequentialGroup().addGap(109, 109, 109).addComponent(this.jLabel18)).addComponent(this.cityABNLabel, Alignment.TRAILING, -2, 44, -2))))).addComponent(this.jLabel12).addComponent(this.jLabel17)).addGap(21, 21, 21)).addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel21).addGap(20, 20, 20))).addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.memoryText, Alignment.TRAILING, -1, 164, 32767).addComponent(this.priceText, Alignment.TRAILING).addComponent(this.capText, Alignment.TRAILING).addComponent(this.internetText, Alignment.TRAILING).addComponent(this.dayText).addComponent(this.monthText).addComponent(this.planIDText).addComponent(this.yearText).addComponent(this.cityOrABNText).addComponent(this.noEmpText).addComponent(this.typeText, 0, 164, 32767).addComponent(this.planUsernameText).addComponent(this.modelText, Alignment.TRAILING).addComponent(this.jButton1, -1, -1, 32767)))).addGap(106, 106, 106).addComponent(this.jButton2, -2, 101, -2).addContainerGap(1106, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.personalChoise).addComponent(this.businessChoise)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.planIDText, -2, -1, -2).addComponent(this.jButton2)).addGap(9, 9, 9).addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addComponent(this.planUsernameText, -2, -1, -2).addComponent(this.jLabel10)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel13).addGap(4, 4, 4).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.modelText, -2, -1, -2).addComponent(this.jLabel14)).addPreferredGap(ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel15, -2, 28, -2).addComponent(this.typeText, -2, 28, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.memoryText, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.priceText, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.internetText, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addComponent(this.capText, -2, -1, -2).addComponent(this.jLabel19)).addGap(18, 18, 18).addComponent(this.jLabel20).addGap(13, 13, 13).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel21).addComponent(this.dayText, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel18).addComponent(this.monthText, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.yearText, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.cityOrABNText, -2, -1, -2).addComponent(this.cityABNLabel)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.noEmpLabel, -2, 33, -2).addComponent(this.noEmpText, -2, -1, -2)).addGap(26, 26, 26).addComponent(this.jButton1).addContainerGap(105, 32767)));
        this.jTabbedPane1.addTab("Add plans", this.jPanel2);
        this.findBut.setFont(new Font("Calibri", 0, 18));
        this.findBut.setForeground(new Color(0, 64, 255));
        this.findBut.setText("FIND");
        this.findBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UserLogin.this.findButActionPerformed(evt);
            }
        });
        this.planArea.setBackground(new Color(0, 229, 160, 255));
        this.planArea.setColumns(20);
        this.planArea.setFont(new Font("Calibri ", 0, 18));
        this.planArea.setRows(5);
        this.jScrollPane2.setViewportView(this.planArea);
        this.IDFindText.setFont(new Font("Calibri", 0, 18));
        this.jLabel23.setFont(new Font("Calibri", 0, 18));
        this.jLabel23.setText("Plan ID");
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(46, 46, 46).addComponent(this.jLabel23).addGap(18, 18, 18).addComponent(this.IDFindText, -2, 138, -2).addGap(20, 20, 20).addComponent(this.findBut, -2, 85, -2).addContainerGap(1343, 32767)).addGroup(Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(30, 30, 30).addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.findBut).addComponent(this.IDFindText, -2, -1, -2).addComponent(this.jLabel23, -2, 31, -2)).addGap(56, 56, 56).addComponent(this.jScrollPane2, -2, 518, -2).addContainerGap(161, 32767)));
        this.jTabbedPane1.addTab("Find a Plan", this.jPanel5);
        this.planTable.setFont(new Font("Calibri", 0, 18));
        this.planTable.setModel(new DefaultTableModel(new Object[][]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.planTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                UserLogin.this.planTableMousePressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.planTable);
        this.updateBut.setFont(new Font("Calibri", 0, 18));
        this.updateBut.setForeground(new Color(0, 26, 255));
        this.updateBut.setText("UPDATE");
        this.updateBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UserLogin.this.updateButActionPerformed();
            }
        });
        this.delBut.setFont(new Font("Calibri", 0, 18));
        this.delBut.setForeground(new Color(255, 0, 0));
        this.delBut.setText("DELETE");
        this.delBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UserLogin.this.delButActionPerformed();
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jScrollPane1, -1, 1708, 32767).addGroup(jPanel3Layout.createSequentialGroup().addGap(268, 268, 268).addComponent(this.updateBut).addContainerGap(-1, 32767)).addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(143, 143, 143).addComponent(this.delBut).addContainerGap(1464, 32767))));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 444, -2).addGap(37, 37, 37).addComponent(this.updateBut).addGap(0, 284, 32767)).addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(482, 32767).addComponent(this.delBut).addGap(283, 283, 283))));
        this.jTabbedPane1.addTab("Plans Information", this.jPanel3);
        this.planTable1.setFont(new Font("Calibri", 0, 18));
        this.planTable1.setModel(new DefaultTableModel(new Object[][]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jScrollPane3.setViewportView(this.planTable1);
        this.modelFilterText.setFont(new Font("Calibri", 0, 18));
        this.modelFilterText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                UserLogin.this.modelFilterTextKeyReleased(evt);
            }
        });
        this.jLabel24.setFont(new Font("Calibri", 0, 18));
        this.jLabel24.setText("Mobile Model");
        this.jLabel25.setFont(new Font("Calibri", 0, 18));
        this.jLabel25.setText("Expiry Date");
        this.dateFilterText.setFont(new Font("Calibri", 0, 18));
        this.jButton3.setFont(new Font("Calibri", 0, 18));
        this.jButton3.setText("Filter By Date");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UserLogin.this.jButton3ActionPerformed(evt);
            }
        });
        this.sort.setFont(new Font("Calibri", 0, 18));
        this.sort.setText("Sort by Username");
        this.sort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UserLogin.this.sortActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jScrollPane3, -1, 1708, 32767).addGroup(jPanel4Layout.createSequentialGroup().addGap(44, 44, 44).addGroup(jPanel4Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel25).addGap(29, 29, 29).addComponent(this.dateFilterText, -2, 136, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel24).addGap(29, 29, 29).addComponent(this.modelFilterText, -2, 136, -2))).addGap(30, 30, 30).addComponent(this.jButton3).addGap(204, 204, 204).addComponent(this.sort).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 512, -2).addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(33, 33, 33).addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel24).addComponent(this.modelFilterText, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel25).addComponent(this.dateFilterText, -2, -1, -2).addComponent(this.jButton3))).addGroup(jPanel4Layout.createSequentialGroup().addGap(73, 73, 73).addComponent(this.sort))).addContainerGap(174, 32767)));
        this.jTabbedPane1.addTab("Filter plans", this.jPanel4);
        this.jMenu1.setText("Logout");
        this.jMenu1.setFont(new Font("Calibri", 0, 18));
        this.jMenu1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                UserLogin.this.jMenu1MousePressed(evt);
            }
        });
        this.jMenuBar1.add(this.jMenu1);
        this.setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addGap(97, 97, 97)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.jTabbedPane1, -2, 832, -2).addContainerGap(-1, 32767)));
        this.pack();
    }

    private void jTabbedPane1StateChanged(ChangeEvent evt) {
        this.planArea.setText("");
        this.idText.setText(this.user.getUserID() + "");
        this.nameText.setText(this.user.getName());
        this.passwordText.setText(this.user.getUserPassword());
        this.streetText.setText(this.user.getAddress().getStreet());
        this.streetNumText.setText(this.user.getAddress().getStreetNum() + "");
        this.suburbText.setText(this.user.getAddress().getSuburb());
        this.cityCombo.setModel(new DefaultComboBoxModel(this.cities.toArray(new String[0])));
        this.cityCombo.setSelectedItem(this.user.getCity());
        this.cityText.setText(this.user.getCity());
        if (this.personalChoise.isSelected()) {
            this.noEmpLabel.setVisible(false);
            this.noEmpText.setVisible(false);
            this.cityABNLabel.setText("City");
        } else {
            this.noEmpLabel.setVisible(true);
            this.noEmpText.setVisible(true);
            this.cityABNLabel.setText("ABN");
        }

        this.planTable.setComponentPopupMenu(this.planTablePopUp);
        this.fillTable();
        this.fillTable1();
    }

    private void cityChoiceItemStateChanged(ItemEvent evt) {
        if (this.cityChoice.isSelected()) {
            this.cityCombo.setEnabled(false);
            this.cityText.setEnabled(true);
        } else {
            this.cityCombo.setEnabled(true);
            this.cityText.setEnabled(false);
        }

    }

    private void changeButtonActionPerformed(ActionEvent evt) {
        try {
            this.user.setName(this.nameText.getText());
            this.user.setUserPassword(this.passwordText.getText());
            if (!this.streetNumText.getText().equals(""))
                this.user.getAddress().setStreetNum(Integer.parseInt(this.streetNumText.getText()));
            this.user.getAddress().setStreet(this.streetText.getText());
            this.user.getAddress().setSuburb(this.suburbText.getText());
            if (this.cityChoice.isSelected()) {
                this.user.getAddress().setCity(this.cityText.getText());
                if (cities.contains(this.cityText.getText())) {
                    JOptionPane.showMessageDialog(this, "We have this city in our list please enter new city.");
                } else {
                    this.cities.add(this.cityText.getText());
                }
                this.cityCombo.setModel(new DefaultComboBoxModel(this.cities.toArray(new String[0])));
                this.cityCombo.setSelectedItem(this.cityText.getText());
            } else {
                this.user.getAddress().setCity((String) this.cityCombo.getSelectedItem());
                this.cityText.setText(this.user.getCity());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }

    private void personalChoseStateChanged(ChangeEvent evt) {
        if (this.personalChoise.isSelected()) {
            this.noEmpLabel.setVisible(false);
            this.noEmpText.setVisible(false);
            this.cityABNLabel.setText("City");
        } else {
            this.noEmpLabel.setVisible(true);
            this.noEmpText.setVisible(true);
            this.cityABNLabel.setText("ABN");
        }

    }

    private void jButton1ActionPerformed(ActionEvent evt) throws PlanException,PlanExceptionUserName {
        try {
            int id = Integer.parseInt(this.planIDText.getText());
            String username = this.planUsernameText.getText();
            String model = this.modelText.getText();
            MobileType type = MobileType.valueOf(this.typeText.getSelectedItem().toString());
            int size = Integer.parseInt(this.memoryText.getText());
            double price = Double.parseDouble(this.priceText.getText());
            int quota = Integer.parseInt(this.internetText.getText());
            int cap = Integer.parseInt(this.capText.getText());
            int day = Integer.parseInt(this.dayText.getText());
            int month = Integer.parseInt(this.monthText.getText());
            int year = Integer.parseInt(this.yearText.getText());
            MyDate date = new MyDate(year, month, day);
            MobilePhone phone = new MobilePhone(model, type, size, price);
            MobilePlan plan = null;
            if (this.personalChoise.isSelected()) {
                String city = null;
                try {
                     city = this.cityOrABNText.getText();
                    plan = new PersonalPlan(username, id, phone, quota, cap, city, date);
                } catch (PlanExceptionUserName peun) {
                    try {
                        username = peun.getNewUserName();
                        JOptionPane.showMessageDialog(this, peun);
                        plan = new PersonalPlan(username, id, phone, quota, cap, city, date);
                    }catch (PlanException pe){
                        id = pe.getNewID();
                        JOptionPane.showMessageDialog(this, pe);
                        plan = new PersonalPlan(username, id, phone, quota, cap, city, date);
                    }

                } catch (PlanException pe) {
                    id = pe.getNewID();
                    JOptionPane.showMessageDialog(this, pe);
                    plan = new PersonalPlan(username, id, phone, quota, cap, city, date);
                }
            } else {
                int noEmp = 0;
                int abn = 0;
                try {
                     abn = Integer.parseInt(this.cityOrABNText.getText());
                     noEmp = Integer.parseInt(this.noEmpText.getText());
                    plan = new BusinessPlan(username, id, phone, quota, cap, noEmp, abn, date);
                } catch (PlanExceptionUserName peun) {
                    try {
                        username = peun.getNewUserName();
                        JOptionPane.showMessageDialog(this, peun);
                        plan = new BusinessPlan(username, id, phone, quota, cap, noEmp, abn, date);
                    }catch (PlanException pe){
                        id = pe.getNewID();
                        JOptionPane.showMessageDialog(this, pe);
                        plan = new BusinessPlan(username, id, phone, quota, cap, noEmp, abn, date);
                    }
                } catch (PlanException pe) {
                    id = pe.getNewID();
                    JOptionPane.showMessageDialog(this, pe);
                    plan = new BusinessPlan(username, id, phone, quota, cap, noEmp, abn, date);
                }
            }


            if (this.user.addPlan(plan, user.getUserID(), user.getUserPassword())) {
                plans.add(plan);
                JOptionPane.showMessageDialog(this, "Plan added successfully :)");
                this.planIDText.setText("");
                this.planUsernameText.setText("");
                this.modelText.setText("");
                this.memoryText.setText("");
                this.priceText.setText("");
                this.internetText.setText("");
                this.capText.setText("");
                this.dayText.setText("");
                this.monthText.setText("");
                this.yearText.setText("");
                this.cityOrABNText.setText("");
                this.noEmpText.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Plan adding failed");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.planIDText.setText("");
        this.planUsernameText.setText("");
        this.modelText.setText("");
        this.memoryText.setText("");
        this.priceText.setText("");
        this.internetText.setText("");
        this.capText.setText("");
        this.dayText.setText("");
        this.monthText.setText("");
        this.yearText.setText("");
        this.cityOrABNText.setText("");
        this.noEmpText.setText("");
    }

    private void findButActionPerformed(ActionEvent evt) {
        try {
            MobilePlan plan = this.user.findPlan(Integer.parseInt(this.IDFindText.getText()), user.getUserID(), user.getUserPassword());
            if (plan != null) {
                this.planArea.append(plan.toString() + "\n");
            } else {
                this.planArea.append("Plan with ID= " + this.IDFindText.getText() + " has not been found \n");
            }
        } catch (Exception var3) {
            JOptionPane.showMessageDialog(this, var3);
        }

    }

    private void delButActionPerformed() {

        int index = this.planTable.getSelectedRow();
        if (index >= 0) {
            plans.remove(index);
            this.fillTable();
        } else {
            JOptionPane.showMessageDialog(this, "Select a Row First");
        }

    }

    private void updateButActionPerformed() {

        int index = this.planTable.getSelectedRow();
        if (index >= 0) {
            EditPlan editPlan = new EditPlan(MobilePlan.shallowCopy(user.getPlans()).get(index), this);
            editPlan.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select a Row First");
        }
    }

    private void jTabbedPane1FocusGained(FocusEvent evt) {
        this.fillTable1();
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.fillTable1();
    }

    private void sortActionPerformed(ActionEvent evt) {
        this.fillTable1();
    }

    private void modelFilterTextKeyReleased(KeyEvent evt) {
        this.fillTable1();
    }

    private void planTableMousePressed(MouseEvent evt) {
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        int index = this.planTable.getSelectedRow();
        if (index >= 0) {
            plans.remove(index);
            this.fillTable();
        }

    }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        int index = this.planTable.getSelectedRow();
        if (index >= 0) {
            EditPlan editPlan = new EditPlan(MobilePlan.shallowCopy(user.getPlans()).get(index), this);
            editPlan.setVisible(true);
        }
    }

    private void jMenu1MousePressed(MouseEvent evt) {
        this.dispose();
        this.login.setVisible(true);
    }

    public void fillTable() {
        String[] header = new String[]{"Plan ID", "username", "Model", "OS Type", "Memory Size", "handset price", "Internet Quota", "Cap Limit", "Expiry Date", "City", "ABN", "Number of Employees", "Monthly Payment"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        this.planTable.setModel(model);

        for (MobilePlan plan : plans) {
            String[] row = new String[13];
            row[0] = plan.getId() + "";
            row[1] = plan.userName;
            row[2] = plan.getHandsetModel();
            row[3] = plan.handset.getType().toString();
            row[4] = plan.handset.getMemorySize() + "";
            row[5] = plan.handset.getPrice() + "";
            row[6] = plan.internetQuota + "";
            row[7] = plan.capLimit + "";
            row[8] = plan.getExpiryDate().toString();
            if (plan instanceof PersonalPlan) {
                row[9] = ((PersonalPlan) plan).city;
                row[10] = "NA";
                row[11] = "NA";
            } else {
                row[9] = "NA";
                row[10] = ((BusinessPlan) plan).ABN + "";
                row[11] = ((BusinessPlan) plan).numberOfEmployees + "";
            }

            row[12] = String.format("$%.2f", plan.calcPayment(10.0D));
            model.addRow(row);
        }

    }

    public void fillTable1() {
        ArrayList<MobilePlan> plansCopy = new ArrayList();
        HashMap<Integer, MobilePlan> hashPlans = new HashMap<>();
        ArrayList<MobilePlan> planArrayList = new ArrayList<>();
        for (MobilePlan mobilePlan : plans) {
            planArrayList.add(mobilePlan);
            hashPlans.put(mobilePlan.getId(), mobilePlan);
            plansCopy.add(mobilePlan);
        }

        String[] fields;
        try {
            if (!this.modelFilterText.getText().isEmpty()) {
                ArrayList<MobilePlan> plansCopy1 = new ArrayList<>();
                for (MobilePlan mobilePlan : user.getPlans().values()) {
                    plansCopy1.add(mobilePlan);
                }
                plansCopy = MobilePlan.filterByMobileModel(MobilePlan.shallowCopy(hashPlans), this.modelFilterText.getText());
            }

            if (!this.dateFilterText.getText().isEmpty()) {
                fields = this.dateFilterText.getText().split("/");
                int year = Integer.parseInt(fields[0]);
                int month = Integer.parseInt(fields[1]);
                int day = Integer.parseInt(fields[2]);
                MyDate date = new MyDate(year, month, day);
                plansCopy = MobilePlan.filterByExpiryDate(MobilePlan.shallowCopy(hashPlans), date);
            }
        } catch (Exception var7) {
            JOptionPane.showMessageDialog(this, var7);
        }

        if (this.sort.isSelected()) {
            Collections.sort(plansCopy);
        }

        fields = new String[]{"Plan ID", "username", "Model", "OS Type", "Memory Size", "handset price", "Internet Quota", "Cap Limit", "Expiry Date", "City", "ABN", "Number of Employees", "Monthly Payment"};
        DefaultTableModel model = new DefaultTableModel(fields, 0);
        this.planTable1.setModel(model);
        for (MobilePlan plan : plansCopy) {
            String[] row = new String[13];
            row[0] = plan.getId() + "";
            row[1] = plan.userName;
            row[2] = plan.getHandsetModel();
            row[3] = plan.handset.getType().toString();
            row[4] = plan.handset.getMemorySize() + "";
            row[5] = plan.handset.getPrice() + "";
            row[6] = plan.internetQuota + "";
            row[7] = plan.capLimit + "";
            row[8] = plan.getExpiryDate().toString();
            if (plan instanceof PersonalPlan) {
                row[9] = ((PersonalPlan) plan).city;
                row[10] = "NA";
                row[11] = "NA";
            } else {
                row[9] = "NA";
                row[10] = ((BusinessPlan) plan).ABN + "";
                row[11] = ((BusinessPlan) plan).numberOfEmployees + "";
            }

            row[12] = String.format("$%.2f", plan.calcPayment(10.0D));
            model.addRow(row);
        }

    }
}