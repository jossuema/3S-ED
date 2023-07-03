package Autonomo3;

import java.util.ArrayList;

public class AlgortimosRecursivos {
	public static void main(String[] args) {
		//System.out.println(Suma(1, 5));
		//System.out.println(numeroPrimo(97));
		System.out.println(numerosPrimos(10, new ArrayList<>()));
	}
	
	public static int Suma(int numMenor, int numMayor) {
		if(numMenor>numMayor)
			return 0;
		
		return numMenor + Suma(numMenor + 1, numMayor);
	}
	
	public static boolean numeroPrimo(int numero) {
		
		return (numero>=2) && primoRecursivo(numero, 2) ;
	}
	
	public static boolean primoRecursivo(int numero, int divisor){
		if(numero == 2) 
			return true;
		
		if(divisor == numero) 
			return true;
		
		if(numero % divisor == 0) 
			return false;
		
		if(divisor * divisor > numero)
			return true;
		
		return primoRecursivo(numero, divisor+1);
	}
	
	public static ArrayList<Integer> numerosPrimos(int n, ArrayList<Integer> array){
        int num = 2;
        while (array.size() < n) {
            if (numeroPrimo(num)) {
                array.add(num);
            }
            num++;
        }
		
		return array;
	}
}
