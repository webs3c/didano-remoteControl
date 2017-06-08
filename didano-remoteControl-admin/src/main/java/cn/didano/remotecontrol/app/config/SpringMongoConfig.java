package cn.didano.remotecontrol.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * 跨域支持
 * 
 * @author wangyi
 * @TODO 需要缩小范围，并且需要增加鉴权
 */
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.database}")
	private String mongoDB;

	@Value("${spring.data.mongodb.uri}")
	private String uri;

	@Override
	public MongoMappingContext mongoMappingContext() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.mongoMappingContext();
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(new MongoClientURI(uri));
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return mongoDB;
	}

	/*protected String getMappingBasePackage() {
		return "cn.didano.remotecontrol.base";
	}

	@Bean
	@ConditionalOnMissingBean(MongoConverter.class)
	public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory, MongoMappingContext context,
			BeanFactory beanFactory) {
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
		MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
		try {
			mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
		} catch (NoSuchBeanDefinitionException ex) {
			// Ignore
		}
		return mappingConverter;
	}*/

}