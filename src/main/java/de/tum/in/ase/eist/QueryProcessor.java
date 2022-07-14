package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

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
            return Integer.toString(Math.max(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
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
        } else
        {
            return "";
        }
    }
}
