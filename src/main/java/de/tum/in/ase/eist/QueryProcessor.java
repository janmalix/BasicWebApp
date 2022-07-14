package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.StringJoiner;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "MyTeam";
        } else if (query.contains("what is your name")){ // TODO extend the programm here
            return "jan";
        } else if (query.contains("which of the following numbers is the largest")) {
            var split = query.split("largest: ")[1].split(", ");
            var largest = Integer.parseInt(split[0]);
            for (var i : split) {
                var temp = Integer.parseInt(i);
                if (temp > largest) {
                    largest = temp;
                }
            }
            return Integer.toString(largest);

        } else if (query.contains("what is")) {
            if (query.contains("plus")) {
                var split = query.split("is ")[1].split(" plus ");
                return Integer.toString(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
            }
            if (query.contains("multiplied by")) {
                var split = query.split("is ")[1].split(" multiplied by ");
                return Integer.toString(Integer.parseInt(split[0]) * Integer.parseInt(split[1]));
            }
            return "";
        } else if (query.contains("numbers are primes: ")) {
            var split = query.split("primes: ")[1].split(", ");
            var joiner = new StringJoiner(", ", "", "");

            for (var s : split) {
                if ((new BigInteger(s)).isProbablePrime(80)) {
                    joiner.add(s);
                }
            }

            return joiner.toString();
        } else
        {
            return "";
        }
    }
}
