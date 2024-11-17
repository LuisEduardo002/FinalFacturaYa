import React, {useEffect, useState} from 'react'
import { listProductos } from '../services/ProductoServicio'
export const ListProductoComponent = () => {
    const [productos, setProductos] = useState([])

    useEffect(() => {
        listProductos().then((response) =>{
            setProductos(response.data);
        }).catch(error=>{
            console.error('Error al listar productos', error);
        })
    
} , [])
  return (
    <div className='container'>
        <h3 className='text-center'>Prodcutos</h3>
        <table className='table table-stripped table-bordered'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>codigo</th>
                    <th>Precio</th>
                </tr>
            </thead>
            <tbody>
                {productos.map((product) => (
                    <tr key={product.id}>
                        <td>{product.id}</td>
                        <td>{product.codigo}</td>
                        <td>{product.precio_venta}</td>
                    </tr>
                ))}
            </tbody>

        </table>
    </div>
  )
}
