package lab.aikibo.manager;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import lab.aikibo.entity.Sppt;
import lab.aikibo.util.FormattedNop;
import lab.aikibo.util.HibernateUtil;

public class SpptManager {
	Logger logger = Logger.getLogger(SpptManager.class);
	
	public List<Sppt> getDaftarSpptFormatBpd(List<String> daftarNop, String thnPajak) {
		//Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		Session session = (new Configuration().configure().buildSessionFactory()).openSession();
		
		session.beginTransaction();
		List<Sppt> result = new LinkedList<Sppt>();
		for(int i=0; i<daftarNop.size(); i++) {
			FormattedNop formattedNop = new FormattedNop(daftarNop.get(i));
			Criteria criteria = session.createCriteria(Sppt.class);
			
			criteria.add(Restrictions.eq("kdPropinsi", formattedNop.getKdPropinsi()));
			criteria.add(Restrictions.eq("kdDati2", formattedNop.getKdDati2()));
			criteria.add(Restrictions.eq("kdKecamatan", formattedNop.getKdKecamatan()));
			criteria.add(Restrictions.eq("kdKelurahan", formattedNop.getKdKelurahan()));
			criteria.add(Restrictions.eq("kdBlok", formattedNop.getKdBlok()));
			criteria.add(Restrictions.eq("noUrut", formattedNop.getNoUrut()));
			criteria.add(Restrictions.eq("kdJnsOp", formattedNop.getKdJnsOp()));
			criteria.add(Restrictions.eq("thnPajakSppt", thnPajak));
			
			List<Sppt> data = (List<Sppt>) criteria.list();
			if(data.size() > 0) {
				result.add((Sppt)data.get(0));
				logger.info("NOP : " + formattedNop.getFormattedNop() + " terbaca.");
			} else {
				logger.error("Data nop : " + formattedNop.getFormattedNop() + " tidak ada!");
			}
		}
		session.close();
		return result;
	}
	
	public boolean batalkanSppt(List<String> daftarNop, String thnPajak) {
		Session session = (Session) HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		for(int i=0; i<daftarNop.size(); i++) {
			FormattedNop formattedNop = new FormattedNop(daftarNop.get(i));
			Criteria criteria = session.createCriteria(Sppt.class);
			
			criteria.add(Restrictions.eq("kdPropinsi", formattedNop.getKdPropinsi()));
			criteria.add(Restrictions.eq("kdDati2", formattedNop.getKdDati2()));
			criteria.add(Restrictions.eq("kdKecamatan", formattedNop.getKdKecamatan()));
			criteria.add(Restrictions.eq("kdKelurahan", formattedNop.getKdKelurahan()));
			criteria.add(Restrictions.eq("kdBlok", formattedNop.getKdBlok()));
			criteria.add(Restrictions.eq("noUrut", formattedNop.getNoUrut()));
			criteria.add(Restrictions.eq("kdJnsOp", formattedNop.getKdJnsOp()));
			criteria.add(Restrictions.eq("thnPajakSppt", thnPajak));
			criteria.add(Restrictions.ne("statusPembayaranSppt", "2"));
			
			List<Sppt> dataResult = criteria.list();
			if(dataResult.size() > 0) {
				Sppt data = dataResult.get(0);
				data.setStatusPembayaranSppt("2");
				session.save(data);
				logger.info("Memproses NOP : " + formattedNop.getFormattedNop() + " - " + thnPajak);
			} else {
				logger.warn("Data NOP : " + formattedNop.getFormattedNop() + " - " + thnPajak + 
						" tidak ada!");
			}
		}
		session.getTransaction().commit();
		session.close();
		return true;
	}

}
