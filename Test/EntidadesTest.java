import Dao.*;
import Domain.Acessorio;
import Domain.Carro;
import Domain.Marca;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public class EntidadesTest {

    private ICarroDao carroDao;

    private IMarcaDao marcaDao;

    private IAcessorioDao acessorioDao;

    public EntidadesTest() {
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrar() {
        Marca marca = criarMarca("Fiat");
        Acessorio acessorio1 = criarAcessorio("Ar Condicionado");
        Acessorio acessorio2 = criarAcessorio("Banco de Couro");

        Carro carro = new Carro();
        carro.setModelo("Palio");
        carro.setMarca(marca);
        carro.setAcessorios(Arrays.asList(acessorio1, acessorio2));

        carro = carroDao.cadastrar(carro);

        assertNotNull(carro);
        assertNotNull(carro.getId());
    }

    private Marca criarMarca(String nome) {
        Marca marca = new Marca();
        marca.setNome(nome);
        return marcaDao.cadastrar(marca);
    }

    private Acessorio criarAcessorio(String nome) {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome(nome);
        return acessorioDao.cadastrar(acessorio);
    }
}
