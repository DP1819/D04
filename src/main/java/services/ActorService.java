
package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;
import domain.Actor;

@Service
@Transactional
public class ActorService extends GenericService<Actor, ActorRepository> implements ServiceI<Actor> {

	// Repositories

	@Autowired
	private ActorRepository	repository;


	// Services

	//@Autowired
	//private FolderService	folderService;

	// CRUD methods

	@Override
	public Actor findOne(final Integer id) {
		return super.findOne(id);
	}

	@Override
	public List<Actor> findAll(final Collection<Integer> ids) {
		return super.findAll(ids);
	}

	@Override
	public List<Actor> findAll() {
		return super.findAll();
	}

	// Other methods

	public Actor findOneByUserAccount(final UserAccount userAccount) {
		return this.repository.findOneByUserAccount(userAccount.getId());
	}

	public Actor findPrincipal() {
		final UserAccount userAccount = LoginService.getPrincipal();
		return this.repository.findOneByUserAccount(userAccount.getId());
	}

	@Override
	public Actor create() {
		throw new IllegalArgumentException("Unallowed method");
	}

	@Override
	public Actor save(final Actor object) {
		throw new IllegalArgumentException("Unallowed method");
	}

	@Override
	public void delete(final Actor object) {
		throw new IllegalArgumentException("Unallowed method");
	}

	public Map<String, Double> fixupTasksStats() {
		final Double[] statistics = this.repository.fixupTasksStats();
		final Map<String, Double> res = new HashMap<>();

		res.put("MIN", statistics[0]);
		res.put("MAX", statistics[1]);
		res.put("AVG", statistics[2]);
		res.put("STD", statistics[3]);
		

		return res;
	}
}
