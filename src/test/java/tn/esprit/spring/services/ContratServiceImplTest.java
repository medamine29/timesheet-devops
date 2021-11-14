package tn.esprit.spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ContratServiceImplTest {

	@Autowired
	IContratService uc;

	@Test
	@Order(1)
	public void testretrieveAllContrats() {
		List<Contrat> listContrats = uc.retrieveAllContrats();
		Assertions.assertEquals(0, listContrats.size());
	}

	@Test
	@Order(2)
	public void testaddContrat() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c = new Contrat(1, d, "CDI", 1800F);
		Contrat contratAdded = uc.addContrat(c);

		Assertions.assertEquals(c.getTypeContrat(), contratAdded.getTypeContrat());

	}

	@Test
	@Order(3)
	public void testupdateContrat() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");

		Contrat c = new Contrat(1, d, "CDD", 1500F);
		Contrat contratUpdated = uc.updateContrat(c);
		Assertions.assertEquals(c.getTypeContrat(), contratUpdated.getTypeContrat());
	}

	@Test
	@Order(4)
	public void retrieveContrat() {

		Contrat userRetrieved = uc.retrieveContrat("1");
		Assertions.assertEquals(1, userRetrieved.getReference());
	}

	@Test
	@Order(5)
	public void testdeleteContrat() {
		uc.deleteContrat("1");
		Assertions.assertNull(uc.retrieveContrat("1"));

	}

}
