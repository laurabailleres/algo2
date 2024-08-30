//POR AHORA EXACTAS FUNCIONA, PERO LOS PROBLEMAS SIGUEN!
//GRILLA SALARIAL DOCENTE: https://aduba.org.ar/wp-content/uploads/2024/07/Instructivo-Liquidacion-Salarios-JULIO-2024.pdf




package aed;
import java.lang.Math;

class Funciones {
    int cuadrado(int x) {
        return (x*x);
    }

    double distancia(double x, double y) {
        return Math.sqrt((x*x) + (y*y));
    }

    boolean esPar(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }   

    boolean esBisiesto(int n) {
        if ((n % 400 == 0) || ((n % 4 == 0) && (n % 100 != 0))) {
            return true;
        } else {
            return false;
        }     
    }

    int factorialIterativo(int n) {   
        int res = 1;
        while (n != 0) {
            res = res * n;
            n = n - 1;
        } return res;
    }

    int factorialRecursivo(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (factorialIterativo(n-1) * n);
        }
    }

    boolean esPrimo(int n) {
        int d = n - 1;
        boolean res = true;
        if ((n == 0) || (n == 1)){
            res = false;
        }
        
        while (d > 1) {
            if (n % d == 0) {
                res = false;
            }
            d = d - 1;
        }
        return res;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int n:numeros) {
            res = res + n;
        } 
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for (int n:numeros) {
            if (esPrimo(n)) {
                res = true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for (int n:numeros) {
            if (n%2 != 0) {
                res = false;
            }
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = true;
        if (s1.length() > s2.length()) {
            res = false;
        } else {
            for(int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i)!=s2.charAt(i)){
                    res = false;
                }
            }
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = true;
        if (s1.length() > s2.length()) {
            res = false;
        } else {
            for(int i = 0; i < s1.length(); i++) {
                if (s1.charAt(s1.length()-1-i)!=s2.charAt(s2.length()-1-i)){
                    res = false;
                }
            }
        } return res;
    }
}
