package br.com.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.entity.Pessoa;
import br.com.enumeration.TipoEmail;

public class EmailUtil implements Runnable {

	private Pessoa pessoa;
	private String senhaVisivel;
	private String assunto;
	private TipoEmail tipoEmail;

	// CONSTANTES PARA O ENVIO DE EMAIL
	private static final String HOST_NAME = "smtp.gmail.com";
	private static final int SMTP_PORT = 465;
	private static final String USER = "ucb.bepid@gmail.com";
	private static final String SENHA = "TccBepidTest";
	private static final String NICKNAME = "Bepid UCB";

	public EmailUtil() {
	}

	public EmailUtil(Pessoa pessoa, String senhaVisivel, String assunto) {
		setPessoa(pessoa);
		setSenhaVisivel(senhaVisivel);
		setAssunto(assunto);
	}

	public EmailUtil(Pessoa pessoa, String senhaVisivel, String assunto, TipoEmail tipoEmail) {
		setPessoa(pessoa);
		setSenhaVisivel(senhaVisivel);
		setAssunto(assunto);
		setTipoEmail(tipoEmail);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getSenhaVisivel() {
		return senhaVisivel;
	}

	public void setSenhaVisivel(String senhaVisivel) {
		this.senhaVisivel = senhaVisivel;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public TipoEmail getTipoEmail() {
		return tipoEmail;
	}

	public void setTipoEmail(TipoEmail tipoEmail) {
		this.tipoEmail = tipoEmail;
	}

	public HtmlEmail setConfiguracoes(HtmlEmail email, Pessoa pessoa) {
		try {
			email.setHostName(HOST_NAME);
			email.setSmtpPort(SMTP_PORT);
			email.setAuthenticator(new DefaultAuthenticator(USER, SENHA));
			email.setSSLOnConnect(true);
			email.setFrom(USER, NICKNAME);
			email.addTo(pessoa.getEmail(), pessoa.getNome());
		} catch (EmailException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return email;
	}

	public HtmlEmail setMsgEmailEsqueceuSenha(HtmlEmail email, Pessoa pessoa, String senha) {
		try {

			String htmlMsg = "<html>" + "	<body>" + "		" + "<h1>Bepid UCB</h1>"
					+ "		<h2>Recuperação de senha</h2>"
					+ "		<h3>Abaixo segue as informações do seu CPF e a nova senha requisitada.</h3>"
					+ "		<br>" + "		<label><b>CPF: " + pessoa.getCpf() + "</b></label>" + "		<br>"
					+ "		<label><b>Senha: " + senha + "</b></label>" + "	</body" + "</html>";

			String textMsg = "" + "Bepid UCB" + "<br>" + "Recuperação de senha" + "<br>"
					+ "Abaixo segue as informações do seu CPF e a nova senha requisitada." + "<br>" + "CPF: "
					+ pessoa.getCpf() + "<br>" + "Senha: " + senha;

			// configura a mensagem para o formato HTML
			email.setHtmlMsg(htmlMsg);
			// configure uma mensagem alternativa caso o servidor n�o suporte
			// HTML
			email.setTextMsg(textMsg);

		} catch (EmailException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return email;
	}

	public HtmlEmail setMsgEmailNovoCadastro(HtmlEmail email, Pessoa pessoa, String senha) {
		try {
			String htmlMsg = "<html>" + "	<body>" + "		<h1>Bepid UCB</h1>" + "		<h2>Senha para acesso</h2>"
					+ "		<h3>Abaixo segue as informações do seu CPF e a senha para acesso.</h3>" + "		<br>"
					+ "		<label><b>CPF: " + pessoa.getCpf() + "</b></label>" + "		<br>"
					+ "		<label><b>Senha: " + senha + "</b></label>" + "	</body" + "</html>";
			String textMsg = "" + "Bepid UCB" + "<br>" + "Senha para acesso" + "<br>"
					+ "Abaixo segue as informações do seu CPF e a senha para acesso." + "<br>" + "CPF: "
					+ pessoa.getCpf() + "<br>" + "Senha: " + senha;

			// configura a mensagem para o formato HTML
			email.setHtmlMsg(htmlMsg);
			// configure uma mensagem alternativa caso o servidor n�o suporte
			// HTML
			email.setTextMsg(textMsg);

		} catch (EmailException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return email;
	}

	public HtmlEmail setMsgEmailConfirmarCadastro(HtmlEmail email, Pessoa pessoa) {
		try {
			String htmlMsg = "<html>" + "	<body>" + "		<h1>Bepid UCB</h1>"
					+ "		<h2>Confirmação de cadastro</h2>"
					+ "		<h3>Seu cadastro foi confirmado pelo gestor.</h3>" + "		<br>" + "		<label><b>CPF: "
					+ pessoa.getCpf() + "</b></label>" + "		<br>" + "	</body" + "</html>";
			String textMsg = "" + "Bepid UCB" + "<br>" + "Confirmação de cadastro" + "<br>"
					+ "Seu cadastro foi confirmado pelo gestor." + "<br>" + "CPF: " + pessoa.getCpf() + "<br>";

			// configura a mensagem para o formato HTML
			email.setHtmlMsg(htmlMsg);
			// configure uma mensagem alternativa caso o servidor não suporte
			// HTML
			email.setTextMsg(textMsg);

		} catch (EmailException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return email;
	}

	public void enviaEmail(Pessoa pessoa, String senha, String assunto) {
		try {

			// Cria o e-mail
			HtmlEmail email = new HtmlEmail();
			email = setConfiguracoes(email, pessoa);
			email.setSubject(assunto);

			switch (getTipoEmail()) {
			case ESQUECEU_SENHA:
				setMsgEmailEsqueceuSenha(email, pessoa, senha);
				break;
			case NOVO_CADASTRO:
				System.out.println("entrou novo cadastro");
				setMsgEmailNovoCadastro(email, pessoa, senha);
				break;
			case CONFIRMACAO_CADASTRO:
				setMsgEmailConfirmarCadastro(email, pessoa);
				break;
			}

			// adiciona uma imagem ao corpo da mensagem e retorna seu id
			// URL url = new
			// URL("http://www.apache.org/images/asf_logo_wide.gif");
			// String cid = email.embed(url, "Apache logo");

			// inserindo a mensagem do email

			// envia o e-mail
			email.send();
		} catch (EmailException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("ENVIOU E-MAIL");

		enviaEmail(getPessoa(), getSenhaVisivel(), getAssunto());
	}

}
