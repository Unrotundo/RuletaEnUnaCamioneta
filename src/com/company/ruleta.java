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
        int numAleatorio;
        String tipoDeApuesta[];

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

                // LA RULETA SACA UN NÚMERO RANDOM DEL 1-36
                numeroRuleta = (int) (Math.random() * 37);
                System.out.println("LA RULETA HA SACADO [" + numeroRuleta + "]");

                //VAMOS A ESTABLECER EL DINERO QUE VA A TENER CADA CLIENTE
                dineroClientes=new float[clientesTotal];
                tipoDeApuesta=new String[clientesTotal];
                for(int i=0;i<clientesTotal;i++){
                    dineroClientes[i]=(float) (Math.random()*50+51);

                    //REALIZAMOS EL SISTEMA DE APUESTAS(color, pares, número, 1-18, docena,columna)
                    numAleatorio = (int) (Math.random() * 101 + 1);//generamos un núemero aleatorio para poder jugar con las probabiidades

                    /* **NOTA** Creo que se puede hacer metiendo directamente el dinero que ha perdido/ganado el jugador,
                    guardandolo en el array del dinero(ten en cuenta que cuando ganas al 50% se multiplica por 2 el dinero que tienes y cuando ganas a 1/3 ps
                    no se pongamos 1,5? O menos ns de eso te encargas tú ), después de eso quedaría meter toda la ruleta en un bucle que solo funciona si hay
                    menos de 10 jugadas o algún jugador se ha quedado sin un puto duro (POR LUDÓPATAS), y creo que ya estaría. Solo quedaría optimizarlo
                    y meterle paja.

                    Tengo muchas ganas de verte UWUWUWUWUWUWUWUWUWWU*/

                    if (numAleatorio >= 1 && numAleatorio <= 25) {//color
                        tipoDeApuesta[i]="color";
                    } else if (numAleatorio > 25 && numAleatorio <= 50) {//pares
                        tipoDeApuesta[i]="pares";
                    } else if (numAleatorio > 50 && numAleatorio <= 65) {//docena
                        tipoDeApuesta[i]="docena";
                    } else if (numAleatorio > 65 && numAleatorio <= 75) {//columna
                        tipoDeApuesta[i]="columna";
                    } else if (numAleatorio > 75 && numAleatorio < 95) {//1-18
                        tipoDeApuesta[i]="1-18";
                    } else {
                        tipoDeApuesta[i]="número";//número
                    }

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
