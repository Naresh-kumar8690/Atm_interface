

import java.util.Scanner;
class BankAccount{
    String name;
    String userName;
    String passward;
    String accountNo;
    float balance =10000f;
    int transactions = 0;
    String transactionHistory = "";
    public void register(){
        Scanner sc =new Scanner(System.in);
        System.out.println("\nEnter your name :");
        this.name = sc.nextLine();
        System.out.println("\n Enter Your username");
        this.userName = sc.nextLine();
        System.out.println("\nEnter your account number:");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration Sucessful. Please log in to your Bank Account ");
    }
    public boolean login(){
        boolean isLogin = false;
        Scanner sc =new Scanner(System.in);
        while(!isLogin){
            System.out.println("\nEnter your username:");
            String passwards= sc.nextLine();
            if(userName.equals(userName)){
                while(!isLogin){
                    System.out.println("\nEnter your passward:");
                    String passward = sc.nextLine();
                    if(passward.equals(passward)){
                
                System.out.println("\nlogain sucessful");
                isLogin = true;
                
            }
            else{
                System.out.println("\nIncorrect passward");

            }
        
        }
    }else{
            System.out.println("\nUsername not found");

        }
    }
    return isLogin;
}

    
    public void withdraw(){
        System.out.println("\nEnter amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(balance >= amount){
                transactions++;
                balance -= amount;
                System.out.println("\nWithdral Sucessful");
                String str = amount + "Rs Withdraw\n";
                transactionHistory =  transactionHistory.concat(str);
            }
            else{
                System.out.println("\nInsufficient Balance");
            }
        }catch(Exception e){

        }
    }
    public void deposit(){
        System.out.println("\nEnter Amount to Deposit:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(amount >= 10000f){
                transactions++;
                balance += amount;
                System.out.println("\nDeposit Sucessful");
                String str = amount + "Rs deposited\n";
                transactionHistory =  transactionHistory.concat(str);


            }else{
                System.out.println("\nSorry the limit is 10000. ");
            }
        }catch(Exception e){

        }

    }
    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Receipent's Name:");
        String receipent = sc.nextLine();
        System.out.println("\nEnter Amount to transfer :");
        float amount = sc. nextFloat();
        try{
            if(balance >= amount){
                if(amount <= 5000f){
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSucessfully transferred to" + receipent);
                    String str = amount + "Rs transferred to" + receipent+ "\n";
                    transactionHistory =  transactionHistory.concat(str);
    


                }else{
                    System.out.println("\nSorry . The limit is 5000");
                }
            }else{
                System.out.println("\nInsufficient Balance");
            
        }}catch(Exception e){

        }

    }
    public void checkBalance(){
        System.out.println("\n"+balance+"Rs");
    }
    public void transHistory(){
        if(transactions ==0){
            System.out.println("No transaction happened");
        }else{
            System.out.println("\n"+transactionHistory);
        }
    }


}
    

public class Atm_interface{
    public  static int takenIntegerInput(int limit){
        int input = 0;
        boolean flag = false;
        while(!flag){
            try{
                Scanner sc =new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if(flag &&  input>limit || input<1){
                    System.out.println("choose the number between 1 to "+limit);
                    flag =false;
                }
            }catch(Exception e){
                System.out.println("Enter only integer value");
                flag =false;

            }
        }
        return input;

    }
    public static void main(String[] args) {
        System.out.println("\n*************WELCOME TO GOVARDHAN ATM INTERFACE*****************");
        System.out.println("\n1.Register \n2.Exit");
        System.out.println("choose one option");
        int choose= takenIntegerInput(2);
        if(choose ==1){
            BankAccount b= new BankAccount();
            b.register();
            while(true){
                System.out.println("\n1.Login  \n2.Exit");
                System.out.println("Enter your choice :");
                int ch = takenIntegerInput(2);
                if(ch==1){
                    if(b.login()){
                        System.out.println("\n********WELCOME BACK"+ b.name+"*************");
                        boolean isFinished =false;
                        while(isFinished){
                            System.out.println("\n1.withdraw \n2.Deposit \n3.Transfer \n4.check balance \n5.Transaction History \n6.Exit");
                            System.out.println("Enter your choice:");
                            int c = takenIntegerInput(6);
                            switch(c){
                                case 1:
                                        b.withdraw();
                                        break;

                                case 2:
                                        b.deposit();
                                        break;
                                case 3:
                                        b.transfer();
                                        break;
                                case 4:
                                        b.checkBalance();
                                        break;
                                case 5:
                                        b.transHistory();
                                        break;
                                case 6:
                                        isFinished = true;
                                        break;
                            }


                        }



                    }


                }else{
                        System.exit(0);
                    }
            }
                    
                        
        }else{
                       System.exit(0);
            }                          

                    
                
            




    }
            
        
    

    
}