package fi.haagahelia.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Bookcategory, Long>{

    List<Bookcategory> findByName(String name);
}
