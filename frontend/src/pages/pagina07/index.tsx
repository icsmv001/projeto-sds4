import React, { Component } from "react";
import ListarFilmes from "components/ListarFilmes";

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
      <div>
        <h1>Listar os filmes</h1>
        {console.log(filmes)}
      </div>
    );
  }
}
export default ListaFilmes;
