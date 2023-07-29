package py.com.daas.adamspayintegration.configurations;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import feign.Logger;

@Configuration
public class FeignConfig {
    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'z'");

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(OffsetDateTime.class, new JsonSerializer<>() {
            @Override
            public void serialize(OffsetDateTime offsetDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                jsonGenerator.writeString(FORMATTER.format(offsetDateTime));
            }
        });
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(simpleModule);

        return objectMapper;
    }

}
