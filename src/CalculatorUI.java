import javax.swing.*;

public class CalculatorUI {
    public CalculatorUI(){
        panel.setLayout(null);
        setFrame();
        setScreen();
        setTitle();

        allBtns();
        frame.setVisible(true);
    }

    private void updateDisplay(String s){
        screen.setText(s);
    }

    private void setFrame(){
        frame.setSize(350,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
    }

    private void setTitle(){
        JLabel title = new JLabel("Calculator");
        title.setBounds(10, 10, 150, 30);
        panel.add(title);
    }

    private void setScreen(){
        screen.setBounds(20, 40, 300, 30);
        panel.add(screen);
    }

    private void allBtns(){
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

    private JButton initButton(String val, int x, int y, int w){
        JButton b = new JButton(val);
        b.setBounds(x, y, w, 40);
        b.setActionCommand(val);
        b.addActionListener(e->{
            logic.update(val);
            updateDisplay(logic.getDisplay());});
        panel.add(b);
        return b;
    }

    private JButton b0;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;

    private JButton dot;
    private JButton eq;

    private JButton del;
    private JButton ac;
    private JButton ans;

    private JButton plus;
    private JButton minus;
    private JButton mul;
    private JButton div;

    private JPanel panel = new JPanel();
    private JTextField screen = new JTextField();
    private JFrame frame = new JFrame("Calculator");

    private CalculatorLogic logic = new CalculatorLogic();
}
