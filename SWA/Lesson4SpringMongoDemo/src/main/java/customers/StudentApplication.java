package app;

import domain.Address;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.StudentRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class StudentApplication implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("1000N 4TH ST", "Fairfield","52557");
		// create customer
		Student student = new Student("John doe", "0688341678","johnd@acme.com",address);
		studentRepository.save(student);

		Address address2 = new Address("1000N 4TH ST", "Burlington","52557");
		// create customer
		Student student2 = new Student("Mary Stone", "0629951678","johnd@acme.com",address2);
		studentRepository.save(student2);

		Address address3 = new Address("1000N 4TH ST", "Burlington","52557");
		// create customer
		Student student3 = new Student("Emma Southland", "0622365678","johnd@acme.com",address3);
		studentRepository.save(student3);

//		Address address4 = new Address(1,"1000N 4TH ST", "Fairfield","52557");5
		Address address4 = new Address("1000N 4TH ST", "Fairfield","52557");
		// create customer
		Student student4 = new Student("John Smith", "0621456678","johnd@acme.com",address4);
		studentRepository.save(student4);

//		Address address5 = new Address(1,"1000N 4TH ST", "Fairfield","52557");
		Address address5 = new Address("1000N 4TH ST", "Fairfield","52557");
		// create customer
		Student student5 = new Student("John Rock", "0644561678","johnd@acme.com",address5);
		studentRepository.save(student5);
		System.out.println("----Find all students----");
		studentRepository.findAll().forEach(System.out::println);

		//
		System.out.println("----Find all students with name 'John' ");
		studentRepository.findAllByNameContains("John").forEach(System.out::println);

		System.out.println("----Find a  student with a certain phoneNumber (0644561678)");
		System.out.println(studentRepository.findAllByPhoneNumber("0644561678"));

		System.out.println("----Find all students come from burlington");
		studentRepository.findAllByCity("burlington").forEach(System.out::println);


	}

}
