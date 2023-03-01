package zack.san.PetApi.Serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import zack.san.PetApi.animal.Animal;

import java.io.IOException;
import java.util.List;

public class AnimalIdSerializer extends JsonSerializer<List<Animal>> {




    @Override
    public void serialize(List<Animal> animals, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        for (Animal animal : animals) {
            gen.writeNumber(animal.getAnimalId());
        }
        gen.writeEndArray();
    }
}
