
package services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.TicketableRepository;
import domain.Ticketable;

@Service
@Transactional
public class TicketableService {

	//Managed Repository

	@Autowired
	private TicketableRepository	ticketableRepository;


	// Supporting Service

	// Simple CRUD methods

	public Collection<Ticketable> findAll() {
		return this.ticketableRepository.findAll();
	}

	public Ticketable findOne(final int ticketableId) {
		return this.ticketableRepository.findOne(ticketableId);
	}

	public Ticketable save(final Ticketable s) {
		Assert.notNull(s);
		return this.ticketableRepository.save(s);
	}

	public void delete(final Ticketable s) {
		Assert.notNull(s);
		this.ticketableRepository.delete(s);
	}

	public String createTicker() {
		String result = "";
		final String alphas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final Random rnd = new Random();
		final DateFormat df = new SimpleDateFormat("YYMMdd");
		final Date date = new Date();
		result += df.format(date);
		int a, b, c, d, e, f;
		a = rnd.nextInt(alphas.length());
		b = rnd.nextInt(alphas.length());
		c = rnd.nextInt(alphas.length());
		d = rnd.nextInt(alphas.length());
		e = rnd.nextInt(alphas.length());
		f = rnd.nextInt(alphas.length());
		result += "-" + alphas.charAt(a) + alphas.charAt(b) + alphas.charAt(c) + alphas.charAt(d) + alphas.charAt(e) + alphas.charAt(f);

		return result;
	}
}
