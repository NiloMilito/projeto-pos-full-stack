package br.com.iesp.full.stack.controle;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface IControler <T, ID extends Serializable>{
	
	public void salvar(@RequestBody @Valid T object, BindingResult result, RedirectAttributes attributes);	
	public void atualisar(@RequestBody @Valid T object, BindingResult result, RedirectAttributes attributes);		
	public void remover(@PathVariable Long id, RedirectAttributes attributes);	
	public List<T> listar(@ModelAttribute("filtro") T filtro);
	public T buscar(@PathVariable("id") Long id);
	
}
