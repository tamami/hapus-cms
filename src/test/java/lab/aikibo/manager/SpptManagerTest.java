package lab.aikibo.manager;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class SpptManagerTest {
	private SpptManager spptManager;
	private List<String> data;
	
	@Before
	public void before() {
		data = new LinkedList<String>();
		data.add("33.29.010.004.006-0085.0");
		data.add("33.29.010.004.006-0090.0");
		data.add("33.29.010.004.006.0137.0");
	}
	
	@Test
	public void test() {
		Assert.assertNotNull(spptManager.getDaftarSpptFormatBpd(data, "2015"));
	}

}
