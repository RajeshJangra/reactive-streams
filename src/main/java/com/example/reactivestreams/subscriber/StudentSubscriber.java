package com.example.reactivestreams.subscriber;

import com.example.reactivestreams.domain.Student;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class StudentSubscriber implements Subscriber<Student> {
  private Subscription subscription;

  @Override
  public void onSubscribe(Subscription subscription) {
    this.subscription = subscription;
    subscription.request(1);
  }

  @Override
  public void onNext(Student student) {
    System.out.println("student = " + student);
    subscription.request(1);
  }

  @Override
  public void onError(Throwable throwable) {
    System.out.println("Error occurred = " + throwable.getMessage());
  }

  @Override
  public void onComplete() {
    System.out.println("No more students from publisher");
  }
}
