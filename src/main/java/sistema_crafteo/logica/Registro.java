package sistema_crafteo.logica;

import sistema_crafteo.objeto.Item;

import java.time.LocalDateTime;
import java.util.Map;

public record Registro(Item item, Map<Item, Integer> ingredientes, String fechaHora) {
    public Registro {
        if (item == null) {
            throw new NullPointerException("Puntero a item nulo");
        }
        if(ingredientes == null) {
            throw new NullPointerException("Puntero a ingredientes nulo");
        }
    }
    public Registro(Item item, Map<Item, Integer> ingredientes){
        this(item, ingredientes, LocalDateTime.now().toString());
    }

    @Override
    public String toString(){
        return "[item=" + item.toString() + ", ingredientes=" + ingredientes.toString() + ", fecha=" + fechaHora + "]";
    }

}
