package br.com.iesp.full.stack.controle;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iesp.full.stack.dto.ClienteDto;
import br.com.iesp.full.stack.servico.ClienteServico;

@Controller
@RequestMapping("/clientes")
public class ClienteControle implements IControler<ClienteDto, Serializable> {

	@Autowired
	private ClienteServico clienteServico;
	
	@Override
	@PostMapping("/savar")
	public ModelAndView salvar(@Valid ClienteDto object, BindingResult result, Model model,
			RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		if (result.hasErrors()) {
			return novo(object);
		}
		attributes.addAttribute("mensagem", "Cliente salvo com sucesso");
		this.clienteServico.salvar(object);
		return mv;
	}
	
	@Override
	@GetMapping("/novo")
	public ModelAndView novo(ClienteDto novo) {
		ModelAndView mv = new ModelAndView("/pages/servicos/novo");
		mv.addObject("cliente", novo);
		return mv;
	}

	@Override
	@GetMapping("/atualisar/{id}")
	public ModelAndView atualisar(@PathVariable("id") Long id) {
		ClienteDto clienteDto = this.clienteServico.buscar(id);
		return novo(clienteDto);
	}

	@Override
	@DeleteMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/clientes");
		this.clienteServico.remover(id);
		attributes.addFlashAttribute("removido", "Servico removido com sucesso!");
		return mv;
	}

	@Override
	@GetMapping
	public ModelAndView listar(@ModelAttribute("filtro") ClienteDto filtro) {
		ModelAndView mv = new ModelAndView("/clientes/listar");
		if (!StringUtils.isEmpty(filtro)) {
			List<ClienteDto> servicos = this.clienteServico.listar(filtro);
			mv.addObject("clientes", servicos);
		} else {
			mv.addObject("clientes", clienteServico.listar());
		}
		return mv;
	}

}
