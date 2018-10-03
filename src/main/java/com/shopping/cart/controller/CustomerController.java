package com.shopping.cart.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.controller.message.ApplicationMessageVO;
import com.shopping.cart.controller.model.Customer;
import com.shopping.cart.service.CustomerService;
import com.shopping.cart.service.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	@Qualifier("CustomerService")
	private ICustomerService customerService;
	
	private List<Customer> customers=new ArrayList<Customer>();
	
	public CustomerController() {
		System.out.println(")@)@)CustomerController is instatiated!@)@)@)");
	}
	
	@PostConstruct
	public void initData(){
	
		  Customer customer1=new Customer();
	        customer1.setCid("E1303");
	        customer1.setName("John");
	        customer1.setEmail("customer1@synergy.com");
	        customer1.setMobile("+1234567898");
	        customer1.setGender("Male");
	        
	        Customer customer2=new Customer();
	        customer2.setCid("E2303");
	        customer2.setName("Alice");
	        customer2.setEmail("customer2@synergy.com");
	        customer2.setMobile("+1234567898");
	        customer2.setGender("Female");
	        customers.add(customer1);
	        customers.add(customer2);
	        customerService.saveCustomer(customer1);
	        customerService.saveCustomer(customer2);
	        List<Customer> customers=customerService.findCustomersByGender("Female");
	        for(Customer customer:customers){
	        	System.out.println(customer);
	        }
	}
	
	@CrossOrigin(origins = "http://localhost:4000")
	@DeleteMapping(value="customer/{cid}")
	public ApplicationMessageVO  deleteCustomer(@PathVariable("cid") String cid){
			Customer customer=new Customer();
			customer.setCid(cid);
			customers.remove(customer);
			ApplicationMessageVO applicationMessageVO=new ApplicationMessageVO();
			applicationMessageVO.setStatus("success");
			applicationMessageVO.setMessage("Customer with cid "+cid+" is deleted successfully............");
			return applicationMessageVO;
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
	@GetMapping(value="customers")
	public List<Customer>  findCustomers(){
		     return this.customers;
	}
	
	@CrossOrigin(origins = "http://localhost:4000")
	@GetMapping(value="customer/photo")
	public void  findCustomerImage(@RequestParam("cid") String cid,HttpServletResponse response){
		response.setContentType("image/png");
		ServletOutputStream outputStream=null;
		try {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("img/"+cid+".jpg").getFile());
		BufferedImage originalImage = ImageIO.read(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( originalImage, "jpg", baos );
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
	   outputStream=response.getOutputStream();
		outputStream.write(imageInByte);
		outputStream.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(outputStream!=null)
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
