import java.lang.Math;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;
import java.util.Set;

//Debe pasar 4 pruebas
// 1- Filas sin repetidos
// 2- Columnas sin repetidos
// 3- SubCubos sin repetidos
// 4- 17 elementos minimos

//prob de insertar -> 0.5

public class sodo{
    public static void main(String[] args) {

        System.out.println("Hola sodoku");
        
        int[][] mapa = new int[9][9];
        double rand = Math.random();
        Scanner scan = new Scanner(System.in);
        
        


        populate(mapa);
        System.out.println(" ");
        System.out.println(Arrays.deepToString(mapa)); 
        System.out.println(numOfElems(mapa));

        if(numOfElems(mapa) == true) {
            boolean tempRow = false;
            boolean tempCol = false; 
            for(int k = 0; k<9; k++) {
                tempCol = checkColumna(mapa, k);
                tempRow = checkFila(mapa, k);

                if(tempCol == false || tempRow == false) {
                    System.out.println("Error hay repetidos hay que repopular sodoku");

                }
                else {
                    System.out.println("Todo bien por ahora");
                }


            }

        }





        

        scan.close();


    }

    private static boolean numOfElems(int [][]mapa) {
        int min =17;
        int count = 0;
        for(int x = 0; x<9;x++) {
            for (int j = 0; j < mapa.length; j++) {
                if(mapa[x][j] != 0 ){
                    count++;
                }
            }
            //System.out.println(Arrays.toString(mapa));
        }

        if(count >= min) return true;
        else return false;


    }
    private static boolean checkColumna(int[][] mapx, int j) {

        boolean flag = false;
        int lenColumna = 0;
        Set<Integer> hashSet = new HashSet<Integer>();


        for (int i = 0;i<9 ;i++) {

            if(mapx[i][j] == 0 ) continue;
            
            else {
                System.out.print("En check columna|| valor:  ");
                System.out.println(mapx[i][j]);
                lenColumna++; 
                hashSet.add(mapx[i][j]);

            }
        }

        if(hashSet.size() == lenColumna){
            flag = true;
        }

        return flag;


    }

    private static void populate(int[][] mapx) {
        double rand;
        int sample;
        
        for(int x = 0; x<9;x++) {
            
            for (int j = 0; j < mapx.length; j++) {
                rand = Math.random();
                
                if(rand > 0.5){
                    sample = (int)(Math.random() * 9 + 1);
                    System.out.println(sample);
                    
                    if(mapx[x][j] == 0) mapx[x][j] = sample;
                    

                }

            }
            

        }
        
    }

    private static boolean checkFila(int [][]mapx,int i ) {

        boolean flag = false;
        int lenFila = 0;
        Set<Integer> hashSet = new HashSet<Integer>();


        for (int j = 0;j<9 ;j++) {

            if(mapx[i][j] == 0 ) continue;
            
            else {
                System.out.print("En check fila|| valor:  ");
                System.out.println(mapx[i][j]);
                lenFila++; 
                hashSet.add(mapx[i][j]);

            }
        }

        if(hashSet.size() == lenFila){
            flag = true;
        }

        return flag;
        

    }



}