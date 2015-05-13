package hello;

import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<GroupUsers, String> {

    Iterable<Person> findByGroupName(String name);

}