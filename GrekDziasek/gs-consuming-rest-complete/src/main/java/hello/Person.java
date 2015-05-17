package hello;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Person {

    @GraphId Long id;
    public String name;

    public Person() {}
    public Person(String name) 
    { 
    	this.name = name; 
    }

    @RelatedTo(type="GROUP", direction=Direction.OUTGOING)
    public @Fetch Set<GroupUsers> group;

    public void isMember(GroupUsers grupa) {
        if (group == null) {
            group = new HashSet<GroupUsers>();
        }
        group.add(grupa);
    }

    public String toString() {
        String results = name + "'s teammates include\n";
        if (group != null) {
            for (GroupUsers group : group) {
                results += "\t- " + group.name + "\n";
            }
        }
        return results;
    }

}





