import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class Login extends JFrame {
    MobileCompany mobileCompany = new MobileCompany();
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPasswordField passText;
    private JTextField userText;

    public Login() throws PlanException, PlanExceptionUserName {
        this.fillDataAndRun();
        this.initComponents();
    }

    public void fillDataAndRun() throws PlanException, PlanExceptionUserName {
        this.mobileCompany = new MobileCompany("AdibTech", "admin", "admin", 5);
        MobilePhone mobilePhone = new MobilePhone("Xiaomi Note 9", MobileType.ANDROID, 8, 5100);
        MobilePhone mobilePhone1 = new MobilePhone("Iphone 8", MobileType.IOS, 4, 2200);
        MobilePhone mobilePhone2 = new MobilePhone("Nokia 10", MobileType.WINDOWS, 16, 5060);

        MobilePlan plan0 = new PersonalPlan("USR111111U", 3000007, mobilePhone, 120, 22, "Mazandaran" ,new MyDate(2000, 5, 14));
        MobilePlan plan1 = new PersonalPlan("USR222222U", 3000008, mobilePhone, 30, 38, "Shiraz", new MyDate(1999, 4, 34));
        MobilePlan plan2 = new PersonalPlan("USR333333U", 3000009, mobilePhone1, 100, 20, "Tehran", new MyDate(2004, 3, 23));
        MobilePlan plan3 = new BusinessPlan("USR444444U", 3000010, mobilePhone1, 50, 80, 20, 128, new MyDate(2020, 6, 21));
        MobilePlan plan4 = new BusinessPlan("USR555555U", 3000011, mobilePhone2, 20, 30, 10, 555, new MyDate(2021, 7, 29));
        MobilePlan plan5 = new BusinessPlan("USR666666U", 3000012, mobilePhone2, 200, 46, 200, 233, new MyDate(2024, 2, 17));

        User user0 = new User( "Adib", new Address(12, "red", "flower", "Esfahan"), "user");
        User user1 = new User( "Adel", new Address(43, "sun", "dimond", "Esfahan"), "user");
        User user2 = new User( "Hasti", new Address(22, "rain", "silver", "Esfahan"), "user");
        User user3 = new User( "Helia", new Address(330, "vet", "green", "Tehran"), "user");
        User user4 = new User( "Sara", new Address(20, "gold", "cloud", "Sari"), "user");
        User user5 = new User( "Yeganeh", new Address(41, "rose", "sun flower", "Isfahan"), "user");

        this.mobileCompany.addUser(user0,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addUser(user1,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addUser(user2,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addUser(user3,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addUser(user4,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addUser(user5,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addUser("Bahador",new Address(9, "goat", "horse", "Esfahan"),"1234567",  "bg657", "pass123");
        this.mobileCompany.addPlan(user0.getUserID(), plan0,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user0.getUserID(), plan5,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user0.getUserID(), plan1,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user0.getUserID(), plan2,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user1.getUserID(), plan1,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user1.getUserID(), plan4,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user1.getUserID(), plan5,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user1.getUserID(), plan3,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user2.getUserID(), plan2,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user2.getUserID(), plan3,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user2.getUserID(), plan0,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.addPlan(user2.getUserID(), plan4,mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
        this.mobileCompany.createPersonalPlan(user3.getUserID(), "USR777777U", 3000001, mobilePhone, 25, 2, new MyDate(2019, 9, 14), "Esfahan",mobileCompany.getAdminUsername(),mobileCompany.getAdminPassword());
        this.mobileCompany.createPersonalPlan(user3.getUserID(), "USR888888U", 3000002, mobilePhone1, 30, 50, new MyDate(2021, 10, 18), "Yazd",mobileCompany.getAdminUsername(),mobileCompany.getAdminPassword());
        this.mobileCompany.createPersonalPlan(user4.getUserID(), "USR999999U", 3000003, mobilePhone2, 120, 57, new MyDate(2021, 11, 22), "Sari",mobileCompany.getAdminUsername(),mobileCompany.getAdminPassword());
        this.mobileCompany.createBusinessPlan(user4.getUserID(), "USR111110U", 3000004, mobilePhone1, 50, 2, new MyDate(2019, 8, 11), 150, 3215,mobileCompany.getAdminUsername(),mobileCompany.getAdminPassword());
        this.mobileCompany.createBusinessPlan(user5.getUserID(), "USR222220U", 3000005, mobilePhone, 200, 34, new MyDate(2020, 9, 31), 4, 3344,mobileCompany.getAdminUsername(),mobileCompany.getAdminPassword());
        this.mobileCompany.createBusinessPlan(user5.getUserID(), "USR333330U", 3000006, mobilePhone2, 5000, 80, new MyDate(2020, 12, 1), 20, 5665,mobileCompany.getAdminUsername(),mobileCompany.getAdminPassword());
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.userText = new JTextField();
        this.jButton1 = new JButton();
        this.passText = new JPasswordField();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.jMenu2 = new JMenu();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setFont(new Font("Calibri", 0, 18));
        this.jLabel1.setText("UserID");
        this.jLabel2.setFont(new Font("Calibri", 0, 18));
        this.jLabel2.setText("Password");
        this.userText.setFont(new Font("Calibri", 0, 18));
        this.jButton1.setFont(new Font("Calibri", 0, 18));
        this.jButton1.setForeground(new Color(102, 122, 255));
        this.jButton1.setText("Login");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    Login.this.jButton1ActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (PlanException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        this.passText.setFont(new Font("Calibri", 0, 18));
        this.passText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    Login.this.passTextActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (PlanException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        this.jMenu1.setText("File");
        this.jMenu1.setFont(new Font("Calibri", 0, 18));
        this.jMenuItem1.setFont(new Font("Calibri", 0, 18));
        this.jMenuItem1.setText("Load");
        this.jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1);
        this.jMenuItem2.setFont(new Font("Calibri", 0, 18));
        this.jMenuItem2.setText("Save");
        this.jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2);
        this.jMenuBar1.add(this.jMenu1);
        this.jMenu2.setText("Users' List");
        this.jMenu2.setFont(new Font("Calibri", 0, 18));
        this.jMenu2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Login.this.jMenu2MouseClicked(evt);
            }
        });
        this.jMenuBar1.add(this.jMenu2);
        this.setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(142, 142, 142).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jButton1).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1, -2, 110, -2).addComponent(this.jLabel2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.userText).addComponent(this.passText, -1, 125, 32767)))).addContainerGap(298, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(114, 114, 114).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel1, -2, 29, -2).addComponent(this.userText, -2, -1, -2)).addGap(29, 29, 29).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.passText, -2, -1, -2)).addGap(34, 34, 34).addComponent(this.jButton1).addContainerGap(126, 32767)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) throws IOException, PlanException, ClassNotFoundException {
        this.login();
    }

    private void passTextActionPerformed(ActionEvent evt) throws IOException, PlanException, ClassNotFoundException {
        this.login();
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        try {
             mobileCompany.load("companyy.ser");
        } catch (IOException var3) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, var3);
        }

    }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        try {
            this.mobileCompany.save("companyy.ser");
        } catch (IOException var3) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, var3);
        }

    }

    private void jMenu2MouseClicked(MouseEvent evt) {
        String message = "";
        ArrayList<User> iterator1 = new ArrayList<>();
        for (User user : mobileCompany.getUsers().values()){
            iterator1.add(user);
        }
        User user;
        for(Iterator var3 = iterator1.iterator(); var3.hasNext(); message = message +"UserID :  " + user.getUserID()+  "       password :  " + user.getUserPassword() + "\n") {
            user = (User)var3.next();
        }

        JOptionPane.showMessageDialog(this, message);
    }

    public void login() throws PlanException, IOException, ClassNotFoundException {
        if(mobileCompany.validateAdmin(userText.getText(),passText.getText())){
            adminLogin adminUI = new adminLogin(mobileCompany,this);
            this.setVisible(false);
            adminUI.setVisible(true);
        }
        else {
            User user = this.mobileCompany.validateUser(Integer.parseInt(this.userText.getText()), this.passText.getText(), mobileCompany.getAdminUsername(), mobileCompany.getAdminPassword());
            this.passText.setText("");
            if (user != null) {
                ArrayList<String> cities = this.mobileCompany.populateDistinctCityNames();
                UserLogin userLogin = new UserLogin(user, this, cities);
                userLogin.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Your ID or password is incorrect");
            }
        }

    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    (new Login()).setVisible(true);
                } catch (PlanException | PlanExceptionUserName planException) {
                    planException.printStackTrace();
                }
            }
        });
    }
}