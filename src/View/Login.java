package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;
import javax.swing.WindowConstants.*;

public class Login  extends JFrame implements ActionListener {


    JLabel lbl_Username;
    JLabel lbl_Password;
    JLabel lbl_Footer;
    JLabel lblMessage;
    JTextField txt_user;
    JPasswordField password;
    JButton btn_login;
    JButton btn_signup, btn_forgot;
    JCheckBox checkBox_Password;
    JLabel lbl_showPass;
    JLabel rj;

    public static int USER_ID;

    public Login() {
        setFrame();
        setUIElements();

    }

    public void setFrame() {
        setTitle(" Login");
        setBounds(400, 100, 560, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(2, 37, 48));

        setResizable(false);
        setLayout(null);
        rj = new JLabel((new ImageIcon("Image\\1.png")));
        rj.setBounds(0, 0, 560, 600);
        add(rj);

    }

    public void setUIElements() {

        //Username Label

        lbl_Username = new JLabel("Username");
        lbl_Username.setFont(new Font("Roboto", Font.PLAIN, 20));
        lbl_Username.setBounds(150, 250, 200, 25);
        lbl_Username.setForeground(Color.BLACK);
        add(lbl_Username);
        add(rj);

        //TextBoxUsername

        txt_user = new JTextField();
        txt_user.setFont(new Font("Roboto", Font.PLAIN, 15));
        txt_user.setBounds(280, 250, 160, 25);
        add(txt_user);
        add(rj);

        //Password

        lbl_Password = new JLabel("Password");
        lbl_Password.setFont(new Font("Roboto", Font.PLAIN, 20));
        lbl_Password.setBounds(150, 320, 200, 25);
        lbl_Password.setForeground(Color.BLACK);
        add(lbl_Password);
        add(rj);

        //PasswordTextBox

        password = new JPasswordField();
        password.setFont(new Font("Roboto", Font.PLAIN, 15));
        password.setBounds(280, 320, 160, 25);
        add(password);
        add(rj);

        //Checkbox

        checkBox_Password = new JCheckBox();
        checkBox_Password.setBounds(250, 370, 20, 20);
        add(checkBox_Password);
        checkBox_Password.addActionListener(this::actionPerformed);
        add(rj);

        //Checkbox label

        lbl_showPass = new JLabel("Show Password");
        lbl_showPass.setFont(new Font("Roboto", Font.PLAIN, 15));
        lbl_showPass.setBounds(280, 370, 200, 20);
        lbl_showPass.setForeground(Color.BLACK);
        add(lbl_showPass);
        add(rj);

        //to check if user has account

        lbl_Footer = new JLabel("Don't have an account? SignUp");
        lbl_Footer.setFont(new Font("Roboto", Font.PLAIN, 15));
        lbl_Footer.setBounds(250, 435, 300, 30);
        lbl_Footer.setForeground(Color.black);
        add(lbl_Footer);
        add(rj);


        //Login Button

        btn_login = new JButton("Login");
        btn_login.setBounds(150, 470, 130, 30);
        btn_login.setFont(new Font("Roboto", Font.BOLD, 15));
        btn_login.setForeground(Color.white);
        btn_login.setBackground(new Color(122, 47, 44));
        add(btn_login);
        add(rj);
        btn_login.addActionListener(this::actionPerformed);

        btn_forgot = new JButton("Forgot password");
        btn_forgot.setBounds(300, 406, 150, 20);
        btn_forgot.setFont(new Font("Roboto", Font.BOLD, 13));
        btn_forgot.setForeground(Color.white);
        btn_forgot.setBackground(new Color(122, 47, 44));
        btn_forgot.addActionListener(this);
        add(btn_forgot);
        add(rj);

        //SignUp Button

        btn_signup = new JButton("SignUp");
        btn_signup.setBounds(300, 470, 130, 30);
        btn_signup.setFont(new Font("Roboto", Font.BOLD, 15));
        btn_signup.setForeground(Color.white);
        btn_signup.setBackground(new Color(122, 47, 44));
        add(btn_signup);
        add(rj);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
//        btn_signup.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Registrationn registrationPage = new Registrationn();
//                registrationPage.show();
//                dispose();
//            }
//        });
//
//        btn_forgot.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Forgetpassword forgetpassword = new Forgetpassword();
//                forgetpassword.show();
//                dispose();
//            }
//        });
//
//        lblMessage = new JLabel("",SwingConstants.CENTER);
//        lblMessage.setBounds(0,500,600,30);
//        lblMessage.setForeground(Color.RED);
//        add(lblMessage);
//        add(rj);
//
//
//    }
//
//    public static void main(String[] args) {
//
//        new LoginFrame().setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource().equals(btn_login)){
//            String user_v= txt_user.getText();
//            char[] p = password.getPassword();
//            String pass_v=String.valueOf(p);
//            Pattern my_pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
//            Matcher my_match = my_pattern.matcher(pass_v);
//            boolean check = my_match.find();
//
//            if(user_v.length()==0&&pass_v.length()==0){
//                JOptionPane.showMessageDialog(null,"Enter Username and Password!!");
//            }
//            else if(user_v.length()==0){
//                JOptionPane.showMessageDialog(null,"Enter Username!!");
//            }
//            else if(pass_v.length()==0){
//                JOptionPane.showMessageDialog(null,"Enter Password!!");
//            }
//            else if(pass_v.length()<5){
//                JOptionPane.showMessageDialog(null,"The password length should be more than 5 Character!!");
//            }
//            else if(!check){
//                JOptionPane.showMessageDialog(null,"Password must contain Special Character!!");
//            }
//            else{
//                JOptionPane.showMessageDialog(null,"Login Successful");
//            }
//        }
//
//        if(checkBox_Password.isSelected()){
//            password.setEchoChar((char)0);
//        }
//        else{
//            password.setEchoChar('*');
//        }
//
//    }

