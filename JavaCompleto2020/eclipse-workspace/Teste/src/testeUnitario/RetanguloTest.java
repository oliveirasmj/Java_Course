package testeUnitario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

class RetanguloTest {

	@Test
	void testCalcularArea() {
		Retangulo retangulo = new Retangulo(10, 2);
		assertEquals(20, retangulo.calcularArea());
	}

	@Test
	void testCalcularPerimetro() {
		Retangulo retangulo = new Retangulo(10, 2);
		assertEquals(24, retangulo.calcularPerimetro());
	}

}
