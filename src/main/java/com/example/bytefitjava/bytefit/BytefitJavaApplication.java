package com.example.bytefitjava.bytefit;

import com.example.bytefitjava.bytefit.repository.FoodRepository;
import com.example.bytefitjava.bytefit.repository.UserRepository;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
@EnableMongoRepositories("com.example.bytefitjava.bytefit.repository")
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class BytefitJavaApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FoodRepository foodRepository;

	public static void main(String[] args) {
		SpringApplication.run(BytefitJavaApplication.class, args);
	}

	public void run(String... args) throws Exception {

		MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "byteFitJava");

		if (!mongoOps.collectionExists("foods")) {
			mongoOps.createCollection("foods");
			log.info("Foods collection created successfully.");
			startupDataInsert("foodDataInsert.sh");

		}
		if (!mongoOps.collectionExists("users")) {
			mongoOps.createCollection("users");
			log.info("Users collection created successfully.");
			startupDataInsert("userDataInsert.sh");
		}

		System.out.println("result" + mongoOps.findById("5e654b1d78d958ebf4dd8129", String.class, "foods"));
//        mongoOps.insert((new Users("brandnewjacobo@hotmail.co.uk","jay123")), "users");

	}

	private void startupDataInsert(String fileName) {
		try {
			String target = new String("/Users/jacobedwards/Documents/gitHub/bytefit-springboot-react/src/main/resources/" + fileName);
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(target);
			proc.waitFor();
			StringBuffer output = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			log.info(fileName + " data successfully inserted.");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
