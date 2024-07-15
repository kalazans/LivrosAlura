package br.comAluraLivroSpringWeb.AluraLIvroSpring.Principal;

import br.comAluraLivroSpringWeb.AluraLIvroSpring.Service.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraLIvroSpringApplication implements CommandLineRunner {
	@Autowired
	LivroRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AluraLIvroSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StartPrincipal sp = new StartPrincipal(repository);
		//sp.salvarNoBD();//
		sp.Menu();




	}


}
