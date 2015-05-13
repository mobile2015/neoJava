package hello;

import java.io.File;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Configuration
	@EnableNeo4jRepositories(basePackages = "hello")
	static class ApplicationConfig extends Neo4jConfiguration {

		public ApplicationConfig() {
			setBasePackage("hello");
		}

		@Bean
		GraphDatabaseService graphDatabaseService() {
			return new GraphDatabaseFactory().newEmbeddedDatabase("accessingdataneo4j.db");
		}
	}

	@Autowired PersonRepository personRepository;
	@Autowired GroupRepository GroupRepository;
	@Autowired WorkspaceRepository workspaceRepository;
	@Autowired GraphDatabase graphDatabase;

	public void run(String... args) throws Exception {

		Person greg = new Person("Greg");
		Person roy = new Person("Roy");
		Person craig = new Person("Craig");
		GroupUsers A = new GroupUsers("A");
		GroupUsers B = new GroupUsers("B");
		Workspace d1 = new Workspace("Dokument1","Greg");
		Workspace d2 = new Workspace("Dokument2","Greg");

		Transaction tx = graphDatabase.beginTx();
		try {
			personRepository.save(greg);
			personRepository.save(roy);
			personRepository.save(craig);
			workspaceRepository.save(d1);
			workspaceRepository.save(d2);
			
			
			greg = personRepository.findByName(greg.name);
			greg.isMember(A);
			personRepository.save(greg);
			
			roy = personRepository.findByName(roy.name);
			roy.isMember(A);
			personRepository.save(roy);
			
			craig = personRepository.findByName(craig.name);
			craig.isMember(B);
			personRepository.save(craig);
			
			d1= workspaceRepository.findByName(d1.name);
			d1.ReadPerson(roy);
			workspaceRepository.save(d1);
			
			d1= workspaceRepository.findByName(d1.name);
			d1.WritePerson(craig);
			workspaceRepository.save(d1);
			
			for (Person person : GroupRepository.findByGroupName("A")) {
				System.out.println(person.name + " należy do A.");
			}
			
			tx.success();
		} finally {
			tx.close();
		}
	}

	public static void main(String[] args) throws Exception {
		FileUtils.deleteRecursively(new File("accessingdataneo4j.db"));

		SpringApplication.run(Application.class, args);
	}
}