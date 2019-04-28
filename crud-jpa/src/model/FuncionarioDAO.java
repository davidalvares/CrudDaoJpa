package model;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class FuncionarioDAO implements CrudDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("funcionarioPU");
	EntityManager em = emf.createEntityManager();
	
	Scanner ler = new Scanner(System.in);
	Funcionario funcionario = new Funcionario();
	
	@Override
	public void salvarFuncionario() {
		
		System.out.println("Digite o nome do funcionario:");
		funcionario.setNome(ler.nextLine());	
		System.out.println("Digite o cargo do funcionario:");		
		funcionario.setCargo(ler.nextLine());
		System.out.println("Digite o telefone do funcionario:");		
		funcionario.setTelefone(ler.nextLine());
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();			
	}

	@Override
	public List<Funcionario> listarFuncionario() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Funcionario> cq = cb.createQuery(Funcionario.class);
		Root<Funcionario> from = cq.from(Funcionario.class);
		CriteriaQuery<Funcionario> all = cq.select(from);
		TypedQuery<Funcionario> allQuery = em.createQuery(all);
		List<Funcionario> funcionarios = allQuery.getResultList();
		if(funcionarios.size() > 0) {
		funcionarios.forEach(funcionario -> {
			System.out.println("ID:" + funcionario.getId() );
			System.out.println("Nome:" + funcionario.getNome());
			System.out.println("Cargo:" + funcionario.getCargo());
			System.out.println("Telelone:" + funcionario.getTelefone());
			System.out.println("Data Registro:" + funcionario.getDataContratacao());
			System.out.println("_________________________________________________\n");
		});
		} else {
			System.out.println("Nenhum funcionário cadastrado.");
			}
		return funcionarios;
		}
		

	@Override
	public void AtualizarFuncionario() {	
		
		System.out.println("Digite o Id do funcionario que deseja atualizar!");
		funcionario.setId(ler.nextLong());
		
		funcionario = em.find(Funcionario.class,funcionario.getId());	
		
		System.out.println("Digite o nome do funcionario:");
		funcionario.setNome(ler.next());
		
		System.out.println("Digite o cargo do funcionario:");		
		funcionario.setCargo(ler.next());
		
		System.out.println("Digite o telefone do funcionario:");		
		funcionario.setTelefone(ler.next());
		
		em.getTransaction().begin();
		em.merge(funcionario);		
        em.getTransaction().commit();
        
        System.out.println("Funcionario atualizado com sucesso!");	
	}
	
	public Funcionario findFuncionario() {
		//Recupera só um funcionario
		return null;
	}

	@Override
	public void excluirFuncionaio(Long id) {
		System.out.println("Insirar o ID do funcionario que deseja excluir!");
		funcionario.setId(ler.nextLong());
//		
//		this.funcionario.getId();
		funcionario = em.find(Funcionario.class,funcionario.getId());		
		em.getTransaction().begin();
		em.remove(funcionario);
        em.getTransaction().commit();
		System.out.println("Funcionario removido com sucesso!");
		
	}
}
