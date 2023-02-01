package com.rolob3rto.springprojects.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolob3rto.springprojects.seguridad.model.DetallePedido;
import com.rolob3rto.springprojects.seguridad.model.DetallePedidoKey;

public interface DetallePedidosRepository extends JpaRepository<DetallePedido, DetallePedidoKey> {
    
    public void deleteByPedidoCodigo(int codigoPedido);
    public List<DetallePedido> findByPedidoCodigo(int codigoPedido);
}
