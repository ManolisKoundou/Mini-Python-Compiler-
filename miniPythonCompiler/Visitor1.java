//Εμμανουήλ Κουνδουράκης – 3140269
//Λεονάρδος Ζήνων Χατζηγιαχτσίδης – 3140220
//Θεόδωρος Ζερβούλιας – 3170050 


import minipython.analysis.DepthFirstAdapter;
import minipython.node.*;
import java.util.Hashtable;

//1)not initialised variable 1
//2)use of variable of a different type 4
//3)none type variables 5
public class Visitor1 extends DepthFirstAdapter {
    Hashtable symtable;
    int error_counter = 0;
    String typeL, typeR, idtype, name;
    boolean checkRight;

    public Visitor1(Hashtable symtable){

        this.symtable = symtable;
    }

    @Override
    public void inAAsnmStatement(AAsnmStatement node) {
        int temp = error_counter;
        name = node.getIdentifier().toString().trim();
        if(symtable.containsKey(name)){
            symtable.replace(name,((AValExpression)node.getExpression()).getValue().getClass().toString().trim());
        }
        if(node.getExpression() instanceof AValExpression) {
            symtable.put(name, ((AValExpression)node.getExpression()).getValue().getClass().toString().trim());
        }
        if(node.getExpression() instanceof APlusExpression){
         
            if(temp == error_counter){
                symtable.put(name,node.getExpression().getClass().toString().trim());
            }
        }
        if(node.getExpression() instanceof AMinusExpression){
            symtable.put(name,node.getExpression().getClass().toString().trim());
        }
        if(node.getExpression() instanceof AMultExpression){
            symtable.put(name,node.getExpression().getClass().toString().trim());
        }
        if(node.getExpression() instanceof ADivExpression){
            symtable.put(name,node.getExpression().getClass().toString().trim());
        }
        if(node.getExpression() instanceof AModExpression){
            symtable.put(name,node.getExpression().getClass().toString().trim());
        }
        if(node.getExpression() instanceof APowerExpression){
            symtable.put(name,node.getExpression().getClass().toString().trim());
        }

    }

    @Override
    public void inAPlusExpression(APlusExpression node){
        boolean strL = false;
        checkRight = true;
        typeL = Declared((AVarExpression) node.getL());
        name = node.getL().toString().trim();
        if(typeL.equals("undeclared")){
            System.out.println("Token: " + name + " is undeclared.");
            checkRight = false;
            ++error_counter;
        }else{
            if(typeL.equals("AStr1Value")|| typeL.equals("AStr2Value")){
                strL = true;
            }
            if(typeL.equals("ANoneValue")){
                System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                ++error_counter;
                checkRight = false;
            }
        }
        if(checkRight){//if left variable is ok check right
            typeR = Declared((AVarExpression) node.getR());
            name = node.getR().toString().trim();
            if(typeR.equals("undeclared")){
                System.out.println("Token: " + name + " is undeclared.");
                ++error_counter;
            }else{
                if((!typeR.equals("AStr1Value") && !typeR.equals("AStr2Value")) && strL){//strL = false if typeL not string
                    System.out.println("You can not perform arithmetic operations with strings");
                            ++error_counter;
                }
                if((typeR.equals("AStr1Value")||typeR.equals("AStr2Value"))&&!strL){
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if(typeR.equals("ANoneValue")){
                    System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                    ++error_counter;
                }

                if(!(typeL.equals(typeR))){
                    System.out.println("You can not perform arithmetic operations with " + typeL + " and " + typeR + " types.");
                    ++error_counter;

                }

            }

        }


    }//inAPlusExpression

    @Override
    public void inAMinusExpression(AMinusExpression node){
        boolean strL = false;
        checkRight = true;

        typeL = Declared((AVarExpression) node.getL());
        name = node.getL().toString().trim();
        if(typeL.equals("undeclared")){
            System.out.println("Token: " + name + " is undeclared.");
            checkRight = false;
            ++error_counter;
        }else{
            if(typeL.equals("AStr1Value")|| typeL.equals("AStr2Value")){
                strL = true;
            }
            if(typeL.equals("ANoneValue")){
                System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                ++error_counter;
                checkRight = false;
            }
        }
        if(checkRight){//if left variable is ok check right
            typeR = Declared((AVarExpression) node.getR());
            name = node.getR().toString().trim();
            if(typeR.equals("undeclared")){
                System.out.println("Token: " + name + " is undeclared.");
                ++error_counter;
            }else{
                if((!typeR.equals("AStr1Value") && !typeR.equals("AStr2Value")) && strL){//strL = false if typeL not string
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if((typeR.equals("AStr1Value")||typeR.equals("AStr2Value"))&&!strL){
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if(typeR.equals("ANoneValue")){
                    System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                    ++error_counter;
                }

                if(!(typeL.equals(typeR))){
                        System.out.println("You can not perform arithmetic operations with " + typeL + " and " + typeR + " types.");
                        ++error_counter;
                    
                }

            }
        }
    }

    @Override
    public void inAMultExpression(AMultExpression node){
        boolean strL = false;
        checkRight = true;

        typeL = Declared((AVarExpression) node.getL());
        name = node.getL().toString().trim();
        if(typeL.equals("undeclared")){
            System.out.println("Token: " + name + " is undeclared.");
            checkRight = false;
            ++error_counter;
        }else{
            if(typeL.equals("AStr1Value")|| typeL.equals("AStr2Value")){
                strL = true;
            }
            if(typeL.equals("ANoneValue")){
                System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                ++error_counter;
                checkRight = false;
            }
        }
        if(checkRight){//if left variable is ok check right
            typeR = Declared((AVarExpression) node.getR());
            name = node.getR().toString().trim();
            if(typeR.equals("undeclared")){
                System.out.println("Token: " + name + " is undeclared.");
                ++error_counter;
            }else{
                if((!typeR.equals("AStr1Value") && !typeR.equals("AStr2Value")) && strL){//strL = false if typeL not string
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if((typeR.equals("AStr1Value")||typeR.equals("AStr2Value"))&&!strL){
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if(typeR.equals("ANoneValue")){
                    System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                    ++error_counter;
                }

                if(!(typeL.equals(typeR))){
                    if(!(typeL.equals("float")&&typeR.equals("int")||!(typeL.equals("int") && typeR.equals("float")))){
                        System.out.println("You can not perform arithmetic operations with " + typeL + " and " + typeR + " types.");
                        ++error_counter;
                    }
                }

            }
        }
    }

    @Override
    public void inADivExpression(ADivExpression node){
        boolean strL = false;
        checkRight = true;

        typeL = Declared((AVarExpression) node.getL());
        name = node.getL().toString().trim();
        if(typeL.equals("undeclared")){
            System.out.println("Token: " + name + " is undeclared.");
            checkRight = false;
            ++error_counter;
        }else{
            if(typeL.equals("AStr1Value")|| typeL.equals("AStr2Value")){
                strL = true;
            }
            if(typeL.equals("ANoneValue")){
                System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                ++error_counter;
                checkRight = false;
            }
        }
        if(checkRight){//if left variable is ok check right
            typeR = Declared((AVarExpression) node.getR());
            name = node.getR().toString().trim();
            if(typeR.equals("undeclared")){
                System.out.println("Token: " + name + " is undeclared.");
                ++error_counter;
            }else{
                if((!typeR.equals("AStr1Value") && !typeR.equals("AStr2Value")) && strL){//strL = false if typeL not string
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if((typeR.equals("AStr1Value")||typeR.equals("AStr2Value"))&&!strL){
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if(typeR.equals("ANoneValue")){
                    System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                    ++error_counter;
                }

                if(isZero((AVarExpression) node.getR())){
                    System.out.println("ZeroDivisionError: division by zero.");
                }

                if(!(typeL.equals(typeR))){
                        System.out.println("You can not perform arithmetic operations with " + typeL + " and " + typeR + " types.");
                        ++error_counter;
                    
                }

            }
        }
    }

    @Override
    public void inAModExpression(AModExpression node) {
        boolean strL = false;
        checkRight = true;

        typeL = Declared((AVarExpression) node.getL());
        name = node.getL().toString().trim();
        if(typeL.equals("undeclared")){
            System.out.println("Token: " + name + " is undeclared.");
            checkRight = false;
            ++error_counter;
        }else{
            if(typeL.equals("AStr1Value")|| typeL.equals("AStr2Value")){
                strL = true;
            }
            if(typeL.equals("ANoneValue")){
                System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                ++error_counter;
                checkRight = false;
            }
        }
        if(checkRight){//if left variable is ok check right
            typeR = Declared((AVarExpression) node.getR());
            name = node.getR().toString().trim();
            if(typeR.equals("undeclared")){
                System.out.println("Token: " + name + " is undeclared.");
                ++error_counter;
            }else{
                if((!typeR.equals("AStr1Value") && !typeR.equals("AStr2Value")) && strL){//strL = false if typeL not string
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if((typeR.equals("AStr1Value")||typeR.equals("AStr2Value"))&&!strL){
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if(typeR.equals("ANoneValue")){
                    System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                    ++error_counter;
                }

                if(isZero((AVarExpression) node.getR())){
                    System.out.println("ZeroDivisionError: division by zero.");
                }

                if(!(typeL.equals(typeR))){

                        System.out.println("You can not perform arithmetic operations with " + typeL + " and " + typeR + " types.");
                        ++error_counter;
                    

              }

            }
        }
    }

    @Override
    public void inAPowerExpression(APowerExpression node) {
        boolean strL = false;
        checkRight = true;

        typeL = Declared((AVarExpression) node.getL());
        name = node.getL().toString().trim();
        if (typeL.equals("undeclared")) {
            System.out.println("Token: " + name + " is undeclared.");
            checkRight = false;
            ++error_counter;
        } else {
            if(typeL.equals("AStr1Value")|| typeL.equals("AStr2Value")){
                strL = true;
            }
            if(typeL.equals("ANoneValue")){
                System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                ++error_counter;
                checkRight = false;
            }
        }
        if (checkRight) {//if left variable is ok check right
            typeR = Declared((AVarExpression) node.getR());
            name = node.getR().toString().trim();
            if (typeR.equals("undeclared")) {
                System.out.println("Token: " + name + " is undeclared.");
                ++error_counter;
            } else {
                if((!typeR.equals("AStr1Value") && !typeR.equals("AStr2Value")) && strL){//strL = false if typeL not string
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if((typeR.equals("AStr1Value")||typeR.equals("AStr2Value"))&&!strL){
                    System.out.println("You can not perform arithmetic operations with strings");
                    ++error_counter;
                }
                if(typeR.equals("ANoneValue")){
                    System.out.println("Token: " + name + " is a noneType token and can not be used in arithmetic operations.");
                    ++error_counter;
                }
            }
        }
    }

    @Override
    public void inAVarExpression(AVarExpression node) {
        idtype = Declared(node);
        name = node.getIdentifier().toString().trim();
        if(idtype.equals("undeclared")) {
            System.out.println("Token: " + name + " is undeclared.");
        }
    }
    private Boolean isZero (AVarExpression node) {
        String name = node.getIdentifier().toString().trim();
        if(symtable.containsKey(name)){
            if(((Number)symtable.get(name)).intValue()==0 || ((Number)symtable.get(name)).doubleValue()==0.0){
                return true;
            }
        }
        return false;
    }

    private String Declared(AVarExpression node){
        String name = node.getIdentifier().toString().trim();
        if(symtable.containsKey(name)){
            return symtable.get(name).toString();
        }
        return "undeclared";
    }



}
