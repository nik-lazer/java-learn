import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * TODO: comment
 * @author lazarev_nv 10.02.2014   16:36
 */
public class Main4 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.refresh();
		TxTest tt = ctx.getBean("txTest", TxTest.class);

		Complex c = tt.edit();
		tt.printOrgs(c.getOrgs());
	}

}
