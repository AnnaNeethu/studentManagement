import React from 'react'
import {Container,Nav,Navbar} from 'react-bootstrap';

function Header() {
  return (
    <Navbar bg="primary" variant="dark">
    <Container>
    <Navbar.Brand href="/">
            <img alt=""
              src="https://thumbs.dreamstime.com/b/school-icon-isolated-black-background-simple-vector-logo-school-icon-isolated-black-background-161146960.jpg"
              width="50" height="50" className="d-inline-block align-top"/>
              &nbsp;ABC School
          </Navbar.Brand>
      {/* <Nav className="me-auto">
        <Nav.Link href="#home">Home</Nav.Link>
      </Nav> */}
    </Container>
  </Navbar>
  )
}

export default Header