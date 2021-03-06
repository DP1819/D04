
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.PersonalRecordRepository;
import domain.PersonalRecord;

@Service
@Transactional
public class PersonalRecordService {

	//Managed Repository

	@Autowired
	private PersonalRecordRepository	personalRecordRepository;


	// Supporting Service

	public PersonalRecordService() {
		super();
	}
	// Simple CRUD methods

	public PersonalRecord create() {
		PersonalRecord pr;
		pr = new PersonalRecord();
		return pr;
	}

	public Collection<PersonalRecord> findAll() {
		Collection<PersonalRecord> pr;
		pr = this.personalRecordRepository.findAll();
		return pr;
	}

	public PersonalRecord findOne(final int personalRecordId) {
		PersonalRecord res;
		res = this.personalRecordRepository.findOne(personalRecordId);
		return res;
		
	}

	public PersonalRecord save(final PersonalRecord p) {
		Assert.notNull(p);
		PersonalRecord res;
		res= this.personalRecordRepository.save(p);
		return res;
	}

	public void delete(final PersonalRecord p) {
		Assert.notNull(p);
		//Assert.isTrue(p.getId() != 0);
		this.personalRecordRepository.delete(p);
	}
}
