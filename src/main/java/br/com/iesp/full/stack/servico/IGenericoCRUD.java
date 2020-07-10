package br.com.iesp.full.stack.servico;

import java.io.Serializable;
import java.util.List;

public interface IGenericoCRUD <T, ID extends Serializable>{
	
	public void salvar(T entidade);
	
	public void alterar(T entidade);
	
	public void remover(Long id);
	
	public T buscar(Long id);
	
	public List<T> listar();
}
