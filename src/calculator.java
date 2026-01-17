import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class calculator implements ActionListener {
    private static JPanel panel = new JPanel();
    private static JTextField screen;
    private static String num1="";
    private static String op="";
    private static String num2="";
    private static int pos =0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(350,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel title = new JLabel("Calculator");
        title.setBounds(10, 10, 150, 30);
        panel.add(title);

        screen = new JTextField();
        screen.setBounds(20, 40, 300, 30);
        panel.add(screen);

        allBtns();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String bval =e.getActionCommand();
        if (bval=="AC"){
            num1="";
            num2="";
            op="";
            pos=0;
        }

        boolean isNum=isNum(bval);
        if (isNum) return;

        if(pos==1){
            if(isOp(bval)){
                op=bval;
                pos=2;
            }else if(bval=="."){
                num1+=bval;
            }else if(bval=="DEL"){
                num1=num1.substring(0,num1.length()-1);
                if (num1.isEmpty()) pos=0;
            }else if(bval=="="){
                eval();
            }
        }else if(pos==2){
            if (isNum){
                pos=3;
                num2+=bval;
            }else if(bval=="DEL"){
                op="";
                pos=1;
            }
        }else if(pos==3){
            if(bval=="DEL"){
                num2=num2.substring(0,num2.length()-1);
                if (num2.isEmpty()) pos=2;
            }else if(bval=="=") {
                eval();
            }
        }
        screen.setText(num1+op+num2);
    }

    private static void eval(){
        double result = 0;
        try{
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);

            switch (op){
                case "+":
                    result = number1+number2;
                    break;
                case "-":
                    result = number1-number2;
                    break;
                case "x":
                    result=number1*number2;
                    break;
                case "/":
                    result = number1/number2;
                    break;
            }
        }catch (Exception ex){

        }
        num1 = String.valueOf(result);
        op="";
        num2="";


    }

    private static boolean isNum(String s){
        try{
            Integer.parseInt(s);
        }catch (Exception ex){
            return false;
        }
        if (pos == 0 || pos == 1) num1 += s;
        else num2 += s;
        if (pos==0) pos=1;
        else if(pos==2) pos=3;
        screen.setText(num1+op+num2);
        return true;
    }

    private static boolean isOp(String s){
        if (s=="+" || s=="x" || s=="-" || s=="/")
            return true;
        return false;
    }


    private static JButton initButton(String val, int x, int y, int w){
        JButton b = new JButton(val);
        b.setBounds(x, y, w, 40);
        b.setActionCommand(val);
        b.addActionListener(new calculator());
        panel.add(b);
        return b;
    }

    private static void allBtns(){
        b0 = initButton("0", 100,300,80);
        b1 = initButton("1", 10,250,80);
        b2 = initButton("2", 100,250,80);
        b3 = initButton("3", 190,250,80);
        b4 = initButton("4", 10,200,80);
        b5 = initButton("5", 100,200,80);
        b6 = initButton("6", 190,200,80);
        b7 = initButton("7", 10,150,80);
        b8 = initButton("8", 100,150,80);
        b9 = initButton("9", 190,150,80);

        dot = initButton(".", 10,300,80);
        eq = initButton("=", 190,300,80);

        del = initButton("DEL", 10,100,80);
        ac = initButton("AC", 100,100,80);
        ans = initButton("ANS", 190,100,80);

        plus = initButton("+", 280,150,50);
        minus = initButton("-", 280,200,50);
        mul = initButton("x", 280,250,50);
        div = initButton("/", 280,300,50);
    }

    private static JButton b0;
    private static JButton b1;
    private static JButton b2;
    private static JButton b3;
    private static JButton b4;
    private static JButton b5;
    private static JButton b6;
    private static JButton b7;
    private static JButton b8;
    private static JButton b9;

    private static JButton dot;
    private static JButton eq;

    private static JButton del;
    private static JButton ac;
    private static JButton ans;

    private static JButton plus;
    private static JButton minus;
    private static JButton mul;
    private static JButton div;
}
