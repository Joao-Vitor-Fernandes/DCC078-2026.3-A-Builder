package padroescriacao.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioBuilderTest {

    @Test
    void deveRetornarExcecaoParaFuncionarioSemMatricula() {
        try {
            FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
            Funcionario funcionario = funcionarioBuilder
                    .setNome("Funcionario 1")
                    .setSalario(3500.00f)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Matrícula inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaFuncionarioSemNome() {
        try {
            FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
            Funcionario funcionario = funcionarioBuilder
                    .setMatricula(1)
                    .setSalario(3500.00f)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaFuncionarioSemSalario() {
        try {
            FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
            Funcionario funcionario = funcionarioBuilder
                    .setMatricula(1)
                    .setNome("Funcionario 1")
                    .setEmail("funcionario1@email.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Salário inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarFuncionarioValido() {
        FuncionarioBuilder funcionarioBuilder = new FuncionarioBuilder();
        Funcionario funcionario = funcionarioBuilder
                .setMatricula(1)
                .setNome("Funcionario 1")
                .setSalario(3500.00f)
                .setCargo("Analista")
                .setSetor("Financeiro")
                .setEmail("funcionario1@email.com")
                .build();

        assertNotNull(funcionario);
    }
}