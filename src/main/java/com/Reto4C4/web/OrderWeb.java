package com.Reto4C4.web;

import com.Reto4C4.model.Clone;
import com.Reto4C4.model.Order;
import com.Reto4C4.service.OrderApi;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nbsc1 
 * Reto 4 Ciclo 4
 */
@RestController
@RequestMapping("order")
@CrossOrigin("*")
public class OrderWeb {

    @Autowired
    private OrderApi orderService;

    /**
     * consultar
     *
     * @return
     */
    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    /**
     * consultar por
     *
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id) {
        return orderService.getOrder(id);
    }

    /**
     * consultar por zona
     *
     * @param zona
     * @return
     */
    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona) {
        return orderService.findByZone(zona);
    }

    /**
     * Crear o guardar
     *
     * @param Ordenes
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    /**
     * Actualizar
     *
     * @param Ordenes
     * @return
     */

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    /**
     * Eliminar
     *
     * @param Ordenes
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return orderService.delete(id);
    }

    //Métodos del reto 4
    // Ordenes de un asesor
    @GetMapping("/salesman/{id}")
    public List<Order> ordersSalesManByID(@PathVariable("id") Integer id) {
        return orderService.ordersSalesManByID(id);
    }

    //Ordenes de un asesor x Estado
    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id) {
        return orderService.ordersSalesManByState(state, id);
    }

    //Ordenes de un asesor x fecha
    @GetMapping("/date/{date}/{id}")
    public List<Order> ordersSalesManByDate(@PathVariable("date") String dateStr, @PathVariable("id") Integer id) {
        return orderService.ordersSalesManByDate(dateStr, id);
    }
}
