package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class main{
    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }
    @GetMapping("/greet")
    public GreetResponse greet(){
        GreetResponse response =new GreetResponse(
                "hello",
                List.of("java", "Golang","javascript"),
                new Person("name:Alex", 28,3000));
        return response;
    }
    record Person(String name, int age, double savings){

    }
    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ){

    }
    /*static class GreetResponse {
        private final String greet;

        public GreetResponse(String greet) {
            this.greet = greet;
        }

        public String getGreet() {
            return greet;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GreetResponse that = (GreetResponse) o;
            return Objects.equals(greet, that.greet);
        }

        @Override
        public int hashCode() {
            return Objects.hash(greet);
        }
    }

     */
}
