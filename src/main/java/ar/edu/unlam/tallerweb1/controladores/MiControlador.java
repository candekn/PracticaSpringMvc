package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MiControlador {

	@RequestMapping(path="/hola")
	public ModelAndView holaMundo () {
		return new ModelAndView ("myfirstview");	
	}
	
	@RequestMapping(path="/saludar") //El nombre del path no se relaciona con nada
	
	public ModelAndView saludito(@RequestParam(name="nombredelrequest")String personaw ) { /*Lo mismo acà
		El name del RequestParam debe ser el mismo que se pondra luego en la queryString despues del action 
		ejemplo: http://action.ejemplo/nombredelpath?nameDelRequestParam=valorDelName*/
		
		ModelMap modelo = new ModelMap();
		
		/*Para añadir el objeto q pasamos por RequestParam, debe ser igual al nombre del objeto definido arriba,
		  en este caso "personaw"
		 */
		
		modelo.put("personita", personaw); /*El primer nombre q ponemos va a ser como se llamara ese objeto en la vista.
		
		En este caso, el objeto tipo String "personaw", en la vista pasara a llamarse "personita" */
		
		return new ModelAndView("vistaSaludo", modelo); //Acà importa q el nombre de la vista corresponda con el nombre del .jsp
		//En este ejemplo se llama vistaSaludo.jsp (es CaseSensitive) asi q en el ModelAndView se pone igual
	
	}
	
	@RequestMapping(path="/probandoRest/{nombre}/{apellido}")
	/*En el caso del action con rest, los valores se separan con barras '/'
	 * y a diferencia de queryString, forman parte del action*/
	public ModelAndView holaRest(@PathVariable(value="nombre")String name, @PathVariable(value="apellido")String lastname){
		/*Aca en vez de "name", se pone value, y en vez de @RequestParam, se pone @PathVariable*/
		ModelMap modelito = new ModelMap();
		modelito.put("nombre", name);
		modelito.put("apellido", lastname);
		return new ModelAndView("vistaRest",modelito);
	}
}
