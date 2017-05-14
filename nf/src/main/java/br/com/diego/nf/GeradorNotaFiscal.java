package br.com.diego.nf;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.zkoss.zhtml.Messagebox;


/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;*/

public class GeradorNotaFiscal {
	public void geraNota(Fatura f, Imposto imposto) {
				
		NotaFiscal notaFiscal = geraNotaFiscal(f, imposto);
			
		EnviarEmail enviaEmail = new EnviarEmail();
		enviaEmail.enviarEmail(f);
					 
		//armazenarNoBanco(notaFiscal);
		
		System.out.println("Nota Fiscal não esta sendo gravada no momento..");
		Messagebox.show("Nota Fiscal não esta sendo gravada...");
	}

	

	private void armazenarNoBanco(NotaFiscal notaFiscal) {
		// Armazenar no BD
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(notaFiscal);

		em.getTransaction().commit();
		em.close();
		*/
		
	}

	private NotaFiscal geraNotaFiscal(Fatura f, Imposto imposto) {
		double valorImposto = 0;

		valorImposto = imposto.getValor(f.getV());

		NotaFiscal notaFiscal = new NotaFiscal(valorImposto, f.getV());
		
		return notaFiscal;
	}
}
