package e1;

public class StringUtilities {

    public static boolean isStringNull (String cadenaDeCaracteres){
        boolean esNulo;


        if (cadenaDeCaracteres == null){
            esNulo = Boolean.TRUE;
        }
        else{
            esNulo = Boolean.FALSE;
        }
        return esNulo;
    }

    public static boolean isStringEmpty (String cadenaDeCaracteres){
        boolean estaVacio;


        if (cadenaDeCaracteres.isEmpty() == Boolean.TRUE){
            estaVacio = Boolean.TRUE;
        }
        else {
            estaVacio = Boolean.FALSE;
        }
        return estaVacio;
    }

    public static boolean isValidString (String cadenaDeCaracteres,
                                         String caracteresValidos, int tamanoMinimo){
        boolean esVerdadero = Boolean.TRUE;


        if(isStringNull(cadenaDeCaracteres) || isStringEmpty(cadenaDeCaracteres)){
            esVerdadero = Boolean.FALSE;
        } else if(cadenaDeCaracteres.length() < tamanoMinimo){
            esVerdadero = Boolean.FALSE;
        } else{
            for(char caracter : cadenaDeCaracteres.toCharArray()){
                if(!Character.isDigit(caracter) && !caracteresValidos.contains(String.valueOf(caracter))){
                    esVerdadero = Boolean.FALSE;
                    break;
                }
            }
        }
        return esVerdadero;
    }

    public static String lowercaseFirst (String cadenaDeCaracteres){
        StringBuilder cadenaModificable = new StringBuilder(); //StringBuilder es la versión modificable del tipo de dato String.
        int posicionMinusculas = 0;


        if(!isStringNull(cadenaDeCaracteres)){
            for (char caracter : cadenaDeCaracteres.toCharArray()){
                if (Character.isLowerCase(caracter)){
                    cadenaModificable.insert(posicionMinusculas, caracter);
                    posicionMinusculas++;
                } else {
                    cadenaModificable.append(caracter);
                }
            }
        }
        return cadenaModificable.toString();
    }

    public static boolean checkTextStats (String cadenaDeCaracteres, int tamanoMedioMinimo,
                                          int tamanoMedioMaximo) throws IllegalArgumentException{
        boolean esVerdadero = Boolean.TRUE;
        String[] separador;
        float tamanoPalabras = 0, tamanoPalabraMaximo = 0, tamanoMedio, numeroPalabras = 0, temp;


        if(isStringNull(cadenaDeCaracteres) || isStringEmpty(cadenaDeCaracteres) ||
                tamanoMedioMinimo <= 0 || tamanoMedioMaximo <= 0){
            throw new IllegalArgumentException();
        } else{
            separador = cadenaDeCaracteres.split( " ");
            for (String palabrasSeparadas : separador){
                if (palabrasSeparadas.length() > tamanoPalabraMaximo) {
                    tamanoPalabraMaximo = (float)palabrasSeparadas.length();
                }
                tamanoPalabras += (float)palabrasSeparadas.length();
                numeroPalabras ++;
            }
            if(numeroPalabras == 0){
                tamanoMedio = tamanoPalabras;
            } else if( tamanoPalabras % numeroPalabras == 0){
            tamanoMedio = tamanoPalabras / numeroPalabras;
            } else{
                for(temp = 0; (tamanoPalabras + temp) % numeroPalabras == 0; temp ++);
                tamanoMedio = (tamanoPalabras + temp) / numeroPalabras;
            }
            if(tamanoMedio < tamanoMedioMinimo || tamanoMedio > tamanoMedioMaximo ||
                    tamanoPalabraMaximo > (2 * tamanoMedioMaximo)){
                esVerdadero = Boolean.FALSE;
            }
        }
        return esVerdadero;
    }
}
