package sistema_crafteo.logica;

import java.util.HashMap;
import java.util.Map;

public class OperacionesMap {

    public static <T> void sumarValor(Map<T, Integer> destino, T key, Integer cantidadNueva) {
        int actual = destino.getOrDefault(key, 0);
        destino.put(key, actual + cantidadNueva);
    }

    public static <T> void restarValor(Map<T, Integer> destino, T key, Integer cantidadEliminada) {
        Integer actual = destino.get(key);
        if (actual == null) { // No existe la key
            throw new IllegalArgumentException("El item no existe");
        }

        if (actual < cantidadEliminada) {
            throw new IllegalArgumentException("Cantidad a eliminar mayor a la que se posee");
        }

        if (!destino.remove(key, cantidadEliminada)) { // actual == cantidadEliminada
            destino.put(key, actual - cantidadEliminada); // actual > cantidadEliminada
        }
    }

    public static <T> Map<T, Integer> sumarTodo(Map<T, Integer> destino, Map<T, Integer> origen) {
        for (Map.Entry<T, Integer> entrada : origen.entrySet()) {
            int actual = destino.getOrDefault(entrada.getKey(), 0);
            destino.put(entrada.getKey(), actual + entrada.getValue());
        }
        return destino;
    }

    public static <T> Map<T, Integer> restarTodo(Map<T, Integer> mayor, Map<T, Integer> menor) {
        if(mayor == null || menor == null) return new HashMap<>();

        Map<T, Integer> ret = new HashMap<>(mayor);

        ret.replaceAll((item, cantidad) -> {
            int m = menor.getOrDefault(item, 0);
            return Math.max(0, cantidad - m);
        });


        return ret;
    }

    public static <T> Map<T, Integer> quitarKeysConValorCero(Map<T, Integer> dic){
        if (dic == null) return new HashMap<>();

        Map<T, Integer> nuevoDic = new HashMap<>(dic);
        nuevoDic.values().removeIf(i -> i == 0);
        return nuevoDic;
    }

}