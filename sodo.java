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
// Arreglar fix con subcubos;

//prob de insertar -> 0.5

public class sodo{
    public static void main(String[] args) {

        System.out.println("Hola sodoku");
        
        int[][] mapa = new int[9][9];
        double rand = Math.random();
        Scanner scan = new Scanner(System.in);
        
        


        //populate(mapa);
        System.out.println(" ");
        System.out.println(Arrays.deepToString(mapa)); 
        System.out.println(numOfElems(mapa));
        int aux = 0;
        while(checkConstruccion(mapa) != true) {
            populate(mapa);
            System.out.printf("Comienza ronda %d:", aux);
            fix(mapa);
            aux++;
            System.out.println("Sodoku Actual: ");
        
        System.out.println(Arrays.deepToString(mapa));

        }




        System.out.println(" ");
        System.out.println("Sodoku Actual: ");
        
        System.out.println(Arrays.deepToString(mapa)); 


        System.out.println("Sodoku Actual por filas: ");
        for (int i = 0; i < mapa.length; i++) {
            System.out.println(Arrays.toString(mapa[i])); 
            
        }
        System.out.println(numOfElems(mapa));
        

        scan.close();


    }

    private static int numOfElems(int [][]mapa) {
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

        if(count >= min) return count;
        else return count;


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
                if(hashSet.add(mapx[i][j]) == true){
                  continue;
                }
                else{
                    mapx[i][j] = 0;
                }

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
                    
                    if(mapx[x][j] == 0){ 
                        sample = (int)(Math.random() * 9 + 1);
                        mapx[x][j] = sample;
                    }
                        
                    

                }

            }
            

        }
        
    }
    private static boolean checkSubCubo(int[][] mapa,int fila, int col ){
        boolean act =false;
        Set<Integer> set = new HashSet<Integer>();
        

        if(fila < 3 && col < 3){

            for (int i = 0; i < 3; i++) {

               for (int j = 0; j < 3; j++) {
                
                if(mapa[i][j] == 0){continue;}

                if (set.add(mapa[i][j]) == true) {  
                    act = true;  
                    continue;
                }
                else{
                    mapa[i][j] = 0;
                    act = false;
                    return act;
                }
                   
               }
               System.out.println(set.toString());
                
            }
            set.clear();
        }

        else if(fila < 3 && col < 6){

            for (int i = 0; i < 3; i++) {

               for (int j = 3; j < 6; j++) {
                
                if(mapa[i][j] == 0){continue;}

                if (set.add(mapa[i][j]) == true) {  
                    act = true;  
                    continue;
                }
                else{
                    mapa[i][j] = 0;
                    act = false;
                    return act;
                }
                   
               }
               System.out.println(set.toString());
                
            }
            set.clear();
        }

        else if(fila < 3 && col < 9){

            for (int i = 0; i < 3; i++) {

               for (int j = 6; j < 9; j++) {
                if(mapa[i][j] == 0){continue;}

                if (set.add(mapa[i][j]) == true) {  
                    act = true;  
                    continue;
                }
                else{
                    mapa[i][j] = 0;
                    act = false;
                    return act;
                }
                   
               }
               System.out.println(set.toString());
                
            }
            set.clear();
        }

        else if(fila < 6 && col < 3){

            for (int i = 3; i < 6; i++) {

               for (int j = 0; j < 3; j++) {

                if(mapa[i][j] == 0){continue;}

                if (set.add(mapa[i][j]) == true) {  
                    act = true;  
                    continue;
                }
                else{
                    mapa[i][j] = 0;
                    act = false;
                    return act;
                }
                   
               }
               System.out.println(set.toString());
                
            }
            set.clear();
        }

        else if(fila < 6 && col < 6){

            for (int i = 3; i < 6; i++) {

               for (int j = 3; j < 6; j++) {

                if(mapa[i][j] == 0){continue;}

                if (set.add(mapa[i][j]) == true) {  
                    act = true;  
                    continue;
                }
                else{
                    mapa[i][j] = 0;
                    act = false;
                    return act;
                }
                   
               }
               System.out.println(set.toString());
                
            }
            set.clear();
        }

        else if(fila < 6 && col < 9){

            for (int i = 3; i < 6; i++) {

               for (int j = 6; j < 9; j++) {

                if(mapa[i][j] == 0){continue;}

                if (set.add(mapa[i][j]) == true) {  
                    act = true;  
                    continue;
                }
                else{
                    mapa[i][j] = 0;
                    act = false;
                    return act;
                }
                   
               }
               System.out.println(set.toString());
                
            }
            set.clear();
        }
        else if(fila < 9 && col < 3){

            for (int i = 6; i < 9; i++) {

               for (int j = 0; j < 3; j++) {

                if(mapa[i][j] == 0){continue;}

                if (set.add(mapa[i][j]) == true) {  
                    act = true;  
                    continue;
                }
                else{
                    mapa[i][j] = 0;
                    act = false;
                    return act;
                }
                   
               }
                
            }
            set.clear();
        }
        else if(fila < 9 && col < 6){

            for (int i = 6; i < 9; i++) {

               for (int j = 3; j < 6; j++) {

                if(mapa[i][j] == 0){continue;}

                if (set.add(mapa[i][j]) == true) {  
                    act = true;  
                    continue;
                }
                else{
                    mapa[i][j] = 0;
                    act = false;
                    return act;
                }
                   
               }
                
            }
            set.clear();
        }
        else if(fila < 9 && col < 9){

            for (int i = 6; i < 9; i++) {

               for (int j = 6; j < 9; j++) {

                if(mapa[i][j] == 0){continue;}

                if (set.add(mapa[i][j]) == true) {  
                    act = true;  
                    continue;
                }
                else{
                    mapa[i][j] = 0;
                    act = false;
                    return act;
                }
                   
               }
                
            }
            set.clear();
        }

        

        return act;
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
                 if(hashSet.add(mapx[i][j]) == true){
                     continue;

                 }
                 else{
                     mapx[i][j] = 0;
                 }


            }
        }

        if(hashSet.size() == lenFila){
            flag = true;
        }

        return flag;
        

    }


    private static boolean checkConstruccion(int[][] mapa) {
        //Debe llamar a checkColumna, ''fila, y subCubo;
            
            boolean tempRow = false;
            boolean tempCol = false; 
            boolean PassSubCubo = false;
            boolean passFilCol =false;
            
            if(numOfElems(mapa) >= 17 ) {
                for(int k = 0; k<9; k++) {
                    tempCol = checkColumna(mapa, k);
                    tempRow = checkFila(mapa, k);
                    
                    
                    if(tempCol == false || tempRow == false) {
                        System.out.println("Error hay repetidos hay que repopular sodoku");
                        return false;

                    }
                    else {
                        System.out.println("Todo bien por ahora");

                        if(k == 8){
                            System.out.println("Logre pasar pruebas fil y col");
                            passFilCol = true;
                        }
                    }


                }
            }
            else{
                System.out.println("No cumple numero de elemntos minimos");
                return false;
            }

            if(passFilCol == true) {
                
                for (int fil = 0; fil < 9; fil++) {
                    PassSubCubo = checkSubCubo(mapa, fil, fil);

                    if(PassSubCubo == true){
                        fil = fil+2;
                    }
                    else{
                        System.out.printf("Error en subcubo fila %d, col %d ",fil,fil );
                        return false;
                    }
                    
                }

                return true;
                
            }

            

        
        

        return false;
    }

    private static void fix(int [][]mapa) {
        boolean tempCol;
        boolean tempRow;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < mapa.length; i++) {
            tempCol = checkColumna(mapa, i);
            tempRow = checkFila(mapa, i);

            if(tempCol == false && tempRow == false) {
                for (int j = 0; j < mapa.length; j++) {
                    if(set.add(mapa[j][i]) == false){
                        mapa[j][i] = 0;
                    }    
                }
                 set.clear();
                 for (int z = 0; z < mapa.length; z++) {
                    if(set.add(mapa[i][z]) == false){
                        mapa[i][z] = 0;
                    }
                     
                 }
                 set.clear();

            }
            else if(tempCol == false && tempRow == true) {
                for (int j = 0; j < mapa.length; j++) {
                    if(set.add(mapa[j][i]) == false){
                        mapa[j][i] = 0;
                    }    
                }
                 set.clear();
            }
            else if(tempCol == true && tempRow == false) {
                for (int z = 0; z < mapa.length; z++) {
                    if(set.add(mapa[i][z]) == false){
                        mapa[i][z] = 0;
                    }
                     
                 }
                 set.clear();
            }
            
            


            
        }
    }
}