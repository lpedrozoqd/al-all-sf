package edu.lpq.alallsf;

import edu.lpq.alallsf.bean.MyBean;
import edu.lpq.alallsf.bean.MyBeanWithDependency;
import edu.lpq.alallsf.component.ComponentDependency;
import edu.lpq.alallsf.entity.Users;
import edu.lpq.alallsf.repository.UserRepository;
import edu.lpq.alallsf.utils.UserData;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AlAllSfApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(AlAllSfApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private UserData userData;
	private UserRepository userRepository;

	/**
	 * Esta anotación @Qualifier("componentTwoImplement") permite
	 * establecer cual componente usar para esa dependencia la cual es
	 * instanciada más de una vez. (el nombre de @Qualifier es de la clase pero
	 * la primera letra es en minúsucla)
	 * Otra situación a tener en cuenta es que en la clase que implementa
	 * la dependiencia se puede agregar @Primary para establecer
	 * el componente default a usar. Existe también el @Autowired el cual
	 * ahora es opciona. Habrá que entender cómo trabaja.
	 * */
	public AlAllSfApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
							  MyBean myBean,
							  MyBeanWithDependency myBeanWithDependency,
							  UserData userData,
							  UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean	= myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.userData = userData;
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(AlAllSfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveUserInDB();
	}

	private void saveUserInDB(){
		Users user1 = new Users("Leonel",
				"leonel@clarape.co",
				LocalDate.of(1981,1,1)
				);
		Users user2 = new Users("Leonel",
				"user2@clarape.co",
				LocalDate.of(1982,2,2)
		);
		Users user3 = new Users("user3",
				"user3@clarape.co",
				LocalDate.of(1983,3,3)
		);
		Users user4 = new Users("user4",
				"user4@clarape.co",
				LocalDate.of(1984,4,4)
		);
		Users user5 = new Users("user5",
				"user5@clarape.co",
				LocalDate.of(1985,5,5)
		);
		Users user6 = new Users("user6",
				"user6@clarape.co",
				LocalDate.of(1986,6,6)
		);
		Users user7 = new Users("user7",
				"user7@clarape.co",
				LocalDate.of(1987,7,7)
		);
		Users user8 = new Users("user8",
				"user8@clarape.co",
				LocalDate.of(1988,8,8)
		);
		Users user9 = new Users("user9",
				"user9@clarape.co",
				LocalDate.of(1989,9,9)
		);
		Users user10 = new Users("user10",
				"user10@clarape.co",
				LocalDate.of(1990,10,10)
		);
		Users user11 = new Users("user11",
				"user11@clarape.co",
				LocalDate.of(1991,11,11)
		);
		Users user12 = new Users("user12",
				"user12@clarape.co",
				LocalDate.of(1992,12,12)
		);

		List<Users> listUsers = Arrays.asList(user1,user2,user3,user4,user5,
				user6,user7,user8,user9,user10,user11,user12);
		System.out.println(">>>>>>>>>>>>>>>>>> 1.1- Iniciando carga datos...");
		listUsers.stream()
				.forEach(userRepository::save);
		System.out.println(">>>>>>>>>>>>>>>>>> 2-2- Finalizando carga datos...");
		System.out.println(">>>>>>>>>>>>>>>>>> 2.1 Iniciando consulta de User...");
		getInformationJpqlFromUser();
		System.out.println(">>>>>>>>>>>>>>>>>> 2.2 Finalizando carga datos...");
		
	}

	private void getInformationJpqlFromUser(){
		String email = "user10@clarape.co";
		Optional<Users> res = Optional.ofNullable(userRepository.findByUserEmail(email)
				.orElseThrow(() -> new RuntimeException("No se encontró el usuario")));
		
				LOGGER.info("######### method::findByUserEmail::"+ email +"::" + (res.isPresent() ? ((Users)res.get()).toString() : "no hay nada"));

		userRepository.findAndSort("user1", Sort.by("id").descending())
			.stream()
			.forEach(user -> LOGGER.info("=====Usuario del metodo ::findAndSort::" + user.toString()));

		
		userRepository.findByName("Leonel")	
			.forEach(user -> LOGGER.info("=====Usuario con query method::" + user.toString()));		

		LOGGER.info("=====Usuario por findByEmailAndName::" + userRepository.findByEmailAndName("leonel@clarape.co","Leonel")
			.orElseThrow(()-> new RuntimeException("No se encontró el usuario")));
		 
				
	}
	public void runEjemplosAnteriores01(String... args) throws Exception {
		//Aquí se ejecutan las dependencias
		componentDependency.saludar();

		//Creación de dependencia propia
		myBean.print();

		//Creación de dependencia que usa otra dependencia
		myBeanWithDependency.printWithDependency();
		System.out.println(userData.getEmail() + " -- " + userData.getPassword());
	}


}
