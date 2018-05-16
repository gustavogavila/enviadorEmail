package br.com.gustavogavila.enviadorEmail.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void enviar(String nome, String emailConvidado) {
		
		try {
			Email email = new SimpleEmail();
			// Preencher com as informações do seu serviço de e-mail
			email.setHostName("host do seu email");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("seuemail@servico.com", "suaSenha"));
			email.setStartTLSRequired(true);
			email.setStartTLSEnabled(true);
			
			email.setFrom("seuemail@servico.com");
			email.setSubject("Assunto do email");
			email.setMsg("Olá " + nome + ", você foi convidado para nomeDaAplicação!");
			email.addTo(emailConvidado);
			email.send();
		
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
