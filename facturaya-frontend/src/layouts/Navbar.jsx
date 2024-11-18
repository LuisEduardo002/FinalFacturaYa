import React from 'react'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Outlet } from 'react-router-dom';
export const Navbar = () => {


  return (
    <>
    <Navbar expand="lg" className="navBg">
    <Container>
      <Navbar.Brand as={Link}to='/'>Casita</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="me-auto">
          <Nav.Link as={Link}to='/cliente' >Home</Nav.Link>
          <Nav.Link as={Link}to='/impuesto'>Link</Nav.Link>
          <Nav.Link as={Link}to='/productos'>elpeple</Nav.Link>
        
        </Nav>
      </Navbar.Collapse>
    </Container>
  </Navbar>
  <section>
    <Outlet>

    </Outlet>
  </section>
  </>
  )
}
