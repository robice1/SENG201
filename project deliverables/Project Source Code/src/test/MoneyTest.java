package test;
import main.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void testSetMoney() {
		Money money = new Money();
		int setter = 2000;
		Money.setMoney(setter);
		Assertions.assertEquals(setter, Money.getMoney());
	}

}
