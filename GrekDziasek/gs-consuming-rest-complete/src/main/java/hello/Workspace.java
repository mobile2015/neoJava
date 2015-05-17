package hello;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Workspace{

    @GraphId Long id;
    public String name;
    public String person_name;

    public Workspace() {}
    public Workspace(String name, String person_name) 
    { 
    	this.name = name; 
    	this.person_name=person_name;
    }

    @RelatedTo(type="READ_G", direction=Direction.OUTGOING)
    public @Fetch Set<GroupUsers> read_group;
    @RelatedTo(type="READ_P", direction=Direction.OUTGOING)
    public @Fetch Set<Person> read_person;
    
    @RelatedTo(type="WRITE_G", direction=Direction.OUTGOING)
    public @Fetch Set<GroupUsers> write_group;
    @RelatedTo(type="WRITE_P", direction=Direction.OUTGOING)
    public @Fetch Set<Person> write_person;

    public void ReadGroup(GroupUsers grupa) {
        if (read_group == null) {
        	read_group = new HashSet<GroupUsers>();
        }
        read_group.add(grupa);
    }
    public void WriteGroup(GroupUsers grupa) {
        if (write_group == null) {
        	write_group = new HashSet<GroupUsers>();
        }
        write_group.add(grupa);
    }
    public void WritePerson(Person person) {
        if (write_person == null) {
        	write_person = new HashSet<Person>();
        }
        write_person.add(person);
    }
    public void ReadPerson(Person person) {
        if (read_person == null) {
        	read_person = new HashSet<Person>();
        }
        read_person.add(person);
    }
}