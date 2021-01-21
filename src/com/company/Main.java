package com.company;

public class Main {

    public static void main(String[] args) {
	//
        int numMesas=(int)(Math.random() * (1-5)+5);
        int numClientes=(int)(Math.random() * (1-6)+6);
        int Clientes[]=new int[5];
        int tipoDeApuesta;
        int numeroRuleta;

        numeroRuleta=(int)(Math.random()*37);
        tipoDeApuesta=(int)(Math.random()*4+1);

        switch (tipoDeApuesta){
            case 1:
                for(int x=1;x<=34;x+=3){
                    if(x==numeroRuleta){

                    }
                }
                break;
            case 2:
                for(int x=2;x<=35;x+=3){
                    if(x==numeroRuleta){

                    }
                }
                break;
            case 3:
                for(int x=3;x<=36;x+=3){
                    if(x==numeroRuleta){

                    }
                }
                break;
        }


    }
}
