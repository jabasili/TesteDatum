package ProvaDatum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class page {

	private DSL dsl;

	public page(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	//ESCREVER
	public void setEmail(String email) {
		dsl.escreve("email", email);
	}

	public void setSenha(String senha) {
		dsl.escreve("passwd", senha);
	}
	
	public void buscaPrintedChiffonDress() {
		dsl.escreve("search_query_top", "Printed Chiffon Dress");
	}
	
	public void buscarFadedShortSleeveTshirt() {
		dsl.escreve("search_query_top", "Faded Short Sleeve T-shirts");
	}
	
	
	//CLICAR
	public void clicarBotaoLogin() {
		dsl.clicarBotaoXpath(".//*[@class='login']");
	}

	public void clicarBotaoSingIn() {
		dsl.clicarBotaoId("SubmitLogin");
	}
	
	public void clicaBuscaProduto() {
		dsl.clicarBotaoBusca("submit_search");
	}
	
	public void selecionaProduto() {
		dsl.clicarProduto(".//*[@class='left-block']");
	}
	
	public void clicaEmContinuaCompra() {
		dsl.continuarComprando(".//*[@class='button-container']//span[@title='Continue shopping']");
	}
	
	public void adicionaProdutoCarrinho() {
		dsl.adicionarCarrinho("add_to_cart");
	}
	
	public void clicaEmIrCheckout() {
		dsl.irCheckout(".//*[@class='button-container']//a[@title='Proceed to checkout']");
	}

	public void clicaEmConfirmaResumoPedido() {
		dsl.confirmaResumoPedido(".//*[@class='cart_navigation clearfix']//a");
	}

	public void clicaEmConfirmaEndereco() {
		dsl.confirmaEndereco(".//*[@class='cart_navigation clearfix']//button");
	}

	public void clicaEmConfirmaEntrega() {
		dsl.confirmaEntrega(".//*[@class='cart_navigation clearfix']//button");
	}

	public void clicaEmTipoPagamentoTransfBancaria() {
		dsl.pagaTranferenciaBancaria(".//*[@class='payment_module']//a");
	}

	public void nextPageConfirmaPedido() {
		dsl.confirmaPedido(".//*[@class='cart_navigation clearfix']//button");
	}
	
	public void clicaBotaoCriarConta() {
		dsl.clicaCriateAnAccount();
	}
	
	public void botaoCadastrar() {
		dsl.cadastra();
	}	
	
	//OBTER
	public String validarTelaLogin() {
		return dsl.obterTexto(By.tagName("h1"));
	}

	public String validarEmail() {
		return dsl.obterValorCampo("email");
	}

	public String validarSenha() {
		return dsl.obterValorCampo("passwd");
	}

	public String validarMyAccount() {
		return dsl.obterTexto(By.className("page-heading"));
	}
	
	public String validaTipoPagamentoTransfBanc() {
		return dsl.obterTexto(By.tagName("h3"));
	}

	public String validaPedidoRealizado() {
		return dsl.obterTexto(By.tagName("h1"));
	}
	
	//LIMPA CAMPO
	public void limparCampoBusca() {
		dsl.limparCampo("search_query_top");
	}

	//RADIO E CHECKBOX
	public void marcarCheckBox() {
		dsl.marcaCheckBox("cgv");
	}
	
	public boolean isCheckBoxMarcado() {
		return dsl.isCheckBoxMarcado();
	}
	
	public void marcaMrs() {
		dsl.marcaRadioBox();
	}
	
	public boolean validaMrs() {
		return dsl.validaRadioBox();
	}
	
	//VALIDACAO
	public String validarPrintedChiffonDress() {
		return dsl.validarVestido();
	}

	public String validarFadedShortSleeveTshirts() {
		return dsl.validarCamiseta();
	}

	public String ValidarVestidoNoCarrinho() {
		return dsl.validarVestidoNoCarrinho();
	}

	public String validaCamisetaNoCarrinho() {
		return dsl.validarCamisetaNoCarrinho();
	}

	public String confirmaTelaResumoPedido() {
		return dsl.validarTelaResumoPedido();
	}

	public String confirmaMsgAdresses() {
		return dsl.validarTelaEndereco();
	}

	public String confirmaTelaEntrega() {
		return dsl.validarTelaEntrega();
	}	

	public String validaTelaEscolhaPagamento() {
		return dsl.validarTelaFormaPagamento();
	}
	
	//CRIACAO DE EMAIL
	public void emailFake() {
		dsl.entrarSiteEmailFake();
	}

	public WebElement campoEmailCriarUser() {
		return dsl.selecionaCreateAnAccount();
	}
	
	public WebElement pegaEmailFake() {
		return dsl.copiarEmailFake();
	}
	
	
	//SETAR CAMPOS CADASTRO	
	public void nomeCad() {
		dsl.setNomeCad();
	}
	
	public void sobrenomeCad() {
		dsl.setSobrenomeCad();
	}
	
	public void senhaCad() {
		dsl.setSenha();
	}
	
	public void dayCad() {
		dsl.setDay();
	}
	
	public void monthCad() {
		dsl.setMonth();
	}
	
	public void yearCad() {
		dsl.setYear();
	}
	
	public void enderecoCad() {
		dsl.setAddress();
	}
	public void cityCad() {
		dsl.setCity();
	}
	
	public void stateCad() {
		dsl.setState();
	}
	
	public void postalCodeCad() {
		dsl.setPostaCode();
	}
	
	public void aliasCad() {
		dsl.setAlias();
	}
	
	public void phoneCad() {
		dsl.setPhone();
	}	
}
