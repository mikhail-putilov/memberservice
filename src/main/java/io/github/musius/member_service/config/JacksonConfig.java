package io.github.musius.member_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;

@Configuration
public class JacksonConfig {

    @Bean
    public ProblemModule problemModule() {
        return new ProblemModule();
    }
}
