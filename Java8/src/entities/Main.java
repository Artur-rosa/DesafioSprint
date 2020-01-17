package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		// Ordena os cursos pela qt de alunos -- Ambos fazem a mesma coisa
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		// ------------------------------------------------------------

		// Stream serve para filtrar (filter esta dentro da coleção stream)
		// Filtrando os cursos com mais de 100 alunos
		Stream<Curso> streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 100);
		streamDeCurso.forEach(c -> System.out.println(c.getNome()));

		// ---------------------- Codigo abaixo é o mesmo só melhorado e reduzido//
		cursos.stream().filter(c -> c.getAlunos() > 100).forEach(c -> System.out.println(c.getNome()));
		// ------------------------Codigo mais
		// legivel---------------------------------------//
		cursos.stream().filter(c -> c.getAlunos() > 100).forEach(c -> System.out.println(c.getNome()));

		// --------------------------------------------------------------//
		cursos.stream().filter(c -> c.getAlunos() > 100).map(Curso::getAlunos).forEach(System.out::println);

		// ---------------------------------------------------------------//
		int soma = cursos.stream().filter(c -> c.getAlunos() > 100).mapToInt(Curso::getAlunos).sum();

		// ---------------Aula05-------------------------------------------//
		// -------------------Optional--------------------------------------//
		cursos.stream()// 1.0.0
				.filter(c -> c.getAlunos() > 100).findAny();// findAny retorna qualquer curso que tenha masi de 100
															// alunos//
															// retorna um optional<curso>
															// optional é um classe que trabalha com valores NULL

		Optional<Curso> optional = cursos.stream().filter(c -> c.getAlunos() > 100).findAny();

		Curso curso = optional.get();
		//Curso curso = optional.orElse(null);
		optional.ifPresent(c -> System.out.println(c.getNome()));

		cursos.stream()// 1.0.1
				.filter(c -> c.getAlunos() > 100).findAny().ifPresent(c -> System.out.println(c.getNome()));

		// ----------------------Collect--------------------------------------//
		// O collect coleta os elementos de um stream para produzir outro objeto como
		// uam coleção//
		// Se utiliza o Collectors

		cursos = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());

		Map mapa = cursos.stream().filter(c -> c.getAlunos() > 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		
		

	}

}

public class Datas{
	 public static void main(String[] args) {        
		 LocalDate hoje = LocalDate.now();
		 System.out.println(hoje);
		 
		 LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
		 
		 int anos = olimpiadasRio.getYear() - hoje.getYear();
		 System.out.println(hoje);
		 
		 
		 Period periodo = Period.between(hoje, olimpiadasRio);
		 System.out.println(periodo);
		 
		 
		 DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		 
		 String valorFormatado = proximasOlimpiadas.format(fomatador);
		 System.out.println(valorFormatado);
		 
		 LocalDateTime agora = LocalDateTime.now();
		 
		 DataTimeFormatter formatadorComHoras = DataTimeFormatter.ofPattern("dd/mm/yyyy");
		 LocalDateTime agora = LocalDateTime.now();
		 System.out.println(agora.format(fomatadorComHoras));

	    }
	
	
	
}
