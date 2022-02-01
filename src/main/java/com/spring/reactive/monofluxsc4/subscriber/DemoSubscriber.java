package com.spring.reactive.monofluxsc4.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DemoSubscriber implements Subscriber<Integer> {
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        System.out.println("Subscribed");
        subscription.request(2);    // retrieve given (2) number of elements from the publisher
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("On Next "+integer);
        subscription.request(1);    // retrieve given (1) number of elements from the publisher
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("On Error"+throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("On Complete");
    }
}
