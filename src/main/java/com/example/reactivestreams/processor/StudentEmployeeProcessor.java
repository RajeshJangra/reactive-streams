package com.example.reactivestreams.processor;

import com.example.reactivestreams.domain.Employee;
import com.example.reactivestreams.domain.Student;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

public class StudentEmployeeProcessor extends SubmissionPublisher<Employee> implements Processor<Student, Employee> {
  private Subscription subscription;

  @Override
  public void onSubscribe(Subscription subscription) {
    this.subscription = subscription;
    subscription.request(1);
  }

  @Override
  public void onNext(Student student) {
    System.out.println("new Employee(student) = " + new Employee(student));
    subscription.request(1);
  }

  @Override
  public void onError(Throwable throwable) {
    System.out.println("Error Occurred: " + throwable.getMessage());
  }

  @Override
  public void onComplete() {
    System.out.println("No more students from publisher");
  }
}
