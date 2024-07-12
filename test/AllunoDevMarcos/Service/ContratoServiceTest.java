package AllunoDevMarcos.Service;

import AlunoDevMarcos.Service.Dao.IContratoDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import service.ContratoService;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ContratoServiceTest {

    @Mock
    private IContratoDao dao; // Cria um mock do IContratoDao

    @InjectMocks
    private ContratoService service; // Injeta o mock do IContratoDao no ContratoService

    @Test
    public void salvarTest() {
        when(dao.salvar()).thenReturn("Sucesso"); // Define o comportamento do mock
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
        verify(dao, times(1)).salvar(); // Verifica se o método salvar foi chamado uma vez
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        when(dao.salvar()).thenThrow(new UnsupportedOperationException("Não funciona com o banco")); // Define o comportamento do mock
        service.salvar(); // Deve lançar UnsupportedOperationException
    }

    @Test
    public void buscarTest() {
        when(dao.buscar()).thenReturn("Encontrado");
        String resultado = service.buscar();
        Assert.assertEquals("Encontrado", resultado);
        verify(dao, times(1)).buscar();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void ErroEsperadoNoBuscar() {
        when(dao.buscar()).thenThrow(new UnsupportedOperationException("Não funciona com o banco"));
        service.buscar();
    }

    @Test
    public void excluirTest() {
        doNothing().when(dao).excluir(); // Define o comportamento do mock para um método void
        service.excluir();
        verify(dao, times(1)).excluir(); // Verifica se o método excluir foi chamado uma vez
    }

    @Test(expected = UnsupportedOperationException.class)
    public void ErroEsperadoNoExcluir() {
        doThrow(new UnsupportedOperationException("Não Excluir")).when(dao).excluir();
        service.excluir();
    }
    @Test
    public void atualiazarTest() {
        doNothing().when(dao).excluir();
        service.excluir();
        verify(dao, times(1)).excluir();
    }
    @Test(expected = UnsupportedOperationException.class)
    public void ErroEsperadoNoatualiazar() {
        doThrow(new UnsupportedOperationException("Não atualizar")).when(dao).excluir();
        service.excluir();
    }


    }




//TODO
//Fazer métodos de buscar, excluir e atualizar
