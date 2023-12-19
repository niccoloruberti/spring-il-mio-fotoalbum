package org.java.spring;

import org.java.spring.auth.conf.AuthConf;
import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.serv.RoleService;
import org.java.spring.auth.db.serv.UserService;
import org.java.spring.db.pojo.Category;
import org.java.spring.db.pojo.Photo;
import org.java.spring.db.serv.CategoryService;
import org.java.spring.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category("Ritratti");
		Category cat2 = new Category("Paesaggi");
		Category cat3 = new Category("Architettura");
		Category cat4 = new Category("Street Photography");
		Category cat5 = new Category("Natura Morta");
		Category cat6 = new Category("Macrofotografia");
		Category cat7 = new Category("Fotografia Astronomica");
		Category cat8 = new Category("Fotografia Documentaristica");
		Category cat9 = new Category("Fotografia di Moda");
		Category cat10 = new Category("Fotografia Culinarie");
		
		categoryService.save(cat1);
		categoryService.save(cat2);
		categoryService.save(cat3);
		categoryService.save(cat4);
		categoryService.save(cat5);
		categoryService.save(cat6);
		categoryService.save(cat7);
		categoryService.save(cat8);
		categoryService.save(cat9);
		categoryService.save(cat10);
		
		
		Photo ph1 = new Photo("Pranzo Sul Grattacielo", "Una delle immagini più impressionanti della storia è sicuramente quella degli undici operai che consumano il pranzo seduti su una trave sospesa a 250 metri d'altezza. Si tratta degli operai che lavorarono alla costruzione del Rockefeller Center di New York.  Era il 1932 e questa immagine testimoniava la ripresa americana dopo la Grande Depressione del 29. Questo era il messaggio che doveva emergere dalle pagine del  supplemento domenicale del New York Herald Tribune che la pubblicò.", "https://www.focus.it/site_stored/imgs/0005/014/pranzosugrattacielo.630x360.jpg", true, cat1, cat3, cat6);
		Photo ph2 = new Photo("La Ragazza Afghana", "Realizzata nel 1984 dal fotografo statunitense, la fotografia è frutto di un reportage nei campi profughi allestiti lungo la frontiera afgano-pakistana. McCurry la realizzò in una classe, in una di quelle scuole di fortuna per rifugiati.", "https://www.artribune.com/wp-content/uploads/2021/11/Steve-McCurry-%E2%80%93-Sharbat-Gula-ragazza-afgana-al-campo-profughi-di-Nasir-Bagh-vicino-a-Peshawar-%E2%80%93-Pakistan-1984-1.jpg", true, cat5,cat8,cat10);
		Photo ph3 = new Photo("Collina di Windows", "Il suo vero nome è Bliss (beatitudine), ma per tutti è la 'collina di Windows'. Si tratta dello sfondo per il desktop più celebre del sistema operativo Microsoft ed è una foto scattata 25 anni fa: era il 1996 quando a immortalarla era stato Charles O'Rear, fotografo del National Geographic. Oggi, un quarto di secolo dopo, il paesaggio è radicalmente cambiato fino a diventare irriconoscibile.", "https://upload.wikimedia.org/wikipedia/it/thumb/d/d3/Colline_%28immagine%29.jpg/640px-Colline_%28immagine%29.jpg", true, cat4, cat7,cat3,cat9);
		Photo ph4 = new Photo("Il Primo Abbraccio", "L'immagine mostra il primo abbraccio ricevuto da Rosa in cinque mesi a causa del Coronavirus. A marzo, le case di cura in Brasile avevano chiuso le porte a tutti i visitatori a causa della pandemia COVID-19, impedendo a milioni di brasiliani di visitare i loro parenti anziani. Agli assistenti è stato ordinato di mantenere al minimo il contatto fisico con le persone vulnerabili.", "https://cloud1.nurse24.it/images/varie/abbraccio-covid.jpg", true, cat5,cat8,cat3,cat4,cat1);
		Photo ph5 = new Photo("Proteste contro il presidente venezuelano", "La foto mostra un ragazzo che indossa una maglietta che sta bruciando; è stata scattata durante le manifestazione di protesta contro il presidente venezuelano Nicolas Maduro, avvenute a Caracas nel maggio 2017.", "https://i1.adis.ws/i/canon/Canon-Pro-WPP-winners-1-Ronaldo-Schemidt_Agence-France-Presse-1140?$og-image$", true, cat5,cat8,cat3,cat4,cat1);
		Photo ph6 = new Photo("Lucky Break", "Una procione sporse la testa da un'auto abbandonata e si fermò per valutare l'ambiente circostante, dando a Jason il tempo sufficiente per utilizzare un'esposizione prolungata nel crepuscolo. Il sedile posteriore era un rifugio ideale per la procione e i suoi cinque cuccioli, poiché l'unico ingresso, attraverso un foro smussato nel vetro, era abbastanza grande per lei ma troppo piccolo per predatori come i coyote.", "https://www.nhm.ac.uk/resources/visit/wpy/2019/large/59.jpg", true, cat5,cat8,cat3,cat4,cat1);
		
		photoService.save(ph1);
		photoService.save(ph2);
		photoService.save(ph3);
		photoService.save(ph4);
		photoService.save(ph5);
		photoService.save(ph6);
		
		Role r1 = new Role("ADMIN");
		roleService.save(r1);
		
		String pws1 = AuthConf.passwordEncoder().encode("password-1");
		userService.save(new User("utente-1", pws1, r1));
	}

}
