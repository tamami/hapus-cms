package lab.aikibo.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import lab.aikibo.entity.Sppt;
import lab.aikibo.util.FormattedNop;
import lab.aikibo.util.HibernateUtil;

public class SpptManager {
	
	public List<Sppt> getDaftarSpptFormatBpd(List<String> daftarNop) {
		Session session = (Session) HibernateUtil.getSessionFactory();
		
		session.beginTransaction();
		for(int i=0; i<daftarNop.size(); i++) {
			FormattedNop formattedNop = new FormattedNop(daftarNop.get(i));
			Criteria criteria = session.createCriteria(Sppt.class);
			
			criteria.add(Restrictions.eq("kdPropinsi", formattedNop.getKdPropinsi()));
			criteria.add(Restrictions.eq("kdDati2", formattedNop.getKdDati2()));
			criteria.add(Restrictions.eq("kdKecamatan", formattedNop.getKdKecamatan()));
			criteria.add(Restrictions.eq("kdKelurahan", formattedNop.getKdKelurahan()));
		}
		return null;
	}

}
