package com.example.demorestAPI.model;


import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da tarefa é obrigatório")
    @Length(max = 150, message = "O nome da tarefa deve ter no máximo 150 caracteres")
    @Column(name = "nome_tarefa", nullable = false, length = 150)
    private String nome;

    
    @NotNull(message = "A data de entrega é obrigatória")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_entrega", nullable = false)
    private LocalDate dataEntrega;


    @NotBlank(message = "O responsável é obrigatório")
    @Length(max = 120, message = "O responsável deve ter no máximo 120 caracteres")
    @Column(nullable = false, length = 120)
    private String responsavel;

    public Tarefa() {}

    public Tarefa(Long id, String nome, LocalDate dataEntrega, String responsavel) {
        this.id = id;
        this.nome = nome;
        this.dataEntrega = dataEntrega;
        this.responsavel = responsavel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(LocalDate dataEntrega) { this.dataEntrega = dataEntrega; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataEntrega, responsavel);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa)) return false;
        Tarefa other = (Tarefa) o;
        return Objects.equals(id, other.id);
    }
}
