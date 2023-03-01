package zack.san.PetApi.Serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import zack.san.PetApi.user.User;

import java.io.IOException;

public class UserIdUsernameSerializer extends JsonSerializer<User> {



    @Override
    public void serialize(User user, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("userId", user.getUserId());
        gen.writeEndObject();
    }
}


