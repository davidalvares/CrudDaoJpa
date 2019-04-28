package model;

import java.util.List;

public interface CrudDAO {

	public void salvarFuncionario(); // Create

	public List<Funcionario> listarFuncionario();// Reader

	public void AtualizarFuncionario();// Update

	public void excluirFuncionaio(Long id);// Delete

}
