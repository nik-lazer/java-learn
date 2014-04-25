import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexey Pobedyonny 28.01.2014
 */
public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.refresh();
		SessionFactory sf = ctx.getBean("sessionFactory", SessionFactory.class);
		Session session = sf.openSession();
		Org o;

		session.save(o = new Org("Test", "Test"));
		session.close();

		session = sf.openSession();
		o = (Org) session.load(Org.class, o.getId());

		o.setName("asdasd");
		o.setSystemName("asdasdqwe");
		session.update(o);

		Complex c = new Complex("Test", "Test");
		c.getOrgs().add(o);
		session.save(c);
		session.flush();
		System.out.println(c);
		session.close();

		session = sf.openSession();
		c = (Complex) session.load(Complex.class, c.getId());
		session.close();

		printOrgs(c.getOrgs());
	}

	private static void printOrgs(Set<Org> orgs) {
		for (Org org : orgs) {
			System.out.println(org.getName());
		}
	}

}
