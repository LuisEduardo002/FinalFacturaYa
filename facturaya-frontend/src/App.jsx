import { useState } from 'react'
import { Hello } from './Hello'
import './App.css'
import { ListProductoComponent } from './components/ListProductoComponent'
import { HeaderComponent } from './components/HeaderComponent'
import { Footer } from './components/FooterComponent'
import { BrowserRouter, Routes, Route} from 'react-router-dom'
import { ProductoCrearComponent } from './components/ProductoComponent'
import { DataDisplayComponent } from './components/DataDisplayComponent'
import { ListIvaComponet } from './components/ListImpuestoComponet'
import { Impuesto } from './components/Impuesto'

function App() {

  return (
  
    <BrowserRouter>
    <HeaderComponent></HeaderComponent>
    <Routes>

      {/* //hpttp://localhost:3030 */}
      <Route path="/" element = { <ListProductoComponent /> }></Route>
    {/* //hpttp://localhost:3030/productos */}
      <Route path="/productos" element = { <ListProductoComponent /> }></Route>

   {/* //hpttp://localhost:3030/add-producto */}
      <Route path = "/add-producto" element = {<ProductoCrearComponent></ProductoCrearComponent>}></Route>

 {/* //hpttp://localhost:3030/edit-producto/1 */}
      <Route path='/edit-producto/:id' element = {<ProductoCrearComponent></ProductoCrearComponent>}></Route>

 {/* //hpttp://localhost:3030/home */}
      <Route path='/home' element={<DataDisplayComponent></DataDisplayComponent>}></Route>

 {/* //hpttp://localhost:3030/impuesto */}
      <Route path='/impuesto' element={<ListIvaComponet></ListIvaComponet>}></Route>

      <Route path='/add-impuesto' element={<Impuesto></Impuesto>}></Route>
    </Routes>


       <Footer></Footer>
       </BrowserRouter>

  )
}

export default App
