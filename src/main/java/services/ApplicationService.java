package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ApplicationRepository;
import domain.Application;


@Service
@Transactional
public class ApplicationService {
	
	//Managed Repository

	@Autowired
	private ApplicationRepository applicationRepository;

	// Supporting Service
	
	
	// Simple CRUD methods
	
	public Application create() {
		final Application a = new Application();
		return a;
	}
	
	public Collection<Application> findAll() {
		return this.applicationRepository.findAll();
	}

	public Application findOne(final int applicationId) {
		return this.applicationRepository.findOne(applicationId);
	}
	
	public Application save(final Application a) {
		Assert.notNull(a);
		return this.applicationRepository.save(a);
	}

	public void delete(final Application a) {
		Assert.notNull(a);
		this.applicationRepository.delete(a);
	}
	
	//Other Methods
	
	public Map<String, Double> applicationPriceStats() {
		final Double[] statistics = this.applicationRepository.applicationPriceStats();
		final Map<String, Double> res = new HashMap<>();

		res.put("MIN", statistics[0]);
		res.put("MAX", statistics[1]);
		res.put("AVG", statistics[2]);
		res.put("STD", statistics[3]);

		return res;
	}

	
	public Map<String, Double> pendingRatio(){
		final Double ratio = this.applicationRepository.pendingRatio();
		final Map<String, Double> res = new HashMap<>();

		res.put("Ratio", ratio);

		return res;
	}
	
	public Map<String, Double> acceptedRatio(){
		final Double ratio = this.applicationRepository.acceptedRatio();
		final Map<String, Double> res = new HashMap<>();

		res.put("Ratio", ratio);

		return res;
	}
	
	public Map<String, Double> appsRejectedRatio(){
		final Double ratio = this.applicationRepository.acceptedRatio();
		final Map<String, Double> res = new HashMap<>();

		res.put("Ratio", ratio);

		return res;
	}
	
	public Map<String, Double> lateApplicationsRatio(){
		final Double ratio = this.applicationRepository.lateApplicationsRatio();
		final Map<String, Double> res = new HashMap<>();

		res.put("Ratio", ratio);

		return res;
	}
	
}
