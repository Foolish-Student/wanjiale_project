package com.framework.common.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * WebMvc配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String os = System.getProperty("os.name");
		if(os.toLowerCase().contains("window")){
			//若当前系统是window系统  注意已定义要带file: 且后面与路径之间不能用空格
			registry.addResourceHandler("/image/**").addResourceLocations("file:D:\\picpath\\");
			// registry.addResourceHandler("/image/**").addResourceLocations("file:D:/picpath/"); 这个也可以
		}else {
			registry.addResourceHandler("/image/**").addResourceLocations("file:user/upload/image/");
		}

//若当前系统是window系统
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();

		// 生成json时，将所有Long转换成String
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		objectMapper.registerModule(simpleModule);

		// 时间格式化
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

		jackson2HttpMessageConverter.setObjectMapper(objectMapper);
		converters.add(0, jackson2HttpMessageConverter);
	}

}
