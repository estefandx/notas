

package com.venta.dao;

import com.venta.model.DetalleVenta;
import com.venta.model.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class VentaDAO extends DAO{
    
    public void registrar(Venta venta,List<DetalleVenta> lista) throws Exception {

        try {
            this.conectar();
            this.getCn().setAutoCommit(false);
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Venta (fecha, persona_id,monto) values(?,?,?)");
            st.setDate(1, venta.getFecha());
            st.setInt(2, venta.getPersona().getIdPersona());
            st.setDouble(3, venta.getMonto());
            st.executeUpdate();
            st.close();
            
          PreparedStatement st2 = this.getCn().prepareStatement("SELECT  LAST_INSERT_ID() FROM venta LIMIT 1");
            ResultSet rs;
            int codigoVenta = 0;
            rs = st2.executeQuery();
            
            while (rs.next()) {                
                codigoVenta = rs.getInt(1);
            }
            rs.close();
            for (DetalleVenta detalle : lista) {
                
            PreparedStatement st3 = this.getCn().prepareStatement("INSERT INTO detalle_venta (venta_id, producto_id,cantidad) values(?,?,?)");
            st3.setInt(1, codigoVenta);
            st3.setInt(2, detalle.getProducto().getProductoId());
            st3.setDouble(3, detalle.getCantidad());
            st3.executeUpdate();
            st3.close();
            }
             this.getCn().setAutoCommit(true);  
        } catch (Exception e) {
            this.getCn().rollback();
            throw e;
        }finally {
        this.cerrar();
        }
    }
}
