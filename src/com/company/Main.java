package com.company;

public class Main {

    public static void main(String[] args) {
	//
        int numMesas=(int)(Math.random() * (1-5)+5);
        int numClientes=(int)(Math.random() * (1-6)+6);
        int Clientes[]=new int[5];

        System.out.println("mesas "+numMesas);
        for(int i=0;i<numMesas;i++){
            Clientes[i]=(int)(Math.random() * (1-6)+6);
            System.out.println("cliente x mesa"+Clientes[i]);
        }


    }
}
