package io.github.musius.member_service.config;

import com.hazelcast.config.Config;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;
import io.github.musius.member_service.model.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

// Intellij IDEA doesn't recognize HazelcastAutoConfiguration. We need to explicitly mute it:
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
public class HazelcastConfig {
    @Bean
    public Config config() {
        return new Config();
    }

    @Bean
    public Map<Long, Member> membersBackingMap(HazelcastInstance hazelcastInstance) {
        return hazelcastInstance.getMap("membersBackingMap");
    }

    @Bean
    public IdGenerator membersIdGenerator(HazelcastInstance hazelcastInstance) {
        return hazelcastInstance.getIdGenerator("membersIdGenerator");
    }
}
