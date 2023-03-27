package com.john.graphite;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

//@Configuration
//public class AppConfig {
//
//    @Autowired
//    private ObjectProvider<Jackson2ObjectMapperBuilder> jacksonObjectMapperBuilder;
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        return jacksonObjectMapperBuilder.getObject().build();
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter halConverter() {
//        ObjectMapper objectMapper = objectMapper();
//        objectMapper.registerModule(new Jackson2HalModule());
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaTypes.HAL_JSON));
//        return converter;
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter jsonConverter() {
//        ObjectMapper objectMapper = objectMapper();
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//        return converter;
//    }
//
//    @Bean
//    public HttpMessageConverters messageConverters() {
//        return new HttpMessageConverters(halConverter(), jsonConverter());
//    }
//}


//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    private final ObjectProvider<Jackson2ObjectMapperBuilder> objectMapperBuilder;
//
//    public WebConfig(ObjectProvider<Jackson2ObjectMapperBuilder> objectMapperBuilder) {
//        this.objectMapperBuilder = objectMapperBuilder;
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//    	 // Configure HAL message converter
////        ObjectMapper halMapper = new ObjectMapper();
////        halMapper.registerModule(new Jackson2HalModule());
////        MappingJackson2HttpMessageConverter halConverter = new MappingJackson2HttpMessageConverter();
////        halConverter.setSupportedMediaTypes(Arrays.asList(
//////                MediaType.APPLICATION_JSON,
////                MediaTypes.HAL_JSON));
////        halConverter.setObjectMapper(halMapper);
////        converters.add(halConverter);
//
//        // Configure JSON message converter
//        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//        jsonConverter.setSupportedMediaTypes(Collections.singletonList(
//                MediaType.APPLICATION_JSON));
//        converters.add(jsonConverter);
//    }
//}

