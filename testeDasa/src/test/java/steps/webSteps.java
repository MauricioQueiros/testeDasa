package steps;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.WebPage;
import utils.PropertiesLoader;

public class webSteps {

    WebPage webPage;
    PropertiesLoader props;

    public webSteps(){
        this.webPage = new WebPage();
        this.props = new PropertiesLoader();
    }

    @Dado("^que esteja no site$")
    public void que_esteja_no_site(DataTable param) throws Throwable {
        String url = props.getWebProperty(param.asMaps(String.class, String.class).get(0).get("Site"));
        webPage.abrirSistema(url);
    }

    @Quando("^cadastrar uma tarefa$")
    public void cadastrar_uma_tarefa() throws Throwable {
        webPage.criarTarefa();
    }

    @Entao("^sera cadastrada uma nova tarefa$")
    public void sera_cadastrada_uma_nova_tarefa() throws Throwable {
        webPage.validarCriacaoTarefa();
    }

    @Quando("^cadastrar multiplas tarefas$")
    public void cadastrar_multiplas_tarefas() throws Throwable {
        webPage.criarMultiplasTarefas();
    }

    @Entao("^seram cadastradas multiplas tarefas$")
    public void seram_cadastradas_multiplas_tarefas() throws Throwable {
        webPage.validarCriacaoMultiplasTarefas();
    }

    @Quando("^conclui-la$")
    public void conclui_la() throws Throwable {
        webPage.concluirTarefa();
    }

    @Quando("^exclui-la$")
    public void exclui_la() throws Throwable {
        webPage.excluirTarefa();
    }

    @Entao("^ela nao aparecera mais na listagem$")
    public void ela_nao_aparecera_mais_na_listagem() throws Throwable {
        webPage.validarExclusaoTarefa();
    }

    @Entao("^ela aparecera como DONE$")
    public void ela_aparecera_como_DONE() throws Throwable {
        webPage.validarTarefaDone();
    }
}
