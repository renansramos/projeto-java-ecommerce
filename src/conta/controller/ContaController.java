package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
    
    @Override
    public void procurarPorNumero(int numero) {
        var conta = buscarNaCollection(numero);
		
		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nO Produto: " + numero + " não foi encontrado!");
    }

    @Override
    public void listarTodas() {
        for (var conta : listaContas) {
			conta.visualizar();
		}        
    }

    @Override
    public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nO Produto: " + conta.getNumero() + " foi criado com sucesso!");
    }

    @Override
    public void atualizar(Conta conta) {
        var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nO Produto: " + conta.getNumero() + " foi atualizado com sucesso!");
		}else
			System.out.println("\nO Produto: " + conta.getNumero() + " não foi encontrado!");
    }

    @Override
    public void deletar(int numero) {
        var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if(listaContas.remove(conta) == true)
				System.out.println("\nO produto: " + numero + " foi deletado com sucesso!");
		}else
			System.out.println("\nO produto: " + numero + " não foi encontrado!");
    }

	public int gerarNumero() {
				
		return ++ numero;

	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		
		return null;
	}
    
}