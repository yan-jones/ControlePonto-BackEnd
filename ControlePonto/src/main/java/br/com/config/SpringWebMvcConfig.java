package br.com.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
@EnableWebMvc
@Import(value = { SpringDataConfig.class })
@ComponentScan("br.com")
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public JasperReportsViewResolver jasperViewResolver() {
		JasperReportsViewResolver resolver = new JasperReportsViewResolver();
		resolver.setPrefix("classpath:/relatorios/");
		resolver.setViewNames("Relatorio*");
		resolver.setSuffix(".jasper");
		resolver.setReportDataKey("JRCollection");
		resolver.setViewClass(JasperReportsMultiFormatView.class);
		resolver.setOrder(0);
		resolver.setAttributesMap(jasperParams());
		return resolver;
	}

	public Map<String, Object> jasperParams() {
		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("SUB_REPORT_DIR", "./relatorios/");
		try {
			map.put("REPORT_CONNECTION", dataSource.getConnection());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return map;
	}

}
