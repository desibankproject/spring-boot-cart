package com.shopping.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.cart.controller.message.ApplicationMessageVO;
import com.shopping.cart.controller.model.Ingredients;
import com.shopping.cart.controller.model.Product;
import com.shopping.cart.model.Frog;

@RestController
public class StoreFrontController {
	
	@CrossOrigin(origins = "http://localhost:4000")
	@PostMapping("/post/photo")
	public ResponseEntity<ApplicationMessageVO> handleFileUpload2(@RequestParam("name") String name,@RequestParam("file") MultipartFile file) {
		String message = "";
		System.out.println("name - "+name);
		ApplicationMessageVO applicationMessageVO=new ApplicationMessageVO();
		try {
			System.out.println("020202929292929292");
			System.out.println(file);
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			applicationMessageVO.setStatus("success");
			applicationMessageVO.setMessage(message);
			String uuid=UUID.randomUUID().toString();
			applicationMessageVO.setMid(uuid);
			return ResponseEntity.status(HttpStatus.OK).body(applicationMessageVO);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			applicationMessageVO.setStatus("fail");
			applicationMessageVO.setMessage(message);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(applicationMessageVO);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4000")
	@PostMapping(value="/post/image",produces={"application/json"},consumes={"application/json"})
	public ApplicationMessageVO handleFileUpload(@RequestParam("file") MultipartFile file) {
		ApplicationMessageVO applicationMessageVO=new ApplicationMessageVO();
		String message="";
		try {
			System.out.println("file = "+file);
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			applicationMessageVO.setStatus("success");
			applicationMessageVO.setMessage(message);
			String uuid=UUID.randomUUID().toString();
			applicationMessageVO.setMid(uuid);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			applicationMessageVO.setStatus("fail");
			applicationMessageVO.setMessage(message);
		}
		return applicationMessageVO;
	}
	
	@CrossOrigin(origins = "http://localhost:4000")
	@RequestMapping(value="product",method=RequestMethod.POST)
	public ApplicationMessageVO  uploadProduct(@ModelAttribute Product product,@RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, IOException{
			ObjectMapper objectMapper = new ObjectMapper();
			List<Ingredients> myObjects = objectMapper.readValue(product.getBodyString(), new TypeReference<List<Ingredients>>(){});  
			System.out.println(myObjects);
			System.out.println("_@_@_@_"+file.getOriginalFilename());
			try {
				System.out.println(file.getBytes());
			} catch (IOException e) {
			}
			System.out.println("@)@()(@(@product@(@(@(@(@" +product);
			System.out.println("@)@()(@(@product@(@(@(@(@" +product);
			System.out.println("@)@()(@(@product@(@(@(@(@" +product);
			ApplicationMessageVO applicationMessageVO=new ApplicationMessageVO();
			applicationMessageVO.setStatus("success");
			applicationMessageVO.setMessage("Product has been uploaded successfully with product id "+product);
			return applicationMessageVO;
	}
	
	@RequestMapping("test")
	public Frog  test(){
		Frog frog=new  Frog();
		frog.setAge(12);
		frog.setEmail("nagen@gmail.com");
		frog.setName("Nayar");
		return frog;
	}
	
	
	/**
	 *  <p>Specifically, {@code @GetMapping} is a <em>composed annotation</em> that
	 *  acts as a shortcut for {@code @RequestMapping(method = RequestMethod.GET)}.
	 *  <mvc:cors>
    	<mvc:mapping path="/**"
        allowed-origins="*"
        allowed-headers="Content-Type, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization, X-Requested-With, requestId, Correlation-Id"
        allowed-methods="GET, PUT, POST, DELETE"/>
		</mvc:cors>
	 *  
	 */
	//No 'Access-Control-Allow-Origin' header is present on the requested resource. spring rest api
	@CrossOrigin(origins = "http://localhost:4000")
	@GetMapping(value="products")
	public List<Product>  findProducts(){
		List<Product> products=new ArrayList<Product>();
		Product product1=new Product();
		product1.setId("9aa113b4-1e4e-4cde-bf9d-8358fc78ea4f");
		product1.setName("Greens");
		product1.setPrice(3.50F);
		product1.setDescription("Looking for simple, clean and green? Four of the most nutrient dense leafy greens create the base in our low-sugar Greens 1.");
		List<Ingredients> ingredients=new ArrayList<Ingredients>();
		Ingredients ingredients1=new  Ingredients("cucumber","50");
		Ingredients ingredients2=new  Ingredients("celery","20");
		Ingredients ingredients3=new  Ingredients("apple","20");
		Ingredients ingredients4=new  Ingredients("lemon","10");
		ingredients.add(ingredients1);
		ingredients.add(ingredients2);
		ingredients.add(ingredients3);
		ingredients.add(ingredients4);
		product1.setIngredients(ingredients);
		products.add(product1);
		
		Product product2=new Product();
		product2.setId("bdcbe438-ac85-4acf-8949-5627fd5b57df");
		product2.setName("Citrus");
		product2.setPrice(2.75F);
		product2.setDescription("This enzyme rich juice is filled with phytonutrients and bromelin which helps to reduce inflammation. Drink it before a meal to get digestive juices flowing.");
	      ingredients=new ArrayList<Ingredients>();
		 ingredients1=new  Ingredients("pineapple","50");
		 ingredients2=new  Ingredients("apple","20");
		 ingredients3=new  Ingredients("mint","20");
		 ingredients4=new  Ingredients("lemon","10");
		ingredients.add(ingredients1);
		ingredients.add(ingredients2);
		ingredients.add(ingredients3);
		ingredients.add(ingredients4);
		product2.setIngredients(ingredients);
		products.add(product2);
		
		Product product3=new Product();
		product3.setId("58552daa-30f6-46fa-a808-f1a1d7667561");
		product3.setName("Roots");
		product3.setPrice(3F);
		product3.setDescription("Beets help your body to release stomach acid which aids digestion! Drink this juice when you want a snack that's both pretty and nutritious!.");
	      ingredients=new ArrayList<Ingredients>();
		 ingredients1=new  Ingredients("apple","50");
		 ingredients2=new  Ingredients("beetroot","20");
		 ingredients3=new  Ingredients("ginger","20");
		 ingredients4=new  Ingredients("lemon","10");
		ingredients.add(ingredients1);
		ingredients.add(ingredients2);
		ingredients.add(ingredients3);
		ingredients.add(ingredients4);
		product3.setIngredients(ingredients);
		products.add(product3);
		
		Product product4=new Product();
		product4.setId("d4666802-fd84-476f-9eea-c8dd29cfb633");
		product4.setName("Orange");
		product4.setPrice(1.99F);
		product4.setDescription("Orange juice with a twist to boost you health!.");
	      ingredients=new ArrayList<Ingredients>();
		 ingredients1=new  Ingredients("orange","50");
		 ingredients2=new  Ingredients("lemon","20");
		 ingredients3=new  Ingredients("apple","20");
		 ingredients4=new  Ingredients("tumeric","10");
		ingredients.add(ingredients1);
		ingredients.add(ingredients2);
		ingredients.add(ingredients3);
		ingredients.add(ingredients4);
		product4.setIngredients(ingredients);
		products.add(product4);
		
		
		Product product5=new Product();
		product5.setId("7ef3b9dd-5a95-4415-af37-6871d6ff0262");
		product5.setName("Coconut");
		product5.setPrice(2.50F);
		product3.setDescription("Beets help your body to release stomach acid which aids digestion! Drink this juice when you want a snack that's both pretty and nutritious!.");
	      ingredients=new ArrayList<Ingredients>();
		 ingredients1=new  Ingredients("Coconut","70");
		 ingredients2=new  Ingredients("Cinnamon","20");
		 ingredients3=new  Ingredients("water","20");
		ingredients.add(ingredients1);
		ingredients.add(ingredients2);
		ingredients.add(ingredients3);
		ingredients.add(ingredients4);
		product5.setIngredients(ingredients);
		products.add(product5);
		
		return products;
	}

}
