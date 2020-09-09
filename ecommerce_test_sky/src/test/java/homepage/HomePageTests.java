package homepage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.ModalProgram;

public class HomePageTests extends BaseTests  {

	ModalProgram modalProgram;
	
	@Test
	public void testBuscaProgramacao_validarResultado() {
		
		carregarPaginaInicial();
		
		homePage.selecMenuProgram();
		
		String tituloPrograma = homePage.pegarTituloPrograma();
		String horaPrograma = homePage.pegarHoraPrograma();
		
		modalProgram = homePage.clicarProgramacao();
		
		String tituloProgramaModal = modalProgram.pegarTituloProgramaModal();
		String horaProgramaMOdal = modalProgram.pegarHoraProgramaModal();
		
		assertThat(tituloPrograma,is(tituloProgramaModal));
		capturarTela("Valida Titulo Programa","positivo");
		assertThat(horaPrograma,is(horaProgramaMOdal));
		capturarTela("Valida Hora Programa","positivo");
		
	}
	
}
