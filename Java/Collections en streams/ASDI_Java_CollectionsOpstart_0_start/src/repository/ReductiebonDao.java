package repository;

import java.util.List;

import domein.Reductiebon;

public interface ReductiebonDao {
	List<Reductiebon> findAll();
}
