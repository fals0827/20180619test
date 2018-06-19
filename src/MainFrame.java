import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JTextArea jta1 = new JTextArea();
    private JTextArea jta2 = new JTextArea();
    private JScrollPane jsp1 = new JScrollPane();
    private JScrollPane jsp2 = new JScrollPane();
    private Container cp ;
    private JPanel jpn = new JPanel(new GridLayout(4,1,1,1));
    private JButton jbtExit = new JButton("Exit");
    private JButton jbtXOR = new JButton("XOR");
    private JPasswordField jpf = new JPasswordField();

    public MainFrame (){
        this.init();
    }

    private void init () {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(80,60,800,600);
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(1,3,2,2));
        jta1.setSize(300,600);
        jta2.setSize(300,600);
        cp.add(jsp1);
        cp.add(jpn);
        cp.add(jsp2);
        jsp1.add(jta1);
        jsp2.add(jta2);
        jpn.add(jpf);
        jpn.add(jbtXOR);
        jpn.add(jbtExit);

        jbtExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        jbtXOR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String str = jta1.getText();
                int size = str.length();
                char [] in = str.toCharArray();
                String psw = jpf.getPassword().toString();
                int pwlen = psw.length();
                char [] pcode = psw.toCharArray();
                for (int i = 0 ; i < size ; i ++){
                    in[i] = (char)( (int) in[i] ^ (int) pcode[i % pwlen]);
                }
                jta2.setText(new String(in));
            }
        });
    }
}
