package com.cice.ejercicios.ejercicio1;

public class Main {

    final static char[] LETRAS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
    final static char[] OTROS_CARACTERES = {' ','1','2','3','4','5','6','7','8','9','0','.',',',';','¿','?','¡','!','-','"','\''};
    final static char[] VOCALES_TILDADAS = {'á','é','í','ó','ú'};

    public static void main(String[] args) {
        System.out.println(cesar("zASA 1 zapato",15));
        System.out.println(cesar("ñ",250));
        String cosa = "ÁÉÍÓÚ";
        System.out.println(cesar(cosa,10));
        System.out.println(cesar("Esta es una cadena con tildes, ¡qué dislate!",15));
        System.out.println(retroCesar("ñoho 1 ñoeoid",15));
        System.out.println(retroCesar("kñryé",10));
    }

    public static String cesar(String s,int n) {
        s = s.toLowerCase();
        StringBuilder salida = new StringBuilder();
        char letra;
        int indice;
        for (int i=0; i<s.length(); i++) {
            letra = s.charAt(i);
            if(esVocalConTilde(letra)) {
                indice = (comprobarIndiceVocalTildada(letra)+n) % LETRAS.length;
                salida.append(indiceConTildes(indice));
            } else if(!esOtroCaracter(letra)) {
                indice = (comprobarIndice(letra)+n) % LETRAS.length;
                salida.append(LETRAS[indice]);
            } else
                salida.append(letra);
        }
        return salida.toString();
    }

    public static String retroCesar(String s, int n) {
        s = s.toLowerCase();
        StringBuilder salida = new StringBuilder();
        char letra;
        int indice;
        for (int i=0; i<s.length(); i++) {
            letra = s.charAt(i);
            if(esVocalConTilde(letra)) {
                indice = ((comprobarIndiceVocalTildada(letra)-n)+LETRAS.length) % LETRAS.length;
                salida.append(indiceConTildes(indice));
            } else if(!esOtroCaracter(letra)) {
                indice = ((comprobarIndice(letra)-n)+LETRAS.length) % LETRAS.length;
                salida.append(LETRAS[indice]);
            } else
                salida.append(letra);
        }
        return salida.toString();
    }

    public static char indiceConTildes(int n) {
        char salida;
        switch (n) {
            case 0:
                salida = 'á';
                break;
            case 4:
                salida = 'é';
                break;
            case 8:
                salida = 'í';
                break;
            case 15:
                salida = 'ó';
                break;
            case 21:
                salida = 'ú';
                break;
            default:
                salida = LETRAS[n];
                break;
        }
        return salida;
    }

    public static int comprobarIndiceVocalTildada(char l) {
        int salida = 0;
        switch(l) {
            case 'á':
                salida = 0;
                break;
            case 'é':
                salida = 4;
                break;
            case 'í':
                salida = 8;
                break;
            case 'ó':
                salida = 15;
                break;
            case 'ú':
                salida = 21;
                break;
            default:
                break;
        }
        return salida;
    }

    public static boolean esVocalConTilde(char l) {
        for (int i=0;i<VOCALES_TILDADAS.length;i++) {
            if(l==VOCALES_TILDADAS[i])
                return true;
        }
        return false;
    }

    public static boolean esOtroCaracter(char l) {
        for (int i=0;i<OTROS_CARACTERES.length;i++) {
            if(l==OTROS_CARACTERES[i])
                return true;
        }
        return false;
    }

    public static int comprobarIndice(char l) {
        for (int i=0;i<LETRAS.length;i++) {
            if(l==LETRAS[i]) {
                return i;
            }
        }
        return 0;
    }


}
