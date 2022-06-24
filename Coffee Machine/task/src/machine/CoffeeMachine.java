package machine;


import java.util.HashMap;

import java.util.Scanner;


/*
01100101 01111000 01100101 01100011 01110101 01110100 01100101 00100000
01101111 01110010 01100100 01100101 01110010 00100000 00110110 00110110
 */

public class CoffeeMachine {

    private static void fill(HashMap<String,Integer> machine,int water,int milk,int beans,int cups ) {

        machine.put("water",machine.get("water")+water);

        machine.put("milk",machine.get("milk")+milk);

        machine.put("beans",machine.get("beans")+beans);

        machine.put("cups",machine.get("cups")+cups);




    }

    private static  void printMachineStatus(HashMap<String,Integer> machine){
        System.out.println("The coffee machine has:\n" +
                machine.get("water")+" ml of water\n" +
                machine.get("milk") + " ml of milk\n" +
                machine.get("beans")+" g of coffee beans\n" +
                machine.get("cups")+" disposable cups\n" +
                machine.get("money")+" of money");

    }

    private static void buy(HashMap<String,Integer> machine,String option){
        //option 1 espresso option 2 latte option 3 cappuccino

        if(option.equals("1")){


            if(machine.get("water")>=250 && machine.get("beans")>=16){
                machine.put("water",machine.get("water")-250);
                machine.put("beans",machine.get("beans")-16);
                machine.put("money",machine.get("money")+4);
                machine.put("cups",machine.get("cups")-1);

            }

            else{

                System.out.println("error not enough");
            }

        }

        if(option.equals("2")){


            if(machine.get("water")>=350 && machine.get("milk")>=75&& machine.get("beans")>=20){
                machine.put("water",machine.get("water")-350);
                machine.put("beans",machine.get("beans")-20);
                machine.put("milk",machine.get("milk")-75);
                machine.put("money",machine.get("money")+7);
                machine.put("cups",machine.get("cups")-1);

            }

            else{

                System.out.println("error not enough");
            }


        }

        if(option.equals("3")){


            if(machine.get("water")>=200 && machine.get("milk")>=100 && machine.get("beans")>=12){
                machine.put("water",machine.get("water")-200);
                machine.put("beans",machine.get("beans")-12);
                machine.put("milk",machine.get("milk")-100);
                machine.put("cups",machine.get("cups")-1);
                machine.put("money",machine.get("money")+6);

            }

            else{

                System.out.println("error not enough for cappuccino");
            }


        }




    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        HashMap<String,Integer> machine = new HashMap<String,Integer>();

        //default values of machine
        machine.put("water",400);
        machine.put("milk",540);
        machine.put("beans",120);
        machine.put("cups",9);
        machine.put("money",550);


        System.out.println("Write action (buy,fill,take,remaining,exit):");


            String action = sc.nextLine();

            while (!action.equals("exit")) {





                if (action.equals("fill")) {
                    System.out.println("Write how many ml of water you want to add:");
                    int waterAdd = sc.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int milkAdd = sc.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int beansAdd = sc.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add: ");
                    int cupsAdd = sc.nextInt();


                    fill(machine, waterAdd, milkAdd, beansAdd, cupsAdd);


                }
                else if (action.equals("buy")) {


                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String option = sc.nextLine();

                    buy(machine, option);

                } else if (action.equals("take")) {


                    System.out.println("I gave you $" + machine.get("money") + "\n");
                    machine.put("money", 0);

                }
                else if(action.equals("remaining")){
                    printMachineStatus(machine);
                }

                System.out.println("Write action (buy,fill,take,remaining,exit):");
                action = sc.nextLine();
            }





    }
}
