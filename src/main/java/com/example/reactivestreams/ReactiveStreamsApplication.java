package com.example.reactivestreams;

import com.example.reactivestreams.domain.Student;
import com.example.reactivestreams.processor.StudentEmployeeProcessor;
import com.example.reactivestreams.subscriber.StudentSubscriber;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.SubmissionPublisher;

import static com.example.reactivestreams.util.StudentBootStrap.getStudents;

@SpringBootApplication
public class ReactiveStreamsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReactiveStreamsApplication.class, args);
  }

  @Bean
  public CommandLineRunner getCommandLineRunner() {
    return args -> {
      System.out.println(" Simple subscriber");
      try (SubmissionPublisher<Student> publisher = new SubmissionPublisher<>()) {
        publisher.subscribe(new StudentSubscriber());
        getStudents().forEach(student -> publisher.submit(student));
        Thread.sleep(1000);
      }

      System.out.println("\nSimple Processor");
      try (SubmissionPublisher<Student> publisher = new SubmissionPublisher<>()) {
        publisher.subscribe(new StudentEmployeeProcessor());
        getStudents().forEach(student -> publisher.submit(student));
        Thread.sleep(1000);
      }
    };
  }
}
