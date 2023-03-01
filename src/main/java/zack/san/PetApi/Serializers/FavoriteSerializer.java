package zack.san.PetApi.Serializers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import zack.san.PetApi.animal.Animal;


import java.io.IOException;
public class FavoriteSerializer extends JsonSerializer<Animal> {
    @Override
    public void serialize(Animal animal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("animalId", animal.getAnimalId() );
        jsonGenerator.writeStringField("name", animal.getName());
        jsonGenerator.writeStringField("breedType", animal.getBreedType());
        jsonGenerator.writeStringField("specie", animal.getSpeciesName());
        jsonGenerator.writeNumberField("age", animal.getAge());
        jsonGenerator.writeEndObject();
    }
}
