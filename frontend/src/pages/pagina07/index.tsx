import React, { Component } from "react";
import ListarFilmes from "components/ListarFilmes";
import Footer from "components/Footer";
import NavBar from "components/Navbar";
import NavBar2 from "components/Navbar2";
import Listing from "pages/Listing";
import Form from "pages/Form";

class ListaFilmes extends Component {
  state = {
    filmes: [],
  };

  async componentDidMount() {
    const response = await ListarFilmes.get(" ");

    this.setState({ filmes: response.data });
  }

  render() {
    const { filmes } = this.state;

    return (
      <>
        <NavBar />
        <NavBar2 />

        <div className="container">
          <h6 className="text-primary py-3">
            Lista de filmes - ICSMV001 - v.01
          </h6>
          <hr />

          <Listing />

          {console.log("teste" + filmes)}

          {/* <Form /> */}
        </div>

        <Footer />
      </>
    );
  }
}
export default ListaFilmes;
