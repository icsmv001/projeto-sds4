import React, { Component } from "react";
import ListarFilmes from "components/ListarFilmes";
import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import NavBar2 from "components/Navbar2";
import Listing from "pages/Listing";

// versao 20220626- funcionando, falta ajustar formulario de score de pontos de filmes -v001

class ListaFilmes extends Component {
  state = {
    filmes: [],
  };

  async componentDidMount() {
    const response = await ListarFilmes.get(" ");

    this.setState({ filmes: response.data });
  }

  render() {
    return (
      <>
        <NavBar1 />
        <NavBar2 />

        <div className="container">
          <h6 className="text-primary py-3">
            Lista de filmes - ICSMV001 - v.01
          </h6>
          <hr />

          <Listing />
        </div>

        <Footer />
      </>
    );
  }
}
export default ListaFilmes;
