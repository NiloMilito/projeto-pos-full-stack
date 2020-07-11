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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iesp.full.stack.dto.ProdutoDto;
import br.com.iesp.full.stack.servico.ProdutoServico;

@Controller
@RequestMapping("/produtos")
public class ProdutoControle implements IControler<ProdutoDto, Serializable> {

	@Autowired
	private ProdutoServico produtoServico;

	@Override
	@PostMapping("/savar")
	public ModelAndView salvar(@Valid ProdutoDto produtoDto, BindingResult result, Model model,
			RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/produtos");
		if (result.hasErrors()) {
			return novo(produtoDto);
		}
		attributes.addAttribute("mensagem", "Produto salvo com sucesso");
		this.produtoServico.salvar(produtoDto);
		return mv;
	}

	@Override
	@GetMapping("/novo")
	public ModelAndView novo(ProdutoDto novo) {
		ModelAndView mv = new ModelAndView("/pages/produtos/novo");
		mv.addObject("produto", novo);
		return mv;
	}

	@Override
	@GetMapping("/atualisar/{id}")
	public ModelAndView atualisar(Long id) {
		ProdutoDto produtoDto = this.produtoServico.buscar(id);
		return novo(produtoDto);
	}

	@Override
	@DeleteMapping("/remover/{id}")
	public ModelAndView remover(Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/produtos");
		this.produtoServico.remover(id);
		attributes.addFlashAttribute("removido", "Produto removido com sucesso!");
		return mv;
	}

	@Override
	@GetMapping
	public ModelAndView listar(@ModelAttribute("filtro") ProdutoDto filtro) {
		ModelAndView mv = new ModelAndView("/produtos/listar");
		if (!StringUtils.isEmpty(filtro)) {
			List<ProdutoDto> produtos = this.produtoServico.listar(filtro);
			mv.addObject("produtos", produtos);
		} else {
			mv.addObject("produtos", produtoServico.listar());
		}
		return mv;
	}

}
