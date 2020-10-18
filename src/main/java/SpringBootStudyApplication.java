import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = {"com.springboot"},exclude={
        org.activiti.spring.boot.SecurityAutoConfiguration.class
})
@MapperScan(value = "com.springboot.study")
/**
 * 测试提交
 */
public class SpringBootStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyApplication.class,args);
        System.out.println();
    }
}
