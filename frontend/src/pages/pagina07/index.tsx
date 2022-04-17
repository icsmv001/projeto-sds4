import React, { Component } from "react";
import ListarFilmes from "components/ListarFilmes";
import Footer from "components/Footer";
import NavBar from "components/Navbar";
import NavBar2 from "components/Navbar2";

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
          <h2 className="text-primary py-3">Listar filmes - ICSMV001 - v.01</h2>
          {console.log("teste" + filmes)}
        </div>
        <Footer />
      </>
    );
  }
}
export default ListaFilmes;