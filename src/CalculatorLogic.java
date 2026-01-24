import java.util.Objects;

public class CalculatorLogic {
    private String num1="";
    private String op="";
    private String num2="";
    private int pos =0;
    private double ans = 0.0;
    private boolean cal= false;
    private boolean period1 =false;
    private boolean period2 =false;

    public void update(String s){
        if (ac(s)) return;
        boolean isNum = isNum(s);
        if (isNum) return;
        switch (pos){
            case 0:
                pos0(s);
                break;
            case 1:
                pos1(s);
                break;
            case 2:
                pos2(s);
                break;
            case 3:
                pos3(s);
                break;
        }
    }

    private boolean isNum(String s){
        try{
            Integer.parseInt(s);
        }catch (Exception ex){
            return false;
        }
        if (cal){
            ac("AC");
            cal=false;
        }
        if (pos == 0 || pos == 1) num1 += s;
        else num2 += s;
        if (pos==0) pos=1;
        else if(pos==2) pos=3;
        return true;
    }

    private boolean isOp(String s){
        if (Objects.equals(s, "+") || Objects.equals(s, "x")
                || Objects.equals(s, "-") || Objects.equals(s, "/"))
            return true;
        return false;
    }

    private void pos0(String s){
        if (Objects.equals(s, "ANS")){
            if (ans%1==0){
                num2=String.valueOf((int)ans);
            }else{
                num2=String.valueOf(ans);
                period2=true;
            }
            pos=1;
        }
    }
    private void pos1(String s){
        if(isOp(s)){
            op=s;
            pos=2;
            cal=false;
            return;
        }
        if (cal){
            ac("AC");
            cal=false;
        }
        if(Objects.equals(s, ".") && !period1){
            num1+=s;
            period1=true;
        }else if(Objects.equals(s, "DEL")){
            if (num1.endsWith(".")) period1=false;
            num1=num1.substring(0,num1.length()-1);
            if (num1.isEmpty()) pos=0;
        }else if(Objects.equals(s, "=")){
            eval();
        }
    }

    private void pos2(String s){
        if(Objects.equals(s, "DEL")){
            op="";
            pos=1;
        }else if(Objects.equals(s, "ANS")){
            if (ans%1==0){
                num2=String.valueOf((int)ans);
            }else{
                num2=String.valueOf(ans);
                period2=true;
            }
            pos=3;
        }
    }

    private void pos3(String s){
        if(Objects.equals(s, "DEL")){
            if (num2.endsWith(".")) period2=false;
            num2=num2.substring(0,num2.length()-1);
            if (num2.isEmpty()) pos=2;
        }else if(Objects.equals(s, "=")) {
            eval();
        }else if(Objects.equals(s, ".") && !period2){
            num2+=s;
            period2=true;
        }
    }

    private void eval(){
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
        }catch (Exception ex){}
        if ((result % 1) == 0){
            num1 = String.valueOf((int)(result));
            period1=false;
        }else{
            num1 = String.valueOf(result);
            period1=true;
        }
        op="";
        num2="";
        ans = result;
        period2=false;
        pos=1;
        cal=true;
        System.out.println(num1);
    }


    private boolean ac(String s){
        if (s=="AC"){
            num1="";
            num2="";
            op="";
            pos=0;
            return true;
        }
        return false;
    }

    public String getDisplay(){
        return num1+op+num2;
    }
}
