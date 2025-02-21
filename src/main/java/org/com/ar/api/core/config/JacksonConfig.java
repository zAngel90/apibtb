package org.com.ar.api.core.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // Exclude null and empty values globally
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        // Add a custom module to handle trimming for all String fields
        SimpleModule stringTrimModule = new SimpleModule();
        stringTrimModule.addSerializer(String.class, new StdSerializer<String>(String.class) {
            @Override
            public void serialize(String value, JsonGenerator gen, com.fasterxml.jackson.databind.SerializerProvider provider) throws IOException {
                if (value != null) {
                    gen.writeString(value.trim()); // Trim the string
                }
            }
        });

        mapper.registerModule(stringTrimModule);
        return mapper;
    }
}
