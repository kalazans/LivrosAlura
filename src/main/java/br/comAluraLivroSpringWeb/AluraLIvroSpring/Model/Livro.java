package br.comAluraLivroSpringWeb.AluraLIvroSpring.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "livrosDB")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String title;
    int ano;
    int pages;

    public Livro(Long id,String title,int ano,int pages){
        this.id = id;
        this.title = title;
        this.ano = ano;
        this.pages = pages;
    }

    public Livro(){}

    @Override
    public String toString() {
        return "Id: "+this.id+"\nTitle: "+this.title+"\nAno: "+this.ano+"\nPages: "+this.pages;

    }
}

