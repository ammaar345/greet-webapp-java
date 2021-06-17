package test;

import greet.Greet;
import org.junit.Test;

public class Testing {
    @Test
    public void testing() {
        Greet greet = new Greet();
        greet.greet("Bread");
        greet.greet("Joe");
        greet.greet("Tom");
        System.out.print(greet.userNames());
    }

    @Test
    public void test() {
        Greet greet = new Greet();
        greet.greet("Ammaar");
        greet.greet("Ammaar");
greet.greet("joe");
        System.out.println(greet.eachUsersCount());
    }
}
