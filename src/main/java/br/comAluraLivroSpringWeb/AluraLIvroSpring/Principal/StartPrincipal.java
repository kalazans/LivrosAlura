package br.comAluraLivroSpringWeb.AluraLIvroSpring.Principal;

import br.comAluraLivroSpringWeb.AluraLIvroSpring.Service.LivroRepository;
import br.comAluraLivroSpringWeb.AluraLIvroSpring.Model.Livro;
import br.comAluraLivroSpringWeb.AluraLIvroSpring.Model.Result;
import br.comAluraLivroSpringWeb.AluraLIvroSpring.Service.BuscaApi;
import br.comAluraLivroSpringWeb.AluraLIvroSpring.Service.Conversordados;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StartPrincipal {
    private BuscaApi api = new BuscaApi();
    private Conversordados cd = new Conversordados();
    private final String url = "https://stephen-king-api.onrender.com/api/books";
    LivroRepository repository;

    public StartPrincipal(LivroRepository r){
        this.repository = r;
    }
    public StartPrincipal(){}

    public void Menu(){
        Scanner leitura = new Scanner(System.in);
        Boolean on =  true;
        String menu = """
                1 - Listar todos os livros;
                2 - Buscar por nome;
                3 - Buscar por data de lançameento;
                4 - Bucar por numer de paginas;
                """;
        System.out.println("BEM VINDO A ESTANTE DE LIVROS DO stephen-king");
        System.out.println(menu);
        int escolha = leitura.nextInt();
        while(on = true){
        switch (escolha){
            case 1:
                listarLivros();
                System.out.println(menu);
                escolha = leitura.nextInt();
                break;
            case 2:
                leitura.nextLine();
                System.out.println("digite o nome do livro");
                String livro = leitura.nextLine();

                buscaPorNome(livro);
                System.out.println(menu);
                escolha = leitura.nextInt();
                break;
            case 3:
                System.out.println("digite o ano");
                int ano = leitura.nextInt();
                buscarPorAno(ano);
                System.out.println(menu);
                escolha = leitura.nextInt();
                break;

            case 4:
                System.out.println("buscar por numero de paginas");
                int paginas = leitura.nextInt();
                buscarPorPaginas(paginas);
                System.out.println(menu);
                escolha = leitura.nextInt();
                break;

            case 0 :  on = false;
        }
        }

    }

    public void salvarNoBD(){
       Result  livrosDaApi =  cd.conversorDeJson(api.consumoApi(url), Result.class);
       List<Livro> lv = livrosDaApi.lista().stream()
               .map(l->new Livro(l.id(),l.title(),l.ano(),l.page())).collect(Collectors.toList());
       lv.forEach(l -> repository.save(l));
    }

    public void listarLivros(){
        List<Livro> lista = repository.findAll();
        for (Livro livro : lista) {
            System.out.println(livro);
        }
    }

    public void buscaPorNome(String nomeLivro){
        Optional<Livro> livroProcurado = repository.findByTitleContainingIgnoreCase(nomeLivro);
        if(livroProcurado.isPresent()){
            Livro livroAchado = livroProcurado.get();
            System.out.println(livroAchado);
        } else{
            System.out.println("nao conta livro com este nome");
        }
    }

    public void buscarPorAno(int anoLivro){
        Optional<Livro> livroProcurado = repository.findByAnoEquals(anoLivro);
        if(livroProcurado.isPresent()){
            Livro livroAchado = livroProcurado.get();
            System.out.println(livroAchado);
        } else{
            System.out.println("nao conta livros deste ano");
        }
    }

    public void buscarPorPaginas(int paginas){
        System.out.println("1 - livros com mais paginas que "+paginas+"\n2 - livros com menos paginas que "+paginas);
        Scanner scan = new Scanner(System.in);
        int escolha = scan.nextInt();

        if(escolha == 1){
            repository.findByPagesGreaterThan(paginas).stream().forEach(System.out::println);
        } else if(escolha == 2){
            repository.findByPagesLessThan(paginas).stream().forEach(System.out::println);
        } else{
            System.out.println("escolha nao aceita");
        }

    }


}
