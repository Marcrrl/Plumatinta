package com.proyecto.plumatinta;
import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.proyecto.plumatinta.repository.LibroRepository;
import com.proyecto.plumatinta.repository.UsuarioRepository;
import com.proyecto.plumatinta.model.Autor;
import com.proyecto.plumatinta.model.Carrito;
import com.proyecto.plumatinta.model.Editorial;
import com.proyecto.plumatinta.model.Genero;
import com.proyecto.plumatinta.model.Libro;
import com.proyecto.plumatinta.model.LineaPedido;
import com.proyecto.plumatinta.model.Pedido;
import com.proyecto.plumatinta.model.Usuario;
import com.proyecto.plumatinta.repository.AutorRepository;
import com.proyecto.plumatinta.repository.GeneroRepository;
import com.proyecto.plumatinta.repository.EditorialRepository;
import com.proyecto.plumatinta.repository.PedidoRepository;
import com.proyecto.plumatinta.repository.LineaPedidoRepository;
import com.proyecto.plumatinta.repository.CarritoRepository;

@SpringBootApplication
public class PlumatintaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlumatintaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(
            LibroRepository bookRepository,
            UsuarioRepository usuarioRepository,
            AutorRepository autorRepository,
            GeneroRepository generoRepository,
            EditorialRepository editorialRepository,
            PedidoRepository pedidoRepository,
            LineaPedidoRepository lineaPedidoRepository,
            CarritoRepository carritoRepository,
            BCryptPasswordEncoder passwordEncoder) {
        return (args) -> {
            Editorial editorial1 = new Editorial();
            editorial1.setNombre("SAGA");
            editorialRepository.save(editorial1);

            Editorial editorial2 = new Editorial();
            editorial2.setNombre("Minotauro");
            editorialRepository.save(editorial2);

            Editorial editorial3 = new Editorial();
            editorial3.setNombre("Salamandra");
            editorialRepository.save(editorial3);

            Editorial editorial4 = new Editorial();
            editorial4.setNombre("Plaza & Janés");
            editorialRepository.save(editorial4);

            Editorial editorial5 = new Editorial();
            editorial5.setNombre("Alianza");
            editorialRepository.save(editorial5);

            Editorial editorial6 = new Editorial();
            editorial6.setNombre("Austral");
            editorialRepository.save(editorial6);

            // Autores
            Autor autor1 = new Autor();
            autor1.setNombre("Brandon");
            autor1.setApellidos("Sanderson");
            autorRepository.save(autor1);

            Autor autor2 = new Autor();
            autor2.setNombre("J.K.");
            autor2.setApellidos("Rowling");
            autorRepository.save(autor2);

            Autor autor3 = new Autor();
            autor3.setNombre("J.R.R.");
            autor3.setApellidos("Tolkien");
            autorRepository.save(autor3);

            Autor autor4 = new Autor();
            autor4.setNombre("George");
            autor4.setApellidos("R. R. Martin");
            autorRepository.save(autor4);

            Autor autor5 = new Autor();
            autor5.setNombre("Dante");
            autor5.setApellidos("Alighieri");
            autorRepository.save(autor5);

            Autor autor6 = new Autor();
            autor6.setNombre("Autor");
            autor6.setApellidos("Ejemplo");
            autorRepository.save(autor6);

            // Generos
            Genero genero1 = new Genero();
            genero1.setGenero("Ficción");
            generoRepository.save(genero1);

            Genero genero2 = new Genero();
            genero2.setGenero("No Ficción");
            generoRepository.save(genero2);

            Genero genero3 = new Genero();
            genero3.setGenero("Ciencia");
            generoRepository.save(genero3);

            Genero genero4 = new Genero();
            genero4.setGenero("Historia");
            generoRepository.save(genero4);

            Genero genero5 = new Genero();
            genero5.setGenero("Fantasía");
            generoRepository.save(genero5);

            Genero genero6 = new Genero();
            genero6.setGenero("Misterio");
            generoRepository.save(genero6);

            // Usuarios
            Usuario usuario1 = new Usuario();
            usuario1.setNombre("Marc");
            usuario1.setApellidos("Ricart");
            usuario1.setContraseña(passwordEncoder.encode("123"));
            usuario1.setEmail("marc@ricart.com");
            usuario1.setRol("cliente");
            usuario1.setDni("12345678A");
            usuario1.setDireccion("Calle 1");
            usuario1.setTelefono("123456789");
            usuarioRepository.save(usuario1);

            Usuario usuario2 = new Usuario();
            usuario2.setNombre("Sergio");
            usuario2.setApellidos("Arjona");
            usuario2.setContraseña(passwordEncoder.encode("sergio"));
            usuario2.setEmail("sergio@arjona.com");
            usuario2.setRol("admin");
            usuario2.setDni("23456789B");
            usuario2.setDireccion("Calle 2");
            usuario2.setTelefono("987654321");
            usuarioRepository.save(usuario2);

            Usuario usuario3 = new Usuario();
            usuario3.setNombre("Ruben");
            usuario3.setApellidos("Filadetrás");
            usuario3.setContraseña(passwordEncoder.encode("ruben"));
            usuario3.setEmail("ruben@filadetras.com");
            usuario3.setRol("cliente");
            usuario3.setDni("23456789C");
            usuario3.setDireccion("Calle 3");
            usuario3.setTelefono("987654321");
            usuarioRepository.save(usuario3);

            Usuario usuario4 = new Usuario();
            usuario4.setNombre("admin");
            usuario4.setApellidos("admin");
            usuario4.setContraseña(passwordEncoder.encode("admin"));
            usuario4.setEmail("admin@admin.com");
            usuario4.setRol("admin");
            usuario4.setDni("23456789D");
            usuario4.setDireccion("Calle 4");
            usuario4.setTelefono("987654321");
            usuarioRepository.save(usuario4);

            Usuario usuario5 = new Usuario();
            usuario5.setNombre("Jorge");
            usuario5.setApellidos("Fabro");
            usuario5.setContraseña(passwordEncoder.encode("jorge"));
            usuario5.setEmail("jorge@fabro.com");
            usuario5.setRol("cliente");
            usuario5.setDni("23456789E");
            usuario5.setDireccion("Calle 5");
            usuario5.setTelefono("987654321");
            usuarioRepository.save(usuario5);

            // Libros
            Libro libro1 = new Libro();
            libro1.setTitle("Divina Comedia");
            libro1.setAuthor("Dante Alighieri");
            libro1.setIsbn("ISBN0001");
            libro1.setNumPages(300);
            libro1.setPrice(20.00);
            libro1.setImage("imagen1.jpg");
            libro1.setStock(100);
            libro1.setGenero(genero1);
            libro1.setAutor(autor5); // Asignar autor
            bookRepository.save(libro1);

            Libro libro2 = new Libro();
            libro2.setTitle("La Casa de Juan");
            libro2.setAuthor("Autor Ejemplo");
            libro2.setIsbn("ISBN0002");
            libro2.setNumPages(250);
            libro2.setPrice(25.00);
            libro2.setImage("imagen1.jpg");
            libro2.setStock(100);
            libro2.setGenero(genero1);
            libro2.setAutor(autor6); // Asignar autor
            bookRepository.save(libro2);

            Libro libro3 = new Libro();
            libro3.setTitle("La Fundación");
            libro3.setAuthor("Autor Ejemplo");
            libro3.setIsbn("ISBN0003");
            libro3.setNumPages(320);
            libro3.setPrice(22.50);
            libro3.setImage("imagen1.jpg");
            libro3.setStock(100);
            libro3.setGenero(genero1);
            libro3.setAutor(autor6); // Asignar autor
            bookRepository.save(libro3);

            Libro libro4 = new Libro();
            libro4.setTitle("El Acero de Madrid");
            libro4.setAuthor("Autor Ejemplo");
            libro4.setIsbn("ISBN0004");
            libro4.setNumPages(400);
            libro4.setPrice(18.00);
            libro4.setImage("imagen1.jpg");
            libro4.setStock(100);
            libro4.setGenero(genero1);
            libro4.setAutor(autor6); // Asignar autor
            bookRepository.save(libro4);

            Libro libro5 = new Libro();
            libro5.setTitle("Bodas de Sangre");
            libro5.setAuthor("Autor Ejemplo");
            libro5.setIsbn("ISBN0005");
            libro5.setNumPages(280);
            libro5.setPrice(23.50);
            libro5.setImage("imagen1.jpg");
            libro5.setStock(100);
            libro5.setGenero(genero1);
            libro5.setAutor(autor6); // Asignar autor
            bookRepository.save(libro5);

            Libro libro6 = new Libro();
            libro6.setTitle("Eudy");
            libro6.setAuthor("Autor Ejemplo");
            libro6.setIsbn("ISBN0006");
            libro6.setNumPages(340);
            libro6.setPrice(19.75);
            libro6.setImage("imagen1.jpg");
            libro6.setStock(100);
            libro6.setGenero(genero1);
            libro6.setAutor(autor6); // Asignar autor
            bookRepository.save(libro6);

            Libro libro7 = new Libro();
            libro7.setTitle("Sainetes");
            libro7.setAuthor("Dante Alighieri");
            libro7.setIsbn("ISBN0007");
            libro7.setNumPages(360);
            libro7.setPrice(21.00);
            libro7.setImage("imagen1.jpg");
            libro7.setStock(100);
            libro7.setGenero(genero1);
            libro7.setAutor(autor5); // Asignar autor
            bookRepository.save(libro7);

            Libro libro8 = new Libro();
            libro8.setTitle("La Vida es un Sueño");
            libro8.setAuthor("Dante Alighieri");
            libro8.setIsbn("ISBN0008");
            libro8.setNumPages(300);
            libro8.setPrice(20.00);
            libro8.setImage("imagen1.jpg");
            libro8.setStock(100);
            libro8.setGenero(genero1);
            libro8.setAutor(autor5); // Asignar autor
            bookRepository.save(libro8);

            Libro libro9 = new Libro();
            libro9.setTitle("Aves de España");
            libro9.setAuthor("Dante Alighieri");
            libro9.setIsbn("ISBN1001");
            libro9.setNumPages(200);
            libro9.setPrice(30.00);
            libro9.setImage("imagen1.jpg");
            libro9.setStock(100);
            libro9.setGenero(genero2);
            libro9.setAutor(autor5); // Asignar autor
            bookRepository.save(libro9);

            Libro libro10 = new Libro();
            libro10.setTitle("Los Arboles Mágicos");
            libro10.setAuthor("Autor Ejemplo");
            libro10.setIsbn("ISBN1002");
            libro10.setNumPages(240);
            libro10.setPrice(27.50);
            libro10.setImage("imagen1.jpg");
            libro10.setStock(100);
            libro10.setGenero(genero2);
            libro10.setAutor(autor6); // Asignar autor
            bookRepository.save(libro10);

            Libro libro11 = new Libro();
            libro11.setTitle("El Gen Egoista");
            libro11.setAuthor("Dante Alighieri");
            libro11.setIsbn("ISBN1003");
            libro11.setNumPages(180);
            libro11.setPrice(29.00);
            libro11.setImage("imagen1.jpg");
            libro11.setStock(100);
            libro11.setGenero(genero2);
            libro11.setAutor(autor5); // Asignar autor
            bookRepository.save(libro11);

            Libro libro12 = new Libro();
            libro12.setTitle("Cronobiologia");
            libro12.setAuthor("Autor Ejemplo");
            libro12.setIsbn("ISBN1004");
            libro12.setNumPages(260);
            libro12.setPrice(25.00);
            libro12.setImage("imagen1.jpg");
            libro12.setStock(100);
            libro12.setGenero(genero2);
            libro12.setAutor(autor6); // Asignar autor
            bookRepository.save(libro12);

            Libro libro13 = new Libro();
            libro13.setTitle("Un Inmenso Azul");
            libro13.setAuthor("Dante Alighieri");
            libro13.setIsbn("ISBN1005");
            libro13.setNumPages(290);
            libro13.setPrice(22.50);
            libro13.setImage("imagen1.jpg");
            libro13.setStock(100);
            libro13.setGenero(genero2);
            libro13.setAutor(autor5); // Asignar autor
            bookRepository.save(libro13);

            Libro libro14 = new Libro();
            libro14.setTitle("El Collar del Neandertal");
            libro14.setAuthor("Dante Alighieri");
            libro14.setIsbn("ISBN1006");
            libro14.setNumPages(310);
            libro14.setPrice(31.00);
            libro14.setImage("imagen1.jpg");
            libro14.setStock(100);
            libro14.setGenero(genero2);
            libro14.setAutor(autor5); // Asignar autor
            bookRepository.save(libro14);

            Libro libro15 = new Libro();
            libro15.setTitle("Tu Primer Pasado");
            libro15.setAuthor("Autor Ejemplo");
            libro15.setIsbn("ISBN1007");
            libro15.setNumPages(220);
            libro15.setPrice(26.75);
            libro15.setImage("imagen1.jpg");
            libro15.setStock(100);
            libro15.setGenero(genero2);
            libro15.setAutor(autor6); // Asignar autor
            bookRepository.save(libro15);

            Libro libro16 = new Libro();
            libro16.setTitle("Hombres Fósiles");
            libro16.setAuthor("Dante Alighieri");
            libro16.setIsbn("ISBN1008");
            libro16.setNumPages(150);
            libro16.setPrice(24.00);
            libro16.setImage("imagen1.jpg");
            libro16.setStock(100);
            libro16.setGenero(genero2);
            libro16.setAutor(autor5); // Asignar autor
            bookRepository.save(libro16);

            Libro libro17 = new Libro();
            libro17.setTitle("Niebla Roja");
            libro17.setAuthor("Dante Alighieri");
            libro17.setIsbn("ISBN2001");
            libro17.setNumPages(330);
            libro17.setPrice(32.00);
            libro17.setImage("imagen1.jpg");
            libro17.setStock(100);
            libro17.setGenero(genero3);
            libro17.setAutor(autor5); // Asignar autor
            bookRepository.save(libro17);

            Libro libro18 = new Libro();
            libro18.setTitle("Escuadrón");
            libro18.setAuthor("Autor Ejemplo");
            libro18.setIsbn("ISBN2002");
            libro18.setNumPages(340);
            libro18.setPrice(34.50);
            libro18.setImage("imagen1.jpg");
            libro18.setStock(100);
            libro18.setGenero(genero3);
            libro18.setAutor(autor6); // Asignar autor
            bookRepository.save(libro18);

            Libro libro19 = new Libro();
            libro19.setTitle("El Imperio Oscuro");
            libro19.setAuthor("Autor Ejemplo");
            libro19.setIsbn("ISBN2003");
            libro19.setNumPages(310);
            libro19.setPrice(35.00);
            libro19.setImage("imagen1.jpg");
            libro19.setStock(100);
            libro19.setGenero(genero3);
            libro19.setAutor(autor6); // Asignar autor
            bookRepository.save(libro19);

            Libro libro20 = new Libro();
            libro20.setTitle("Estelar");
            libro20.setAuthor("Autor Ejemplo");
            libro20.setIsbn("ISBN2004");
            libro20.setNumPages(295);
            libro20.setPrice(30.00);
            libro20.setImage("imagen1.jpg");
            libro20.setStock(100);
            libro20.setGenero(genero3);
            libro20.setAutor(autor6); // Asignar autor
            bookRepository.save(libro20);

            Libro libro21 = new Libro();
            libro21.setTitle("Desafiante");
            libro21.setAuthor("Autor Ejemplo");
            libro21.setIsbn("ISBN2005");
            libro21.setNumPages(325);
            libro21.setPrice(33.00);
            libro21.setImage("imagen1.jpg");
            libro21.setStock(100);
            libro21.setGenero(genero3);
            libro21.setAutor(autor6); // Asignar autor
            bookRepository.save(libro21);

            Libro libro22 = new Libro();
            libro22.setTitle("Los Juegos de Nemesis");
            libro22.setAuthor("Autor Ejemplo");
            libro22.setIsbn("ISBN2006");
            libro22.setNumPages(310);
            libro22.setPrice(31.50);
            libro22.setImage("imagen1.jpg");
            libro22.setStock(100);
            libro22.setGenero(genero3);
            libro22.setAutor(autor6); // Asignar autor
            bookRepository.save(libro22);

            Libro libro23 = new Libro();
            libro23.setTitle("Silo");
            libro23.setAuthor("Dante Alighieri");
            libro23.setIsbn("ISBN2007");
            libro23.setNumPages(280);
            libro23.setPrice(29.00);
            libro23.setImage("imagen1.jpg");
            libro23.setStock(100);
            libro23.setGenero(genero3);
            libro23.setAutor(autor5); // Asignar autor
            bookRepository.save(libro23);

            Libro libro24 = new Libro();
            libro24.setTitle("Artemisa");
            libro24.setAuthor("Autor Ejemplo");
            libro24.setIsbn("ISBN2008");
            libro24.setNumPages(300);
            libro24.setPrice(30.00);
            libro24.setImage("imagen1.jpg");
            libro24.setStock(100);
            libro24.setGenero(genero3);
            libro24.setAutor(autor6); // Asignar autor
            bookRepository.save(libro24);

            Libro libro25 = new Libro();
            libro25.setTitle("Nexus");
            libro25.setAuthor("Autor Ejemplo");
            libro25.setIsbn("ISBN3001");
            libro25.setNumPages(300);
            libro25.setPrice(28.00);
            libro25.setImage("imagen1.jpg");
            libro25.setStock(100);
            libro25.setGenero(genero4);
            libro25.setAutor(autor6); // Asignar autor
            bookRepository.save(libro25);

            Libro libro26 = new Libro();
            libro26.setTitle("Mein Kampf");
            libro26.setAuthor("Autor Ejemplo");
            libro26.setIsbn("ISBN3002");
            libro26.setNumPages(310);
            libro26.setPrice(27.00);
            libro26.setImage("mein.jpg");
            libro26.setStock(100);
            libro26.setGenero(genero4);
            libro26.setAutor(autor6); // Asignar autor
            bookRepository.save(libro26);

            Libro libro27 = new Libro();
            libro27.setTitle("La Bailarina de Auschwitz");
            libro27.setAuthor("Dante Alighieri");
            libro27.setIsbn("ISBN3003");
            libro27.setNumPages(320);
            libro27.setPrice(29.50);
            libro27.setImage("imagen1.jpg");
            libro27.setStock(100);
            libro27.setGenero(genero4);
            libro27.setAutor(autor5); // Asignar autor
            bookRepository.save(libro27);

            Libro libro28 = new Libro();
            libro28.setTitle("El Olor de la Edad Media");
            libro28.setAuthor("Autor Ejemplo");
            libro28.setIsbn("ISBN3004");
            libro28.setNumPages(330);
            libro28.setPrice(30.50);
            libro28.setImage("imagen1.jpg");
            libro28.setStock(100);
            libro28.setGenero(genero4);
            libro28.setAutor(autor6); // Asignar autor
            bookRepository.save(libro28);

            Libro libro29 = new Libro();
            libro29.setTitle("Historia de Roma");
            libro29.setAuthor("Dante Alighieri");
            libro29.setIsbn("ISBN3005");
            libro29.setNumPages(340);
            libro29.setPrice(31.00);
            libro29.setImage("imagen1.jpg");
            libro29.setStock(100);
            libro29.setGenero(genero4);
            libro29.setAutor(autor5); // Asignar autor
            bookRepository.save(libro29);

            Libro libro30 = new Libro();
            libro30.setTitle("Octubre 1934");
            libro30.setAuthor("Autor Ejemplo");
            libro30.setIsbn("ISBN3006");
            libro30.setNumPages(350);
            libro30.setPrice(33.00);
            libro30.setImage("imagen1.jpg");
            libro30.setStock(100);
            libro30.setGenero(genero4);
            libro30.setAutor(autor6); // Asignar autor
            bookRepository.save(libro30);

            Libro libro31 = new Libro();
            libro31.setTitle("Anglosajones");
            libro31.setAuthor("Autor Ejemplo");
            libro31.setIsbn("ISBN3007");
            libro31.setNumPages(360);
            libro31.setPrice(34.00);
            libro31.setImage("imagen1.jpg");
            libro31.setStock(100);
            libro31.setGenero(genero4);
            libro31.setAutor(autor6); // Asignar autor
            bookRepository.save(libro31);

            Libro libro32 = new Libro();
            libro32.setTitle("14 de Abril");
            libro32.setAuthor("Autor Ejemplo");
            libro32.setIsbn("ISBN3008");
            libro32.setNumPages(370);
            libro32.setPrice(32.00);
            libro32.setImage("imagen1.jpg");
            libro32.setStock(100);
            libro32.setGenero(genero4);
            libro32.setAutor(autor6); // Asignar autor
            bookRepository.save(libro32);

            Libro libro33 = new Libro();
            libro33.setTitle("Palabras Radiantes");
            libro33.setAuthor("Brandon Sanderson");
            libro33.setIsbn("ISBN4001");
            libro33.setNumPages(1600);
            libro33.setPrice(25.00);
            libro33.setImage("palabrasradiantes.jpg");
            libro33.setStock(100);
            libro33.setGenero(genero5);
            libro33.setAutor(autor1); // Asignar autor
            bookRepository.save(libro33);

            Libro libro34 = new Libro();
            libro34.setTitle("Juramentada");
            libro34.setAuthor("Brandon Sanderson");
            libro34.setIsbn("ISBN4002");
            libro34.setNumPages(1600);
            libro34.setPrice(26.00);
            libro34.setImage("juramentada.jpg");
            libro34.setStock(100);
            libro34.setGenero(genero5);
            libro34.setAutor(autor1); // Asignar autor
            bookRepository.save(libro34);

            Libro libro35 = new Libro();
            libro35.setTitle("El Camino de los Reyes");
            libro35.setAuthor("Brandon Sanderson");
            libro35.setIsbn("ISBN4003");
            libro35.setNumPages(1600);
            libro35.setPrice(27.00);
            libro35.setImage("caminoreyes.jpg");
            libro35.setStock(100);
            libro35.setGenero(genero5);
            libro35.setAutor(autor1); // Asignar autor
            bookRepository.save(libro35);

            Libro libro36 = new Libro();
            libro36.setTitle("El Ritmo de la Guerra");
            libro36.setAuthor("Brandon Sanderson");
            libro36.setIsbn("ISBN4004");
            libro36.setNumPages(2000);
            libro36.setPrice(28.00);
            libro36.setImage("ritmoguerra.jpg");
            libro36.setStock(100);
            libro36.setGenero(genero5);
            libro36.setAutor(autor1); // Asignar autor
            bookRepository.save(libro36);

            Libro libro37 = new Libro();
            libro37.setTitle("El Imperio Final");
            libro37.setAuthor("Brandon Sanderson");
            libro37.setIsbn("ISBN4005");
            libro37.setNumPages(440);
            libro37.setPrice(29.00);
            libro37.setImage("imperiofinal.jpg");
            libro37.setStock(100);
            libro37.setGenero(genero5);
            libro37.setAutor(autor1); // Asignar autor
            bookRepository.save(libro37);

            Libro libro38 = new Libro();
            libro38.setTitle("El Pozo de la Ascension");
            libro38.setAuthor("Brandon Sanderson");
            libro38.setIsbn("ISBN4006");
            libro38.setNumPages(450);
            libro38.setPrice(30.00);
            libro38.setImage("pozoascension.jpg");
            libro38.setStock(100);
            libro38.setGenero(genero5);
            libro38.setAutor(autor1); // Asignar autor
            bookRepository.save(libro38);

            Libro libro39 = new Libro();
            libro39.setTitle("El Héroe de las Eras");
            libro39.setAuthor("Brandon Sanderson");
            libro39.setIsbn("ISBN4007");
            libro39.setNumPages(460);
            libro39.setPrice(31.00);
            libro39.setImage("heroeeras.jpg");
            libro39.setStock(100);
            libro39.setGenero(genero5);
            libro39.setAutor(autor1); // Asignar autor
            bookRepository.save(libro39);

            Libro libro40 = new Libro();
            libro40.setTitle("Aleación de Ley");
            libro40.setAuthor("Brandon Sanderson");
            libro40.setIsbn("ISBN40081");
            libro40.setNumPages(470);
            libro40.setPrice(32.00);
            libro40.setImage("aleacionley.jpg");
            libro40.setStock(100);
            libro40.setGenero(genero5);
            libro40.setAutor(autor1); // Asignar autor
            bookRepository.save(libro40);

            Libro libro41 = new Libro();
            libro41.setTitle("Sombras de Identidad");
            libro41.setAuthor("Brandon Sanderson");
            libro41.setIsbn("ISBN40082");
            libro41.setNumPages(470);
            libro41.setPrice(32.00);
            libro41.setImage("sombrasidentidad.jpg");
            libro41.setStock(100);
            libro41.setGenero(genero5);
            libro41.setAutor(autor1); // Asignar autor
            bookRepository.save(libro41);

            Libro libro42 = new Libro();
            libro42.setTitle("El Metal Perdido");
            libro42.setAuthor("Brandon Sanderson");
            libro42.setIsbn("ISBN40083");
            libro42.setNumPages(470);
            libro42.setPrice(32.00);
            libro42.setImage("metalperdido.jpg");
            libro42.setStock(100);
            libro42.setGenero(genero5);
            libro42.setAutor(autor1); // Asignar autor
            bookRepository.save(libro42);

            Libro libro43 = new Libro();
            libro43.setTitle("Elantris");
            libro43.setAuthor("Brandon Sanderson");
            libro43.setIsbn("ISBN40084");
            libro43.setNumPages(470);
            libro43.setPrice(32.00);
            libro43.setImage("elantris.jpg");
            libro43.setStock(100);
            libro43.setGenero(genero5);
            libro43.setAutor(autor1); // Asignar autor
            bookRepository.save(libro43);

            Libro libro44 = new Libro();
            libro44.setTitle("Viento y Verdad");
            libro44.setAuthor("Brandon Sanderson");
            libro44.setIsbn("ISBN400851");
            libro44.setNumPages(470);
            libro44.setPrice(32.00);
            libro44.setImage("vientoverdad.jpg");
            libro44.setStock(100);
            libro44.setGenero(genero5);
            libro44.setAutor(autor1); // Asignar autor
            bookRepository.save(libro44);

            Libro libro45 = new Libro();
            libro45.setTitle("El Señor de los Anillos");
            libro45.setAuthor("J.R.R. Tolkien");
            libro45.setIsbn("ISBN400852");
            libro45.setNumPages(470);
            libro45.setPrice(32.00);
            libro45.setImage("señoranillos.jpg");
            libro45.setStock(100);
            libro45.setGenero(genero5);
            libro45.setAutor(autor3); // Asignar autor
            bookRepository.save(libro45);

            Libro libro46 = new Libro();
            libro46.setTitle("El Hobbit");
            libro46.setAuthor("J.R.R. Tolkien");
            libro46.setIsbn("ISBN400853");
            libro46.setNumPages(470);
            libro46.setPrice(32.00);
            libro46.setImage("hobbit.jpg");
            libro46.setStock(100);
            libro46.setGenero(genero5);
            libro46.setAutor(autor3); // Asignar autor
            bookRepository.save(libro46);

            Libro libro47 = new Libro();
            libro47.setTitle("El Silmarillion");
            libro47.setAuthor("J.R.R. Tolkien");
            libro47.setIsbn("ISBN400854");
            libro47.setNumPages(470);
            libro47.setPrice(32.00);
            libro47.setImage("silma.jpg");
            libro47.setStock(100);
            libro47.setGenero(genero5);
            libro47.setAutor(autor3); // Asignar autor
            bookRepository.save(libro47);

            Libro libro48 = new Libro();
            libro48.setTitle("Canción de Hielo y Fuego");
            libro48.setAuthor("George R. R. Martin");
            libro48.setIsbn("ISBN400855");
            libro48.setNumPages(470);
            libro48.setPrice(32.00);
            libro48.setImage("hielofuego.jpg");
            libro48.setStock(100);
            libro48.setGenero(genero5);
            libro48.setAutor(autor4); // Asignar autor
            bookRepository.save(libro48);

            Libro libro49 = new Libro();
            libro49.setTitle("Harry Potter: El Prisionero de Azkaban");
            libro49.setAuthor("J.K. Rowling");
            libro49.setIsbn("ISBN400856");
            libro49.setNumPages(470);
            libro49.setPrice(32.00);
            libro49.setImage("azkaban.jpg");
            libro49.setStock(100);
            libro49.setGenero(genero5);
            libro49.setAutor(autor2); // Asignar autor
            bookRepository.save(libro49);

            Libro libro50 = new Libro();
            libro50.setTitle("Harry Potter: El Caliz de Fuego");
            libro50.setAuthor("J.K. Rowling");
            libro50.setIsbn("ISBN400857");
            libro50.setNumPages(470);
            libro50.setPrice(32.00);
            libro50.setImage("caliz.jpg");
            libro50.setStock(100);
            libro50.setGenero(genero5);
            libro50.setAutor(autor2); // Asignar autor
            bookRepository.save(libro50);
            
            Pedido pedido = new Pedido();
            pedido.setNombre("Juan");
            pedido.setApellidos("Pérez");
            pedido.setDni("12345678A");
            pedido.setDireccion("Calle Falsa 123");
            pedido.setPrecioTotal(50.00);
            pedido.setFecha(new Date());
            pedido.setUsuario(usuarioRepository.findById(1L).get());
            pedidoRepository.save(pedido);

            LineaPedido lineaPedido = new LineaPedido();
            lineaPedido.setCantidad(2);
            lineaPedido.setLibro(bookRepository.findById(1L).get());
            lineaPedido.setPedido(pedido);
            lineaPedidoRepository.save(lineaPedido);

            Carrito carrito = new Carrito();
            carrito.setUsuario(usuarioRepository.findById(1L).get());
            carrito.setLibro(bookRepository.findById(1L).get());
            carrito.setCantidad(1);
            carritoRepository.save(carrito);
        };
    }
}
