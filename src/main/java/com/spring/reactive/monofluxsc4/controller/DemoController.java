package com.spring.reactive.monofluxsc4.controller;

import com.spring.reactive.monofluxsc4.subscriber.DemoSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo() {
        Flux<Integer> flux = Flux.just(1,2,3,4,5);

        // will not print anything as subscriber not there to consume
       // flux.doOnNext(n-> System.out.println(n));

        // will print as 1 1 2 2 3 3 4 4 5 5
       // flux.doOnNext(n-> System.out.println(n))
            //    .subscribe(p-> System.out.println(p));

        // will print as 1 2 3 4 5
        // flux.subscribe(p -> System.out.println(p));

        flux.subscribe(new DemoSubscriber());
    }
}
