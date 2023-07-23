package in.ashokit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.Book;
import in.ashokit.repo.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repo;
	
	@GetMapping("/book")
	public ModelAndView getBookById(@RequestParam("id")Integer id) {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("Id ::"+id);
		
		Optional<Book> findById = repo.findById(id);
		
		if(findById.isPresent()) {
			Book bookobj = findById.get();
			mav.addObject("book", bookobj);
		}
		mav.setViewName("index");
		return mav;
		
		
		
	}

}
