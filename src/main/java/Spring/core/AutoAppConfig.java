package Spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // member 패키지부터 ~ 하위패키지 쯕
        //basePackages = "Spring.core.member",
        //basePackageClasses = AutoAppConfig.class,
        //default는  Spring.core
        //제외 하는 방법
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
    public class AutoAppConfig {

    }
