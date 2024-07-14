package one.digitalinnovation;

import one.digitalinnovation.dominio.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Java Básico");
        cursoJava.setDescricao("Aprenda os conceitos básicos sobre Java");
        cursoJava.setCargaHoraria(8);

        Curso cursoDotNet = new Curso();
        cursoDotNet.setTitulo("DotNet Básico");
        cursoDotNet.setDescricao("Aprenda os conceitos básicos sobre DotNet");
        cursoDotNet.setCargaHoraria(8);

        Curso cursoJavaAvancado = new Curso();
        cursoJavaAvancado.setTitulo("Java Avançado");
        cursoJavaAvancado.setDescricao("Aprenda os conceitos avançados sobre Java");
        cursoJavaAvancado.setCargaHoraria(8);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Aprenda Orientação a Objetos com Java");
        mentoria.setDescricao("Imersão sobre os pilares da Orientação a Objetos");
        mentoria.setData(LocalDateTime.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("JAVA");
        bootcamp.setInicio(LocalDate.now());
        bootcamp.setFim(bootcamp.getInicio().plusDays(45));
        List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJava, mentoria, cursoJavaAvancado);
        bootcamp.setConteudos(conteudosBootcamp);

        Dev thompson = new Dev();
        thompson.setNome("Thompson");

        Dev carlos = new Dev();
        carlos.setNome("Carlos");

        thompson.inscrever(cursoDotNet);
        thompson.inscrever(bootcamp);
        thompson.progredir();
        thompson.progredir();

        carlos.inscrever(bootcamp);
        carlos.progredir();
        carlos.progredir();
        carlos.progredir();
        carlos.progredir();

        System.out.println(String.format("XP Carlos: %.2f", carlos.calcularTotalXp()));
        System.out.println(String.format("XP Thompson: %.2f", thompson.calcularTotalXp()));

        System.out.println("Ranking");
        List<Dev> ranking = Arrays.asList(thompson, carlos).stream()
                .sorted((dev1, dev2) -> Double.compare(dev2.calcularTotalXp(), dev1.calcularTotalXp()))
                .collect(Collectors.toList());
        for(Dev dev : ranking){
            System.out.println(dev.getNome());
        }
    }
}
