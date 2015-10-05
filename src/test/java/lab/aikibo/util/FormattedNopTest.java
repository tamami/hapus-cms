package lab.aikibo.util;


import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import lab.aikibo.util.FormattedNop;

import org.junit.Before;
import org.junit.Test;

public class FormattedNopTest {
	List<String> formattedNop;
	List<String> result;

	@Before
	public void before() {
		formattedNop = new LinkedList<String>();
		formattedNop.add("33.29.010.004.006-0085.0");
		formattedNop.add("33.29.010.004.006-0090.0");
		formattedNop.add("33.29.010.004.006.0137.0");
		
		result = new LinkedList<String>();
		result.add("332901000400600850");
		result.add("332901000400600900");
		result.add("332901000400601370");
	}
	
	@Test
	public void test() {
		for(int i=0;i<formattedNop.size(); i++) {
			FormattedNop fn = new FormattedNop(formattedNop.get(i));
			String resultNop = fn.getKdPropinsi() + fn.getKdDati2() + fn.getKdKecamatan() + 
					fn.getKdKelurahan() + fn.getKdBlok() + fn.getNoUrut() + fn.getKdJnsOp();
			assertEquals(result.get(i), resultNop);
		}
	}

}
