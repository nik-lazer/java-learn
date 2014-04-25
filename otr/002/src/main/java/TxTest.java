import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * TODO: comment
 * @author lazarev_nv 10.02.2014   17:09
 */
public class TxTest {
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public Complex edit() {
		Org o;

		hibernateTemplate.save(o = new Org("Test", "Test"));

		o = (Org) hibernateTemplate.load(Org.class, o.getId());

		o.setName("asdasd");
		o.setSystemName("asdasdqwe");
		hibernateTemplate.update(o);

		Complex c = new Complex("Test", "Test");
		c.getOrgs().add(o);
		hibernateTemplate.save(c);
		hibernateTemplate.flush();
		System.out.println(c);

		c = (Complex) hibernateTemplate.get(Complex.class, c.getId());

		//printOrgs(c.getOrgs());
		return c;
	}

	@Transactional
	public void printOrgs(Set<Org> orgs) {
		for (Org org : orgs) {
			System.out.println(org.getName());
		}
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
