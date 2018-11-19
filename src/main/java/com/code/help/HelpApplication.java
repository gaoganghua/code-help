package com.code.help;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class HelpApplication {
    /**
     * 引入自定义的yml文件
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        String[] path = {"generate/application-generate.yml", "tabletobean/application-datasource.yml"};
        ClassPathResource[] resources = new ClassPathResource[path.length];

        for(int i=0;i<path.length;i++){
            resources[i] = new ClassPathResource(path[i]);
        }

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(resources);
        configurer.setProperties(yaml.getObject());
        return configurer;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelpApplication.class, args);
    }
}
