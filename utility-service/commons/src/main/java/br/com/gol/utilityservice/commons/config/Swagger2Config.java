package br.com.gol.utilityservice.commons.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

//@Configuration
//@EnableSwagger2
public abstract class Swagger2Config {

	@Value("${api.title}")
	private String title;
	@Value("${api.description}")
	private String description;
	@Value("${api.version}")
	private String version;
	@Value("${api.tag.name}")
	private String tagName;
	@Value("${api.tag.description}")
	private String tagDescription;

	// abstract protected Tag getTag();

	// abstract protected String getTitle();

	// abstract protected String getDescription();

	// abstract protected String getVersion();

	@Bean
	public Docket productApi() {
		// @formatter:off
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                    .paths(PathSelectors.any())
                    .build()
                .tags(new Tag(tagName, tagDescription))
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .genericModelSubstitutes(ResponseEntity.class)
                .pathMapping("/")
                .enableUrlTemplating(true);
        // @formatter:on
	}

/*
	@Bean
	public WebMvcConfigurerAdapter adapter() {

		return new WebMvcConfigurerAdapter() {

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("swagger-ui.html")
						.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
				registry.addResourceHandler("/webjars/**")
						.addResourceLocations("classpath:/META-INF/resources/webjars/");
				super.addResourceHandlers(registry);
			}

			@Override
			public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
				configurer.enable();
			}

		};

	}
*/

	@Bean
	public UiConfiguration uiConfig() {
		// @formatter:off
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(0)
                .defaultModelExpandDepth(0)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(true)
                .docExpansion(DocExpansion.LIST)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(true)
                .tagsSorter(TagsSorter.ALPHA)
                .validatorUrl(null)
                .build();
        // @formatter:on
	}

	private ApiInfo apiInfo() {
		// @formatter:off
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(null)
                .contact(new Contact(null, null, null))
                .license(null)
                .licenseUrl(null)
                .version(version)
                .build();
        // @formatter:on
	}

}
