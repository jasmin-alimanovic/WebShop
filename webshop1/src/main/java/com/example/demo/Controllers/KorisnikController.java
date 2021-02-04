package com.example.demo.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.Entity.Kategorija;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Proizvod;
import com.example.demo.Repository.KategorijaRepository;
import com.example.demo.Repository.KorisnikRepository;
import com.example.demo.Service.ProizvodService;



@RestController
public class KorisnikController {
	
	@Autowired
	KorisnikRepository korisnikRepo;
	
	@Autowired
	KategorijaRepository kategorijaRepo;
	
	@Autowired
	ProizvodService proizvodService;

	@RequestMapping("/register")
	public ModelAndView RegisterView()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}
	
	@PostMapping("/registracija" )
	public RedirectView Registracija(Korisnik korisnik, HttpServletRequest request)
	{
		//service.saveKnjiga(knjiga);
		System.out.println(korisnik.getIme());
		System.out.println(korisnik.getEmail());
		System.out.println(korisnik.getRole().getId());
		
		korisnikRepo.save(korisnik);
		
		
		return new RedirectView("login");
	}
	@RequestMapping("/login")
	public ModelAndView LoginView()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/logiranje" )
	public RedirectView Login(Korisnik korisnik, HttpServletRequest request, RedirectAttributes redirectAttributes) throws AuthenticationException, Exception
	{
		//service.saveKnjiga(knjiga);
		
		
		String poruka="";
		Korisnik dataUser = korisnikRepo.findByEmailAndPassword(korisnik.getEmail(), korisnik.getPassword());
		if(dataUser != null)
		{
			/*UsernamePasswordAuthenticationToken authReq
		      = new UsernamePasswordAuthenticationToken(korisnik.getUsername(), korisnik.getPassword());
			Authentication auth =  authenticationManager.authenticate(authReq);
		    
		    SecurityContext sc = SecurityContextHolder.getContext();
		    sc.setAuthentication(auth);
		    HttpSession session = request.getSession(true);
		    session.setAttribute("SPRING_SECURITY_CONTEXT_KEY", sc);
		    */
			request.getSession().setAttribute("user", dataUser);
			request.getSession().setMaxInactiveInterval(1000*60*60*24*365);
			return new RedirectView("user/home");
		}
		
		else {
			poruka="Incorrect email or password";
			redirectAttributes.addFlashAttribute("poruka", poruka);
			return new RedirectView("/login");
		}
	}
	
	
	@RequestMapping("/user/home")
	public ModelAndView user_home(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user-home");
		Korisnik k = (Korisnik)request.getSession().getAttribute("user");
		mv.addObject("user", k);
		List<Kategorija> kategorije = kategorijaRepo.findAll();
		mv.addObject("kategorije", kategorije);
		
		List<Proizvod> proizvodi = proizvodService.getProizvode();
		mv.addObject("proizvodi", proizvodi);
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
}
