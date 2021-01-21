import java.util.Scanner;

public class ruleta {

    public static void main(String[] args) {
        // Hacer una ruleta y obtener un estudio, el estudio será cuanto dinero ha ganado/perdido el casino en "x" días

        Scanner sc = new Scanner (System.in);

        //VARIABLES
        int dias; //número de días elegido
        int numeroRuleta; // la ruleta, números del 0 al 36
        int numMesas;
        int ClientesMesa[]=new int[5];//Número de clientes por mesa que habrá(cómo máximo 6 por medidas de covid)
        int clientesTotal=0;
        float dineroClientes[];
        int contadorDias=1;//Para ir sumandole uno cada vez que pase un día
        int tipoDeApuesta;
        int contadorFallos=0;
        int rondas=0;
        float dineroTotalClientes=0;

        try{
            //PREGUNTAMOS DE CUÁNTOS DÍAS SE QUIERE OBTENER EL ESTUDIO
            System.out.println("¿DE CUÁNTOS DÍAS DESEAS OBTENER EL ESTUDIO?");
            dias=sc.nextInt();
            System.out.println("EL ESTUDIO SERÁ DE ["+dias+"] DÍAS");
            System.out.println();

            //Creamos un bucle para que el programa se ejecute cada vez que pasé un día
            while(contadorDias<=dias) {
                //INDICAMOS QUE HA EMPEZADO EL DÍA
                System.out.println("-------------DÍA "+ contadorDias+"-------------");

                // PARA LAS MESAS Y LOS CLIENTES
                numMesas = (int) (Math.random() * 5 + 1);
                System.out.println("HOY, EN EL CASINO HAY [" + numMesas + "] MESAS");
                for (int i = 0; i < numMesas; i++) {
                    ClientesMesa[i] = (int) (Math.random() * 6 + 1);
                    System.out.println("->En la mesa " + (i + 1) + " hay " + ClientesMesa[i] + " clientes.");
                    clientesTotal=clientesTotal+ClientesMesa[i];
                }
                System.out.println();

                //VAMOS A ESTABLECER EL DINERO QUE VA A TENER CADA CLIENTE
                dineroClientes=new float[clientesTotal];
                for(int i=0;i<clientesTotal;i++){
                    dineroClientes[i]=(float) (Math.random()*50+51);
                    System.out.println("El cliente "+i+" tiene "+dineroClientes[i]);

                    dineroTotalClientes=dineroTotalClientes+dineroClientes[i];
                }

                //REALIZAMOS EL SISTEMA DE APUESTAS(color, pares, número, 1-18, docena,columna)
                while(rondas<=5&&dineroTotalClientes>0) {
                    System.out.println("RONDA NÚMERO "+rondas);

                    // LA RULETA SACA UN NÚMERO RANDOM DEL 1-36
                    numeroRuleta = (int) (Math.random() * 37);
                    System.out.println("LA RULETA HA SACADO [" + numeroRuleta + "]");

                    for (int i = 0; i < clientesTotal; i++) {
                        int numAleatorio = (int) (Math.random() * 100 + 1);//generamos un núemero aleatorio para poder jugar con las probabiidades
                        int apuestaCliente = (int) (Math.random()) * 80 + 21;//generamos un número aleatorio que será el porcentaje de dinero que apostará el cliente

                        if (numAleatorio >= 1 && numAleatorio <= 25) {//color
                            tipoDeApuesta = (int) (Math.random() * 2+1);
                            if(numeroRuleta==1&&numeroRuleta==3&&numeroRuleta==5&&numeroRuleta==7&&numeroRuleta==9&&numeroRuleta==12&&numeroRuleta==14&&numeroRuleta==16&&numeroRuleta==18&&numeroRuleta==19&&numeroRuleta==21&&numeroRuleta==25&&numeroRuleta==27&&numeroRuleta==30&&numeroRuleta==34&&numeroRuleta==36){
                                if(tipoDeApuesta==1){
                                    dineroClientes[i] = dineroClientes[i] + (((dineroClientes[i] * apuestaCliente) / 100) * 2);
                                }else{
                                    dineroClientes[i] = dineroClientes[i] - ((dineroClientes[i] * apuestaCliente) / 100);
                                }
                            }
                            else{
                                if(tipoDeApuesta==2){
                                    dineroClientes[i] = dineroClientes[i] + (((dineroClientes[i] * apuestaCliente) / 100) * 2);
                                }else{
                                    dineroClientes[i] = dineroClientes[i] - ((dineroClientes[i] * apuestaCliente) / 100);
                                }
                            }



                        } else if (numAleatorio > 25 && numAleatorio <= 50) {//pares
                            tipoDeApuesta = (int) (Math.random() * 2 + 1);//1 es par y 2 es impar
                            int nPar = (numeroRuleta % 2) + 1;
                            if (nPar == tipoDeApuesta) {
                                dineroClientes[i] = dineroClientes[i] + (((dineroClientes[i] * apuestaCliente) / 100) * 2);
                            } else {
                                dineroClientes[i] = dineroClientes[i] - ((dineroClientes[i] * apuestaCliente) / 100);
                            }

                        } else if (numAleatorio > 50 && numAleatorio <= 65) {//docena
                            tipoDeApuesta = (int) (Math.random() * 3 + 1);
                            int nDocena = (numeroRuleta - 1) / 12 + 1;//Si dividimos el número de la ruleta entre 12, nos dará un número entre el cero 0 o el 2, y sumandole uno sabremos la columna en la que se encuentra

                            if (nDocena == tipoDeApuesta) {
                                dineroClientes[i] = dineroClientes[i] + (((dineroClientes[i] * apuestaCliente) / 100) * 3);
                            } else {
                                dineroClientes[i] = dineroClientes[i] - ((dineroClientes[i] * apuestaCliente) / 100);
                            }

                        } else if (numAleatorio > 65 && numAleatorio <= 75) {//columna
                            tipoDeApuesta = (int) (Math.random() * 3 + 1);
                            int nColumna = (numeroRuleta - 1) % 3 + 1;//Si obtenemos el resto del número de la ruleta dividido entre el número de filas, y sumandole uno sabremos la fila en la que se encuentra

                            if (nColumna == tipoDeApuesta) {
                                dineroClientes[i] = dineroClientes[i] + (((dineroClientes[i] * apuestaCliente) / 100) * 3);
                            } else {
                                dineroClientes[i] = dineroClientes[i] - ((dineroClientes[i] * apuestaCliente) / 100);
                            }

                        } else if (numAleatorio > 75 && numAleatorio < 95) {//1-18
                            tipoDeApuesta = (int) (Math.random() * 2 + 1);
                            int nMitad = (numeroRuleta - 1) / 18 + 1;//Mismo procedimiento que en el de las docenas

                            if (nMitad == tipoDeApuesta) {
                                dineroClientes[i] = dineroClientes[i] + (((dineroClientes[i] * apuestaCliente) / 100) * 2);
                            } else {
                                dineroClientes[i] = dineroClientes[i] - ((dineroClientes[i] * apuestaCliente) / 100);
                            }

                        } else {//número
                            tipoDeApuesta = (int) (Math.random() * 37);
                            if (numeroRuleta == tipoDeApuesta) {
                                dineroClientes[i] = dineroClientes[i] + (((dineroClientes[i] * apuestaCliente) / 100) * 36);
                            } else {
                                dineroClientes[i] = dineroClientes[i] - ((dineroClientes[i] * apuestaCliente) / 100);
                            }
                        }
                       dineroTotalClientes=dineroTotalClientes+dineroClientes[i];
                    }
                    rondas++;
                }

                //INDICAMOS QUE EL DÍA HA ACABADO
                System.out.println("----------FIN DEL DÍA----------");
                System.out.println();
                clientesTotal=0;//Para que al siguiente día no se le sumen los clientes anteriores
                contadorDias++;//al terminar el día se le suma uno al contador

            }

        } catch(Exception e){
            System.out.println("ERROR");
        } finally {
            System.out.println("FIN DEL PROGRAMA");
        }
    }
}
