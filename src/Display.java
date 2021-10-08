import javax.swing.*;

public class Display {


    static void printUserMenu() {
        System.out.println("*********************************************");
        System.out.println("To apply for a Boarding Pass, press 1:");
//        System.out.println("To print an existing Boarding Pass, press 2: ");
        System.out.println("To exit, press 3: ");
        System.out.println("*********************************************");
        Access.userMenu();
    }

    static void gui(){
        JFrame f = new JFrame();

//        JCheckBoxMenuItem jcbmi = new JCheckBoxMenuItem("input");
        JButton b=new JButton("submit");
        b.setBounds(130,100,100, 40);

//        f.add(jcbmi);
        f.add(b);


        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
}
