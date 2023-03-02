package com.DigitalContentV2.DigitalContentv2.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DigitalContentV2.DigitalContentv2.facadeImp.SendMailService;
import com.DigitalContentV2.DigitalContentv2.facadeImp.Usuariodao;
import com.DigitalContentV2.DigitalContentv2.modelo.Mail;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;

@RequestMapping("/mail")
@Controller
public class SendMailController {

	@Autowired
	private SendMailService sendMailService;
	
	@Autowired
	private Usuariodao usuarioDao;
	
	@GetMapping("/view")
	public String mail() {
	
		
		return "mail_view";
	}
	
	@GetMapping("/correos")
	public String correos(String correos,Model model) {
		List<Usuario> listaCorreos = usuarioDao.listaCorreos(correos);
		model.addAttribute("listaCorreos", listaCorreos);
		return "mail_view";
	}
	
	
	 @PostMapping("/sendMail")
	    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body){

	        String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nCorreo: " + mail;
	        sendMailService.sendMail("digitialcontent@gmail.com",mail,subject,message);

	        return "mail_view";
	    }
	 
	 @PostMapping("/sendMailWithTemplate")
	 public String sendMailTemplate(Mail mail) throws MessagingException, IOException {
		 
		 mail.setFrom("digitialcontent@gmail.com");
		 mail.setMailTo("bayronstivenramirezpachon28@gmail.com");
		 mail.setSubject("Hola esta es la prueba 1");
		 
		 sendMailService.sendEmailTemplate(mail);
		 
		 return "mail_view";
		 
	 }
	 
	 
}
