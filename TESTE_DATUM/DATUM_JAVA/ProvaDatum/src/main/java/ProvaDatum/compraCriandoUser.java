package ProvaDatum;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class compraCriandoUser {

	private WebDriver driver;
	private page page;

	@Before
	public void inicializa() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.get("http://automationpractice.com/index.php");
		page = new ProvaDatum.page(driver);
	}

	@After
	public void finaliza() {
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		// Criar Email
		page.emailFake();
		WebElement GetMail = page.pegaEmailFake();
		String GetMailText = GetMail.getAttribute("value");

		// Entra Site Compra
		driver.get("http://automationpractice.com/index.php");
		page.clicarBotaoLogin();
		Assert.assertEquals("AUTHENTICATION", page.validarTelaLogin());

		// Usa E-mail Criado
		WebElement NewMail = page.campoEmailCriarUser();
		NewMail.clear();
		NewMail.sendKeys(GetMailText);
		page.clicaBotaoCriarConta();
		Thread.sleep(10000);

		// Cadastra novo user
		page.marcaMrs();
		Assert.assertTrue(page.validaMrs());
		page.nomeCad();
		page.sobrenomeCad();
		page.senhaCad();
		page.dayCad();
		page.monthCad();
		page.yearCad();
		page.enderecoCad();
		page.cityCad();
		page.stateCad();
		page.postalCodeCad();
		page.aliasCad();
		page.phoneCad();
		page.botaoCadastrar();

		// Vestido sendo posta no carrinho
		page.buscaPrintedChiffonDress();
		page.clicaBuscaProduto();
		Assert.assertEquals("Printed Chiffon Dress", page.validarPrintedChiffonDress());
		page.selecionaProduto();
		page.adicionaProdutoCarrinho();
		Thread.sleep(7000);
		Assert.assertEquals("Product successfully added to your shopping cart", page.ValidarVestidoNoCarrinho());
		page.clicaEmContinuaCompra();

		// Camiseta sendo posta no carrinho
		page.limparCampoBusca();
		page.buscarFadedShortSleeveTshirt();
		page.clicaBuscaProduto();
		Assert.assertEquals("Faded Short Sleeve T-shirts", page.validarFadedShortSleeveTshirts());
		page.selecionaProduto();
		page.adicionaProdutoCarrinho();
		Thread.sleep(7000);
		Assert.assertEquals("Product successfully added to your shopping cart", page.validaCamisetaNoCarrinho());

		// Finalização e confirmação do pedido
		page.clicaEmIrCheckout();
		page.clicaEmConfirmaResumoPedido();
		Assert.assertEquals("ADDRESSES", page.confirmaMsgAdresses());
		page.clicaEmConfirmaEndereco();
		page.marcarCheckBox();
		Assert.assertEquals("SHIPPING", page.confirmaTelaEntrega());
		Assert.assertTrue(page.isCheckBoxMarcado());
		page.clicaEmConfirmaEntrega();
		Assert.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", page.validaTelaEscolhaPagamento());
		page.clicaEmTipoPagamentoTransfBancaria();
		Assert.assertEquals("BANK-WIRE PAYMENT.", page.validaTipoPagamentoTransfBanc());
		page.nextPageConfirmaPedido();
		Assert.assertEquals("ORDER CONFIRMATION", page.validaPedidoRealizado());
	}
}
