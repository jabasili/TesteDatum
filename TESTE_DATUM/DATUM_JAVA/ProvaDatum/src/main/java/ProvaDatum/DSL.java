package ProvaDatum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private static final WebElement NewMail = null;
	private static final CharSequence GetMailText = null;
	private WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	//OBTER TEXTOS E ESCREVER TEXTOS
	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}
 
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	public void escreve(By by, String texto) {
		driver.findElement(by).sendKeys(texto);
	}

	public void escreve(String id_campo, String texto) {
		escreve(By.id(id_campo), texto);
	}

	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public String validarVestido() {
		return driver.findElement(By.xpath(".//h5[@itemprop]//a")).getText();
		}
	
	public String validarCamiseta() {
		return driver.findElement(By.xpath(".//h5[@itemprop]//a")).getText();
		}
	
	public String validarVestidoNoCarrinho() {
		return driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")).getText();
	}
	
	public String validarCamisetaNoCarrinho() {
		return driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")).getText();
	}
	
	public String validarTelaResumoPedido() {
		return driver.findElement(By.xpath(".//div[@id='center_column']//h1")).getText();
	}
	
	public String validarTelaEndereco() {
		return driver.findElement(By.xpath(".//div[@id='center_column']//h1")).getText();
	}
	
	public String validarTelaEntrega() {
		return driver.findElement(By.xpath(".//div[@id='center_column']//h1")).getText();
	}
	
	public String validarTelaFormaPagamento() {
		return driver.findElement(By.xpath(".//*[@id='center_column']//h1")).getText();
	}
	
	//BOTOES
	public void clicarBotaoXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clicarBotaoId(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarBotaoBusca(String name) {
		driver.findElement(By.name(name)).click();
	}
	
	public void clicarProduto(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void adicionarCarrinho(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void continuarComprando(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void limparCampo(String id) {
		driver.findElement(By.id(id)).clear();
	}
	
	public void irCheckout(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void confirmaResumoPedido(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void confirmaEndereco(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void marcaCheckBox(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void confirmaEntrega(String xpath) {
		driver.findElement(By.xpath(xpath)).click();

	}
	
	public void pagaTranferenciaBancaria(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void confirmaPedido(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clicaCriateAnAccount() {
		driver.findElement(By.id("SubmitCreate")).click();
	}
	
	public void cadastra() {
		driver.findElement(By.id("submitAccount")).click();
	}
	
	//RADIO E CHECKBOX
	
	public boolean isCheckBoxMarcado() {
		return driver.findElement(By.id("cgv")).isSelected();
	}
	
	public void marcaRadioBox() {
		driver.findElement(By.id("id_gender2")).click();
	}
	
	public boolean validaRadioBox() {
		return driver.findElement(By.id("id_gender2")).isSelected();
	}
	
	
	//CRIACAO DE EMAIL	
	public WebElement selecionaCreateAnAccount() {
		return driver.findElement(By.id("email_create"));		
	}
	
	public void entrarSiteEmailFake() {
		driver.get("https://www.invertexto.com/gerador-email-temporario");
	}
	
	public WebElement copiarEmailFake() {
		return driver.findElement(By.id("email-input"));
	}
	
	public void usaEmailFake() {
		NewMail.sendKeys(GetMailText);
	}
	
	
	//SETAR VALORES CADASTRO	
	public void setNomeCad() {
		driver.findElement(By.id("customer_firstname")).sendKeys("Jader");
	}
	
	public void setSobrenomeCad() {
		driver.findElement(By.id("customer_lastname")).sendKeys("Basili");
	}
	
	public void setSenha() {
		driver.findElement(By.id("passwd")).sendKeys("123456");
	}
	
	public void setDay() {
		Select selectDay = new Select(driver.findElement(By.id("days")));
		selectDay.selectByValue("28");
	}
	
	public void setMonth() {
		Select selectMonth = new Select(driver.findElement(By.id("months")));
		selectMonth.selectByValue("4");
	}
	public void setYear() {
		Select selectYear = new Select(driver.findElement(By.id("years")));
		selectYear.selectByValue("1988");
	}
	
	public void setAddress() {
		driver.findElement(By.id("address1")).sendKeys("Rua tal, 198");
	}
	
	public void setCity() {
		driver.findElement(By.id("city")).sendKeys("Paris");
	}
	
	public void setState() {
		Select selectState = new Select(driver.findElement(By.id("id_state")));
		selectState.selectByValue("6");
	}
	
	public void setPostaCode() {
		driver.findElement(By.id("postcode")).sendKeys("00000");
	}
	
	public void setAlias() {
		driver.findElement(By.id("alias")).clear();		
		driver.findElement(By.id("alias")).sendKeys("My New Address");
	}
	
	public void setPhone() {
		driver.findElement(By.id("phone_mobile")).sendKeys("51 997144790");
	}
}
