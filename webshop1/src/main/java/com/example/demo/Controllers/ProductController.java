package com.example.demo.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.Entity.Kategorija;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Korpa;
import com.example.demo.Entity.Narudzba;
import com.example.demo.Entity.NarudzbaStavke;
import com.example.demo.Entity.ProductCreationDto;
import com.example.demo.Entity.Proizvod;
import com.example.demo.Entity.Status;
import com.example.demo.Repository.KategorijaRepository;
import com.example.demo.Repository.KorpaRepository;
import com.example.demo.Repository.NarudzbaRepository;
import com.example.demo.Repository.NarudzbeStavkeRepository;
import com.example.demo.Service.ProizvodService;

@RestController
public class ProductController {

	
	@Autowired
	ProizvodService proizvodService;
	
	@Autowired
	KategorijaRepository kategorijeRepo;
	
	@Autowired
	KorpaRepository korpaRepo;
	
	@Autowired
	NarudzbaRepository narudzbaRepo;
	
	@Autowired
	NarudzbeStavkeRepository narudzbaStavkeRepo;
	
	@PostMapping("/addProduct" )
	public RedirectView AddProizvod(Proizvod p, HttpServletRequest request)
	{
		System.out.println(p.getName());
		System.out.println(p.getKolicina());
		System.out.println(p.getOpis());
		System.out.println(p.getKategorija().getId());
		System.out.println(p.getKorisnik().getId());
		
		proizvodService.saveProizvod(p);
		return new RedirectView("user/home");
	}
	
	@RequestMapping("/product")
	public ModelAndView ShowProductDetail(@RequestParam(name = "id") int id, HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		Korisnik k = (Korisnik)request.getSession().getAttribute("user");
		mv.addObject("user", k);
		mv.setViewName("product");
		Proizvod p = proizvodService.getProizvodeById(id);
		mv.addObject("proizvod", p);
		return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView Edit(@RequestParam(name = "id") int id, HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		Korisnik k = (Korisnik)request.getSession().getAttribute("user");
		mv.addObject("user", k);
		mv.setViewName("izmjena");
		Proizvod p = proizvodService.getProizvodeById(id);
		mv.addObject("proizvod", p);
		List<Kategorija> kategorije = kategorijeRepo.findAll();
		mv.addObject("kategorije", kategorije);
		return mv;
	}
	
	@PostMapping("/updateProduct" )
	public RedirectView updateProizvod(Proizvod p, HttpServletRequest request)
	{
		proizvodService.updateProizvod(p);
		return new RedirectView("user/home");
	}
	
	@RequestMapping("/addtocart")
	public RedirectView AddToCart(@RequestParam(name="id") int id, HttpServletRequest request)
	{
		Korisnik k = (Korisnik)request.getSession().getAttribute("user");
		Korpa korpa = new Korpa();
		korpa.setKorisnik(k);
		korpa.setProizvod_id(id);
		korpaRepo.save(korpa);
		
		return new RedirectView("/user/home");
	}
	@RequestMapping("/cart")
	public ModelAndView Cart(HttpServletRequest request)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart");
		
		List<Proizvod> proizvodi = new ArrayList<>();
		Korisnik k = (Korisnik)request.getSession().getAttribute("user");
		List<Korpa> korpa = korpaRepo.findByKorisnik_id(k.getId());
		ProductCreationDto pr = new ProductCreationDto();
		for(int i=0; i<korpa.size(); i++)
		{
			pr.addProduct(new Proizvod());
		}
		for(Korpa ko : korpa)
		{
			Proizvod p = proizvodService.getProizvodeById(ko.getProizvod_id());
			proizvodi.add(p);
		}
		for(Proizvod p : proizvodi)
		{
			System.out.println(p.getName());
			System.out.println(p.getKolicina());
		}
		mv.addObject("proizvodi", proizvodi);
		mv.addObject("form", pr);
		mv.addObject("user", k);
		
		return mv;
	}
	
	@PostMapping("/order")
	public RedirectView Order(@ModelAttribute ProductCreationDto proizvodi, HttpServletRequest request)
	{
		Korisnik k = (Korisnik)request.getSession().getAttribute("user");
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String dtm = formatter.format(date);
		Narudzba n = new Narudzba();
		n.setDtm(dtm);
		n.setKorisnik(k);
		n.setStatus(new Status(1));
		narudzbaRepo.save(n);
		Narudzba dbNar = narudzbaRepo.findByDtm(dtm);
		
		List<NarudzbaStavke> stavke = narudzbaStavkeRepo.findAll();
		int brojac = 1;
		for(Proizvod p : proizvodi.getProizvodi())
		{
			NarudzbaStavke ns = new NarudzbaStavke();
			ns.setKolicina(p.getKolicina());
			ns.setNarudzba(dbNar);
			ns.setProizvod(new Proizvod(p.getId()));
			ns.setId(brojac + stavke.size());
			brojac+=1;
			System.out.println("Narudzbe");
			System.out.println(ns.getNarudzba().getId());
			System.out.println(ns.getProizvod().getId());
			System.out.println(ns.getId());
			int dbKolicina = proizvodService.getProizvodeById(p.getId()).getKolicina() - p.getKolicina();
			proizvodService.UpdateKolicina(dbKolicina, p.getId());
			narudzbaStavkeRepo.save(ns);
		}
		
		List<Korpa> korpe = korpaRepo.findByKorisnik_id(k.getId());
		for(Korpa kor : korpe)
		{
			korpaRepo.deleteById(kor.getId());
		}
		
		return new RedirectView("/user/home");
	}
	
	
	
	@RequestMapping("/products")
	public ModelAndView Products()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("allproducts");
		List<Proizvod> proizvodi = proizvodService.getProizvode();
		mv.addObject("proizvodi", proizvodi);
		return mv;
	}
	
	
	
	
	
	
	
	
}
