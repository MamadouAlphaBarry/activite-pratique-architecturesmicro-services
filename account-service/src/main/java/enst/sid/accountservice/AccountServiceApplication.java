package enst.sid.accountservice;

import enst.sid.accountservice.dtos.AccountRequestDto;
import enst.sid.accountservice.web.AccountRestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRestController controller){
		return args -> {
			for (int i = 1; i < 50; i++) {
				AccountRequestDto accountRequestDto= AccountRequestDto.builder()
						.balance(500+Math.random()*2001)
						.currency(Math.random()>0.5?"£":"$")
						.customerId((long) i)
						.build();
				controller.saveAccount(accountRequestDto);
				System.out.println(accountRequestDto.toString());
			}
		};
	}

}
