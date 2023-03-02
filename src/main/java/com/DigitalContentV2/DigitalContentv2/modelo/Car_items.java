package com.DigitalContentV2.DigitalContentv2.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cart_items")
public class Car_items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto product;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
		
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private List<Car_items> idCarrito;

	private int cantidad;

	public Integer getId() {
		return id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Producto getProduct() {
		return product;
	}

	public void setProduct(Producto product) {
		this.product = product;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public List<Car_items> getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(List<Car_items> idCarrito) {
		this.idCarrito = idCarrito;
	}

	@Transient
	public float getSubtotal() {
		return this.product.getPrecio() * cantidad;
	}
}
