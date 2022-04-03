package com.alzohar.webSecurity.webservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alzohar.webSecurity.webservice.Entity.Order;
import com.alzohar.webSecurity.webservice.Repository.OrderRepository;

@RestController
@RequestMapping("api")
public class OrderController {

	@Autowired
	OrderRepository orderRepo;

	@GetMapping("/order")
	public List<Order> getOrderByName(@RequestParam("name") String name) {
		return orderRepo.findByName(name);
	}

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@GetMapping("/order/{id}")
	public Order getOrderById(@PathVariable("id") long id) {
		return orderRepo.getById(id);
	}

	@PostMapping("/order")
	public Order addOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}

	@PutMapping("/orders")
	public Order updateOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}

	@DeleteMapping("/order/{id}")
	public String deleteOrder(@PathVariable("id") long id) {
		orderRepo.deleteById(id);
		return "Order is deleted Successfully";
	}
}
