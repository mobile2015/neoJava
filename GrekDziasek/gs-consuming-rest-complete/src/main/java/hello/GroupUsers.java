package hello;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class GroupUsers {
	@GraphId Long id;
    public String name;

    public GroupUsers() {}
    public GroupUsers(String groupId) 
    { 
    	this.name=groupId; 
    }

    @RelatedTo(type="GROUP", direction=Direction.BOTH)
    public @Fetch Set<Person> group;

    public void isMember(Person person) {
        if (group == null) {
            group = new HashSet<Person>();
        }
        group.add(person);
    }

    public String toString() {
        String results = name + "'s teammates include\n";
        if (group != null) {
            for (Person person : group) {
                results += "\t- " + person.name + "\n";
            }
        }
        return results;
    }
}
