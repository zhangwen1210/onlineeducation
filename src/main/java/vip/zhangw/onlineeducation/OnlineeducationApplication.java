package vip.zhangw.onlineeducation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan("vip.zhangw.onlineeducation.mapper")
public class OnlineeducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineeducationApplication.class, args);
	}

}
