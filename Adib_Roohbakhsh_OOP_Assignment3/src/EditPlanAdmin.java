//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EditPlanAdmin extends JFrame {
    MobilePlan plan;
    UserLogin userLogin;
    adminLogin admin;
    private JRadioButton businessChoise;
    private JTextField capText;
    private JLabel cityABNLabel;
    private JTextField cityOrABNText;
    private JTextField dayText;
    private JTextField internetText;
    private JButton jButton1;
    private JButton jButton2;
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
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JTextField memoryText;
    private JTextField modelText;
    private JTextField monthText;
    private JLabel noEmpLabel;
    private JTextField noEmpText;
    private JRadioButton personalChoise;
    private JTextField planIDText;
    private JTextField planUsernameText;
    private JTextField priceText;
    private JComboBox<String> typeText;
    private JTextField yearText;

    public EditPlanAdmin(MobilePlan plan, UserLogin userLogin) {
        this.plan = plan;
        this.userLogin = userLogin;
        this.initComponents();
        this.planIDText.setText(plan.getId() + "");
        this.planUsernameText.setText(plan.userName);
        this.modelText.setText(plan.getHandsetModel());
        this.memoryText.setText(plan.handset.getMemorySize() + "");
        this.priceText.setText(plan.getHandsetPrice() + "");
        this.internetText.setText(plan.internetQuota + "");
        this.typeText.setSelectedItem(plan.handset.getType().toString());
        this.capText.setText(plan.capLimit + "");
        this.dayText.setText(plan.getExpiryDate().getDay() + "");
        this.monthText.setText(plan.getExpiryDate().getMonth() + "");
        this.yearText.setText(plan.getExpiryDate().getYear() + "");
        if (plan instanceof PersonalPlan) {
            this.personalChoise.setSelected(true);
            this.businessChoise.setSelected(false);
            this.cityABNLabel.setText("City");
            this.cityOrABNText.setText(((PersonalPlan)plan).getCity());
            this.noEmpText.setText("");
            this.noEmpLabel.setVisible(false);
            this.noEmpText.setVisible(false);
        } else {
            this.personalChoise.setSelected(false);
            this.businessChoise.setSelected(true);
            this.cityABNLabel.setText("ABN");
            this.cityOrABNText.setText(((BusinessPlan)plan).ABN + "");
            this.noEmpText.setText(((BusinessPlan)plan).numberOfEmployees + "");
            this.noEmpLabel.setVisible(true);
            this.noEmpText.setVisible(true);
        }

    }
    
    public EditPlanAdmin(MobilePlan plan, adminLogin adminLogin) {
        this.plan = plan;
        this.admin = adminLogin;
        this.initComponents();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.planIDText.setText(plan.getId() + "");
        this.planUsernameText.setText(plan.userName);
        this.modelText.setText(plan.getHandsetModel());
        this.memoryText.setText(plan.handset.getMemorySize() + "");
        this.priceText.setText(plan.getHandsetPrice() + "");
        this.internetText.setText(plan.internetQuota + "");
        this.typeText.setSelectedItem(plan.handset.getType().toString());
        this.capText.setText(plan.capLimit + "");
        this.dayText.setText(plan.getExpiryDate().getDay() + "");
        this.monthText.setText(plan.getExpiryDate().getMonth() + "");
        this.yearText.setText(plan.getExpiryDate().getYear() + "");
        if (plan instanceof PersonalPlan) {
            this.personalChoise.setSelected(true);
            this.businessChoise.setSelected(false);
            this.cityABNLabel.setText("City");
            this.cityOrABNText.setText(((PersonalPlan)plan).getCity());
            this.noEmpText.setText("");
            this.noEmpLabel.setVisible(false);
            this.noEmpText.setVisible(false);
        } else {
            this.personalChoise.setSelected(false);
            this.businessChoise.setSelected(true);
            this.cityABNLabel.setText("ABN");
            this.cityOrABNText.setText(((BusinessPlan)plan).ABN + "");
            this.noEmpText.setText(((BusinessPlan)plan).numberOfEmployees + "");
            this.noEmpLabel.setVisible(true);
            this.noEmpText.setVisible(true);
        }

    }

    private void initComponents() {
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
        this.setDefaultCloseOperation(3);
        this.jLabel10.setFont(new Font("Calibri", 0, 18));
        this.jLabel10.setText("Username");
        this.jLabel11.setFont(new Font("Calibri", 0, 18));
        this.jLabel11.setText("Plan ID");
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
        this.cityABNLabel.setHorizontalAlignment(4);
        this.cityABNLabel.setText("City");
        this.noEmpLabel.setFont(new Font("Calibri", 0, 18));
        this.noEmpLabel.setText("No. of Employees");
        this.planUsernameText.setFont(new Font("Calibri", 0, 18));
        this.planIDText.setFont(new Font("Calibri", 0, 18));
        this.planIDText.setEnabled(false);
        this.cityOrABNText.setFont(new Font("Calibri", 0, 18));
        this.cityOrABNText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EditPlanAdmin.this.cityOrABNTextActionPerformed(evt);
            }
        });
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
        this.personalChoise.setFont(new Font("Calibri", 0, 18));
        this.personalChoise.setSelected(true);
        this.personalChoise.setText("Personal Plan");
        this.personalChoise.setEnabled(false);
        this.personalChoise.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                EditPlanAdmin.this.personalChoiseStateChanged(evt);
            }
        });
        this.businessChoise.setFont(new Font("Calibri", 0, 18));
        this.businessChoise.setText("Business Plan");
        this.businessChoise.setEnabled(false);
        this.jButton1.setFont(new Font("Calibri", 1, 18));
        this.jButton1.setForeground(new Color(255, 51, 51));
        this.jButton1.setText("UPDATE");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EditPlanAdmin.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Calibri", 1, 18));
        this.jButton2.setForeground(new Color(255, 51, 51));
        this.jButton2.setText("CLEAR");
        this.jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EditPlanAdmin.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(61, 61, 61).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel19).addComponent(this.jLabel16).addComponent(this.jLabel20)).addGroup(layout.createSequentialGroup().addGap(48, 48, 48).addComponent(this.personalChoise).addGap(18, 18, 18).addComponent(this.businessChoise))).addGap(265, 265, 265)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel11).addComponent(this.jLabel13).addComponent(this.jLabel10)).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(310, 310, 310).addComponent(this.jButton2, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1, -2, 118, -2))).addGap(98, 98, 98)))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel15).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(144, 144, 144).addComponent(this.jLabel14)).addGroup(layout.createSequentialGroup().addGap(35, 35, 35).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel22).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.noEmpLabel).addGroup(layout.createSequentialGroup().addGap(109, 109, 109).addComponent(this.jLabel18)).addComponent(this.cityABNLabel, Alignment.TRAILING, -2, 44, -2))))).addComponent(this.jLabel12).addComponent(this.jLabel17)).addGap(21, 21, 21)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel21).addGap(20, 20, 20))).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.memoryText, Alignment.TRAILING, -1, 164, 32767).addComponent(this.priceText, Alignment.TRAILING).addComponent(this.capText, Alignment.TRAILING).addComponent(this.internetText, Alignment.TRAILING).addComponent(this.dayText).addComponent(this.monthText).addComponent(this.planIDText).addComponent(this.yearText).addComponent(this.cityOrABNText).addComponent(this.noEmpText).addComponent(this.typeText, 0, 164, 32767).addComponent(this.planUsernameText).addComponent(this.modelText, Alignment.TRAILING)).addGap(98, 314, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.businessChoise).addComponent(this.personalChoise)).addGap(21, 21, 21).addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.planIDText, -2, -1, -2).addComponent(this.jButton2)).addGap(9, 9, 9).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.planUsernameText, -2, -1, -2).addComponent(this.jLabel10)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel13)).addComponent(this.jButton1)).addGap(4, 4, 4).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.modelText, -2, -1, -2).addComponent(this.jLabel14)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel15, -2, 28, -2).addComponent(this.typeText, -2, 28, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.memoryText, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.priceText, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.internetText, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.capText, -2, -1, -2).addComponent(this.jLabel19)).addGap(18, 18, 18).addComponent(this.jLabel20).addGap(13, 13, 13).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel21).addComponent(this.dayText, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel18).addComponent(this.monthText, -2, -1, -2)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.yearText, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.cityOrABNText, -2, -1, -2).addComponent(this.cityABNLabel)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.noEmpLabel, -2, 33, -2).addComponent(this.noEmpText, -2, -1, -2)).addContainerGap(172, 32767)));
        this.pack();
    }

    private void cityOrABNTextActionPerformed(ActionEvent evt) {
    }

    private void personalChoiseStateChanged(ChangeEvent evt) {
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

    private void jButton1ActionPerformed(ActionEvent evt) {
        try {
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
            this.plan.userName = username;
            this.plan.expiryDate = date;
            this.plan.handset = phone;
            this.plan.capLimit = cap;
            this.plan.internetQuota = quota;
            if (this.personalChoise.isSelected()) {
                String city = this.cityOrABNText.getText();
                ((PersonalPlan)this.plan).city = city;
            } else {
                int abn = Integer.parseInt(this.cityOrABNText.getText());
                int noEmp = Integer.parseInt(this.noEmpText.getText());
                ((BusinessPlan)this.plan).numberOfEmployees = noEmp;
                ((BusinessPlan)this.plan).ABN = abn;
            }

            JOptionPane.showMessageDialog(this, "Plan updated");
            if(userLogin !=null)
                this.userLogin.fillTable();
            if(admin !=null)
                this.admin.fillTable();
            this.dispose();
        } catch (Exception var17) {
            JOptionPane.showMessageDialog(this, var17);
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
}
